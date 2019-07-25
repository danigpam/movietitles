package com.ibm.test.movietitles.dataaccess;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ibm.test.movietitles.dataaccess.MovieDAOImpl;
import com.ibm.test.movietitles.model.Movie;
import com.ibm.test.movietitles.model.MovieQueryResponse;

public class MovieDAOTests {

	@Test
	public void shouldConnectToRestService() {
		
		RestTemplate restTemplate = new RestTemplate();
		String apiURL = "https://jsonmock.hackerrank.com/api/movies/search?Title=spiderman&page=1";
		ResponseEntity<MovieQueryResponse> response = restTemplate.getForEntity(apiURL, MovieQueryResponse.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(13, response.getBody().getTotal());
		assertEquals(2007, response.getBody().getData().get(0).getYear());
	}
	
	@Test
	public void shouldGetListOfMoviesFromDAO() {
		
		List<Movie> movies = new MovieDAOImpl().getAllMoviesWithSubstring("spiderman");
		assertEquals(13, movies.size());
		assertEquals(2007, movies.get(0).getYear());
	}

}
