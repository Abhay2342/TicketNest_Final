package com.movie.cinema.service;

import com.movie.cinema.entity.Cinema;
import com.movie.cinema.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public Cinema addCinema(Cinema cinema) {
        cinema.setCreatedAt(LocalDateTime.now());
        return cinemaRepository.save(cinema); // Save the cinema
    }

    public Cinema updateCinema(Integer id, Cinema cinemaDetails) {
        Cinema cinema = cinemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cinema not found with id " + id));

        cinema.setName(cinemaDetails.getName());
        cinema.setDescription(cinemaDetails.getDescription());
        cinema.setLocation(cinemaDetails.getLocation());
        return cinemaRepository.save(cinema); // Save updated cinema
    }

    public void deleteCinema(Integer id) {
        Cinema cinema = cinemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cinema not found with id " + id));
        cinemaRepository.delete(cinema); // Delete cinema
    }

    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll(); // Retrieve all cinemas
    }

    public Cinema getCinemaById(Integer id) {
        return cinemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cinema not found with id " + id)); // Find by ID
    }
    
    public List<Cinema> getCinemasByMerchantId(Integer merchantId) {
        List<Cinema> cinemas = cinemaRepository.findByMerchantId(merchantId);
        if (cinemas.isEmpty()) {
            throw new RuntimeException("No cinemas found for merchant ID " + merchantId);
        }
        return cinemas;
    }
    
    public List<Cinema> getCinemasByMovieId(Integer movieId) {
        return cinemaRepository.findCinemasByMovieId(movieId);
    }


}