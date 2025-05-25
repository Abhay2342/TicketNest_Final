package com.movie.movieservice.service;

import com.movie.movieservice.entity.Movie;
import com.movie.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie addMovie(Movie movie) {
        movie.setCreatedAt(LocalDateTime.now());
        return movieRepository.save(movie); // Save new movie
    }

    public Movie updateMovie(Integer id, Movie movieDetails) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id " + id));

        movie.setTitle(movieDetails.getTitle());
        movie.setDescription(movieDetails.getDescription());
        movie.setGenre(movieDetails.getGenre());
        movie.setReleaseDate(movieDetails.getReleaseDate());
        movie.setLanguage(movieDetails.getLanguage());
        movie.setDurationMinutes(movieDetails.getDurationMinutes());
        return movieRepository.save(movie); // Save updated movie
    }

    public void deleteMovie(Integer id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id " + id));
        movieRepository.delete(movie); // Delete movie
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll(); // Retrieve all movies
    }

    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id " + id)); // Find by ID
    }
}