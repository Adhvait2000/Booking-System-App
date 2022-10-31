import java.io.*;
import java.util.List;

class Show
{
}

public class BookingTickets {
    // customer id of the person who has made the booking

    private int idCustomer;

    // unique booking ID of the movie
    String booking_id;

    // movie name booked
    private String booked_movie;

    // first and last seat booked
    private String first_seat;

    // number of seats booked
    private int seatnum;

    // date and time of the show
    private String datetime;

    // show object of the show booked
    private Show listOfShows;

    // email ID of the customer
    private String email_id;

    public BookingTickets() {
    };

    // Booking Constructor

    public BookingTickets(int idCustomer, String booking_id, String booked_movie, int seatnum, String first_seat, Show show,
            String email_id) {
        this.booked_movie = booked_movie;
        this.booking_id = booking_id;
        this.seatnum = seatnum;
        this.first_seat = first_seat;
        this.email_id = email_id;
        this.setShow(show);
    }

    public void getListOfShow() {
        //return ListOfShow;
    }

    public void setShow(Show ListOfShow) {
        //this.ListOfShow = ListOfShow;
    }

    // gets name of the booked movie and returns it
    public String getBookedMovie() {
        return booked_movie;
    }

    // gets ID of the booked movie and returns it
    public String getBookingID() {
        return booking_id;
    }

    // gets the number of seats booked and returns it
    public int getNumberOfSeats() {
        return seatnum;
    }

    // gets the first and last seats booked and returns it
    public String getFirstSeat() {
        return first_seat;
    }

    // setting them

    public void setBookedMovie() {
        this.booked_movie = booked_movie;
    }

    // sets the ID of the booked movie
    public void setBookingID() {
        this.booking_id = booking_id;
    }

    // sets the booked number of seats
    public void setNumberOfSeats() {
        this.seatnum = seatnum;
    }

    // sets the first and last seats
    public void setFirstSeat() {
        this.first_seat = first_seat;
    }

    // getting and setting Customer ID
    public int getIDCustomer() {
        return idCustomer;
    }

    public void setIDCustomer() {
        this.idCustomer = idCustomer;
    }

    // getting and setting email ID
    public String getEmail() {
        return email_id;
    }

    public void setEmail() {
        this.email_id = email_id;
    }

    // getting and setting date and time
    public String getDateTime() {
        return datetime;
    }

    public void setDateTime() {
        this.datetime = datetime;
    }

}