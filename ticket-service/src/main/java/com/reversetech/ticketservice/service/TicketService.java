package com.reversetech.ticketservice.service;


import com.reversetech.client.AccountServiceClient;
import com.reversetech.dto.AccountDto;
import com.reversetech.ticketservice.dto.TicketDto;
import com.reversetech.ticketservice.mapper.TicketMapper;
import com.reversetech.ticketservice.model.Ticket;
import com.reversetech.ticketservice.repository.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Service
public class TicketService {

    private  TicketRepository ticketRepository;

    private  TicketMapper ticketMapper;

    private  AccountServiceClient accountClient;

    private TicketNotificationService ticketNotificationService;

    public TicketService(TicketRepository ticketRepository, TicketMapper ticketMapper, AccountServiceClient accountClient, TicketNotificationService ticketNotificationService) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
        this.accountClient = accountClient;
        this.ticketNotificationService = ticketNotificationService;
    }
    public TicketService() {
    }
    public TicketDto save(TicketDto ticketDto){

        ResponseEntity<AccountDto> accountRes =  accountClient.get(UUID.fromString(ticketDto.getAssigned()));
        Ticket ticket = ticketMapper.toEntity(ticketDto);

        ticket.setAssigned(Objects.requireNonNull(accountRes.getBody()).getId());

        ticketNotificationService.sendToQueue(ticket);
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

    public  Page<TicketDto> getPagination(Pageable pageable){
        return null;
    };


}
