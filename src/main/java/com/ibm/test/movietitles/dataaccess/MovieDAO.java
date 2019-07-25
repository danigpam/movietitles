package com.ibm.test.movietitles.dataaccess;

import java.util.List;

import com.ibm.test.movietitles.model.Movie;

public interface MovieDAO {
	
	public List<Movie> getAllMoviesWithSubstring(String movieTitleSubstring);

}
