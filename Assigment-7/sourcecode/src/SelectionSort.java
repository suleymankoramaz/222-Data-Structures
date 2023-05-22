package src;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * The SelectionSort class sorts a map of letters and their corresponding word counts using the
 * selection sort algorithm.
 */
public class SelectionSort
{
    myMap originalMap;
	myMap sortedMap;
	List<String> aux;
    
    // This is the constructor for the SelectionSort class. It takes a parameter of type myMap, which
    // is the original map of letters and their corresponding word counts. It initializes the
    // originalMap instance variable with the parameter value, creates a new ArrayList called aux and
    // initializes it with the keys of the originalMap, and creates a new empty myMap called sortedMap.
    public SelectionSort(myMap originalMap)
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

        for(int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for(int j = i+1; j < n; j++)
            {
                if(originalMap.map.get(aux.get(j)).count < originalMap.map.get(aux.get(min_idx)).count)
                    min_idx = j;
            }

            String temp = aux.get(min_idx);
            aux.set(min_idx,aux.get(i));
            aux.set(i,temp);
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