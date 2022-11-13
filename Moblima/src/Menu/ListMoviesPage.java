package Menu;

import java.util.ArrayList;
import java.util.HashMap;

import MOBLIMA.Cinema;
import MOBLIMA.Cineplex;
import MOBLIMA.Movie;
import MOBLIMA.MovieCineplexModel;
import MOBLIMA.MovieGoerIO;
import MOBLIMA.MovieTicket;
import MOBLIMA.PriceTicket;
import MOBLIMA.PublicHolidayIO;
import MOBLIMA.Show;
import MOBLIMA.TransactionID;

public class ListMoviesPage extends MenuPage {

	private class MovieOption {
		Cineplex cineplex;
		Cinema cinema;
		Show show;
		Movie movie;

		public MovieOption(Cineplex cineplex, Cinema cinema, Show show, Movie movie) {
			this.cineplex = cineplex;
			this.cinema = cinema;
			this.show = show;
			this.movie = movie;
		}
	}

	ArrayList<MovieOption> displayOptions;

	final int CANCEL = -1;

	@Override
	public void Initialize() {
		// TODO Auto-generated method stub
		this.endWhenGoNext = true;
		displayOptions = new ArrayList<MovieOption>();
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		System.out.println("All Movies");
		Movie selectedMovie = movieSelect();

		if (selectedMovie == null) {
			this.endMenu = true;
			return;
		}

		System.out.println("");
		System.out.println(selectedMovie.getMovieName() + " Movie Details");

		CreateDisplayOptions(selectedMovie);
		int chosenOption = ValidInputManager.GetIntWithinRange(1, displayOptions.size() + 1);
		Show chosenShow = displayOptions.get(chosenOption - 1).show;
		Cinema chosenCinema = displayOptions.get(chosenOption - 1).cinema;
		chosenShow.printSeats();
		boolean seatsOK = false;
		String firstseat = "";
		int numseats = 0;

		while (!seatsOK) {
			System.out.println("...Enter first seat (Enter 'a1' for row-1 seat-1 or 'd5' for row-4 seat-5):");
			firstseat = ValidInputManager.GetString();

			System.out.print("...Enter number of seats: ");
			numseats = ValidInputManager.GetInt();

			char ch = firstseat.charAt(0);
			int firstseatnum = Character.getNumericValue(firstseat.charAt(1)) - 1;
			int row = ch - 'a';
			for (int t = 0; t < numseats; t++) {
				if (!chosenShow.checkingSeat(row, firstseatnum + t)) {
					seatsOK = true;
				} else {
					System.out.println("Error! Seats are unavailable, please choose again");
					seatsOK = false;
					break;
				}
			}
		}

		if (seatsOK) {
			System.out.println("...Select Ticket Type (Adult / SeniorCitizen / Child): ");
			String[] movieGoerCategoryChoices = { "Adult", "SeniorCitizen", "Child" };
			String movieGoerCategory = ValidInputManager.GetStringInChoices(movieGoerCategoryChoices);

			boolean isPublicHoliday = false;
			String date = chosenShow.getTimenDate().split(" ")[0];
			String[] holidays = null;
			PublicHolidayIO h = new PublicHolidayIO();
			try {
				holidays = h.readPublicHolidays();
			} catch (Exception e) {
				System.out.println(e);
			}

			for (int j = 0; j < holidays.length; j++) {
				if (holidays[j].equals(date)) {
					isPublicHoliday = true;
					break;
				}
			}

			MovieTicket ticket = new MovieTicket(chosenShow.get3D(), chosenCinema.getCinemaCategory(),
					movieGoerCategory, isPublicHoliday);

			System.out.printf("...Total Ticket Price: S$%s (Inclusive of GST)\n", ticket.findPrice() * numseats);
			System.out.println("...Confirmation: Book the tickets? (Yes / No)");
			String[] yesOrNo = { "Yes", "No" };
			String confirmation = ValidInputManager.GetStringInChoices(yesOrNo);

			if (confirmation.toLowerCase().equals("yes")) {
				// Enter Customer Email
				System.out.println("...Enter Email now");
				String customerEmail = ValidInputManager.GetString();

				System.out.println("...Enter customer Name");
				String customerName = ValidInputManager.GetString();

				System.out.print("...Enter Phone Number: ");
				int phoneNumber = ValidInputManager.GetIntWithinRange(11111111, 100000000);

				try {
					MovieGoerIO mgio = new MovieGoerIO();
					int showIndex = 0;
					for (int i = 0; i < chosenCinema.getCinemaShows().size(); i++) {
						if (chosenCinema.getCinemaShows().get(i) == chosenShow) {
							showIndex = i;
							break;
						}
					}
					TransactionID T = new TransactionID(displayOptions.get(chosenOption - 1).cineplex);
					String TID = T.getTID();

					mgio.assignSeatsByMovie(selectedMovie, showIndex, customerEmail, customerName, phoneNumber, TID,
							numseats, firstseat);
					selectedMovie.saveShowDetails();
					System.out.println("...Your Movie Tickets have been successfuly booked!");
					System.out.println("...Transaction ID: " + TID);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println("[CustomerPage] Error at assignSeatsByMovie" + e.getMessage());
				}
			} else {
				this.endMenu = true;
				return;
			}
		}

		this.endMenu = true;
	}

