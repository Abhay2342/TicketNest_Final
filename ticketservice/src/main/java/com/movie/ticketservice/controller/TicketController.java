package com.movie.ticketservice.controller;

import com.movie.ticketservice.dto.TicketWithMovieDTO;
import com.movie.ticketservice.entity.Ticket;
import com.movie.ticketservice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket showTiming) {
        return ResponseEntity.ok(ticketService.addTicket(showTiming));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Integer id, @RequestBody Ticket showTiming) {
        return ResponseEntity.ok(ticketService.updateTicket(id, showTiming));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable Integer id) {
    	ticketService.deleteTicket(id);
        return ResponseEntity.ok("Ticket deleted successfully.");
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllShowTimings() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getShowTimingById(@PathVariable Integer id) {
        return ResponseEntity.ok(ticketService.getTicketById(id));
    }
    
    @GetMapping("/merchant/{merchantId}/tickets")
    public ResponseEntity<List<TicketWithMovieDTO>> getTicketsByMerchant(@PathVariable Long merchantId) {
        List<TicketWithMovieDTO> tickets = ticketService.getTicketsByMerchantId(merchantId);
        return ResponseEntity.ok(tickets);
    }

}