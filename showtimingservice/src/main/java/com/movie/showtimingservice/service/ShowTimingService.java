package com.movie.showtimingservice.service;

import com.movie.showtimingservice.entity.ShowTiming;
import com.movie.showtimingservice.repository.ShowTimingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShowTimingService {

    @Autowired
    private ShowTimingRepository showTimingRepository;

    public ShowTiming addShowTiming(ShowTiming showTiming) {
        showTiming.setCreatedAt(LocalDateTime.now());
        showTiming.setAvailableSeats(showTiming.getTotalSeats()); // Initially, all seats are available
        return showTimingRepository.save(showTiming); // Save new show timing
    }

    public ShowTiming updateShowTiming(Integer id, ShowTiming showTimingDetails) {
        ShowTiming showTiming = showTimingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show timing not found with id " + id));

        showTiming.setShowDate(showTimingDetails.getShowDate());
        showTiming.setShowTime(showTimingDetails.getShowTime());
        showTiming.setTicketPrice(showTimingDetails.getTicketPrice());
        showTiming.setTotalSeats(showTimingDetails.getTotalSeats());
        showTiming.setAvailableSeats(showTimingDetails.getTotalSeats()); // Resetting available seats
        showTiming.setCinemaId(showTimingDetails.getCinemaId());
        showTiming.setMovieId(showTimingDetails.getMovieId());
        return showTimingRepository.save(showTiming); // Save updated show timing
    }

    public void deleteShowTiming(Integer id) {
        ShowTiming showTiming = showTimingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show timing not found with id " + id));
        showTimingRepository.delete(showTiming); // Delete show timing
    }

    public List<ShowTiming> getAllShowTimings() {
        return showTimingRepository.findAll(); // Retrieve all show timings
    }

    public ShowTiming getShowTimingById(Integer id) {
        return showTimingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show timing not found with id " + id)); // Find by ID
    }
    
    public List<ShowTiming> getShowTimingsByCinemaId(Integer cinemaId) {
        return showTimingRepository.findByCinemaId(cinemaId);
    }
    
    public List<ShowTiming> getShowTimingsByMovieId(Integer movieId) {
        return showTimingRepository.findByMovieId(movieId);
    }
    
    public List<ShowTiming> getShowTimingsByMovieIdAndCinemaId(Integer movieId, Integer cinemaId) {
        return showTimingRepository.findByMovieIdAndCinemaId(movieId, cinemaId);
    }


}