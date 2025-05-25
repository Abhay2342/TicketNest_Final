package com.movie.showtimingservice.controller;

import com.movie.showtimingservice.entity.ShowTiming;
import com.movie.showtimingservice.service.ShowTimingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/show-timings")
public class ShowTimingController {

    @Autowired
    private ShowTimingService showTimingService;

    @PostMapping
    public ResponseEntity<ShowTiming> addShowTiming(@RequestBody ShowTiming showTiming) {
        return ResponseEntity.ok(showTimingService.addShowTiming(showTiming));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShowTiming> updateShowTiming(@PathVariable Integer id, @RequestBody ShowTiming showTiming) {
        return ResponseEntity.ok(showTimingService.updateShowTiming(id, showTiming));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShowTiming(@PathVariable Integer id) {
        showTimingService.deleteShowTiming(id);
        return ResponseEntity.ok("Show timing deleted successfully.");
    }

    @GetMapping
    public ResponseEntity<List<ShowTiming>> getAllShowTimings() {
        return ResponseEntity.ok(showTimingService.getAllShowTimings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowTiming> getShowTimingById(@PathVariable Integer id) {
        return ResponseEntity.ok(showTimingService.getShowTimingById(id));
    }
    
    @GetMapping("/cinema/{cinemaId}")
    public ResponseEntity<List<ShowTiming>> getByCinemaId(@PathVariable Integer cinemaId) {
        return ResponseEntity.ok(showTimingService.getShowTimingsByCinemaId(cinemaId));
    }
    
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<ShowTiming>> getByMovieId(@PathVariable Integer movieId) {
        return ResponseEntity.ok(showTimingService.getShowTimingsByMovieId(movieId));
    }
    
    
    @GetMapping("/movie-cinema")
    public ResponseEntity<List<ShowTiming>> getByMovieIdAndCinemaId(
            @RequestParam(required = false) Integer movieId,
            @RequestParam(required = false) Integer cinemaId) {

        return ResponseEntity.ok(showTimingService.getShowTimingsByMovieIdAndCinemaId(movieId, cinemaId));
    }


}