package com.movie.cinema.repository;

import com.movie.cinema.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
    // Additional query methods can be defined here
	List<Cinema> findByMerchantId(Integer merchantId);

	@Query(value = "SELECT DISTINCT c.* FROM cinemas c JOIN show_timings s ON c.id = s.cinema_id WHERE s.movie_id = :movieId", nativeQuery = true)
	List<Cinema> findCinemasByMovieId(@Param("movieId") Integer movieId);



}