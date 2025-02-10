package com.reversetech.ticketservice.service;


import com.reversetech.ticketservice.dto.TicketDto;
import com.reversetech.ticketservice.mapper.TicketMapper;
import com.reversetech.ticketservice.model.Ticket;
import com.reversetech.ticketservice.repository.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketService {

   
    
    private  TicketRepository ticketRepository;
    
    private  TicketMapper ticketMapper;
    
    public TicketService(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }
    public TicketService() {
    }
    public TicketDto save(TicketDto ticketDto){
        Ticket ticket = ticketMapper.toEntity(ticketDto);
        Ticket savedTicket = ticketRepository.save(ticket);
        return ticketMapper.toDto(savedTicket);
    };

    public TicketDto update(String id, TicketDto ticketDto){


        return null;
    };

    public TicketDto getById(String ticketId){
        return null;
    };

    public List<TicketDto> getTickets(){
        return null;
    };
    

}
