package MOBLIMA;

import java.io.*;
import java.util.*;

//import model.*;

public class MovieGoerIO {

	private File text_file;  // access file containing list of movie goers

	private static ArrayList<MovieGoer> movie_goer = new ArrayList<>(); // list of movie goers

	private String customer_name; // name of customer

	private int mobile_number;

	private String emailCustomer; // customers' email as id

	private String booking_id; // booking id of a particular booking

	private String booked_movie; // movie being booked by a customer

	private String date_time; // date and time of movie

	private int seat_num; // customer's seat number(s)

	private String first_seat; // first seat booked by customers

	private static int numOfBookings = 0; // to count number of bookings previously made, count no. of rows in each
											// customer file (each row contains details of a customer's booking)

	public int[][] seat_pos = new int[9][9]; // seats in a cinema

	public MovieGoerIO() {
		if(System.getProperty("os.name").startsWith("Windows"))
		{
			text_file = new File(System.getProperty("user.dir") + "/data/movie_goers.txt");
		}else
		{
			text_file = new File(System.getProperty("user.dir") + "/Moblima/data/movie_goers.txt");
		}
	}; // constructor for the class

	public void previousBookingCount() throws IOException, Exception { // class to count previous bookings made by
																		// customers

		FileReader text_file = new FileReader(this.text_file); // read data on customers
		BufferedReader reader = new BufferedReader(text_file);

		String str;

		while ((str = reader.readLine()) != null) {
			numOfBookings++; // update num of bookings based on number of lines in the customer file (each
								// line is a booking made by a customer)
		}

		reader.close();
	}

