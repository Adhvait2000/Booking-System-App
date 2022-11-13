package MOBLIMA;

import java.util.*;

/**
 * Create and obtain Cineplexes using relevant information
 * There are three cinemas in each Cineplex
 * 
 * @version 1.0
 * @since 2022-11-01
 */
public class Cineplex {

	/**
	 * Name of Cineplex
	 */
	private String nameCineplex;

	/**
	 * ID of a Cineplex
	 */
	private int idCineplex;

	/**
	 * List of cinemas in each cineplex
	 */
	private ArrayList<Cinema> listCinemas;

	/**
	 * Constructor for Cineplex
	 * sets the name and id of the cineplex and creates a new list of Cinemas for
	 * the Cineplex
	 * 
	 * @param nameCineplex Name of this cineplex
	 * @param idCineplex   ID of this Cineplex
	 */
	public Cineplex(String nameCineplex, int idCineplex) {
		this.nameCineplex = nameCineplex;
		this.idCineplex = idCineplex;
		this.listCinemas = new ArrayList<Cinema>();
	}

	/**
	 * Another Constructor for Cineplex but with different parameters
	 * Allows for a list of cinemas to be set for the Cineplex instead of creating a
	 * new list
	 * 
	 * @param nameCineplex Name of this cineplex
	 * @param idCineplex   ID of this Cineplex
	 * @param listCinemas  array of all cinemas in this cinemplex
	 */
	public Cineplex(String nameCineplex, int idCineplex, ArrayList<Cinema> listCinemas) {
		this.nameCineplex = nameCineplex;
		this.idCineplex = idCineplex;
		this.listCinemas = listCinemas;
	}

	/**
	 * Sets the name of the cineplex
	 * 
	 * @param nameCineplex Name of this cineplex
	 */
	public void setNameCineplex(String nameCineplex) {
		this.nameCineplex = nameCineplex;
	}

	/**
	 * Gets the name of the cineplex
	 * 
	 * @return nameCineplex Name of this cineplex
	 */
	public String getNameCineplex() {
		return nameCineplex;
	}

	/**
	 * Gets the id of the cineplex
	 * 
	 * @return idCineplex ID of this cineplex
	 */
	public int getIDCineplex() {
		return idCineplex;
	}

	/**
	 * Gets list of cinemas in this cineplex
	 * 
	 * @return listCinemas list of cinemas in this Cineplex
	 */
	public ArrayList<Cinema> getListCinemas() { // get list of cinemas in cineplex
		return listCinemas;
	}

	/**
	 * Add a Cinema to the list of cinemas in this Cineplex
	 * 
	 * @param cinema
	 */
	public void addCinema(Cinema cinema) {
		listCinemas.add(cinema); // add cinema to cineplex
	}

}
