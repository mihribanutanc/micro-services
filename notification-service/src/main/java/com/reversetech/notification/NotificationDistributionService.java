package com.reversetech.notification;

import com.reversetech.messaging.TicketNotification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

@Service
public class NotificationDistributionService {

    @RabbitListener(queues = "msqueue")
    public void receiveMessage(byte[] message) {
        try {
            TicketNotification ticketNotification = deserializeMessage(message);
            System.out.println("Gelen mesaj: " + ticketNotification);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Mesaj deserialization işlemi sırasında bir hata oluştu: " + e.getMessage());
        }
    }


    private TicketNotification deserializeMessage(byte[] message) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(message);
             ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {

            return (TicketNotification) objectInputStream.readObject();
        }
    }
}
