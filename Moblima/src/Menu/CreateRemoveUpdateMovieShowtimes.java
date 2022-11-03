package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import MOBLIMA.*;

//UI to create, update, and remove movie showtimes

public class CreateRemoveUpdateMovieShowtimes extends MenuPage {
    private static MovieCineplexModel movieCineplexModel;

    @Override
    public void Initialize() {
        // TODO Auto-generated method stub
        movieCineplexModel = MovieCineplexModel.getInstance();
    }

    @Override
    public void Update() {
        System.out.println("");

        System.out.println("Please select an option:\n"
                + "1) Create Movie Listing\n"
                + "2) Delete Movie Listing\n"
                + "3) Back");

        int select = ValidInputManager.GetIntWithinRange(1, 4);

        switch (select) {

            case 1:
                ArrayList<Movie> movies = new ArrayList<Movie>();
                int a;

                ArrayList<Cineplex> Cineplexes1 = new ArrayList<Cineplex>();

                Cineplexes1 = movieCineplexModel.GetCineplexes();

                for (a = 0; a < Cineplexes1.size(); a++) {
                    System.out.printf("%d) " + Cineplexes1.get(a).getNameCineplex() + "\n", a + 1);
                }

                System.out.println("");

                System.out.print("Select a Cineplex: ");
                int choice1 = ValidInputManager.GetIntWithinRange(1, Cineplexes1.size() + 1);

                System.out.print("Select a Movie Screen (1 / 2 /3): ");
                int cinemaID = ValidInputManager.GetIntWithinRange(1, 4);

                System.out.print("Is the Movie 3D (Yes/ No): ");
                String answer = ValidInputManager.GetString();
                boolean is3D = false;
                if (answer.equals("Yes") || answer.equals("yes")) {
                    is3D = true;
                }

                System.out.print("Enter the Date and Time of Movie (e.g., 12/05/2022 2:30PM): ");

                String date = ValidInputManager.GetString();

                System.out.println();

                movies = movieCineplexModel.GetMovies();

                Movie movie;
                Show show;
                System.out.println("---- All Movies ----");

                for (a = 0; a < movies.size(); a++) {
                    System.out.printf("%d " + movies.get(a).getMovieName() + "\n", a + 1);
                }

                System.out.println("");

                System.out.print("Please select a Movie to add: ");
                int movie_num = ValidInputManager.GetIntWithinRange(1, movies.size() + 1);

                Movie m = movies.get(movie_num - 1);

                if (m.getShowingStatus().equals("NOW_SHOWING") || m.getShowingStatus().equals("PREVIEW")) {

                    show = m.createShowListing(date, cinemaID - 1, choice1, is3D);

                    Cineplexes1.get(choice1 - 1).getListCinemas().get(cinemaID - 1).addaShow(show);

                    movieCineplexModel.setCineplex(Cineplexes1);

                    System.out.println(AdminChangeStatus.SUCCESSFUL.returnStatus());
                } else {
                    System.err.println("Please set Showing Status to NOW_SHOWING!!");
                }
                break;

            // deleting Movie Listing
            case 2:

                movies = movieCineplexModel.GetMovies();
                int choice;
                System.out.println("");
                System.out.println("--- All Movies ---");

                for (a = 0; a < movies.size(); a++) {
                    System.out.printf("%d " + movies.get(a).getMovieName() + "\n", a + 1);
                }

                System.out.println("\n"
                        + "Please make a selection:\n"
                        + " 1) Select to Delete Movie Showtime\n"
                        + " 2) Back\n");

                select = ValidInputManager.GetIntWithinRange(1, 3);

                if (select == 1) {
                    System.out.print("Please select a Movie Index to add its Details and Shows: ");
                    if (select - 1 > movies.size()) {
                        System.out.println("");
                        System.out.println("Movie number is INVALID...Please enter a VALID Movie Number !!");
                    }

                    System.out.println("");
                    movie = movies.get(select - 1);

                    System.out.println(movie.getMovieName());
                    System.out.println(movie.getDirector());
                    String[] review = movie.getReviews();

                    for (int i = 0; i < review.length; i++) {
                        System.out.printf("%s", review[i]);
                    }

                    System.out.println("\n");
                    double[] ratings = movie.getAllRatings();

                    for (int i = 0; i < ratings.length; i++) {
                        System.out.printf("%f ", ratings[i]);
                    }
                    System.out.println("\n");

                    System.out.println(movie.getShowingStatus());
                    System.out.println(movie.getSynopsis());

                    String[] castmembers = movie.getCast();

                    for (int i = 0; i < castmembers.length; i++) {
                        System.out.printf("%s ", castmembers[i]);
                    }

                    System.out.println("");

                    ArrayList<Show> temp = movie.getShows();

                    for (int j = 0; j < temp.size(); j++) {
                        show = temp.get(j);
                        System.out.printf("\n\nShow %d:\n", j + 1);
                        System.out.println(show.getTimenDate());
                        System.out.printf("Cineplex ID: %d\n", show.getCineplexID());
                        System.out.printf("Cinema ID: %d\n", show.getScreenNumber());
                        show.printSeats();
                    }

                    System.out.println("Please input the show number to be removed!!");

                    movie.deleteShow(movieCineplexModel, select);
                }
        }
    }

    @Override
    public void End() {
        // TODO Auto-generated method stub

    }
}
