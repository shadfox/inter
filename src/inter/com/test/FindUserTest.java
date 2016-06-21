package inter.com.test;

import inter.com.code.FindUser;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by Thiago Amanajás on 21/06/16.
 *
 * This class is used to test the FlatArray code.
 */
public class FindUserTest {

	// File path to be used in the tests
	public static final String FILE_PATH = "./json/gistfile1.txt";
	
	@Test
    public void loadJsonFile() {
    	try {
            assertTrue("The file has been loaded sucessfully", 
            		FindUser.getUsers(FILE_PATH, 100).size() > 0);
        } catch (FileNotFoundException e) {
            fail("No file was found");
        }
    }
	
	@Test
    public void checkDistances() {
    	try {
    		ArrayList<String[]> list = FindUser.getUsers(FILE_PATH, 100);
            assertTrue(list.size() == 16);
            System.out.println("-----------");
            
            list = FindUser.getUsers(FILE_PATH, -200);
            assertTrue(list.size() == 0);
            System.out.println("- NONE -");
            System.out.println("-----------");
    		
    		list = FindUser.getUsers(FILE_PATH, 40);
    		assertTrue(list.size() == 5);
    		System.out.println("-----------");
    		
    		list = FindUser.getUsers(FILE_PATH, 80);
    		assertTrue(list.size() == 10);
    		System.out.println("-----------");
            
        } catch (FileNotFoundException e) {
            fail("No file was found");
        }
    }
}
