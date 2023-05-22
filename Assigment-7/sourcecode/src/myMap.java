package src;
import java.util.LinkedHashMap;
import java.util.ArrayList;

/**
 * The class "myMap" is a Java implementation of a map data structure that stores words based on their
 * individual characters.
 */
public class myMap
 {
	LinkedHashMap <String, info> map;
	int mapSize;
	String str;
	String [] words;

	// This is a constructor for the `myMap` class. It initializes the instance variables `map`,
	// `mapSize`, `str`, and `words` to their default values. `map` is initialized as a new
	// `LinkedHashMap` object, `mapSize` is set to 0, and `str` and `words` are set to `null`.
	public myMap() 
	{
		this.map = new LinkedHashMap<String, info>();
		this.mapSize = 0;
		this.str = null;
		this.words = null;
	}
	
	/**
	 * This function appends a new word to an existing character in a map or adds a new character with the
	 * given word.
	 * 
	 * @param x The first parameter "x" is a String that represents a character or symbol that is being
	 * mapped to a list of words.
	 * @param word The string that is being added to the list of words associated with the key "x".
	 */
	public void append(String x, String word) 
	{
		if (this.map.containsKey(x)) {
			info myinfo = this.map.get(x);
			myinfo.push(word);
		}
		else
			addNewCharacter(x, word);
	}
	
	
	/**
	 * This function adds a new character to a map with an associated info object containing a count of 1
	 * and an ArrayList of words.
	 * 
	 * @param x The key to be added to the map.
	 * @param word The parameter "word" is a String that represents a word to be added to the ArrayList of
	 * words associated with a particular character.
	 */
	private void addNewCharacter(String x, String word) 
	{
		ArrayList<String> words = new ArrayList<String>();
		words.add(word);
		info myInfo = new info (1, words);
		this.map.put(x, myInfo);
		this.mapSize ++;
	}
	
	/**
	 * The function assigns a string value to a variable by adding a new character and appending the
	 * remaining characters from an ArrayList of words.
	 * 
	 * @param x The first parameter "x" is a String variable that represents the target string to which
	 * the words in the ArrayList will be assigned.
	 * @param words An ArrayList of Strings that contains the words to be assigned to the variable x.
	 */
	public void assign(String x, ArrayList<String> words) 
	{
		addNewCharacter(x, (String) words.get(0));
		for (int i = 1; i < words.size(); i++) {
			append(x, (String) words.get(i));
		}
	}
	
	/**
	 * The function builds a map by removing non-alphabetic characters from a given string, splitting it
	 * into words, and appending each letter of each word to a map with the word as its value.
	 * 
	 * @param str A string input that contains words to be used for building a map.
	 * @return The method is returning a boolean value, which indicates whether the map was successfully
	 * built or not. True is returned if the map was built successfully, and false is returned if the
	 * input was invalid and the map could not be built.
	 */
	public boolean buildMap(String str) 
	{
		boolean check = false;
		this.str = str.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
		
		for(int i=0 ; i<this.str.length() ; i++){
			if(!(this.str.charAt(i) == ' '))
				check = true;
		}
		if(!check){
			System.out.println("Invalid input.Failed to create map..\n");
			return false;
		}

		this.words = this.str.split(" ");
		for (int i = 0; i < this.words.length; i++) {
			for (int j = 0; j < this.words[i].length(); j++) {
				append(this.words[i].substring(j, j + 1), this.words[i]);
			}
		}
		return true;
	}
	
}
