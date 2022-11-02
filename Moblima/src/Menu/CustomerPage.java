package Menu;
import MOBLIMA.MovieCineplexModel;
import MOBLIMA.Movie;

import java.util.ArrayList;
import java.util.Collections;

import MOBLIMA.Cineplex;
import MOBLIMA.Show;

public class CustomerPage extends MenuPage {
	static final int MOVIES_DETAILS = 1;
	static final int SEAT_AVAILABILITY = 2;
	static final int PURCHASE_TICKETS = 3;
	static final int BOOKING_HISTORY = 4;
	static final int TOP_RANKING = 5;
	static final int ALL_CINEPLEX = 6;
	static final int WRITEREVIEWRATING = 7;
	
	@Override
	public void Initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		System.out.println("Customer Mode");
		System.out.println("...1) List All Movies and Movie Details");
		System.out.println("...2) Check Seat Availability");
		System.out.println("...3) Book and Purchase movie tickets");
		System.out.println("...4) View booking history");
		System.out.println("...5) List top 5 movies ranked by ticket sales or overall reviewer's ratings");
		System.out.println("...6) List all Cineplexes");
		System.out.println("...7) Write a review / Give Rating");
		System.out.println("...8) Go Back");
		
		int choice = ValidInputManager.GetIntWithinRange(1, 9);
		System.out.println("");
		
		switch(choice)
		{
		case MOVIES_DETAILS:
			MovieDetailsUpdate();
			break;
		case SEAT_AVAILABILITY:
			SeatAvailabilityUpdate();
			break;
		case PURCHASE_TICKETS:
			break;
		case BOOKING_HISTORY:
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
		case 8:
			endMenu = true;
			break;
		}
	}

	public void MovieDetailsUpdate()
	{
		System.out.println("All Movie Listings");
		ArrayList<Movie> movieList = MovieCineplexModel.getInstance().GetMovies();
		
		for(int i = 0; i < movieList.size(); i++)
		{
			System.out.println("..." + movieList.get(i).getMovieName());
		}
		
		System.out.println("");
		System.out.println("...1) Select A Movie");
		System.out.println("...2) Go Back");
		
		int choice = ValidInputManager.GetIntWithinRange(1, 3);
		if(choice == 1)
		{
			nextPage = new SelectMoviePage();
			goNext = true;
		}
		else
		{
			System.out.println("");
			return;
		}
		
	}
	
	public void SeatAvailabilityUpdate()
	{
		System.out.println("Check Seat Availability");
		ArrayList<Cineplex> cineplexes = null;
		try
		{
			cineplexes = MovieCineplexModel.getInstance().GetCineplexes();
		}catch(Exception e)
		{
			System.err.println(e.getMessage());
			return;
		}
		
        for(int i = 0; i < cineplexes.size(); i++)
        {
        	System.out.printf("...%d) " + cineplexes.get(i).getNameCineplex() + "\n", i+1);
        }
        
        System.out.printf("...%d) Back\n", cineplexes.size()+1);
        int cineplexChoice = ValidInputManager.GetIntWithinRange(1, cineplexes.size()+2);
        
        if(cineplexChoice == cineplexes.size()+1)
        	return;
        
        System.out.printf("...Select Cinema Screen: 1, 2, 3\n");
        int cinemaChoice = ValidInputManager.GetIntWithinRange(1, 4);
        
        System.out.println("");
        System.out.printf("Cinema No.%d Movies:\n", cinemaChoice);
        ArrayList<Show> showList = MovieCineplexModel.getInstance().GetCineplexes().get(cineplexChoice-1).getListCinemas().get(cinemaChoice-1).getCinemaShows();
        
        for(int i = 0; i < showList.size(); i++)
        {
        	Show show = showList.get(i);
        	show.printSeats();
        }
	}
	
	public void ReviewRatingUpdate()
	{
		System.out.println("Write a Review / Give a Rating");
		ArrayList<Movie> movieList = MovieCineplexModel.getInstance().GetMovies();
		
		for(int i = 0; i < movieList.size(); i++)
		{
			System.out.printf("...%d) " + movieList.get(i).getMovieName() + "\n", i+1);
		}
		
		int movieChoice = ValidInputManager.GetIntWithinRange(1,  movieList.size()+2);
		
		if(movieChoice == movieList.size()+1)
		{
			return;
		}
		Movie chosenMovie = movieList.get(movieChoice-1);
		System.out.println("");
		System.out.println("Review or Rating");
		System.out.println("...1. Write a Review");
		System.out.println("...2. Give a Rating");
		System.out.println("...3. Go Back");
		int actionChoice = ValidInputManager.GetIntWithinRange(1, 4);
		
		if(actionChoice == 3)
			return;
		
		if(actionChoice == 1)
		{
			System.out.printf("...Please input your review: \n");
			String review = ValidInputManager.GetString();
			chosenMovie.writeReview(review);
			//MovieCineplexModel.getInstance().updateMovie(chosenMovie.getMovieName(), chosenMovie);
			MovieCineplexModel.getInstance().saveMovies();
			System.out.println("...Review Added!");
			return;
		}else
		{
			System.out.printf("...Please input your rating: ");
			double rating = ValidInputManager.GetDoubleWithinRange(0, 5);
			chosenMovie.giveRating(rating);
			//MovieCineplexModel.getInstance().updateMovie(chosenMovie.getMovieName(), chosenMovie);
			MovieCineplexModel.getInstance().saveMovies();
			System.out.println("...Rating Added!");
			return;
		}
	}
	
	public void TopRankingUpdate()
	{
		System.out.println("Top Rankings");
		ArrayList<Movie> movies = MovieCineplexModel.getInstance().GetMovies();
		
		System.out.println("...Top Ticket Sales");
		Collections.sort(movies, Movie.topticketsales);
		for(int i= movies.size() -1 ; i >=0 ; i--)
			System.out.println("......" + movies.get(i).getMovieName() + ": " + movies.get(i).getTSales());
		
		System.out.println("...Top Ratings");
		Collections.sort(movies, Movie.topratings);
		for(int i= movies.size() -1 ; i >=0 ; i--)
			System.out.println("...... " + movies.get(i).getMovieName() + ": " + movies.get(i).getTotalRatings());		
	}
	
	public void ListAllCineplexesUpdate()
	{
		System.out.println("List All Cineplexes");
 		ArrayList<Cineplex> Cineplexes = MovieCineplexModel.getInstance().GetCineplexes(); 	

        for(int i = 0; i < Cineplexes.size(); i++)
        	System.out.printf("%d) " + Cineplexes.get(i).getNameCineplex() + "\n",i+1);
	}

	@Override
	public void End() {
		// TODO Auto-generated method stub
		
	}
}
