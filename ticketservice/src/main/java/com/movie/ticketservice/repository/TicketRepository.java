package com.movie.ticketservice.repository;

import com.movie.ticketservice.entity.Ticket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    // Additional query methods can be defined here
	@Query(value = "SELECT t.id, t.user_id, t.status, t.show_id, t.seat_numbers, " +
            "t.seats_booked, t.qr_code, t.booking_timing, m.title AS movie_name " +
            "FROM tickets t " +
            "JOIN show_timings s ON t.show_id = s.id " +
            "JOIN cinemas c ON s.cinema_id = c.id " +
            "JOIN movies m ON s.movie_id = m.id " +
            "WHERE c.merchant_id = :merchantId", nativeQuery = true)
List<Object[]> findAllTicketsWithMovieNameByMerchantId(@Param("merchantId") Long merchantId);



}