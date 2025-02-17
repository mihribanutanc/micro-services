package com.reversetech.ticketservice.api;

import com.reversetech.ticketservice.dto.TicketDto;
import com.reversetech.ticketservice.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketApi {

    @Autowired
    private TicketService ticketService;

    public TicketApi(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public TicketDto create(@RequestBody TicketDto ticketDto){
        return ticketService.save(ticketDto);
    }

}
