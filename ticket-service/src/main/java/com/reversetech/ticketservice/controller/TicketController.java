package com.reversetech.ticketservice.controller;

import com.reversetech.ticketservice.api.TicketApi;
import com.reversetech.ticketservice.dto.TicketDto;
import com.reversetech.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TicketController implements TicketApi {

    private final TicketService ticketService;


    @Override
    public TicketDto create(TicketDto ticketDto) {
        return ticketService.save(ticketDto);
    }

    @Override
    public TicketDto getById(UUID id) {
        return ticketService.getById(id);
    }

    @Override
    public List<TicketDto> getAll() {
        return ticketService.getTickets();
    }

    @Override
    public TicketDto update(UUID id, TicketDto ticketDto) {
        return ticketService.update(id, ticketDto);
    }

    @Override
    public void delete(UUID id) {
        ticketService.delete(id);
    }
}
