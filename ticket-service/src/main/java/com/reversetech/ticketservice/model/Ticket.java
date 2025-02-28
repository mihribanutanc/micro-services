package com.reversetech.ticketservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tickets")
@Data
public class Ticket extends BaseEntityModel{


    public Ticket() {
    }

    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    protected UUID id;

    public Ticket(UUID id, TicketStatus ticketStatus, PriorityType priorityType, Date ticketDate, String assigned, String notes, String description) {
        this.id = id;
        this.ticketStatus = ticketStatus;
        this.priorityType = priorityType;
        this.ticketDate = ticketDate;
        this.assigned = assigned;
        this.notes = notes;
        this.description = description;
    }

    @Column(name = "description")
    private String description;

    @Column(name = "notes")
    private String notes;

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public PriorityType getPriorityType() {
        return priorityType;
    }

    public void setPriorityType(PriorityType priorityType) {
        this.priorityType = priorityType;
    }

    public Date getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "assignee")
    private String assigned;

    @Column(name = "ticket_date")
    private Date ticketDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority_type")
    private PriorityType priorityType;

    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_status")
    private TicketStatus ticketStatus;

}