	/**
	 * @return Movie
	 */
	Movie movieSelect() {
		boolean checker = true;
		int movieIndex = 0;
		ArrayList<Movie> movieList = MovieCineplexModel.getInstance().GetMovies();

		while (checker) {
			System.out.println("...Select A Movie");

			movieList = MovieCineplexModel.getInstance().GetMovies();

			for (int i = 0; i < movieList.size(); i++) {
				System.out.printf(
						"...%d)" + movieList.get(i).getMovieName() + " " + movieList.get(i).getShowingStatus() + "\n",
						i + 1);
			}

			System.out.println();
			System.out.printf("...%d) Go Back\n", movieList.size() + 1);

			movieIndex = ValidInputManager.GetIntWithinRange(1, movieList.size() + 2);
			if (movieIndex == movieList.size() + 1)
				return null;
			if (movieList.get(movieIndex - 1).getShowingStatus().equals("COMING_SOON")) {
				System.out.println("\nMovie is not available for viewing yet...please choose another movie\n");
				checker = true;
			} else
				checker = false;
		}

		return movieList.get(movieIndex - 1);
	}

	/**
	 * @param selectedMovie
	 */
	void CreateDisplayOptions(Movie selectedMovie) {
		ArrayList<Cineplex> cineplexList = MovieCineplexModel.getInstance().GetCineplexes();

		int optionCounter = 0;
		displayOptions.clear();
		for (int i = 0; i < cineplexList.size(); ++i) {
			ArrayList<Cinema> cinemaList = cineplexList.get(i).getListCinemas();
			boolean cinemaContainsMovie = false;
			for (int j = 0; j < cinemaList.size(); ++j) {
				ArrayList<Show> showList = cinemaList.get(j).getCinemaShows();
				for (int k = 0; k < showList.size(); ++k) {
					Movie currentMovie = showList.get(k).getMovie();
					if (currentMovie.getMovieName().equals(selectedMovie.getMovieName())) {
						if (!cinemaContainsMovie) {
							System.out.println("..." + cineplexList.get(i).getNameCineplex() + ":");
							cinemaContainsMovie = true;
						}
						displayOptions.add(optionCounter,
								new MovieOption(cineplexList.get(i), cinemaList.get(j), showList.get(k), currentMovie));
						System.out.printf("... %d) " + showList.get(k).getTimenDate() + "\n", ++optionCounter);
					}
				}
			}
		}
	}

	@Override
	public void End() {
		// TODO Auto-generated method stub

	}

}
