package inter.com.code;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.google.gson.Gson;

/**
 * Created by Thiago Amanajás on 21/06/16.
 *
 * The class uses this library to read and manipulate 
 * the json file: https://mvnrepository.com/artifact/com.google.code.gson/gson/2.7
 *
 * This class is used to find users within 100km
 * answering the following question:
 *
 * We have some customer records in a text file (customers.json) -- one customer per line,
 * JSON-encoded. We want to invite any customer within 100km of our Dublin office for some food
 * and drinks on us. Write a program that will read the full list of customers and output the
 * names and user ids of matching customers (within 100km), sorted by User ID (ascending).
 */
public class FindUser {

	// Earth radius in KM
    private static final double EARTH_RADIUS = 6371.0;
	// Latitude of the office
    private static double LAT = 53.3381985;
    // Longitude of the office
    private static double LONG = -6.2592576;


    /**
     * Read the json file, and generate the user object list
     * @param file the address of the file
     * @return      the user list
     */
    private static ArrayList<User> loadUserList(String file) 
    		throws FileNotFoundException {

        ArrayList<User> userList = new ArrayList<>();
        String line = "";

        // Buffering the file
        InputStream is = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        try {
        	// Reading the json
        	Gson gson = new Gson();
            while((line = br.readLine()) != null) { 
            	User user = gson.fromJson(line, User.class);
            	userList.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	// Closing the buffer
        	try {
	        	if (is != null) {
					is.close();
	        	}
	        	if (isr != null) {
	        		isr.close();
	        	}
	        	if (br != null) {
	        		br.close();
	        	}
	        } catch (IOException e) {
	        	
				e.printStackTrace();
	        }
        }

        return userList;
    }

    /**
     * Reads the json file
     * @param file the address of the file
     * @param distance the distance of the users
     * @return       the list of user within the distance passed by param
     */
    public static ArrayList<User> getUsers(String file, double distance)
            throws FileNotFoundException {

    	// User list
    	ArrayList<User> userList = loadUserList(file);
    	
    	// Ordering the user list by id
    	Comparator<User> comparator = new Comparator<User>() {
    	    public int compare(User c1, User c2) {
    	        return c1.getUser_id() - c2.getUser_id(); // use your logic
    	    }
    	};
    	Collections.sort(userList, comparator);
    	
    	// Creating the user list by distance
    	ArrayList<User> userIdList = new ArrayList<>();
        
    	// For each user it calculates the distance
    	for (User user : userList) {
    		
    		// Verify if the distance of the user is less or equal to the param @distance
    		if (getDistanceFromOffice(user) <= distance) {
    			
    			// Add the user in the list
    			userIdList.add(user);
    			
    			// Printing users
    			System.out.println(user.toString());
    		}
    	}

        return userIdList;
    }
    
    /**
     * Calculate the distance between two geo locations
     * @param user the object containing the lat and long of the user
     * @return     the distance between the user and the office
     */
    private static double getDistanceFromOffice(User user) {
    	
    	double latDistance = Math.toRadians(user.getLatitude() - LAT);
        double lngDistance = Math.toRadians(user.getLongitude() - LONG);
        double arccos = Math.sin(latDistance/2) * Math.sin(latDistance/2) +
                   Math.cos(Math.toRadians(LAT)) * Math.cos(Math.toRadians(user.getLatitude())) *
                   Math.sin(lngDistance/2) * Math.sin(lngDistance/2);
        return EARTH_RADIUS * (2 * Math.atan2(Math.sqrt(arccos), Math.sqrt(1-arccos)));
        
    }
    
    /*
     * Print a list of users
     * @param users the list of users to be printed
     */
    public static void printUsers(ArrayList<User> users) {
    	
    	for (User user : users) {
			System.out.println(user.toString());
    	}
    }
    
}
