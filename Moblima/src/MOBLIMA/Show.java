package MOBLIMA;


public class Show { // figure out how to implement extends movie
	
	//declaration of variables;
	
	private String timenDate;
	private int cineplexID;
	private Movie mov;
	private int screenNumber;
	private int availableSeats = 81;
	
	//to find if movie is 3D?;
	private boolean is3D;
	
	//declare array of seats;
	private int[][] seat = new int[9][9];
	
	
	public Show(Movie mov, String timeDate, int cineplexID, int screenNumber, boolean is3D) {
		this.mov = mov;
		timenDate = timeDate;
		for(int x=0;x<9;x++) {
			for(int y=0;y<9;y++) {
				seat[x][y] = 0;
			}
		}
		this.is3D = is3D;
		this.cineplexID = cineplexID;
		this.screenNumber = screenNumber;
	}
	
	public Show(Movie mov, String timeDate, int cineplexID, int screenNumber, boolean is3D, int[][] seat) {
		this.mov = mov;
		timenDate = timeDate;
		
		this.cineplexID = cineplexID;
		this.screenNumber = screenNumber;
		this.is3D = is3D;
		this.seat = seat;
	}
	
	
	//printing the seats;
	public void printSeats() {
		System.out.printf("Movie %s by Director %s\n",mov.getMovieName(),mov.getDirector());
		System.out.printf("Show Location: Cineplex ID: %d, Screen Number: %d\n",cineplexID+1,screenNumber+1);
		System.out.printf("Show Time: %s\n\n\n",timenDate);
		System.out.printf("      1 2 3   4 5 6   7 8 9\n");
		
		for(int x=0;x<9;x++) {
			for(int y=0;y<9;y++) {
				if (y%3 == 0) {
					System.out.print("  ");
				}
				if (y == 0) {
					System.out.printf("%c   ",(char)x+65);
				}
				if (seat[x][y]==1) {
					System.out.printf("X ");
				}
				else {
					System.out.printf("_ ");
				}
			}
			System.out.print("\n");
		}
		System.out.printf("\n           Screen Here     \n");
		System.out.printf("\n          X  -  Occupied   \n");
		System.out.printf("          _  -  Vaccant    \n");

	}
	
	
	//assigning the x and y axis;
	public void assignSeat(int x1,int y2) {
		if (seat[x1][y2] == 0) {
			seat[x1][y2] = 1;
			availableSeats--;
			//mov.incTsales();
		}
		else
			System.out.println("Error");
	}
	
	public boolean checkingSeat(int x1,int y2) {
		if (seat[x1][y2] == 0) {
			return false;
		}
		else return true;
	}
	
	//get functions and return;
	
	public String getTimenDate() {
		return timenDate;
	}
	
	public int getCineplexID() {
		return cineplexID;
	}
	
	public int getScreenNumber() {
		return screenNumber;
	}
	
	public int getAvailableSeats() {
		return availableSeats;
	}
	
	//end of get functions;
	
	public boolean get3D() {
		return is3D;
	}
	
	public int[][] getSeat(){
		return seat;
	}
	//displaying seats
	
}
