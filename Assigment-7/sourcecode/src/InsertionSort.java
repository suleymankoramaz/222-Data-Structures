package src;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * The InsertionSort class sorts a map of letters and their corresponding word counts using the
 * insertion sort algorithm and generates a new map with the sorted data.
 */
public class InsertionSort
{
    myMap originalMap;
	myMap sortedMap;
	List<String> aux;
    
    // This is the constructor of the `InsertionSort` class that takes a `myMap` object as a parameter.
    // It initializes the `originalMap` instance variable with the `myMap` object passed as a
    // parameter. It also initializes the `aux` instance variable with a new `ArrayList` containing the
    // keys of the `originalMap` object. Finally, it initializes the `sortedMap` instance variable with
    // a new `myMap` object.
    public InsertionSort(myMap originalMap)
    {
        this.originalMap = originalMap;
		this.aux = new ArrayList<String>(this.originalMap.map.keySet());
		this.sortedMap = new myMap();
    }

    /**
     * This function sorts a list of strings based on the count of their corresponding values in a map.
     */
    public void sort()
    {
        int n = aux.size();

        for(int i = 1; i < n; ++i) 
        {
            String key = aux.get(i);
            int j = i - 1;
            while(j >= 0 && originalMap.map.get(aux.get(j)).count > originalMap.map.get(key).count) 
            {
                aux.set(j + 1 , aux.get(j));
                j = j - 1;
            }
            aux.set(j + 1 , key);
        }

        generateNewMap();
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