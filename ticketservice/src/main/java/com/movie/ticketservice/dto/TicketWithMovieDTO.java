package com.movie.ticketservice.dto;

import java.time.LocalDateTime;

public class TicketWithMovieDTO {
    private Integer id;
    private Integer userId;
    private String status;
    private Integer showId;
    private String seatNumbers;
    private Integer seatsBooked;
    private String qrCode;
    private LocalDateTime bookingTiming;
    private String movieName;

    public TicketWithMovieDTO(Integer id, Integer userId, String status, Integer showId,
                               String seatNumbers, Integer seatsBooked, String qrCode,
                               LocalDateTime bookingTiming, String movieName) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.showId = showId;
        this.seatNumbers = seatNumbers;
        this.seatsBooked = seatsBooked;
        this.qrCode = qrCode;
        this.bookingTiming = bookingTiming;
        this.movieName = movieName;
    }

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

	public String getSeatNumbers() {
		return seatNumbers;
	}

	public void setSeatNumbers(String seatNumbers) {
		this.seatNumbers = seatNumbers;
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

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

    // Getters and Setters (or make fields public if preferred for simplicity)
}
