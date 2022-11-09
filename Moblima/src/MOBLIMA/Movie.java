package MOBLIMA;

import java.io.IOException;
import java.util.*;

public class Movie {
    private int tsales;
    private String movie;
    private String director;
    private String[] reviews;
    private double[] ratings;
    private String showingStatus;
    private String synopsis;
    private String[] cast;
    private ArrayList<Show> Shows;

    public Movie(String name, String director, String[] reviews, double[] ratings, String showingStatus,
            String synopsis, String[] cast, int sales) {
        movie = name;
        this.director = director;
        this.reviews = reviews;
        this.ratings = ratings;
        this.showingStatus = showingStatus;
        this.synopsis = synopsis;
        this.cast = cast;
        tsales = sales;
        this.Shows = new ArrayList<Show>();
    }

    public String getMovieName() {
        return movie;
    }

    public String getShowingStatus() {
        return showingStatus;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getDirector() {
        return director;
    }

    public String[] getCast() {
        return cast;
    }

    public double getTotalRatings() {
        if (ratings.length == 0)
            return -1;

        double sum = 0;
        int size = ratings.length;

        for (int i = 0; i < size; i++) {
            sum += ratings[i];
        }
        sum = sum / size;

        return sum;
    }

    public double[] getAllRatings() {
        return ratings;
    }

    public String[] getReviews() {
        return reviews;
    }

    public void writeReview(String rev) {
        String[] temp;
        if (reviews == null) {
            temp = new String[1];
            temp[0] = rev;
        } else {
            int size = reviews.length;
            temp = new String[size + 1];
            for (int i = 0; i < size; i++)
                temp[i] = reviews[i];

            temp[size] = rev;
        }
        reviews = temp;
    }

    public void giveRating(double rat) {
        double[] temp;
        if (ratings == null) {
            temp = new double[1];
            temp[0] = rat;
        } else {
            int size = ratings.length;
            temp = new double[size + 1];
            for (int i = 0; i < size; i++)
                temp[i] = ratings[i];
            temp[size] = rat;
        }
        ratings = temp;
    }

    public Show createShowListing(String dt, int screenNum, int CineplexID, boolean is3D) {
        Show s = new Show(this, dt, screenNum, CineplexID, is3D);
        Shows.add(s);
        return s;
    }

    public void saveShowDetails() {
        MovieIO m = new MovieIO();
        try {
        	String dir = "";
    		// If using windows
    		if(System.getProperty("os.name").startsWith("Windows"))
    		{
    			dir = System.getProperty("user.dir") + "/data/Shows/" + movie + ".txt";
    		}else
    		{
    			dir = System.getProperty("user.dir") + "/Moblima/data/Shows/" + movie + ".txt";
    		}
        	
            m.saveShows(dir, Shows);
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }

    public void readShowDetails(MovieCineplexModel movieCineplexModel) {
        Show temp;
        ArrayList<Cineplex> tempCineplexArray;
        ArrayList<Cinema> tempCinemaArray;
        Cineplex tempCineplex;
        Cinema tempCinema;
        MovieIO m = new MovieIO();
        try {
        	String dir = "";
    		// If using windows
    		if(System.getProperty("os.name").startsWith("Windows"))
    		{
    			dir = System.getProperty("user.dir") + "/data/Shows/" + movie + ".txt";
    		}else
    		{
    			dir = System.getProperty("user.dir") + "/Moblima/data/Shows/" + movie + ".txt";
    		}
            ArrayList arr = m.readShows(this, dir);
            Shows = arr;

            for (int i = 0; i < Shows.size(); i++) {
                temp = Shows.get(i);
                tempCineplexArray = movieCineplexModel.GetCineplexes();
                tempCineplex = tempCineplexArray.get(temp.getCineplexID());
                tempCinemaArray = tempCineplex.getListCinemas();
                tempCinema = tempCinemaArray.get(temp.getScreenNumber());
                tempCinema.addaShow(temp);
            }
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }

    }

    public ArrayList<Show> getShows() {
        return Shows;
    }

    public void setShowingStatus(String st) {
        showingStatus = st;
    }

    public void incTsales() {
        tsales++;
    }

    public int getTSales() {
        return tsales;
    }

    public static Comparator<Movie> topratings = new Comparator<Movie>() {
        public int compare(Movie m1, Movie m2) {

            double rating1 = m1.getTotalRatings();
            double rating2 = m2.getTotalRatings();

            return (int) rating1 - (int) rating2;
        }
    };

    public static Comparator<Movie> topticketsales = new Comparator<Movie>() {
        public int compare(Movie m1, Movie m2) {

            int ts1 = m1.getTSales();
            int ts2 = m2.getTSales();

            return ts1 - ts2;
        }
    };

    public void deleteShow(MovieCineplexModel m, int ind) {
        Show s = Shows.get(ind);
        ArrayList<Cineplex> temp = m.GetCineplexes();
        ArrayList<Cinema> temp2 = temp.get(s.getCineplexID()).getListCinemas();
        ArrayList<Show> temp3 = temp2.get(s.getScreenNumber()).getCinemaShows();
        temp3.remove(s);
        Shows.remove(ind);

    }

    public void deleteShow(MovieCineplexModel m, Show s) {
        ArrayList<Cineplex> temp = m.GetCineplexes();
        ArrayList<Cinema> temp2 = temp.get(s.getCineplexID()).getListCinemas();
        ArrayList<Show> temp3 = temp2.get(s.getScreenNumber()).getCinemaShows();
        temp3.remove(s);
        Shows.remove(s);
    }
}
