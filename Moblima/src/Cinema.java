package sc2002;

//import necessary files;
import java.util.ArrayList;

public class Cinema {

	//declaration of the variables;
    
    private int idOfCinema;
    private String cinemaCategory;
    private String nameOfCinema;
    
    //array of the shows;
    private ArrayList<show> listOfShows;
    
    public Cinema(String nameOfCinema, String cinemaCategory, int idOfCinema) {
        this.nameOfCinema = nameOfCinema;
        this.idOfCinema = idOfCinema;
        this.cinemaCategory = cinemaCategory;
        
        listOfShows=new ArrayList<show>();
    }

    //get functions;
    public int getCinemaID() {
        return idOfCinema;
        
    }
    
    public String getCinemaName() {
        return nameOfCinema;
        
    }

    public String getCinemaCategory() {
        return cinemaCategory;
        
    }

    //display the shows;
    public ArrayList<show> getCinemaShows(){
    	return listOfShows;
    }

    
    
    //adding a show;
    public void addaShow(show s) {
    	listOfShows.add(s);
    	
    }
 
   
}
