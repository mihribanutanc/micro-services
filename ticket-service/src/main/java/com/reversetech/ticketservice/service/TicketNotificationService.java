package com.reversetech.ticketservice.service;

import com.reversetech.messaging.TicketNotification;
import com.reversetech.ticketservice.model.Ticket;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import javax.xml.transform.Source;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Supplier;

@Service
public class TicketNotificationService {



    private final Queue<TicketNotification> notificationQueue = new LinkedList<>();

    // Mesaj göndermek için fonksiyon
    public void sendToQueue(Ticket ticket) {
        TicketNotification ticketNotification = new TicketNotification();
        ticketNotification.setAccountId(ticket.getAssigned());
        ticketNotification.setTicketDescription(ticket.getDescription());
        notificationQueue.offer(ticketNotification);  // Kuyruğa ekliyoruz
    }

    // Stream'e mesaj gönderen fonksiyon
    @Bean
    public Supplier<Flux<Message<TicketNotification>>> sendToQueue() {
        return () -> {
            TicketNotification notification = notificationQueue.poll();  // Kuyruktan bir tane alıyoruz
            return notification != null
                    ? Flux.just(MessageBuilder.withPayload(notification).build())
                    : Flux.empty();
        };
    }
}
