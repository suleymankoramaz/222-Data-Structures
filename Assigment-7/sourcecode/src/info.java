package src;
import java.util.ArrayList;

/**
 * The "info" class is a data structure that stores a count and a list of words, with methods to add
 * and remove words.
 */
public class info 
{

	int count;
	ArrayList<String> words = new ArrayList<String>();

	// This is a constructor for the `info` class that takes in an integer `count` and an `ArrayList` of
	// strings `words` as parameters. It initializes the `count` and `words` instance variables of the
	// `info` object with the values passed in as parameters. The `this` keyword is used to refer to the
	// instance variables of the object being created.
	public info(int count, ArrayList<String> words) 
	{
		this.count = count;
		this.words = words;
	}
	
	/**
	 * This function adds a string to a list and increments a count variable.
	 * 
	 * @param word The parameter "word" is a String type variable that represents the word to be added to
	 * a stack data structure. The method "push" adds the word to the top of the stack and increments the
	 * count of elements in the stack.
	 */
	public void push(String word) 
	{
		this.count++;
		this.words.add(word);
	}
	
	
	/**
	 * The function removes a given word from a list of words and increments a count if the word is found,
	 * otherwise it prints a message indicating that the word is not found.
	 * 
	 * @param word The parameter "word" is a String variable that represents the word to be removed from
	 * the list of words.
	 */
	public void pop(String word) 
	{
		if (this.words.contains(word)) 
		{
			this.words.remove(word);
			this.count++;
		}
		else
			System.out.println("'" + word + "' is not found.");
	}
}
