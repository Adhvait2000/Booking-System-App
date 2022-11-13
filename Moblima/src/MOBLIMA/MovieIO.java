package MOBLIMA;

import java.util.*;
import java.io.*;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MovieIO {
    public static String SEPERATOR = "|";

    /**
     * @param arr
     * @return String[]
     */
    public static String[] GetStringArray(ArrayList<String> arr) {
        String str[] = new String[arr.size()];

        Object[] objArr = arr.toArray();
        int i = 0;
        for (Object obj : objArr) {
            str[i++] = (String) obj;
        }
        return str;
    }

    /**
     * @param ArrayListarr
     * @return double[]
     */
    public static double[] getDoubleArray(ArrayList<String> arr) {
        double db[] = new double[arr.size()];

        int i = 0;
        for (String str : arr) {
            db[i++] = Double.parseDouble(str);
        }
        return db;
    }

    /**
     * @param filename
     * @return ArrayList
     * @throws IOException
     */
    public static ArrayList readMovie(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);

        ArrayList alr = new ArrayList();
        int size = stringArray.size();

        for (int i = 0; i < size; i++) {
            ArrayList alr2 = new ArrayList();

            String st = (String) stringArray.get(i);

            StringTokenizer star = new StringTokenizer(st, SEPERATOR);

            String movieName = star.nextToken().trim();

            String directorName = star.nextToken().trim();

            String all_reviews = star.nextToken().trim();

            StringTokenizer star2 = new StringTokenizer(all_reviews, ",");

            String[] reviews;

            if (!all_reviews.equals("No Reviews")) {
                while (star2.hasMoreTokens()) {
                    alr2.add(star2.nextToken());
                }
                reviews = GetStringArray(alr2);
            } else {
                reviews = new String[0];
            }
            alr2 = new ArrayList();

            String all_ratings = star.nextToken().trim();

            double[] ratings;

            if (!all_ratings.equals("No Ratings")) {
                star2 = new StringTokenizer(all_ratings, ",");
                while (star2.hasMoreTokens()) {
                    alr2.add(star2.nextToken());
                }
                ratings = getDoubleArray(alr2);
            } else {
                ratings = new double[0];
            }
            alr2 = new ArrayList();

            String showingStatus = star.nextToken().trim();

            String Synopsis = star.nextToken().trim();

            String all_cast = star.nextToken().trim();

            star2 = new StringTokenizer(all_cast, ",");

            while (star2.hasMoreTokens()) {
                alr2.add(star2.nextToken());
            }
            String cast[] = GetStringArray(alr2);
            int tSales = Integer.parseInt(star.nextToken());

            Movie mov = new Movie(movieName, directorName, reviews, ratings, showingStatus, Synopsis, cast, tSales);

            alr.add(mov);

        }
        return alr;
    }

    /**
     * @param fileName
     * @return List
     * @throws IOException
     */
    public static List read(String fileName) throws IOException {
        List data = new ArrayList();
        Scanner sc = new Scanner(new FileInputStream(fileName));
        try {
            while (sc.hasNextLine()) {
                data.add(sc.nextLine());
            }
        } finally {
            sc.close();
        }

        return data;
    }

    /**
     * @param fileName
     * @param data
     * @throws IOException
     */
    public static void write(String fileName, List data) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(fileName));
        try {
            int size = data.size();
            for (int i = 0; i < size; i++) {
                out.println((String) data.get(i));
            }
        } finally {
            out.close();
        }
    }

    /**
     * @param fileName
     * @param al
     * @throws IOException
     */
    public static void saveMovie(String fileName, List al) throws IOException {
        List alw = new ArrayList();
        int size = al.size();

        for (int i = 0; i < size; i++) {
            Movie mov = (Movie) al.get(i);
            StringBuilder st = new StringBuilder();
            st.append(mov.getMovieName().trim());
            st.append(SEPERATOR);
            st.append(mov.getDirector().trim());
            st.append(SEPERATOR);
            String[] temp = mov.getReviews();
            if (temp.length == 0) {
                st.append("No Reviews");
            } else {
                for (int j = 0; j < temp.length; j++) {
                    st.append(temp[j]);
                    if (j < temp.length)
                        st.append(",");
                }
            }
            st.append(SEPERATOR);

            double[] temp2 = mov.getAllRatings();
            if (temp2.length == 0)
                st.append("No Ratings");
            else {
                for (int j = 0; j < temp2.length; j++) {
                    st.append(String.valueOf(temp2[j]));
                    if (j < temp.length)
                        st.append(",");
                }
            }
            st.append(SEPERATOR);

            st.append(mov.getShowingStatus());
            st.append(SEPERATOR);
            st.append(mov.getSynopsis());
            st.append(SEPERATOR);
            temp = mov.getCast();

            for (int j = 0; j < temp.length; j++) {
                st.append(temp[j]);
                if (j < temp.length - 1)
                    st.append(",");
            }
            st.append(SEPERATOR);
            st.append(String.valueOf(mov.getTSales()));
            alw.add(st.toString());
        }
        write(fileName, alw);
    }

    /**
     * @param mov
     * @param filename
     * @return ArrayList<Show>
     * @throws IOException
     */
    public static ArrayList<Show> readShows(Movie mov, String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList<Show> alr = new ArrayList<Show>();

        for (int i = 0; i < stringArray.size(); i++) {
            ArrayList alr2 = new ArrayList();

            String st = (String) stringArray.get(i);

            StringTokenizer star = new StringTokenizer(st, SEPERATOR);

            String dateTime = star.nextToken().trim();

            String strCineplexID = star.nextToken().trim();
            int cineplexID = Integer.parseInt(strCineplexID);

            String strScreenNum = star.nextToken().trim();
            int screenNum = Integer.parseInt(strScreenNum);

            String seats = star.nextToken().trim();

            StringTokenizer star2 = new StringTokenizer(seats, ",");
            while (star2.hasMoreTokens()) {
                alr2.add(star2.nextToken());
            }
            double[] Seats = getDoubleArray(alr2);

            int[][] seats_final = new int[9][9];

            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 9; y++) {
                    seats_final[x][y] = (int) Math.round(Seats[9 * x + y]);
                }
            }

            boolean is3D = Boolean.parseBoolean(star.nextToken().trim());

            Show s = new Show(mov, dateTime, cineplexID, screenNum, is3D, seats_final);
            alr.add(s);
        }
        return alr;
    }

    /**
     * @param filename
     * @param shows
     * @throws IOException
     */
    public static void saveShows(String filename, List shows) throws IOException {
        if (shows == null)
            return;

        List alw = new ArrayList();

        for (int i = 0; i < shows.size(); i++) {
            Show s = (Show) shows.get(i);
            StringBuilder st = new StringBuilder();

            st.append(s.getTimenDate().trim());
            st.append(SEPERATOR);
            st.append(String.valueOf(s.getCineplexID()).trim());
            st.append(SEPERATOR);
            st.append(String.valueOf(s.getScreenNumber()).trim());
            st.append(SEPERATOR);

            int[][] temp2 = s.getSeat();
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    st.append(String.valueOf(temp2[j][k]));
                    if (j != 8 || k != 8)
                        st.append(",");
                }
            }

            st.append(SEPERATOR);
            st.append(String.valueOf(s.get3D()));
            alw.add(st.toString());
        }
        write(filename, alw);
    }
}
