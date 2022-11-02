package MOBLIMA;

import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import MOBLIMA.*;

public class CreateRemoveUpdateMovieListing {
    private static MovieCineplexModel movieCineplexModel;

    // initializing master class which calls the backend of the application
    public CreateRemoveUpdateMovieListing(MovieCineplexModel m) {
        movieCineplexModel = MovieCineplexModel.getInstance();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // used to go back into the main program
        boolean back = false;

        ArrayList<Movie> movies = new ArrayList<Movie>();
        int i;

        System.out.println("1. Create a new Movie Listing\n"
                + "2. Update a Movie Listing\n"
                + "3. Remove a Movie Listing\n"
                + "4. Back");

        System.out.println("");

        System.out.print("Select an option: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                String name, director, showStatus = null, Synopsis;
                String[] Cast = new String[5];

                sc.nextLine();

                System.out.print("Enter Movie Name: ");
                name = sc.nextLine();

                System.out.print("Enter the Director's Name: ");
                director = sc.nextLine();

                boolean incorrect = true;

                System.out.print("Enter Movie Status (COMING_SOON, PREVIEW, NOW_SHOWING): ");
                showStatus = sc.nextLine();
                showStatus = showStatus.trim();

                System.out.print("Enter Synoposis: ");
                Synopsis = sc.nextLine();

                incorrect = true;
                int count = 0;

                while (incorrect) {
                    try {
                        System.out.print("Enter the number of cast members in the movie: ");
                        count = sc.nextInt();
                        sc.nextLine();
                        if (count <= 5) {
                            incorrect = false;
                        } else {
                            System.err.println("Please enter at most 5 cast members !!");

                        }
                    } catch (Exception e) {
                        System.err.println("Please enter at most 5 cast members !!");
                    }
                }

                for (i = 0; i < count; i++) {
                    System.out.printf("Enter the name of cast members %d: ", (i + 1));
                    Cast[i] = sc.nextLine();
                    System.out.println("");
                }

                String[] review = new String[0];
                double[] rating = new double[0];

                Movie newMovie = new Movie(name, director, review, rating, showStatus, Synopsis, Cast, 0);

                movieCineplexModel.addMovie(newMovie);

                System.out.println("");

                System.out.println(AdminChangeStatus.SUCCESSFUL.returnStatus());

                System.out.println("");

                break;

            case 2:

                movies = movieCineplexModel.GetMovies();

                Movie mov;
                Show s;
                for (i = 0; i < movies.size(); i++) {
                    System.out.printf("%d " + movies.get(i).getMovieName() + "\n", i + 1);
                }

                System.out.print("Please select a movie number: ");
                int movie_num = sc.nextInt();

                System.out.print("Current Status of the Movie: ");

                System.out.println("Enter new status of the Moive (COMING_SOON, PREVIEW, NOW_SHOWING): ");
                sc.nextLine();
                String newStatus = sc.nextLine();

                movies.get(movie_num - 1).setShowingStatus(newStatus);

                System.out.println("");

                System.out.println(AdminChangeStatus.SUCCESSFUL.returnStatus());

                System.out.println("");

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

                back = true;
                break;

            default:

                System.out.print("Invalid input, please try again!!");
                break;
        }

        if (back == true) {
            return;
        }
    }
}
