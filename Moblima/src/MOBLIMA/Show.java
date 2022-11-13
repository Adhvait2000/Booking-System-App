package MOBLIMA;

/**
 * Created this class to show and create the different movies. This will be
 * using the objects in the class movie.java
 * 
 * @version 1.0
 * @since 2022-11-01
 */

public class Show {

	// declaration of variables;

	/**
	 * The time and date details for the show
	 */
	private String timenDate;

	/**
	 * The cineplex ID details for the show
	 */
	private int cineplexID;

	/**
	 * To reference the object from movie class created
	 */
	private Movie mov;

	/**
	 * The screennumber details for the show
	 */
	private int screenNumber;

	/**
	 * Declare and initialise available seats
	 */
	private int availableSeats = 81;

	// to find if movie is 3D;

	/**
	 * Created a boolean value to find out if the movie is 3D or not
	 */
	private boolean is3D;

	// declare array of seats;
	/**
	 * Create an array for seats in the cinema
	 */
	private int[][] seat = new int[9][9];

	/**
	 * Constructing the seats based on input
	 * 
	 * @param mov          This customer's movie
	 * @param timeDate     This customers' date and time selected
	 * @param cineplexID   This customers' cineplex ID
	 * @param screenNumber This customers' screen number for the show
	 * @param is3D         Check if the customers' movie is 3D
	 */

	public Show(Movie mov, String timeDate, int cineplexID, int screenNumber, boolean is3D) {
		this.mov = mov;
		timenDate = timeDate;
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				seat[x][y] = 0;
			}
		}
		this.is3D = is3D;
		this.cineplexID = cineplexID;
		this.screenNumber = screenNumber;
	}

	/**
	 * Constuctor to manually construct the seats in cinema and uses movieIO as
	 * reference
	 * 
	 * @param mov          This customer's movie
	 * @param timeDate     This customers' date and time selected
	 * @param cineplexID   This customers' cineplex ID
	 * @param screenNumber This customers' screen number for the show
	 * @param is3D         Check if the customers' movie is 3D
	 * @param seats        Displays the seat array
	 */
	public Show(Movie mov, String timeDate, int cineplexID, int screenNumber, boolean is3D, int[][] seat) {
		this.mov = mov;
		timenDate = timeDate;

		this.cineplexID = cineplexID;
		this.screenNumber = screenNumber;
		this.is3D = is3D;
		this.seat = seat;
	}

	// printing the seats;
	/**
	 * Seats to be printed
	 */
	public void printSeats() {
		System.out.printf("Movie %s by Director %s\n", mov.getMovieName(), mov.getDirector());
		System.out.printf("Show Location: Cineplex ID: %d, Screen Number: %d\n", cineplexID + 1, screenNumber + 1);
		System.out.printf("Show Time: %s\n\n\n", timenDate);
		System.out.printf("      1 2 3   4 5 6   7 8 9\n");

		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				if (y % 3 == 0) {
					System.out.print("  ");
				}
				if (y == 0) {
					System.out.printf("%c   ", (char) x + 65);
				}
				if (seat[x][y] == 1) {
					System.out.printf("X ");
				} else {
					System.out.printf("_ ");
				}
			}
			System.out.print("\n");
		}
		System.out.printf("\n           Screen Here     \n");
		System.out.printf("\n          X  -  Occupied   \n");
		System.out.printf("          _  -  Vaccant    \n");

	}

	// assigning the x and y axis;
	/**
	 * Seat to be assigned
	 * 
	 * @param x1 seat arrangement x coordinate
	 * @param y2 seat arrangment y coordinate
	 */
	public void assignSeat(int x1, int y2) {
		if (seat[x1][y2] == 0) {
			seat[x1][y2] = 1;
			availableSeats--;
			// mov.incTsales();
		} else
			System.out.println("Error");
	}

	/**
	 * @param x1
	 * @param y2
	 * @return boolean
	 */
	public boolean checkingSeat(int x1, int y2) {
		if (seat[x1][y2] == 0) {
			return false;
		} else
			return true;
	}

	// get functions and return;
	/**
	 * Gets the time and date details of the show
	 * 
	 * @return TimenDate This customers' time and date selected
	 */
	public String getTimenDate() {
		return timenDate;
	}

	/**
	 * Gets the CineplexID of the show
	 * 
	 * @return CineplexID This customers' cineplex ID
	 */
	public int getCineplexID() {
		return cineplexID;
	}

	/**
	 * Gets the ScreenNumber of the show
	 * 
	 * @return ScreenNumber This customers' screen number for the show
	 */
	public int getScreenNumber() {
		return screenNumber;
	}

	/**
	 * Gets the available seats for the show selected
	 * 
	 * @return AvailableSeats This customers' available seats to choose from
	 */
	public int getAvailableSeats() {
		return availableSeats;
	}

	/**
	 * Gets the movie of the show
	 * 
	 * @return getMovie Get the movie
	 */
	public Movie getMovie() {
		return mov;
	}

	/**
	 * Show if movie is 3D
	 * 
	 * @return get3D This customers' movie details-3D or not
	 */
	public boolean get3D() {
		return is3D;
	}

	/**
	 * Gets the array for seats
	 * 
	 * @return getSeat Return the seat array
	 */
	public int[][] getSeat() {
		return seat;
	}
	// displaying seats
	// end of get functions
}
