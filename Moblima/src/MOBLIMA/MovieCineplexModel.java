package MOBLIMA;
import java.util.HashMap;
import java.util.ArrayList;

class Movie
{
	String name;

	public String getMovieName() {
		// TODO Auto-generated method stub
		return "NOT IMPLEMENTED";
	}

	public String getDirectorName() {
		// TODO Auto-generated method stub
		return "NOT IMPLEMENTED";
	}

	public ArrayList<Show> getShows() {
		// TODO Auto-generated method stub
		return null;
	}
}

/**
 * The Primary Model Class for storing movie and cineplex data
 * <p>
 * This class handles the data and logic for movies and cineplexes
 * </p>
 * @author ArunEzekiel
 */
public class MovieCineplexModel {
	private HashMap<String, Movie> movieList;
	private HashMap<String, Cineplex> cineplexList;
	
	private String moviesDir = "data/movieInfo.dat";
	private String cineplexDir = "data/cineplexInfo.dat";
	
	/**
	 * This method adds new movies into the HashMap movielist
	 * @param movie
	 * @return true when added successfully, false if movie already exists
	 */
	public boolean addMovie(Movie movie)
	{
		if(!movieList.containsKey(movie.name))
		{
			movieList.put(movie.name, movie);
			return true;
		}
		
		return false;
	}
	
	/**
	 * This method deletes movies from the HashMap movielist
	 * @param name
	 * @return true when deleted successfully, false if unable to delete (Movie does not exists)
	 */
	public boolean deleteMovie(String name)
	{
		if(movieList.containsKey(name))
		{
			Movie movie = movieList.remove(name);
			return true;
		}
		return false;
	}
	
	/**
	 * This method returns the hashmap in an arraylist form for movie data processing
	 * @return ArrayList of movies in movieList
	 */
	public ArrayList<Movie> GetMovies()
	{
		return new ArrayList<Movie>(movieList.values());
	}
	
	/**
	 * This method sets the movie list to the given one
	 * @param aMovieList
	 */
	public void SetMovies(ArrayList<Movie> aMovieList)
	{
		
	}
	
	/**
	 * This method deletes movies from the HashMap movielist
	 * @param name
	 * @return true when deleted successfully, false if unable to delete (Movie does not exists)
	 */
	boolean deleteCineplex(String name)
	{
		if(cineplexList.containsKey(name))
		{
			Cineplex cineplex = cineplexList.remove(name);
			return true;
		}
		return false;
	}
	
	/**
	 * This method returns the hashmap in an arraylist form for movie data processing
	 * @return ArrayList of movies in movieList
	 */
	public ArrayList<Cineplex> GetCineplexes()
	{
		return new ArrayList<Cineplex>(cineplexList.values());
	}
	
	/**
	 * This method adds new movies into the HashMap movielist
	 * @param movie
	 * @return true when added successfully, false if movie already exists
	 */
	public boolean addCineplex(Cineplex cineplex)
	{
		if(!cineplexList.containsKey(cineplex.getNameCineplex()))
		{
			cineplexList.put(cineplex.getNameCineplex(), cineplex);
			return true;
		}
		
		return false;
	}
	
	/**
	 * This method sets the cineplex list to the given one
	 * @param aCineplexList
	 */
	public void SetCineplex(ArrayList<Cineplex> aCineplexList)
	{
		
	}
}
