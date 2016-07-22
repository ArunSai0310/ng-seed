package io.arun.movies_hub.repository;

import io.arun.movies_hub.entity.Movie;

import java.util.List;

public interface MovieRepository {
	
	public List<Movie> findAll();

	public Movie findOne(String id);
	
	public Movie findByTitle(String title);

	public Movie create(Movie movie);

	public Movie update(Movie movie);

	public void delete(Movie movie);

//	public List<Movie> findAll();
//	
	public List<Movie> findByYear(String year);
//	
//	public Movie create(Movie movie);
//	
//	public Movie update(Movie movie);
//	
//	public Movie findById(String imdbId);
//	
//	public Movie findByTitle(String title);
//	
	public List<Movie> findByRated(String rated);
	
	public List<Movie> findByType(String type);
//	
//	public void delete(Movie movie);
	
	
	
}
