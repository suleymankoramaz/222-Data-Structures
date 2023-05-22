package src;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * The MergeSort class implements the merge sort algorithm to sort a map of letters and their
 * corresponding word counts.
 */
public class MergeSort 
{
	myMap originalMap;
	myMap sortedMap;
	List<String> aux;


	// This is the constructor of the MergeSort class. It takes a myMap object called originalMap as a
	// parameter and initializes the originalMap, aux, and sortedMap variables of the class. The aux
	// variable is initialized as a new ArrayList containing the keys of the originalMap, and the
	// sortedMap is initialized as a new empty myMap object.
	public MergeSort(myMap originalMap) 
	{
		super();
		this.originalMap = originalMap;
		this.aux = new ArrayList<String>(this.originalMap.map.keySet());
		this.sortedMap = new myMap();
	}

	/**
	 * This is a recursive helper function for sorting an array using the merge sort algorithm.
	 * 
	 * @param l The index of the leftmost element in the array or subarray being sorted.
	 * @param r r is an integer parameter representing the index of the rightmost element in the array or
	 * subarray being sorted.
	 */
	private void sortHelper(int l, int r) 
	{
		if (l < r) 
		{
	        int m = l + (r - l) / 2;
	        sortHelper(l, m);
	        sortHelper(m + 1, r);
	        merge(l, m, r);
		}
	    
	}
	
	/**
	 * This function merges two sorted arrays of integers and strings into a single sorted array.
	 * 
	 * @param l The starting index of the left subarray to be merged.
	 * @param m The middle index of the array being sorted. It is used to divide the array into two
	 * subarrays for merging.
	 * @param r The index of the rightmost element in the array or sublist being sorted.
	 */
	public void merge(int l, int m, int r)
	{
		int n1 = m - l + 1;
	    int n2 = r - m;

	    int L[] = new int[n1];
	    String Left[] = new String[n1];
	    int R[] = new int[n2];
	    String Right[] = new String[n2];

	    for(int i = 0; i < n1; ++i) 
		{
	       L[i] = originalMap.map.get(((List<String>) this.aux).get(l + i)).count;
	       Left[i] = this.aux.get(l + i);
	    }
	    for(int j = 0; j < n2; ++j) 
		{
	    	R[j] = originalMap.map.get(((List<String>) this.aux).get(m + 1 + j)).count;
	    	Right[j] = this.aux.get(m + 1 + j);
	    }

	 
	    int i = 0, j = 0;
	    int k = l;
	    while(i < n1 && j < n2) 
		{
	    	if(L[i] <= R[j]) 
			{
	    		aux.set(k, Left[i]);
	    		i++; 	    		
	        }
	    	
	        else 
			{
	    		aux.set(k, Right[j]);
	        	j++;
	        }
	    	
	    	k++;
	    }
	 
	    while(i < n1) 
		{
    		aux.set(k, Left[i]);
	    	i++;
	    	k++;
	    }
	 
	    while(j < n2) 
		{
    		aux.set(k, Right[j]);
	    	j++;
	        k++;
	    }
	}
	
	/**
	 * This function generates a new map by assigning words to keys in the sortedMap based on the
	 * originalMap and aux list.
	 */
	private void generateNewMap() 
	{
		for (int i = 0; i < aux.size(); i++)
			this.sortedMap.assign(aux.get(i), this.originalMap.map.get(aux.get(i)).words);
	}
	 
	/**
	 * This function sorts the elements in the originalMap object and generates a new map.
	 */
	public void sort()
	{		
	    sortHelper (0, this.originalMap.mapSize - 1);
	    generateNewMap();
	}
	
	/**
     * This Java function prints a sorted array of letters, their count, and associated words.
     */
	public void printSortedArray()
	{
	    for (Map.Entry<String, info> e : sortedMap.map.entrySet())
            System.out.println("Letter: " + e.getKey() + " - Count: "
                               + e.getValue().count + " - Words: " + e.getValue().words);
	}

	/**
     * This Java function prints the original array with information about the count and words associated
     * with each letter.
     */
	public void printOriginalArray()
	{
	    for (Map.Entry<String, info> e : originalMap.map.entrySet())
            System.out.println("Letter: " + e.getKey() + " - Count: "
                               + e.getValue().count + " - Words: " + e.getValue().words);
	}
}