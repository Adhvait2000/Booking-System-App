package Menu;

import java.util.ArrayList;

import MOBLIMA.Movie;
import MOBLIMA.MovieCineplexModel;
import MOBLIMA.Show;

public class SelectMoviePage extends MenuPage {

	@Override
	public void Initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		System.out.println("Select A Movie");
		ArrayList<Movie> movieList = MovieCineplexModel.getInstance().GetMovies();
		for (int i = 0; i < movieList.size(); i++) {
			System.out.printf("...%d) " + movieList.get(i).getMovieName() + "\n", i + 1);
		}
		System.out.printf("...%d) " + "Go Back\n", movieList.size() + 1);

		int choice = ValidInputManager.GetIntWithinRange(1, movieList.size() + 2); // +2 because option +1 will be used
																					// for going back
		if (choice == movieList.size() + 1) {
			this.endMenu = true;
			return;
		}

		Movie pickedMovie = movieList.get(choice - 1);
		System.out.println("");
		System.out.println(pickedMovie.getMovieName());
		System.out.println("...Director Name: " + pickedMovie.getDirector());

		System.out.println("...Review(s): ");
		String[] reviews = pickedMovie.getReviews();

		if (reviews.length > 0) {
			for (int i = 0; i < reviews.length; i++) {
				System.out.printf("......%d) " + reviews[i] + "\n", i + 1);
			}
		} else {
			System.out.println("......No Reviews yet");
		}

		System.out.println("...Rating(s): ");

		double[] ratings = pickedMovie.getAllRatings();

		if (ratings.length > 0) {
			for (int i = 0; i < ratings.length; i++) {
				System.out.printf("......%d) %.1f / 5\n", i + 1, ratings[i]);
			}
		} else {
			System.out.println("......No Ratings yet");
		}

		System.out.println("...Movie Status: " + pickedMovie.getShowingStatus());
		System.out.println("...Synopsis: " + pickedMovie.getSynopsis());
		System.out.println("...Cast: ");

		String[] cast = pickedMovie.getCast();

		if (cast.length > 0) {
			for (int i = 0; i < cast.length; i++) {
				if (cast[i] == null || cast[i].equals("null"))
					break;
				System.out.printf("......%d) " + cast[i] + "\n", i + 1);
			}
		} else {
			System.out.println("......No Cast? What?");
		}

		System.out.println("...Shows");
		ArrayList<Show> pickedShows = pickedMovie.getShows();
		if (pickedShows.size() > 0) {
			for (int i = 0; i < pickedShows.size(); i++) {
				Show show = pickedShows.get(i);

				System.out.printf("......[Show No.%d]\n", i + 1);
				System.out.println(".........Show Time: " + show.getTimenDate());
				System.out.printf(".........Cineplex ID: %d\n", show.getCineplexID() + 1);
				System.out.printf(".........Cinema ID: %d\n", show.getScreenNumber() + 1);
				System.out.println("");
			}
		} else {
			System.out.println("......No shows for " + pickedMovie.getMovieName() + " at the moment");
		}
		System.out.println("");

		System.out.println("");

	}

	@Override
	public void End() {
		// TODO Auto-generated method stub

	}
}
