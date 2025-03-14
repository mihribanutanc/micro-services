package com.reversetech.messaging;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Data
@ToString
public class TicketNotification implements Serializable {

    private UUID ticketId;

    private String accountId;

    private String ticketDescription;

}
