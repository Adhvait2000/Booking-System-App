package Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import MOBLIMA.Cineplex;
import MOBLIMA.Show;
import MOBLIMA.MovieCineplexModel;
import MOBLIMA.Movie;
import MOBLIMA.MovieGoerIO;
import MOBLIMA.PublicHolidayIO;
import MOBLIMA.MovieTicket;
import MOBLIMA.TransactionID;
import MOBLIMA.MovieGoer;
import MOBLIMA.BookingTicket;

public class CustomerPage extends MenuPage {
	static final int VIEWMOVIES = 1;
	static final int VIEWREVIEWS = 2;
	static final int BOOKING_HISTORY = 3;
	static final int TOP_RANKING = 4;
	static final int ALL_CINEPLEX = 5;
	static final int WRITEREVIEWRATING = 6;

	@Override
	public void Initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		System.out.println("Customer Mode");
		System.out.println("...1) View Movies");
		System.out.println("...2) View Reviews");
		System.out.println("...3) View booking history");
		System.out.println("...4) List top 5 movies ranked by ticket sales or overall reviewer's ratings");
		System.out.println("...5) List all Cineplexes");
		System.out.println("...6) Write a review / Give Rating");
		System.out.println("...7) Go Back");

		int choice = ValidInputManager.GetIntWithinRange(1, 7);
		System.out.println("");

