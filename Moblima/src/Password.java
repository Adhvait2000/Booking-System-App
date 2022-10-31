import java.util.Scanner;
import java.util.ArrayList;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.io.File;
import java.io.FileNotFoundException;

public class Password {
    // storing all the passwords
    static ArrayList<String> passwords = new ArrayList<>();

    // hash password using MD5

    public static String hashPassword(String password) {
        try {
            // create messagedigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // add password bytes to digest
            md.update(password.getBytes());

            // get hash bytes
            byte bytesdata[] = md.digest();

            // convert decimals to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytesdata.length; i++) {
                sb.append(Integer.toString((bytesdata[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }
    }
    // read passwords and store in an arraylist

    public static ArrayList<String> readPasswords() {

        File file = new File("data/passwords.txt");

        try {

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                passwords.add(i);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return passwords;
    }

    // checking if the passwords entered are correct
    // return valid if the password is correct
    public static boolean checkPassword(String password) {
        ArrayList<String> check = readPasswords();
        boolean valid;

        valid = false;

        for (int j = 0; j < check.size(); j++) {
            if (check.get(j).matches(hashPassword(password))) {
                valid = true;
            }
        }
        return valid;
    }

}