	public void readBookingsFile() throws IOException, Exception { // class to read a booking file

		try {
			previousBookingCount(); // update num of bookings already made by customers

			FileReader text_file = new FileReader(this.text_file);
			BufferedReader reader = new BufferedReader(text_file);

			String str;

			int i = 1;

			while (i <= numOfBookings) {

				str = reader.readLine();

				if (str != null) { // for each line in the customer file, retrieve details of each booking and
									// update attributes

					String[] list = str.split("[|]"); // each attribute is split by | in a line
					this.customer_name = list[0];
					this.booking_id = list[1];
					this.emailCustomer = list[2];
					this.mobile_number = Integer.parseInt(list[3]);
					this.booked_movie = list[4];
					this.date_time = list[5];
					this.seat_num = Integer.parseInt(list[6]);
					this.first_seat = list[7];

					addNewMovieGoer(); // add movie goer using customer details retrieved

				}

				i += 1;

			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public void writeNewBooking(String emailCustomer, String booking_id, String customer_name, int mobile_number,
			String booked_movie, String time, int seat_num, String first_seat) throws IOException, Exception {

		// class to create a new booking

		previousBookingCount(); // update numOfBookings once again

		text_file = getCustomerFile(); // obtain file on customers

		String temporary;

		try { // write in a new booking made by a customer

			Scanner scanner = new Scanner(System.in);

			FileWriter file_write = new FileWriter(text_file, true);
			BufferedWriter writer = new BufferedWriter(file_write);

			writer.newLine();
			writer.write(emailCustomer + "|");
			writer.write(booking_id + "|");
			writer.write(customer_name + "|");
			writer.write(Integer.toString(mobile_number) + "|");
			writer.write(booked_movie + "|");
			writer.write(time + "|");
			writer.write(Integer.toString(seat_num) + "|");
			writer.write(first_seat + "|");
			writer.write("");
			writer.close();

			numOfBookings += 1; // update numOfBookings

		} catch (IOException error) {

			error.printStackTrace();
		}

	}

	public void addNewMovieGoer() { // class to add movie goer

		MovieGoer goer = new MovieGoer();

		// add movie goer using customer booking details retrieved from the customer
		// file

		goer.setEmailCustomer(emailCustomer);
		goer.setNameCustomer(customer_name);
		goer.setMobileNumber(mobile_number);

		int num = movie_goer.size(); // number of movie goers

		int check = 1; // check if customer has made previous booking

		for (int i = 0; i < num; i++) {

			String goerID = movie_goer.get(i).getEmailCustomer();

			if (goerID == emailCustomer) {

				check = 0;

				addBooking(i);

				break;
			}
		}

		if (check == 1) { // if customer has not made a booking previously, create a new booking
			goer.setBooking(createBooking());
		}

		if (!movie_goer.contains(goer)) { // if list of movie goers do not contain the customer, add the customer in

			movie_goer.add(goer);
		}

	}

	public void addBooking(int i) { // class to add a booking made by customer

		MovieGoer goer = new MovieGoer();
		goer = movie_goer.get(i); // get movie goer details

		goer.setBooking(createBooking());

	}

	public BookingTicket createBooking() { // class to create new booking

		BookingTicket book = new BookingTicket();

		book.setEmailCustomer(emailCustomer);
		book.setBookingID(booking_id);
		book.setFirstSeat(first_seat);
		book.setBookedMovie(booked_movie);
		book.setNumberOfSeats(seat_num);
		book.setDateTime(date_time);

		return book;
	}

	public void assignSeatsByMovie(Movie movie, int index, String customer_name, String emailCustomer,
			int mobile_number, String booking_id, int seat_num, String first_seat) throws IOException, Exception {

		try {
			readBookingsFile(); // read bookings made by customers

			this.booked_movie = movie.getMovieName(); // retrieve booking details of a particular booking
			this.seat_num = seat_num;
			this.booking_id = booking_id;

			BookingTicket book = new BookingTicket();

			int num = movie_goer.size(); // get total num of movie goers
			int check = 1; // to check if customer has made a previous booking
			int i;

			for (i = 0; i < num; i++) {

				String custID = movie_goer.get(i).getEmailCustomer();
				if (custID == emailCustomer) {
					check = 0;
					break;
				}
			}

			if (check == 1) { // if new customer, create new movie goer and assign id in addition to creating
								// a new booking

				MovieGoer goer = new MovieGoer();
				goer.setNameCustomer(customer_name);
				goer.setEmailCustomer(emailCustomer);

				book = createBooking();
				goer.setBooking(book);

			} else { // add booking for existing customer

				MovieGoer goer = new MovieGoer();
				goer = movie_goer.get(i);
				addBooking(i);
				ArrayList<BookingTicket> bookingList = goer.getCustBookings();
				int numOfBookings = bookingList.size();

				goer.setBooking(bookingList.get(numOfBookings - 1));
			}

			ArrayList<Show> showList = new ArrayList<>(); // list of shows

			showList = movie.getShows(); // get showtimes for a movie

			// assign seats
			char firstSeatAlpha = first_seat.charAt(0);
			int row = firstSeatAlpha - 'a' + 1;
			int first_seat_num = Character.getNumericValue(first_seat.charAt(1));

			Show show = showList.get(index);

			for (int j = 1; j <= seat_num; j++) {

				show.assignSeat(row - 1, j + first_seat_num - 2);

			}

			// get show time for the movie
			String timing = show.getTimenDate();

			// write a new booking for a customer with the designated seat and timing
			writeNewBooking(emailCustomer, booking_id, customer_name, mobile_number, booked_movie, timing, seat_num,
					first_seat);
		}

		finally {

			movie_goer.clear();

		}

	}

	public File getCustomerFile() { // class to retrieve customer file

		return text_file;
	}

	public MovieGoer getMovieGoer(String emailCustomer) throws IOException, Exception { // class to identify movie goer

		try {
			readBookingsFile();
			int numOfCustomers = movie_goer.size(); // get number of customers
			int i;
			for (i = 0; i < numOfCustomers; i++) {
				String email = movie_goer.get(i).getEmailCustomer();
				if (email.equals(emailCustomer))
					break; // find movie goer using id
			}

			return movie_goer.get(i); // return movie goer details

		} catch (Exception e) {
			System.out.println("[MovieGoerIO] " + e.getMessage());
			return null;
		} finally {

			movie_goer.clear();

		}

	}

}
