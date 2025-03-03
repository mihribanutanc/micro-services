package com.reversetech.ticketservice.service;


import com.reversetech.client.AccountServiceClient;
import com.reversetech.dto.AccountDto;
import com.reversetech.ticketservice.dto.TicketDto;
import com.reversetech.ticketservice.mapper.TicketMapper;
import com.reversetech.ticketservice.model.Ticket;
import com.reversetech.ticketservice.model.es.TicketModel;
import com.reversetech.ticketservice.repository.TicketRepository;
import com.reversetech.ticketservice.repository.es.TicketElasticSearchRepository;
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

    public TicketService(TicketRepository ticketRepository, TicketMapper ticketMapper, AccountServiceClient accountClient,
                         TicketNotificationService ticketNotificationService, TicketElasticSearchRepository elasticSearchRepository) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
        this.accountClient = accountClient;
        this.ticketNotificationService = ticketNotificationService;
        this.elasticSearchRepository = elasticSearchRepository;
    }

    public TicketService() {
    }

    @Autowired
    private  TicketRepository ticketRepository;

    @Autowired
    private TicketElasticSearchRepository elasticSearchRepository;

    @Autowired
    private  TicketMapper ticketMapper;


    private AccountServiceClient accountClient;

    @Autowired
    private  TicketNotificationService ticketNotificationService;




    public TicketDto save(TicketDto ticketDto){

        Ticket ticket = ticketMapper.toEntity(ticketDto);
        Ticket savedTicket = ticketRepository.save(ticket);

        TicketModel model = new TicketModel();

                model.setDescription(ticket.getDescription());
                model.setNotes(ticket.getNotes());
                model.setId(ticket.getId());


        // elastic kaydet
        elasticSearchRepository.save(model);

        //ResponseEntity<AccountDto> accountRes =  accountClient.get(UUID.fromString(ticketDto.getAssigned()));


       // ticket.setAssigned(Objects.requireNonNull(accountRes.getBody()).getId());

        ticketNotificationService.sendMessage(ticket);



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
