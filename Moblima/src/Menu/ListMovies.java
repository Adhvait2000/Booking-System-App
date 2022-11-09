package Menu;

import java.util.ArrayList;

import MOBLIMA.Movie;
import MOBLIMA.MovieCineplexModel;

public class ListMovies extends MenuPage {

	@Override
	public void Initialize() {
		// TODO Auto-generated method stub
		this.endWhenGoNext = true;
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		System.out.println("All Movies");
		
		ArrayList<Movie> movieList = MovieCineplexModel.getInstance().GetMovies();
		
		for(int i = 0; i < movieList.size(); i++)
		{
			System.out.println("..." + movieList.get(i).getMovieName());
		}
		
		System.out.println("");
		System.out.println("...1) Select A Movie");
		System.out.println("...2) Go Back");
	}

	@Override
	public void End() {
		// TODO Auto-generated method stub

	}

}
