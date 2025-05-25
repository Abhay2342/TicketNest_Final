package com.movie.movieservice.controller;

import com.movie.movieservice.dto.MovieDTO;
import com.movie.movieservice.entity.Movie;
import com.movie.movieservice.service.MovieService;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    
    @PostMapping("/add")
    public ResponseEntity<?> addMovie(
        @RequestBody MovieDTO movieDTO
    ) {
        try {
            // Save movie data including the image URL
            Movie movie = new Movie();
            movie.setTitle(movieDTO.getTitle());
            movie.setDescription(movieDTO.getDescription());
            movie.setGenre(movieDTO.getGenre());
            movie.setLanguage(movieDTO.getLanguage());
            movie.setReleaseDate(LocalDate.parse(movieDTO.getReleaseDate()));
            movie.setDurationMinutes(movieDTO.getDurationMinutes());
            movie.setImageUrl(movieDTO.getImageUrl());  // Storing the image URL

//            movieRepository.save(movie);

            return ResponseEntity.ok(movieService.addMovie(movie));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body("Error adding movie");
        }
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.updateMovie(id, movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted successfully.");
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }
}