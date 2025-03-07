package com.reversetech.ticketservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Builder
@Data
public class TicketDto {

    private String description;

    private String notes;

    private String assigned;

    private Date ticketDate;

    private String priorityType;

    private String ticketStatus;
}
