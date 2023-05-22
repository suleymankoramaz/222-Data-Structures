package src;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * The BubbleSort class sorts a map of letters and their corresponding word counts using the bubble
 * sort algorithm.
 */
public class BubbleSort
{
    myMap originalMap;
	myMap sortedMap;
	List<String> aux;
    
    // This is a constructor for the BubbleSort class that takes in a myMap object called originalMap
    // as a parameter. It assigns the originalMap to the instance variable originalMap, creates a new
    // ArrayList called aux that contains the keys of the originalMap, and creates a new myMap object
    // called sortedMap.
    public BubbleSort(myMap originalMap)
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

        for(int i = 0; i < n - 1; i++)
        {
            for(int j = 0; j < n - i - 1; j++)
            {
                if(originalMap.map.get(aux.get(j)).count > originalMap.map.get(aux.get(j + 1)).count) 
                {
                    String temp = aux.get(j);
                    aux.set(j , aux.get(j + 1));
                    aux.set(j + 1 , temp);
                }
            }
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
    private void generateNewMap(){
		for (int i = 0; i < aux.size(); i++)
        {
			this.sortedMap.assign(aux.get(i), this.originalMap.map.get(aux.get(i)).words);
        }
	}
}