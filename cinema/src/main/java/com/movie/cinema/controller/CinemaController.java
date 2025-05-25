package com.movie.cinema.controller;

import com.movie.cinema.entity.Cinema;
import com.movie.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cinemas")
public class CinemaController {
    
    @Autowired
    private CinemaService cinemaService;

    @PostMapping
    public ResponseEntity<Cinema> addCinema(@RequestBody Cinema cinema) {
        return ResponseEntity.ok(cinemaService.addCinema(cinema));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cinema> updateCinema(@PathVariable Integer id, @RequestBody Cinema cinema) {
        return ResponseEntity.ok(cinemaService.updateCinema(id, cinema));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCinema(@PathVariable Integer id) {
        cinemaService.deleteCinema(id);
        return ResponseEntity.ok("Cinema deleted successfully.");
    }

    @GetMapping
    public ResponseEntity<List<Cinema>> getAllCinemas() {
        return ResponseEntity.ok(cinemaService.getAllCinemas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Cinema>> getCinemaById(@PathVariable Integer id) {
        return ResponseEntity.ok(cinemaService.getCinemasByMerchantId(id));
    }
    
    @GetMapping("/by-movie")
    public ResponseEntity<List<Cinema>> getCinemasByMovieId(@RequestParam Integer movieId) {
        List<Cinema> cinemas = cinemaService.getCinemasByMovieId(movieId);
        return ResponseEntity.ok(cinemas);
    }

}