package inter.com.test;

import inter.com.code.FlatArray;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Thiago Amanajás on 21/06/16.
 *
 * This class is used to test the FlatArray code.
 */
public class FlatArrayTest {

	/**
	 * Check the flatten arrays
	 * @result  Creates many arrays containing integers and other arrays,
	 *          and after the execution of the flatten method verifies
	 *          if the array is flat. 
	 */
    @Test
    public void checkFlatten() {
        Object[] tester1 = new Object[]{0, 1, new Object[]{1, new Object[]{4, 5, 6}, 0, 2}, 4};
        Object[] tester2 = new Object[]{2, 3, new Object[]{2, 1, 3}, 5, new Object[]{2, null, 3}};
        Object[] tester3 = new Object[]{3, 4, new Object[]{3, null, 4}, 6};
        Object[] tester4 = new Object[]{4, new Object[]{4, new Object[]{7, 8}}, new Object[]{77}};
        Object[] tester5 = new Object[]{new Object[]{5, new Object[]{8, 9, 10}, null, 6}, 5, 6, 8};
        Object[] tester6 = new Object[]{null,null,null,0};

        assertArrayEquals(new Object[]{0, 1, 1, 4, 5, 6, 0, 2, 4}, FlatArray.getFlatten(tester1));
        assertArrayEquals(new Object[]{2, 3, 2, 1, 3, 5, 2, 3}, FlatArray.getFlatten(tester2));
        assertArrayEquals(new Object[]{3, 4, 3, 4, 6}, FlatArray.getFlatten(tester3));
        assertArrayEquals(new Object[]{4, 4, 7, 8, 77}, FlatArray.getFlatten(tester4));
        assertArrayEquals(new Object[]{5, 8, 9, 10, 6, 5, 6, 8}, FlatArray.getFlatten(tester5));
        assertArrayEquals(new Object[]{0}, FlatArray.getFlatten(tester6));
    }

    /**
	 * Check for exceptions
	 * @result  Verifies if the flatten method is prepared to 
	 *          receive null objects instead array. The method
	 *          must throw a exception.
	 */
    @Test
    public void failFlatten() {
        try{
            FlatArray.getFlatten(null);
        }catch(Exception e){
            assertEquals("Original array must be valid!", e.getMessage());
        }
    }
}
