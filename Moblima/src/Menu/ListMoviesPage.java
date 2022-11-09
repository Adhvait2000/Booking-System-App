package Menu;

import java.util.ArrayList;

import MOBLIMA.Cineplex;
import MOBLIMA.Movie;
import MOBLIMA.MovieCineplexModel;

public class ListMoviesPage extends MenuPage {

	@Override
	public void Initialize() {
		// TODO Auto-generated method stub
		this.endWhenGoNext = true;
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		System.out.println("All Movies");
		Movie selectedMovie = movieSelect();
		
		ArrayList<Cineplex> cineplexList = MovieCineplexModel.getInstance().GetCineplexes();
		
		for(int i = 0; i < cineplexList.size(); ++i)
		{

		}			
	}

	Movie movieSelect()
	{
		System.out.println("...Select A Movie");
		
		ArrayList<Movie> movieList = MovieCineplexModel.getInstance().GetMovies();
		
		for(int i = 0; i < movieList.size(); i++)
		{
			System.out.printf("...%d)" + movieList.get(i).getMovieName() + "\n", i+1);
		}
		
		System.out.println();
		System.out.printf("...%d) Go Back\n", movieList.size()+1);
		
		int movieIndex = ValidInputManager.GetIntWithinRange(1, movieList.size()+2);
		return movieList.get(movieIndex);
	}
	
	@Override
	public void End() {
		// TODO Auto-generated method stub

	}

}
