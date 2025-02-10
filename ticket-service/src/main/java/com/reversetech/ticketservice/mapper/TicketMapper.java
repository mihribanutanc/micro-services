package com.reversetech.ticketservice.mapper;


import com.reversetech.ticketservice.dto.TicketDto;
import com.reversetech.ticketservice.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TicketMapper {

    TicketDto toDto(Ticket ticket);

    Ticket toEntity(TicketDto ticketDto);
}
