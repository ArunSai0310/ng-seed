package io.arun.movies_hub.repository;

import io.arun.movies_hub.entity.Movie;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

	@PersistenceContext
	private EntityManager em;	
	
	
//	@Override
//	public List<Movie> findAll() {
//		TypedQuery<Movie> query = em.createQuery("from Movie", Movie.class);
//		return query.getResultList();
//	}
//	
//	@Override
//	public Movie create(Movie movie) {
//		em.persist(movie);
//		return movie;
//	}
//
	@Override
	public List<Movie> findByYear(String year) {
		TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE m.year="+year, Movie.class);
		List<Movie> movies = query.getResultList();
		return movies;
	}
//
//	@Override
//	public Movie findById(String imdbId) {
//		return em.find(Movie.class, imdbId);
//	}
//
//	@Override
//	public Movie findByTitle(String title) {
//		//replaced named query
//		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class);
//		query.setParameter("pTitle", title);
//		List<Movie> movies = query.getResultList();
//		if(movies!=null && movies.size()==1)
//			return movies.get(0);
//		else
//			return null;
////		TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE m.title="+title, Movie.class);
////		List<Movie> movies = query.getResultList();
////		if(movies!=null && movies.size()==1)
////			return movies.get(0);
////		else
////			return null;
//	}
//
	@Override
	public List<Movie> findByRated(String rated) {
		TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE m.rated="+rated, Movie.class);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> findByType(String type) {
		TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE m.type="+type, Movie.class);
		List<Movie> movies = query.getResultList();
		return movies;
	}
//
//	@Override
//	public Movie update(Movie movie) {
//		em.merge(movie);
//		return movie;
//	}
//	
//	@Override
//	public void delete(Movie movie) {
//		em.remove(movie);
//	}
	
	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createQuery("from Movie", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String id) {
		return em.find(Movie.class, id);
	}

	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		em.merge(movie);
		return movie;
	}

	@Override
	public void delete(Movie movie) {
		em.remove(movie);
		
	}

	@Override
	public Movie findByTitle(String title) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class);
		query.setParameter("pTitle", title);
		List<Movie> movies = query.getResultList();
		
		if (movies != null && movies.size() == 1) {
			return movies.get(0);
		} else {
			return null;
		}		
	}
	

}
