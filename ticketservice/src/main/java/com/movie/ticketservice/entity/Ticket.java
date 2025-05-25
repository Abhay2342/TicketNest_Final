package com.movie.ticketservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Tickets")
public class Ticket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "status")
    private String status;

    @Column(name = "show_id")
    private Integer showId;
    
    @Column(name = "seat_numbers")
    private String seatNumbers;

    @Column(name = "seats_booked")
    private Integer seatsBooked;

    @Column(name = "qr_code") 
    private String qrCode;

    @Column(name = "booking_time")
    private LocalDateTime bookingTiming;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getShowId() {
		return showId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	public Integer getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(Integer seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public LocalDateTime getBookingTiming() {
		return bookingTiming;
	}

	public void setBookingTiming(LocalDateTime bookingTiming) {
		this.bookingTiming = bookingTiming;
	}

	public String getSeatNumbers() {
		return seatNumbers;
	}

	public void setSeatNumbers(String seatNumbers) {
		this.seatNumbers = seatNumbers;
	}

	

    // Getters and Setters
}