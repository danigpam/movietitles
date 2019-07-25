package com.ibm.test.moviestitle.dataaccess;

import java.util.List;
import com.ibm.test.moviestitle.model.Movie;

public interface MovieDAO {
	
	public List<Movie> getAllMoviesWithSubstring(String movieTitleSubstring);

}
