package com.movie.ticketservice.service;

import com.movie.ticketservice.dto.TicketWithMovieDTO;
import com.movie.ticketservice.entity.Ticket;
import com.movie.ticketservice.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket addTicket(Ticket ticket) {
    	String randomQRCode = UUID.randomUUID().toString(); // generates a unique QR code
        ticket.setQrCode(randomQRCode);
        System.out.println("Generated QR Code: " + randomQRCode);
    	ticket.setBookingTiming(LocalDateTime.now());
        return ticketRepository.save(ticket); // Save new show timing
    }

    public Ticket updateTicket(Integer id, Ticket ticketDetails) {
    	Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id " + id));

    	ticket.setBookingTiming(ticketDetails.getBookingTiming());
    	ticket.setQrCode(ticketDetails.getQrCode());
    	ticket.setSeatsBooked(ticketDetails.getSeatsBooked());
    	ticket.setShowId(ticketDetails.getShowId()); // Resetting available seats
    	ticket.setStatus(ticketDetails.getStatus());
    	ticket.setUserId(ticketDetails.getUserId());
        return ticketRepository.save(ticket); // Save updated show timing
    }

    public void deleteTicket(Integer id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id " + id));
        ticketRepository.delete(ticket); // Delete show timing
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll(); // Retrieve all show timings
    }

    public Ticket getTicketById(Integer id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show timing not found with id " + id)); // Find by ID
    }
    
    public List<TicketWithMovieDTO> getTicketsByMerchantId(Long merchantId) {
        List<Object[]> results = ticketRepository.findAllTicketsWithMovieNameByMerchantId(merchantId);
        return results.stream().map(obj -> new TicketWithMovieDTO(
            (Integer) obj[0],
            (Integer) obj[1],
            (String) obj[2],
            (Integer) obj[3],
            (String) obj[4],
            (Integer) obj[5],
            (String) obj[6],
            obj[7] != null ? ((java.sql.Timestamp) obj[7]).toLocalDateTime() : null,
            (String) obj[8]
        )).toList();
    }


}