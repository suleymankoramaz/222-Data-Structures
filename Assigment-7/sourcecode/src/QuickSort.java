package src;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * The QuickSort class implements a quicksort algorithm to sort a map of letters and their
 * corresponding count and words.
 */
public class QuickSort
{
    myMap originalMap;
	myMap sortedMap;
	List<String> aux;
    
    // This is the constructor for the QuickSort class. It takes in a myMap object called originalMap
    // as a parameter and assigns it to the instance variable originalMap. It also initializes two
    // other instance variables: aux, which is an ArrayList of Strings containing the keys of the
    // originalMap, and sortedMap, which is a new empty myMap object.
    public QuickSort(myMap originalMap)
    {
        this.originalMap = originalMap;
		this.aux = new ArrayList<String>(this.originalMap.map.keySet());
		this.sortedMap = new myMap();
    }

    /**
     * The "sort" function uses quicksort algorithm to sort the elements in the "aux" list and then
     * generates a new map.
     */
    public void sort()
    {
        quickSort(0, aux.size() - 1);
        generateNewMap();
    }

    /**
     * This is a private function in Java that swaps two elements in an ArrayList of Strings.
     * 
     * @param i The parameter "i" is an integer representing the index of the first element to be
     * swapped in the "aux" list.
     * @param j The parameter "j" is an integer variable representing the index of an element in a list
     * or array. It is used in the "swap" method to swap the element at index "i" with the element at
     * index "j".
     */
    private void swap(int i, int j)
    {
        String temp = aux.get(i);
        aux.set(i, aux.get(j));
        aux.set(j, temp);
    }

    /**
     * This is a Java function that performs partitioning on an array of strings based on the count of
     * their corresponding values in a map.
     * 
     * @param low The index of the first element in the subarray being partitioned.
     * @param high The index of the last element in the array being partitioned.
     * @return The method is returning an integer value which represents the index of the pivot element
     * after partitioning the array.
     */
    private int partition(int low, int high)
    {
        String pivot = aux.get(high);

        int i = (low - 1);
 
        for(int j = low; j <= high - 1; j++) 
        {

            if(originalMap.map.get(aux.get(j)).count < originalMap.map.get(pivot).count) 
            {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return (i + 1);
    }

    /**
     * This is a recursive implementation of the quicksort algorithm in Java.
     * 
     * @param low The index of the first element in the array or subarray being sorted.
     * @param high The highest index of the subarray being sorted.
     */
    private void quickSort(int low, int high)
    {
        if(low < high) 
        {
            int pi = partition(low, high);

            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    /**
     * This Java function prints a sorted array of letters, their count, and associated words.
     */
    public void printSortedArray()
    {
	    for(Map.Entry<String, info> e : sortedMap.map.entrySet())
        {
            System.out.println("Letter: " + e.getKey() + " - Count: "
                               + e.getValue().count + " - Words: " + e.getValue().words);
        }
	}

    /**
     * This Java function prints the original array with information about the count and words associated
     * with each letter.
     */
	public void printOriginalArray()
    {
	    for(Map.Entry<String, info> e : originalMap.map.entrySet())
        {
            System.out.println("Letter: " + e.getKey() + " - Count: "
                               + e.getValue().count + " - Words: " + e.getValue().words);
        }
	}

    /**
     * This function generates a new map by assigning words to keys in a sorted map based on the
     * original map and a list of keys.
     */
    private void generateNewMap() 
    {
		for(int i = 0; i < aux.size(); i++)
        {
			this.sortedMap.assign(aux.get(i), this.originalMap.map.get(aux.get(i)).words);
        }
	}
}