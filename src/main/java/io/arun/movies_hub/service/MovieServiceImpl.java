package io.arun.movies_hub.service;

import io.arun.movies_hub.entity.Movie;
import io.arun.movies_hub.exception.MovieAlreadyExistException;
import io.arun.movies_hub.exception.MovieNotFound;
import io.arun.movies_hub.repository.MovieRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repository;
	
//	@Override
//	public List<Movie> findAll() {
//		return repository.findAll();
//	}
//
//	@Override
//	public Movie findById(String id) {
//		Movie existing = repository.findById(id);
//		if(existing==null)
//			throw new MovieNotFound("Movie with id="+id+" not found");
//		return existing;
//	}
//
//	@Override
//	public Movie create(Movie movie) {
//		Movie existing = repository.findByTitle(movie.getTitle());
//		if(existing!=null)
//		{
//			throw new MovieAlreadyExistException("Movie with the Title = "+existing.getTitle()+" already exists");
//		}
//		return repository.create(movie);
//	}
//
//	@Override
//	public Movie update(String id, Movie movie) {
//		Movie existing = repository.findById(id);
//		if(existing==null)
//			throw new MovieNotFound("Movie with id="+id+" not found");
//		return repository.update(movie);
//	}
//
//	@Override
//	public void delete(String id) {
//		Movie existing = repository.findById(id);
//		if(existing==null)
//			throw new MovieNotFound("Movie with id="+id+" not found");
//		repository.delete(existing);
//	}
//
	@Override
	public List<Movie> findByYear(String year) {
		List<Movie> existing = repository.findByYear(year);
		if(existing==null)
			throw new MovieNotFound("Movies with year="+year+" not found");
		return existing;
	}

	@Override
	public Movie findByTitle(String title) {
		Movie existing = repository.findByTitle(title);
		if(existing==null)
			throw new MovieNotFound("Movie with title="+title+" not found");
		return existing;
	}

	@Override
	public List<Movie> findByRated(String rated) {
		List<Movie> existing = repository.findByRated(rated);
		if(existing==null)
			throw new MovieNotFound("Movies with rated="+rated+" not found");
		return existing;
	}

	@Override
	public List<Movie> findByType(String type) {
		List<Movie> existing = repository.findByType(type);
		if(existing==null)
			throw new MovieNotFound("Movies with type="+type+" not found");
		return existing;
	}
	
	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie findOne(String id) {
		Movie existingMovie = repository.findOne(id);
		if(existingMovie == null){
			throw new MovieNotFound("Movie with id: "+ id+" not found");
		}
		return existingMovie;		
	}

	@Override
	public Movie create(Movie movie) {
		Movie existingMovie = repository.findByTitle(movie.getTitle());
		if(existingMovie == null){
			return repository.create(movie);
		}
		throw new MovieAlreadyExistException("Movie with title "+movie.getTitle()+ " already exists");
		
	}

	@Override
	public Movie update(String id, Movie movie) {
		Movie existingMovie = repository.findOne(id);
		if(existingMovie == null){
			throw new MovieNotFound("Movie with id: "+ id+" not found");
		}
		return repository.update(movie);	
	}

	@Override
	public void delete(String id) {
		Movie existingMovie = repository.findOne(id);
		if(existingMovie == null){
			throw new MovieNotFound("Movie with id: "+ id+" not found");
		}
	     repository.delete(existingMovie);
	}

}
