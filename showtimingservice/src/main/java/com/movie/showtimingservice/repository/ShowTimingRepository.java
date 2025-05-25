package com.movie.showtimingservice.repository;

import com.movie.showtimingservice.entity.ShowTiming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ShowTimingRepository extends JpaRepository<ShowTiming, Integer> {
    // Additional query methods can be defined here
	List<ShowTiming> findByCinemaId(Integer cinemaId);
	
	List<ShowTiming> findByMovieId(Integer movieId);
	
	List<ShowTiming> findByMovieIdAndCinemaId(Integer movieId, Integer cinemaId);
}