package MOBLIMA

import java.io.IOException;
import java.util.*;
import controller.movieIO;
import Master;
import Cineplex;
import Cinema;

public class Movie
 {
    private int tsales;
    private String movie;
    private String director;
    private String[] reviews;
    private double[] ratings;
    private String showingStatus;
    private String synopsis;
    private String[] cast;
    private ArrayList<Show>Shows;
    
    public Movie(String name, String director, String[] reviews, double[] ratings, String showingStatus, String synopsis, String[] cast, int sales)
    {
        movie=name;
        this.director = director;
        this.reviews=reviews;
        this.ratings=ratings;
        this.showingStatus = showingStatus;
        this.synopsis = synopsis;
        this.cast = cast;
        tsales=sales;
        this.Shows = new ArrayList<Show>();
    }
    
    public String getMovieName()
    {
        return movie;
    }
    
    public String getShowingStatus()
    {
        return showingStatus;
    }
    
    public String getSynopsis()
    {
        return synopsis;
    }
    
    public String getDirector()
    {
        return director;
    }
    
    public String[] getCast()
    {
        return cast;
    }
    
    public double getTotalRatings()
    {
        if(ratings.length==0)
        return -1;
        
        double sum=0;
        int size = ratings.length;
        
        for(int i=0;i<size;i++)
        {
            sum+= ratings[i];
        }
        sum = sum/size;
        
        return sum;
    }
    
    public double [] getAllRatings()
    { 
        return ratings;
    }
        
    public String[] getReviews()
    {
        return reviews;
    }
    
    public void writeReview(String rev)
    {
        String[] temp;
        if(reviews==null)
        {
            temp = new String[1];
            temp[0]=rev;
        }
        else
        {
            int size = reviews.length;
            temp = new String[size+1];
            for(int i=0;i<size;i++)
            temp[i]=reviews[i];
            
            temp[size]=rev;
        }
        reviews=temp;
    }
    
    public void giveRating( double rat)
    {
        double[] temp;
        if(ratings==null)
        {
            temp = new double[1];
            temp[0]=rat;
        }
        else
        {
            int size=ratings.length;
            temp = new double[size+1];
            for(int i=0;i<size;i++)
            temp[i]=ratings[i];
            temp[size]=rat;
        }
        ratings=temp;
    }
    
    
    public Show createShowListing(String dt, int screenNum, int CineplexID, boolean is3D)
    {
        Show s = new Show(this, dt, screenNum,CineplexID, is3D);
        Shows.add(s);
        return s;
    }
    
    public void saveShowDetails()
    {
        MovieIO m = new MovieIO();
        try {
        m.saveShows("data/Shows/"+movie+".txt", Shows);
        }catch(IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
    
   public void readShowDetails(Master Master)
    {
        Show temp;
        ArrayList<Cineplex> tempCineplexArray;
        ArrayList<Cinema> tempCinemaArray;
        Cineplex tempCineplex;
        Cinema tempCinema;
        MovieIO m = new MovieIO();
        try 
        {
          ArrayList arr = m.readShows(this,"data/Shows/"+movie+".txt");
          Shows = arr;
        
          for(int i=0;i<Shows.size();i++) 
          {
            temp = Shows.get(i);
            tempCineplexArray = Master.getCineplexes();
            tempCineplex = tempCineplexArray.get(temp.getCineplexID());
            tempCinemaArray = tempCineplex.getCinemaList();
            tempCinema = tempCinemaArray.get(temp.getScreenNum());
            tempCinema.addShow(temp);
          }
        }
        catch(IOException e) 
        {
            System.out.println("IOException > " + e.getMessage());
        }
     
    }
   public ArrayList<Show> getShows()
    {
        return Shows;
    }
    
   public void setShowingStatus(String st)
    { 
        showingStatus=st;
    }
    
   public void incTsales()
    {
        tsales++;
    }
    
   public int getTSales()
    {
        return tsales;
    }
   
   public static Comparator<Movie> topratings = new Comparator<Movie>()
   {
        public int compare(Movie m1, Movie m2) 
        {

           double rating1 = m1.getTotalRating();
           double rating2 = m2.getTotalRating();

           return (int) rating1- (int) rating2;
        } 
    };


    public static Comparator<Movie> topticketsales = new Comparator<Movie>()
    {
      public int compare(Movie m1, Movie m2)
      {

        int ts1 = m1.getTsales();
        int ts2 = m2.getTsales();

        return ts1-ts2; 
       } 
    };
    
    public void deleteShow(Master m, int ind)
    {
        Show s = Shows.get(ind);
        ArrayList<Cineplex> temp = m.getCineplexes();
	ArrayList<Cinema> temp2 = temp.get(s.getCineplexID()).getCinemaList();
	ArrayList<Show> temp3 = temp2.get(s.getScreenNum()).getCinemaShows();
	temp3.remove(s);
	Shows.remove(ind);
        
    }
    
    public void deleteShow(Master m, Show s) 
    {
	ArrayList<Cineplex> temp = m.getCineplexes();
	ArrayList<Cinema> temp2 = temp.get(s.getCineplexID()).getCinemaList();
	ArrayList<show> temp3 = temp2.get(s.getScreenNum()).getCinemaShows();
	temp3.remove(s);
	Shows.remove(s);
    }
}
