package MOBLIMA;
import java.io.*;
import java.util.List;

public class BookingTicket {
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
    private Show bookedShow;

    // email ID of the customer
    private String email_id;

    public BookingTicket() {
    };

    // Booking Constructor

    public BookingTicket(int idCustomer, String booking_id, String booked_movie, int seatnum, String first_seat,
            Show show,
            String email_id) {
        this.booked_movie = booked_movie;
        this.booking_id = booking_id;
        this.seatnum = seatnum;
        this.first_seat = first_seat;
        this.email_id = email_id;
        this.setShow(show);
    }

    // public void getListOfShow() {
    // return ListOfShow;
    // }

    // public void setShow(Show ListOfShow) {
    // this.ListOfShow = ListOfShow;

    public Show getbookedShow() {
        return bookedShow;
    }

    public void setShow(Show bookedShow) {
        this.bookedShow = bookedShow;

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

    public void setBookedMovie(String booked_movie) {
        this.booked_movie = booked_movie;
    }

    // sets the ID of the booked movie
    public void setBookingID(String booking_id) {
        this.booking_id = booking_id;
    }

    // sets the booked number of seats
    public void setNumberOfSeats(int seatnum) {
        this.seatnum = seatnum;
    }

    // sets the first and last seats
    public void setFirstSeat(String first_seat) {
        this.first_seat = first_seat;
    }

    // getting and setting Customer ID
    public int getIDCustomer() {
        return idCustomer;
    }

    public void setIDCustomer(int customer_id) {
        this.idCustomer = customer_id;
    }

    // getting and setting email ID
    public String getEmail() {
        return email_id;
    }

    public void setEmail(String email_id) {
        this.email_id = email_id;
    }

    // getting and setting date and time
    public String getDateTime() {
        return datetime;
    }

    public void setDateTime(String datetime) {
        this.datetime = datetime;
    }

}