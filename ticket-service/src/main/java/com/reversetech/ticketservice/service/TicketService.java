package com.reversetech.ticketservice.service;

import com.reversetech.ticketservice.client.AccountService;
import com.reversetech.ticketservice.dto.AccountDto;
import com.reversetech.ticketservice.dto.TicketDto;
import com.reversetech.ticketservice.mapper.TicketMapper;
import com.reversetech.ticketservice.model.Ticket;
import com.reversetech.ticketservice.model.es.TicketModel;
import com.reversetech.ticketservice.repository.TicketRepository;
import com.reversetech.ticketservice.repository.es.TicketElasticSearchRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class TicketService {


    private final TicketRepository ticketRepository;

    private final TicketElasticSearchRepository elasticSearchRepository;

    private final TicketMapper ticketMapper;

    private final AccountService accountClient;

    private final TicketNotificationService ticketNotificationService;


    public TicketDto save(TicketDto ticketDto) {

        Ticket ticket = ticketMapper.toEntity(ticketDto);

        ResponseEntity<AccountDto> accountRes =  accountClient.get(UUID.fromString(ticketDto.getAssigned()));

        if (ObjectUtils.isEmpty(accountRes)) return null;

        ticket.setAssigned(Objects.requireNonNull(accountRes.getBody()).getName());

        Ticket savedTicket = ticketRepository.save(ticket);

        TicketModel model = new TicketModel();
        model.setId(savedTicket.getId());
        model.setDescription(savedTicket.getDescription());
        model.setNotes(savedTicket.getNotes());

        elasticSearchRepository.save(model);

        ticketNotificationService.sendMessage(savedTicket);

        return ticketMapper.toDto(savedTicket);
    }

    public TicketDto update(UUID id, TicketDto ticketDto) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());

        Ticket updatedTicket = ticketRepository.save(ticket);

        TicketModel model = new TicketModel();
        model.setId(updatedTicket.getId());
        model.setDescription(updatedTicket.getDescription());
        model.setNotes(updatedTicket.getNotes());
        elasticSearchRepository.save(model);

        return ticketMapper.toDto(updatedTicket);
    }

    public TicketDto getById(UUID ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
        return ticketMapper.toDto(ticket);
    }

    public List<TicketDto> getTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream().map(ticketMapper::toDto).toList();
    }

    public Page<TicketDto> getPagination(Pageable pageable) {
        Page<Ticket> ticketPage = ticketRepository.findAll(pageable);
        return ticketPage.map(ticketMapper::toDto);
    }

    public void delete(UUID id) {
        ticketRepository.deleteById(id);
    }
}
