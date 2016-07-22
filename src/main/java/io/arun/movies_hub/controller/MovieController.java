package io.arun.movies_hub.controller;

import java.util.List;

import io.arun.movies_hub.entity.Movie;
import io.arun.movies_hub.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	public MovieService service;
	
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll()
	{
		System.out.println("This is the get all movies route");
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/year/{year}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findByYear(@PathVariable("year") String year)
	{
		return service.findByYear(year);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/title/{title}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findByTitle(@PathVariable("title") String title)
	{
		return service.findByTitle(title);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/rated/{rated}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findByRated(@PathVariable("rated") String rated)
	{
		return service.findByRated(rated);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/type/{type}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findByType(@PathVariable("type") String type)
	{
		return service.findByType(type);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findOne(@PathVariable("id") String id)
	{
		return service.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie movie)
	{
		return service.create(movie);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("id") String id,@RequestBody Movie movie)
	{
		return service.update(id, movie);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public void delete(@PathVariable("id") String id)
	{
		service.delete(id);
	}
	
}
