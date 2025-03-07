package com.reversetech.notification.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.UUID;


@Data
public class TicketNotification implements Serializable {

    private UUID ticketId;

    private String accountId;

    private String ticketDescription;
}
