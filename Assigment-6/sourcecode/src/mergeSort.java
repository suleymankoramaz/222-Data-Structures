// `package src;` is declaring the package name for the Java file. In this case, the package name is
// "src". This is used to organize related classes and interfaces into a single unit, and to avoid
// naming conflicts between classes with the same name in different packages.
package src;

import java.util.LinkedHashMap;
import java.util.ArrayList;

/**
 * The mergeSort class implements the merge sort algorithm to sort a map of strings and their
 * corresponding counts.
 */
public class mergeSort
{
    //VARIABLES
    private myMap originalMap;
    private myMap sortedMap;
    ArrayList<String> aux;

    //CONSTRUCTOR
    // This is a constructor for the `mergeSort` class that takes in a parameter of type `myMap` named
    // `mapValue`. It sets the value of the instance variable `originalMap` to the value of `mapValue`,
    // and initializes the `aux` ArrayList with the keys from the `originalMap` using a for-each loop.
    protected mergeSort(myMap mapValue)
    {
        originalMap = mapValue;
        aux = new ArrayList<String>();
        for(String key : getOriginalMap().getMap().keySet())
            aux.add(key);
    }

    //GETTERS
    /**
     * The method returns the original map.
     * 
     * @return The method is returning an object of type `myMap`, which is the original map.
     */
    protected myMap getOriginalMap()
    {
        return originalMap;
    }
    /**
     * The method returns a sorted map.
     * 
     * @return The method is returning a variable named `sortedMap` which is of type `myMap`.
     */
    protected myMap getSortedMap()
    {
        return sortedMap;
    }
    /**
     * The function returns an ArrayList of Strings named "aux".
     * 
     * @return An ArrayList of Strings named "aux" is being returned.
     */
    protected ArrayList<String> getAux()
    {
        return aux;
    }

    //SETTERS
    /**
     * This is a Java method that sets the value of a variable called "originalMap" to a new value
     * passed as a parameter.
     * 
     * @param newMap The parameter "newMap" is of type "myMap", which is likely a custom class or data
     * structure representing a map or dictionary. This method sets the value of the instance variable
     * "originalMap" to the value of the "newMap" parameter.
     */
    protected void setOriginalMap(myMap newMap)
    {
        originalMap = newMap;
    }
    /**
     * This is a Java method that sets a sorted map to a new map.
     * 
     * @param newMap The parameter "newMap" is a variable of type "myMap" which is being passed as an
     * argument to the method "setSortedMap". The method is then assigning the value of "newMap" to the
     * instance variable "sortedMap".
     */
    protected void setSortedMap(myMap newMap)
    {
        sortedMap = newMap;
    }

    /**
     * This is a Java function that sets the value of an ArrayList called "aux" to a new ArrayList
     * passed as a parameter.
     * 
     * @param newAux newAux is an ArrayList of Strings that contains the new values that will be
     * assigned to the variable "aux". This method "setAux" is used to update the value of the "aux"
     * variable with the new values passed as an argument.
     */
    protected void setAux(ArrayList<String> newAux)
    {
        aux = newAux;
    }

    //METHODS
    /**
     * This method sorts an ArrayList of strings using the merge sort algorithm and updates a
     * LinkedHashMap with the sorted values.
     */
    protected void mergeSort()
    {
        LinkedHashMap<String,info> newMap = new LinkedHashMap<String,info>();

        merge(0,getAux().size()-1);
        
        for(int i=0 ; i<getAux().size() ; i++)
        {
            info newInfo = getOriginalMap().getMap().get(getAux().get(i));
            newMap.put(getAux().get(i), newInfo);
        }
        myMap newMyMap = new myMap(newMap,getOriginalMap().getStr(),getOriginalMap().getMapSize());

        setSortedMap(newMyMap);
    }

    /**
     * The function recursively divides an array into halves, sorts them, and then merges them back
     * together.
     * 
     * @param left The index of the leftmost element in the array or subarray being sorted.
     * @param right The index of the rightmost element in the subarray being sorted/merged.
     */
    protected void merge(int left, int right) 
    {
        if(left < right) 
        {
            int mid = left + (right - left) / 2;
            merge(left, mid);      //merge left half
            merge(mid + 1, right); //merge right half
            sort(left, mid, right);   //sort the sorted halves
        }
    }

    /**
     * This is a merge sort implementation that sorts a string array based on the count of each string
     * in a map.
     * 
     * @param left The index of the leftmost element in the subarray being sorted.
     * @param mid The index of the middle element in the subarray being sorted.
     * @param right The index of the rightmost element in the subarray being sorted.
     */
    protected void sort(int left, int mid, int right) 
    {
        String[] temp = new String[getAux().size()];
        for(int i = left; i <= right; i++) 
            temp[i] = getAux().get(i);
    
        int i = left;     // pointer for left subarray
        int j = mid + 1;  // pointer for right subarray
        int k = left;     // pointer for merged array
    
        // Merge the two sorted subarrays
        while(i <= mid && j <= right) 
        {
            if(getOriginalMap().getMap().get(temp[i]).getCount() <= getOriginalMap().getMap().get(temp[j]).getCount())
            {
                getAux().set(k,temp[i]);
                i++;
            }
            else
            {
                getAux().set(k,temp[j]);
                j++;
            }
            k++;
        }
    
        // Copy remaining elements from the left subarray
        while(i <= mid) 
        {
            getAux().set(k,temp[i]);
            i++;
            k++;
        }
    
        // Copy remaining elements from the right subarray
        while(j <= right) 
        {
            getAux().set(k,temp[j]);
            j++;
            k++;
        }
    }
}