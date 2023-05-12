// `package src;` is declaring the package name for the Java file. In this case, the package name is
// "src". This is used to organize related classes and interfaces into a single unit, and to avoid
// naming conflicts between classes with the same name in different packages.
package src;

import java.util.Scanner;
import java.util.LinkedHashMap;

/**
 * The Main class takes user input, preprocesses the input string, builds a map, sorts the map using
 * merge sort, and prints the original and sorted maps.
 */
public class Main
{
    /**
     * The function takes user input, preprocesses the input string, builds a map, sorts the map using
     * merge sort, and prints the original and sorted maps.
     */
    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);   
        System.out.print("\nEnter a string: ");  
        String str= sc.nextLine();     
        
        System.out.println("\nOriginal String:     " + str);
        str = fixString(str);
        System.out.println("Preprocessed String: " + str);
        System.out.print("\n\n");

        myMap map = new myMap(str);
        map.buildMap();
        mergeSort mrgSort = new mergeSort(map);
        mrgSort.mergeSort();

        System.out.println("The original (unsorted) map:");
        mrgSort.getOriginalMap().printMap();
        System.out.print("\n\n");

        System.out.println("The sorted map");
        mrgSort.getSortedMap().printMap();
        System.out.print("\n\n");
    }

    /**
     * The function takes a string input, converts it to lowercase and removes all non-alphabetic
     * characters and returns the processed string.
     * 
     * @param input A string that needs to be processed and fixed.
     * @return The method `fixString` returns a processed string with all non-alphabetic characters
     * removed and all alphabetic characters converted to lowercase.
     */
    public static String fixString(String input) 
    {
        //make uppercase letters to lowercase letters
        String lowercaseString = input.toLowerCase();

        //remove non-letter characters
        String processedString = lowercaseString.replaceAll("[^a-z\\s]", "");
        return processedString;
    }
}