		switch (choice) {
			case VIEWMOVIES:
				// MovieDetailsUpdate();
				this.nextPage = new ListMoviesPage();
				this.goNext = true;
				break;
			case VIEWREVIEWS:
				MovieDetailsUpdate();
				break;
			case BOOKING_HISTORY:
				ViewBookingHistoryUpdate();
				break;
			case TOP_RANKING:
				TopRankingUpdate();
				break;
			case ALL_CINEPLEX:
				ListAllCineplexesUpdate();
				break;
			case WRITEREVIEWRATING:
				ReviewRatingUpdate();
				break;
		}
		endMenu = true;
	}

	public void MovieDetailsUpdate() {
		System.out.println("All Movie Listings");
		ArrayList<Movie> movieList = MovieCineplexModel.getInstance().GetMovies();

		for (int i = 0; i < movieList.size(); i++) {
			System.out.println("..." + movieList.get(i).getMovieName());
		}

		System.out.println("");
		System.out.println("...1) Select A Movie");
		System.out.println("...2) Go Back");

		int choice = ValidInputManager.GetIntWithinRange(1, 3);
		if (choice == 1) {
			nextPage = new SelectMoviePage();
			goNext = true;
		} else {
			System.out.println("");
			return;
		}

	}

	public void SeatAvailabilityUpdate() {
		System.out.println("Check Seat Availability");
		ArrayList<Cineplex> cineplexes = null;
		try {
			cineplexes = MovieCineplexModel.getInstance().GetCineplexes();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}

		for (int i = 0; i < cineplexes.size(); i++) {
			System.out.printf("...%d) " + cineplexes.get(i).getNameCineplex() + "\n", i + 1);
		}

		System.out.printf("...%d) Back\n", cineplexes.size() + 1);
		int cineplexChoice = ValidInputManager.GetIntWithinRange(1, cineplexes.size() + 2);

		if (cineplexChoice == cineplexes.size() + 1)
			return;

		System.out.printf("...Select Cinema Screen: 1, 2, 3\n");
		int cinemaChoice = ValidInputManager.GetIntWithinRange(1, 4);

		System.out.println("");
		System.out.printf("Cinema No.%d Movies:\n", cinemaChoice);
		ArrayList<Show> showList = MovieCineplexModel.getInstance().GetCineplexes().get(cineplexChoice - 1)
				.getListCinemas().get(cinemaChoice - 1).getCinemaShows();

		for (int i = 0; i < showList.size(); i++) {
			Show show = showList.get(i);
			show.printSeats();
		}
	}

	public void ReviewRatingUpdate() {
		System.out.println("Write a Review / Give a Rating");
		ArrayList<Movie> movieList = MovieCineplexModel.getInstance().GetMovies();

		for (int i = 0; i < movieList.size(); i++) {
			System.out.printf("...%d) " + movieList.get(i).getMovieName() + "\n", i + 1);
		}

		int movieChoice = ValidInputManager.GetIntWithinRange(1, movieList.size() + 2);

		if (movieChoice == movieList.size() + 1) {
			return;
		}

		Movie chosenMovie = movieList.get(movieChoice - 1);
		System.out.println("");
		System.out.println("Review or Rating");
		System.out.println("...1. Write a Review");
		System.out.println("...2. Give a Rating");
		System.out.println("...3. Go Back");
		int actionChoice = ValidInputManager.GetIntWithinRange(1, 4);

		if (actionChoice == 3)
			return;

		if (actionChoice == 1) {
			System.out.printf("...Please input your review: \n");
			String review = ValidInputManager.GetString();
			chosenMovie.writeReview(review);
			MovieCineplexModel.getInstance().saveMovies();
			System.out.println("...Review Added!");
			return;
		} else {
			System.out.printf("...Please input your rating: ");
			double rating = ValidInputManager.GetDoubleWithinRange(0, 5);
			chosenMovie.giveRating(rating);
			MovieCineplexModel.getInstance().saveMovies();
			System.out.println("...Rating Added!");
			return;
		}
	}

	public void TopRankingUpdate() {
		System.out.println("Top Rankings");
		ArrayList<Movie> movies = MovieCineplexModel.getInstance().GetMovies();

		System.out.println("...Top Ticket Sales");
		Collections.sort(movies, Movie.topticketsales);
		for (int i = movies.size() - 1; i >= 0; i--)
			System.out.println("......" + movies.get(i).getMovieName() + ": " + movies.get(i).getTSales());

		System.out.println("...Top Ratings");
		Collections.sort(movies, Movie.topratings);
		for (int i = movies.size() - 1; i >= 0; i--)
			System.out.println("...... " + movies.get(i).getMovieName() + ": " + movies.get(i).getTotalRatings());
	}

	public void ListAllCineplexesUpdate() {
		System.out.println("List All Cineplexes");
		ArrayList<Cineplex> Cineplexes = MovieCineplexModel.getInstance().GetCineplexes();

		for (int i = 0; i < Cineplexes.size(); i++)
			System.out.printf("%d) " + Cineplexes.get(i).getNameCineplex() + "\n", i + 1);
	}

	public void PurchaseTicketsUpdate() {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		movies = MovieCineplexModel.getInstance().GetMovies();

		// Enter Customer Email
		System.out.println("...Enter Email now");
		String customerEmail = ValidInputManager.GetString();

		System.out.println("...Enter customer Name");
		String customerName = ValidInputManager.GetString();

		System.out.print("...Enter Phone Number: ");
		int phoneNumber = ValidInputManager.GetIntWithinRange(11111111, 100000000);

		System.out.println("...Enter Movie Goer Category (Adult / SeniorCitizen / Child): ");

		String[] movieGoerCategoryChoices = { "Adult", "SeniorCitizen", "Child" };
		String movieGoerCategory = ValidInputManager.GetStringInChoices(movieGoerCategoryChoices);

		System.out.println("All Movies");

		for (int i = 0; i < movies.size(); i++)
			System.out.printf("...%d) " + movies.get(i).getMovieName() + "\n", i + 1);

		System.out.println("...Enter Movie ID to be booked");
		int movieID = ValidInputManager.GetIntWithinRange(1, movies.size() + 1);
		Movie movieBooked = movies.get(movieID - 1);

		String[] holidays = null;
		PublicHolidayIO h = new PublicHolidayIO();
		try {
			holidays = h.readPublicHolidays();
		} catch (Exception e) {
			System.out.println(e);
		}

		String tempstring;

		ArrayList<Show> showList = movieBooked.getShows();

		for (int i = 0; i < showList.size(); i++) {
			boolean publicHoliday = false;
			Show s = showList.get(i);

			tempstring = s.getTimenDate().split(" ")[0];
			for (int j = 0; j < holidays.length; j++) {
				if (holidays[j].equals(tempstring)) {
					publicHoliday = true;
					break;
				}
			}

			String cinemaType = MovieCineplexModel.getInstance().GetCineplexes().get(s.getCineplexID()).getListCinemas()
					.get(s.getScreenNumber()).getCinemaCategory();
			MovieTicket ticket = new MovieTicket(s.get3D(), cinemaType, movieGoerCategory, publicHoliday);
			System.out.printf("\n\n...Show %d:\n", i + 1);
			System.out.println("...Date Time: " + s.getTimenDate());
			System.out.printf("...Cineplex ID: %d\n", s.getCineplexID() + 1);
			System.out.printf("...Cinema ID: %d\n", s.getScreenNumber() + 1);
			System.out.printf("...Cinema Class: %s\n", cinemaType);
			System.out.printf("...3D: %s\n", s.get3D());
			System.out.printf("...Ticket Price: S$%s (Inclusive of GST)\n", ticket.findPrice());

		}

		System.out.println("");
		System.out.print("...Enter Show Index: ");
		int showindex = ValidInputManager.GetIntWithinRange(1, showList.size() + 1);

		// Enter first seat.
		Show s = showList.get(showindex - 1);
		s.printSeats();

		System.out.println("");
		System.out.println("...Enter first seat (Enter as 'a1' for row-1 seat-1 or 'd5' for row-4 seat-5):");
		String firstseat = ValidInputManager.GetString();

		System.out.print("...Enter number of seats: ");
		int numseats = ValidInputManager.GetInt();

		System.out.println("...Confirmation: Book the tickets? (Yes / No)");
		String[] yesOrNo = { "Yes", "No" };
		String confirmation = ValidInputManager.GetStringInChoices(yesOrNo);

		// Booking Confirmed, Generate TID
		if (confirmation.toLowerCase().equals("yes")) {
			TransactionID T = new TransactionID(
					MovieCineplexModel.getInstance().GetCineplexes().get(s.getCineplexID()));
			String TID = T.getTID();

			String bookingID = TID;
			char ch = firstseat.charAt(0);
			int firstseatnum = Character.getNumericValue(firstseat.charAt(1)) - 1;
			int row = ch - 'a';
			boolean flag1 = false;
			for (int t = 0; t < numseats; t++) {
				if (s.checkingSeat(row, firstseatnum + t)) {
					flag1 = true;
				}
			}
			if (!flag1) {
				MovieGoerIO mgio = new MovieGoerIO();

				try {
					mgio.assignSeatsByMovie(movieBooked, showindex - 1, customerEmail, customerName, phoneNumber,
							bookingID, numseats, firstseat);
					movieBooked.saveShowDetails();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println("[CustomerPage] Error at assignSeatsByMovie" + e.getMessage());
				}

				System.out.println("...Your Movie Tickets have been successfuly booked!");
				System.out.println("...Transaction ID: " + bookingID);

			} else {

				System.out.println("");
				System.err.println("The Ticket Purchase was cancelled! Seat not available!");
				System.out.println("");

			}

			/* Enter specific show to book for movie. */
			/* System.out.println("Enter show:"); */
		} else {
			System.out.println("");
			System.err.println("Please select different seats, a few of these seats are occupied.");
			System.out.println("");
		}

	}

	public void ViewBookingHistoryUpdate() {
		System.out.println("Booking History");
		MovieGoerIO M = new MovieGoerIO();
		MovieGoer moviegoer = null;
		ArrayList<BookingTicket> customerbookings = new ArrayList<>();
		MovieGoer moviegoers[] = Arrays.copyOf(MovieGoerIO.movie_goer.toArray(), MovieGoerIO.movie_goer.size(),
				MovieGoer[].class);

		// Accepting Customer ID to retrieve booking history.
		System.out.println("Please enter Customer Email to view booking history: ");
		String customerEmail = ValidInputManager.GetString();

		// Get corresponding MovieGoer object from MoverGoerIO class using CustomerID.
		try {
			moviegoer = M.getMovieGoer(customerEmail);
			if (moviegoer == null)
				throw new Exception("NULL CUSTOMER");
		} catch (Exception e) {
			System.err.println("Error: No booking made with that email");
			return;
		}

		// Use MovieGoer object to retrieve customerbooking ArrayList for corresponding
		// cutomer ID.
		customerbookings = moviegoer.getCustBookings();
		// Iterate through customerbookings ArrayList to print movie names of bookings
		// made by customer.
		for (int i = 0; i < customerbookings.size(); i++) {
			System.out.println("");
			System.out.printf("Booking %d)\n", i + 1);
			System.out.println("Customer Email ID: " + customerbookings.get(i).getEmailCustomer());
			System.out.println("Movie Booked: " + customerbookings.get(i).getBookedMovie());
			System.out.println("Date & Time: " + customerbookings.get(i).getDateTime());
			System.out.println("Number of Seats booked: " + customerbookings.get(i).getNumberOfSeats());
			System.out.println("FirstSeat booked: " + customerbookings.get(i).getFirstSeat());
			System.out.println("Transaction ID: " + customerbookings.get(i).getBookingID());
		}
		System.out.println("");
	}

	@Override
	public void End() {
		// TODO Auto-generated method stub

	}
}
