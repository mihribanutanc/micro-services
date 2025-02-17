package com.reversetech.messaging;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
public class TicketNotification {
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
