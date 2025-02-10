package com.reversetech.ticketservice.api;

import com.reversetech.ticketservice.dto.TicketDto;
import com.reversetech.ticketservice.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/ticket")
public class TicketApi {

    private TicketService ticketService;

    @PostMapping
    public TicketDto create(@RequestBody TicketDto ticketDto){
        //return ticketService.save(ticketDto);
        return null;
    }

}
