package com.reversetech.ticketservice.service;

import com.reversetech.messaging.TicketNotification;
import com.reversetech.ticketservice.config.RabbitMQConfig;
import com.reversetech.ticketservice.model.Ticket;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class TicketNotificationService {

    private final RabbitTemplate rabbitTemplate;

    public TicketNotificationService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void sendMessage(Ticket ticket) {

        TicketNotification ticketNotification = new TicketNotification();
        ticketNotification.setAccountId(ticket.getAssigned());
        ticketNotification.setTicketDescription(ticket.getDescription());
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, ticketNotification);
        System.out.println("Mesaj gönderildi: " + ticketNotification);
    }
}
