package inter.com.test;

import inter.com.code.FindUser;
import inter.com.code.User;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by Thiago Amanajás on 21/06/16.
 *
 * This class is used to test the FindUser code.
 */
public class FindUserTest {

	// File path to be used in the tests
	public static final String FILE_PATH = "./json/gistfile1.txt";
	
	/**
	 * Load the user list file.
	 * @result the file will be loaded without any errors.
	 */
	@Test
    public void loadJsonFile() {
    	try {
            assertTrue("The file has been loaded sucessfully", 
            		FindUser.getUsers(FILE_PATH, 100).size() > 0);
        } catch (FileNotFoundException e) {
            fail("No file was found");
        }
    }
	
	/**
	 * Check the user distances
	 * @result after load the file this method checks if the amount 
	 *         of users matches with the amount expected for that
	 *         distance, and also if it is printing the results that contains
	 *         id and name.
	 */
	@Test
    public void checkDistances() {
    	try {
    		ArrayList<User> list = FindUser.getUsers(FILE_PATH, 100);
    		FindUser.printUsers(list);
    		assertThat(list.get(0).toString(), 
    				CoreMatchers.containsString("ID:"));
    		assertThat(list.get(0).toString(), 
    				CoreMatchers.containsString("Name:"));
            assertTrue(list.size() == 16);
            System.out.println("-----------");
            
            list = FindUser.getUsers(FILE_PATH, -200);
            assertTrue(list.size() == 0);
            System.out.println("- NONE -");
            System.out.println("-----------");
    		
    		list = FindUser.getUsers(FILE_PATH, 40);
    		FindUser.printUsers(list);
    		assertTrue(list.size() == 5);
    		System.out.println("-----------");
    		
    		list = FindUser.getUsers(FILE_PATH, 80);
    		FindUser.printUsers(list);
    		assertTrue(list.size() == 10);
    		System.out.println("-----------");
            
        } catch (FileNotFoundException e) {
            fail("No file was found");
        }
    }
}
