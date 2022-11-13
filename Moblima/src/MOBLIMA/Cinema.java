package MOBLIMA;

//import necessary files;
import java.util.ArrayList;

/**
 * This cinema class is to create cinemas in cineplexes and to initialise the
 * shows
 * 
 * @version 1.0
 * @since 2022-11-01
 */
public class Cinema {

    // declaration of the variables;
    /**
     * Cinema ID
     */
    private int idOfCinema;
    /**
     * Category of cinema
     */
    private String cinemaCategory;
    /**
     * Name of the cinema
     */
    private String nameOfCinema;
    /**
     * Code of cinema
     */
    private String cinemaCode;

    // array of the shows;
    /**
     * Array for the shows in cinema
     */
    private ArrayList<Show> listOfShows;

    /**
     * Constructor default
     * 
     * @param nameOfCinema   This customers' cinema name
     * @param cinemaCategory This customers' cinema category
     * @param cinemaCode     This customers' cinema code
     * @param idOfCinema     This customers' cinema ID
     */
    public Cinema(String nameOfCinema, String cinemaCategory, String cinemaCode, int idOfCinema) {
        this.nameOfCinema = nameOfCinema;
        this.idOfCinema = idOfCinema;
        this.cinemaCategory = cinemaCategory;
        this.cinemaCode = cinemaCode;

        listOfShows = new ArrayList<Show>();
    }

    // get functions;
    /**
     * Get the cinema ID
     * 
     * @return cinema ID
     */
    public int getCinemaID() {
        return idOfCinema;

    }

    /**
     * Get the cinema name
     * 
     * @return cinema name
     */
    public String getCinemaName() {
        return nameOfCinema;

    }

    /**
     * Get the cinema category
     * 
     * @return cinema category
     */
    public String getCinemaCategory() {
        return cinemaCategory;

    }

    /**
     * Get the cinema code
     * 
     * @return cinema code
     */
    public String getCinemaCode() {
        return cinemaCode;

    }

    // display the shows;
    /**
     * @return the array of shows present in cinema
     */
    public ArrayList<Show> getCinemaShows() {
        return listOfShows;
    }

    // adding a show;
    /**
     * Add a show to cinema
     * 
     * @param s add show to cinema
     */
    public void addaShow(Show s) {
        listOfShows.add(s);

    }

}
