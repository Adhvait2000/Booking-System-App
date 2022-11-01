package MOBLIMA;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * The Primary Model Class for storing movie and cineplex data
 * <p>
 * This class handles the data and logic for movies and cineplexes
 * </p>
 * @author ArunEzekiel
 */
public class MovieCineplexModel {
	private static MovieCineplexModel instance = null;
	
	private HashMap<String, Movie> movieList;
	private HashMap<String, Cineplex> cineplexList;
	
	private String moviesDir = "data/movieInfo.dat";
	private String cineplexDir = "data/cineplexInfo.dat";
	
	public static MovieCineplexModel getInstance()
	{
		if(instance == null)
			instance = new MovieCineplexModel();
		
		if(!instance.readCineplexes())
		{
			System.err.println("[MovieCineplexModel] Error: Unable to read Cineplexes");
		}
		
		if(!instance.readMovies())
		{
			System.err.println("[MovieCineplexModel] Error: Unable to read Movies");
		}
		
		return instance;
	}
	
	/**
	 * This method adds new movies into the HashMap movielist
	 * @param movie
	 * @return true when added successfully, false if movie already exists
	 */
	public boolean addMovie(Movie movie)
	{
		if(!movieList.containsKey(movie.getMovieName()))
		{
			movieList.put(movie.getMovieName(), movie);
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
	
	public boolean readMovies()
	{
		return false;
	}
	
	public boolean saveMovies()
	{
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
	public void setMovies(ArrayList<Movie> aMovieList)
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
	public void setCineplex(ArrayList<Cineplex> aCineplexList)
	{
		
	}
	
	public boolean readCineplexes()
	{
		return false;
	}
	
	public boolean saveCineplexes()
	{
		return false;
	}
}
