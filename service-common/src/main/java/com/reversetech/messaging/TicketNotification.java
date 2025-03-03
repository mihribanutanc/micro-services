package com.reversetech.messaging;


import lombok.*;

import java.io.Serializable;


@ToString
public class TicketNotification implements Serializable {
    private String ticketId;

    public TicketNotification() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public void setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    private String accountId;

    public TicketNotification(String ticketId, String ticketDescription, String accountId) {
        this.ticketId = ticketId;
        this.ticketDescription = ticketDescription;
        this.accountId = accountId;
    }
    private String ticketDescription;
}
