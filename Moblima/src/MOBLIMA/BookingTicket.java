package MOBLIMA;

import java.io.*;
import java.util.List;

public class BookingTicket {
    // email id of customer who made booking
    private String emailCustomer;

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

    public BookingTicket() {
    };

    // Booking Constructor

    public BookingTicket(String emailCustomer, String booking_id, String booked_movie, int seatnum, String first_seat,
            Show show) {
        this.booked_movie = booked_movie;
        this.booking_id = booking_id;
        this.seatnum = seatnum;
        this.first_seat = first_seat;
        this.setShow(show);
    }

    /**
     * @return Show
     */
    // public void getListOfShow() {
    // return ListOfShow;
    // }

    // public void setShow(Show ListOfShow) {
    // this.ListOfShow = ListOfShow;

    public Show getbookedShow() {
        return bookedShow;
    }

    /**
     * @param bookedShow
     */
    public void setShow(Show bookedShow) {
        this.bookedShow = bookedShow;

    }

    /**
     * @return String
     */
    // gets name of the booked movie and returns it
    public String getBookedMovie() {
        return booked_movie;
    }

    /**
     * @return String
     */
    // gets ID of the booked movie and returns it
    public String getBookingID() {
        return booking_id;
    }

    /**
     * @return int
     */
    // gets the number of seats booked and returns it
    public int getNumberOfSeats() {
        return seatnum;
    }

    /**
     * @return String
     */
    // gets the first and last seats booked and returns it
    public String getFirstSeat() {
        return first_seat;
    }

    /**
     * @param booked_movie
     */
    // setting them

    public void setBookedMovie(String booked_movie) {
        this.booked_movie = booked_movie;
    }

    /**
     * @param booking_id
     */
    // sets the ID of the booked movie
    public void setBookingID(String booking_id) {
        this.booking_id = booking_id;
    }

    /**
     * @param seatnum
     */
    // sets the booked number of seats
    public void setNumberOfSeats(int seatnum) {
        this.seatnum = seatnum;
    }

    /**
     * @param first_seat
     */
    // sets the first and last seats
    public void setFirstSeat(String first_seat) {
        this.first_seat = first_seat;
    }

    /**
     * @return String
     */
    // getting and setting Email ID of customers
    public String getEmailCustomer() {
        return emailCustomer;
    }

    /**
     * @param emailCustomer
     */
    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    /**
     * @return String
     */
    // getting and setting date and time
    public String getDateTime() {
        return datetime;
    }

    /**
     * @param datetime
     */
    public void setDateTime(String datetime) {
        this.datetime = datetime;
    }

}
