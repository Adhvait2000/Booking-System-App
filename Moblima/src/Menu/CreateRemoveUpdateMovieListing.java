package Menu;

import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import MOBLIMA.*;

public class CreateRemoveUpdateMovieListing extends MenuPage {

    private static MovieCineplexModel movieCineplexModel;

    // initializing master class which calls the backend of the application
    @Override
    public void Initialize() {
        // TODO Auto-generated method stub
        movieCineplexModel = MovieCineplexModel.getInstance();
    }

    @Override
    public void Update() {
        // TODO Auto-generated method stub
        System.out.println("Create/Remove/Update Movie Listings");
        Scanner sc = new Scanner(System.in);

        ArrayList<Movie> movies = new ArrayList<Movie>();
        int i;

        System.out.println("...1. Create a new Movie Listing\n"
                + "...2. Update a Movie Listing\n"
                + "...3. Remove a Movie Listing\n"
                + "...4. Back");

        int choice = ValidInputManager.GetIntWithinRange(1, 5);

        switch (choice) {
            case 1:
                System.out.println("Create new movie listing");
                String name, director, showStatus = null, Synopsis;
                String[] Cast = new String[5];

                System.out.println("...Enter Movie Name");
                name = ValidInputManager.GetString();

                System.out.println("...Enter the Director's Name");
                director = ValidInputManager.GetString();

                System.out.println("...Enter Movie Status (COMING_SOON, PREVIEW, NOW_SHOWING)");
                showStatus = ValidInputManager.GetString();
                showStatus = showStatus.trim();

                System.out.println("...Enter Synoposis");
                Synopsis = ValidInputManager.GetString();

                System.out.println("...Enter the number of cast members in the movie (Max 5 cast members)");
                int count = ValidInputManager.GetIntWithinRange(1, 6);

                for (i = 0; i < count; i++) {
                    System.out.printf("...Enter the name of cast members %d\n", (i + 1));
                    Cast[i] = ValidInputManager.GetString();
                    // System.out.println("");
                }

                String[] review = new String[0];
                double[] rating = new double[0];

                Movie newMovie = new Movie(name, director, review, rating, showStatus, Synopsis, Cast, 0);

                movieCineplexModel.addMovie(newMovie);
                movieCineplexModel.saveMovies();
                System.out.println("..." + AdminChangeStatus.SUCCESSFUL.returnStatus());
                break;

            case 2:

                movies = movieCineplexModel.GetMovies();

                Movie mov;
                Show s;
                for (i = 0; i < movies.size(); i++) {
                    System.out.printf("%d " + movies.get(i).getMovieName() + "\n", i + 1);
                }

                System.out.print("Please select a movie number: ");
                int movie_num = ValidInputManager.GetIntWithinRange(1, movies.size() + 1);

                System.out.print("Current Status of the Movie: " + movies.get(movie_num - 1).getShowingStatus() + " ");

                System.out.println("\nEnter new status of the Movie (COMING_SOON, PREVIEW, NOW_SHOWING): ");

                String newStatus = ValidInputManager.GetString();

                movies.get(movie_num - 1).setShowingStatus(newStatus);

                System.out.println("");

                System.out.println(AdminChangeStatus.SUCCESSFUL.returnStatus());

                System.out.println("");

                movieCineplexModel.saveMovies();

                break;

            case 3:

                movies = movieCineplexModel.GetMovies();
                Movie movie_1;
                Show show_1;

                for (i = 0; i < movies.size(); i++) {
                    System.out.printf("%d " + movies.get(i).getMovieName() + "\n", i + 1);
                }

                System.out.print("Please select a Movie Number: ");
                int movie_num1 = sc.nextInt();
                File file = new File("data/Shows/" + movies.get(movie_num1 - 1).getMovieName() + ".txt");
                file.delete();

                // movieCineplexModel.deleteMovie(movie_num1-1);
                System.out.println("");

                System.out.println(AdminChangeStatus.SUCCESSFUL.returnStatus());

                System.out.println("");

                break;

            case 4:
                this.endMenu = true;
                return;
        }
    }

    @Override
    public void End() {
        // TODO Auto-generated method stub

    }
}
