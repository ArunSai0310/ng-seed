package io.arun.movies_hub.service;

import io.arun.movies_hub.entity.Movie;

import java.util.List;

public interface MovieService {

//	public List<Movie> findAll();
//	
//	public Movie findById(String id);
//	
	public List<Movie> findByYear(String year);
//	
	public Movie findByTitle(String title);
//	
	public List<Movie> findByRated(String rated);
//	
	public List<Movie> findByType(String type);
//	
//	public Movie create(Movie movie);
//	
//	public Movie update(String id, Movie user);
//	 
//	public void delete(String id);
	
	public List<Movie> findAll();
	public Movie findOne(String id);
	public Movie create(Movie movie);
	public Movie update(String id, Movie movie);
	public void delete(String id);
	
}
