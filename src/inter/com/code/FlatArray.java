package inter.com.code;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Thiago Amanajás on 21/06/16.
 *
 * This class is used to transform any nested arrays of
 * integers into a flat array answering the following question:
 *
 * Write a function that will flatten an array of arbitrarily nested arrays of integers into
 * a flat array of integers. e.g. [[1,2,[3]],4] → [1,2,3,4]. If the language you're using has a
 * function to flatten arrays, you should pretend it doesn't exist.
 *
 */
public class FlatArray {

    /**
     * Creates the flat array
     * @param  originalArray a new array provided to be transformed into a flat array
     * @return       the flat array originated from the array passed by param
     */
    public static Object[] getFlatten(Object[] originalArray) {

        // Check of the original array is valid
        if (originalArray == null) {
            throw new NullPointerException("Original array must be valid!");
        }

        // Creates the result list
        ArrayList<Object> createdArray = new ArrayList<>();

        // Check each object of the original array
        for (Object i : originalArray) {

            // If the object is not null
            if (i != null) {

                // If the object is an Array it executes the method using the object
                if (i instanceof Object[]) {

                    createdArray.addAll(Arrays.asList(getFlatten((Object[]) i)));

                // If the object is not an Array it is added directly in the list
                } else {

                    createdArray.add(i);

                }
            }
        }

        return createdArray.toArray();
    }

}
