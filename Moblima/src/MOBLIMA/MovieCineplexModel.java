package MOBLIMA;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * The Primary Model Class for storing movie and cineplex data
 * <p>
 * This class handles the data and logic for movies and cineplexes
 * </p>
 * 
 * @author ArunEzekiel
 */
public class MovieCineplexModel {
	private static MovieCineplexModel instance = null;

	private HashMap<String, Movie> movieList;
	private HashMap<String, Cineplex> cineplexList;

	private String moviesDir = System.getProperty("user.dir") + "/Moblima/data/movies.txt";
	private String cineplexDir = System.getProperty("user.dir") + "/Moblima/data/cineplex.txt";

	public static MovieCineplexModel getInstance() {
		if (instance == null) {
			instance = new MovieCineplexModel();
			
        	String dir = "";
    		// If using windows
    		if(System.getProperty("os.name").startsWith("Windows"))
    		{
    			instance.moviesDir = System.getProperty("user.dir") + "/data/movies.txt";
    			instance.cineplexDir = System.getProperty("user.dir") + "/data/cineplex.txt";
    		}else
    		{
    			instance.moviesDir = System.getProperty("user.dir") + "/Moblima/data/movies.txt";
    			instance.cineplexDir = System.getProperty("user.dir") + "/Moblima/data/cineplex.txt";
    		}
    		
    		

			if (!instance.readCineplexes()) {
				System.err.println("[MovieCineplexModel] Error: Unable to read Cineplexes");
			}

			if (!instance.readMovies()) {
				System.err.println("[MovieCineplexModel] Error: Unable to read Movies");
			}
		}

		return instance;
	}

	/**
	 * This method adds new movies into the HashMap movielist
	 * 
	 * @param movie
	 * @return true when added successfully, false if movie already exists
	 */
	public boolean addMovie(Movie movie) {
		if (!movieList.containsKey(movie.getMovieName())) {
			movieList.put(movie.getMovieName(), movie);
			return true;
		}

		return false;
	}

	/**
	 * This method deletes movies from the HashMap movielist
	 * 
	 * @param name
	 * @return true when deleted successfully, false if unable to delete (Movie does
	 *         not exists)
	 */
	public boolean deleteMovie(String name) {
		if (movieList.containsKey(name)) {
			Movie movie = movieList.remove(name);
			return true;
		}
		return false;
	}

	public boolean readMovies() {
		MovieIO temp = new MovieIO();
		try {
			this.setMovies(temp.readMovie(moviesDir));
			return true;
		} catch (Exception e) {
			System.out.println("[MovieCineplexModel] " + e.getMessage());
		}
		return false;
	}

	public boolean saveMovies() {
		MovieIO temp = new MovieIO();
		try {
			temp.saveMovie(moviesDir, this.GetMovies());
		} catch (Exception e) {
			System.out.println("[MovieCineplexModel] " + e.getMessage());
		}
		return false;
	}

	/**
	 * This method returns the hashmap in an arraylist form for movie data
	 * processing
	 * 
	 * @return ArrayList of movies in movieList
	 */
	public ArrayList<Movie> GetMovies() {
		return new ArrayList<Movie>(movieList.values());
	}

	/**
	 * This method sets the movie list to the given one
	 * 
	 * @param aMovieList
	 */
	public void setMovies(ArrayList<Movie> aMovieList) {
		if (movieList != null)
			movieList.clear();
		else
			movieList = new HashMap<String, Movie>();

		for (int i = 0; i < aMovieList.size(); i++) {
			Movie temp = aMovieList.get(i);
			if(!temp.getShowingStatus().equals("COMING_SOON"))
				temp.readShowDetails(this);
			movieList.put(temp.getMovieName(), temp);
		}
	}

	/**
	 * This method deletes movies from the HashMap movielist
	 * 
	 * @param name
	 * @return true when deleted successfully, false if unable to delete (Movie does
	 *         not exists)
	 */
	boolean deleteCineplex(String name) {
		if (cineplexList.containsKey(name)) {
			Cineplex cineplex = cineplexList.remove(name);
			return true;
		}
		return false;
	}

	/**
	 * This method returns the hashmap in an arraylist form for movie data
	 * processing
	 * 
	 * @return ArrayList of movies in movieList
	 */
	public ArrayList<Cineplex> GetCineplexes() {
		return new ArrayList<Cineplex>(cineplexList.values());
	}

	/**
	 * This method adds new movies into the HashMap movielist
	 * 
	 * @param movie
	 * @return true when added successfully, false if movie already exists
	 */
	public boolean addCineplex(Cineplex cineplex) {
		if (!cineplexList.containsKey(cineplex.getNameCineplex())) {
			cineplexList.put(cineplex.getNameCineplex(), cineplex);
			return true;
		}

		return false;
	}

	/**
	 * This method sets the cineplex list to the given one
	 * 
	 * @param aCineplexList
	 */
	public void setCineplex(ArrayList<Cineplex> aCineplexList) {
		if (cineplexList != null)
			cineplexList.clear();
		else
			cineplexList = new HashMap<String, Cineplex>();

		for (int i = 0; i < aCineplexList.size(); i++) {
			Cineplex temp = aCineplexList.get(i);
			cineplexList.put(temp.getNameCineplex(), temp);
		}
	}

	public boolean readCineplexes() {
		CineplexIO temp = new CineplexIO();
		setCineplex(temp.accessCineplex());
		return true;
	}

	public boolean saveCineplexes() {
		CineplexIO temp = new CineplexIO();
		try {
			temp.cinStore(this.GetCineplexes());
			return true;
		} catch (Exception e) {
			System.err.println("[MovieCineplexModel] " + e.getMessage());
		}
		return false;
	}

	public boolean updateMovie(String movieName, Movie movie) {
		if (movieList.containsKey(movieName)) {
			movieList.replace(movieName, movie);
			return true;
		}
		return false;
	}
}
