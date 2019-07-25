package com.ibm.test.movietitles.restcontrollers;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.ibm.test.movietitles.restcontrollers.MoviesTitleRestController;

public class MovieTitlesRestControllerTests {

	@Test
	public void shouldGetSpidermanMovieTitles() {
		
		List<String> titles = new MoviesTitleRestController().getMoviesTitles("spiderman");
		assertEquals(13, titles.size());
		assertEquals("Amazing Spiderman Syndrome", titles.get(0));
	}
}
