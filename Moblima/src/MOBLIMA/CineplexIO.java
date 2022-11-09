package MOBLIMA;

//import the necessary files;
import java.io.PrintWriter;
import java.io.File;
import java.util.*;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileWriter;

public class CineplexIO {
	private static String SEPERATOR = "|";
	// to read the data;
	public static String filename = System.getProperty("user.dir") + "/Moblima/data/cineplex.txt";

	public CineplexIO() {
		// TODO Auto-generated constructor stub
	}

	// access the cineplexes;
	public ArrayList<Cineplex> accessCineplex() {
		try {
			ArrayList<Cineplex> cinRecord = new ArrayList<Cineplex>();
			String[] var;
			String[] var1;
			Cinema c;
			// declaring and initialising;
			Scanner fileScanner = new Scanner(new File(filename));
			while (fileScanner.hasNext()) {
				var = fileScanner.nextLine().split(";");
				ArrayList<Cinema> cinRecord2 = new ArrayList<>();
				for (int i = 2; i < var.length; i++) {
					var1 = var[i].split("[|]");
					c = new Cinema(var1[0], var[1], "XXX", Integer.parseInt(var1[2]));
					cinRecord2.add(c);
				}
				cinRecord.add(new Cineplex(
						var[0], Integer.parseInt(var[1]),
						cinRecord2));
			}
			fileScanner.close();
			return cinRecord;
		}

		catch (Exception exc) {
			System.err.println(exc);

			exc.printStackTrace();

			return null;
		}
	}

	public static void cinStore(List store) throws IOException {
		int y;
		List rec = new ArrayList();
		Cineplex c;
		ArrayList<Cinema> var;
		Cinema cin;
		StringBuilder build;
		final String spec = ";";
		int x;

		for (x = 0; x < store.size(); x++) {
			c = (Cineplex) store.get(x);
			build = new StringBuilder();
			build.append(c.getNameCineplex().trim());
			build.append(spec);

			build.append(c.getIDCineplex());
			build.append(spec);

			var = c.getListCinemas();

			for (y = 0; y < var.size(); y++) {
				cin = var.get(y);
				build.append(cin.getCinemaName());
				build.append("|");

				build.append(cin.getCinemaCategory());
				build.append("|");

				build.append(String.valueOf(cin.getCinemaID()));
				if (y != var.size() - 1)
					build.append(spec);

			}
			build.append(spec);
			rec.add(build.toString());
		}
		write(filename, rec);
	}

	public static List process(String nameFolder) throws IOException {
		List record = new ArrayList();
		Scanner scanner = new Scanner(new FileInputStream(nameFolder));
		try {
			while (scanner.hasNextLine()) {
				record.add(scanner.nextLine());
			}
		} finally {
			scanner.close();
		}
		return record;

	}

	public static void write(String nameFolder, List record) throws IOException {
		PrintWriter last = new PrintWriter(new FileWriter(nameFolder));
		int z;
		try {
			for (z = 0; z < record.size(); z++) {
				last.println((String) record.get(z));
			}
		} finally {
			last.close();
		}
	}
}
