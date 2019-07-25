package com.ibm.test.moviestitle.restcontrollers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.test.moviestitle.dataaccess.MovieDAOImpl;
import com.ibm.test.moviestitle.model.Movie;

@RestController
public class MoviesTitleRestController {

	final static Logger logger = Logger.getLogger(MoviesTitleRestController.class);

	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<String> getMoviesTitles(@RequestParam(value="substr") String substr) {

		logger.info("Issued GET request: /getMoviesTitles/" + substr);
		
		try {
			List<Movie> movies = new MovieDAOImpl().getAllMoviesWithSubstring(substr);
			
			List<String> moviesTitlesList = movies.stream()
                    .map(Movie::getTitle)
                    .collect(Collectors.toList());
			
			Collections.sort(moviesTitlesList);
			return moviesTitlesList;
		
		} catch (Exception e) {
			logger.error("Error on /getMoviesTitles/" + substr, e);
		}
		return null;
	}

}
