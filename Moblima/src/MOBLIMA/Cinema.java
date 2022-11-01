package MOBLIMA;
//import necessary files;
import java.util.ArrayList;

public class Cinema {

	//declaration of the variables;
    
    private int idOfCinema;
    private String cinemaCategory;
    private String nameOfCinema;
    private String cinemaCode;
    
    //array of the shows;
    private ArrayList<Show> listOfShows;
    
    public Cinema(String nameOfCinema, String cinemaCategory, String cinemaCode, int idOfCinema) {
        this.nameOfCinema = nameOfCinema;
        this.idOfCinema = idOfCinema;
        this.cinemaCategory = cinemaCategory;
        this.cinemaCode = cinemaCode;
        
        listOfShows=new ArrayList<Show>();
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
    
    public String getCinemaCode() {
        return cinemaCode;
        
    }

    //display the shows;
    public ArrayList<Show> getCinemaShows(){
    	return listOfShows;
    }

    
    
    //adding a show;
    public void addaShow(Show s) {
    	listOfShows.add(s);
    	
    }
 
   
}
