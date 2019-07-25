package com.ibm.test.movietitles.dataaccess;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ibm.test.movietitles.model.Movie;
import com.ibm.test.movietitles.model.MovieQueryResponse;

public class MovieDAOImpl implements MovieDAO {
	
	final static Logger logger = Logger.getLogger(MovieDAOImpl.class);
	
	public static final String API_URL = "https://jsonmock.hackerrank.com/api/movies/search";

	@Override
	public List<Movie> getAllMoviesWithSubstring(String movieTitleSubstring) {

		try {
			int pageNumber = 1;
			int totalPages = 1;
			List<Movie> allMovies = new ArrayList<Movie>();
			
			do {
				URI url = new URIBuilder(API_URL).addParameter("Title", movieTitleSubstring).addParameter("page", String.valueOf(pageNumber)).build();
				RestTemplate restTemplate = new RestTemplate();
				ResponseEntity<MovieQueryResponse> response = restTemplate.getForEntity(url, MovieQueryResponse.class);
				
				totalPages = response.getBody().getTotal_pages();
				pageNumber++;
				allMovies.addAll(response.getBody().getData());
			
			} while (pageNumber <= totalPages);
			
			return allMovies;
		
		} catch (URISyntaxException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		return null;
	}

}
