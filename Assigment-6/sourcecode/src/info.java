// `package src;` is declaring the package name for the Java file. In this case, the package name is
// "src". This is used to organize related classes and interfaces into a single unit, and to avoid
// naming conflicts between classes with the same name in different packages.
package src;

import java.util.Arrays;

/**
 * The "info" class is a Java class that contains methods for setting and getting a count and an array
 * of words, as well as a push method for adding new words to the array.
 */
public class info
{
    //VARIABLES
    private int count;
    private String [] words;
    
    //CONSTRUCTOR
    // This is a constructor method for the `info` class that takes no arguments. It initializes the
    // `count` variable to 0. The `protected` keyword means that this method can only be accessed
    // within the same package or by subclasses of the `info` class.
    protected info()
    {
        count = 0;
    }
    // This is a constructor method for the `info` class that takes two arguments: an integer
    // `countValue` and a String array `wordsValue`. It initializes the `count` variable to the value
    // of `countValue` and the `words` variable to the value of `wordsValue`. The `protected` keyword
    // means that this method can only be accessed within the same package or by subclasses of the
    // `info` class.
    protected info(int countValue, String[] wordsValue)
    {
        count = countValue;
        words = wordsValue;
    }

    //GETTERS
    /**
     * The function returns the value of the variable "count".
     * 
     * @return The method `getCount()` is returning an integer value which is the value of the variable
     * `count`.
     */
    protected int getCount()
    {
        return count;
    }
    /**
     * The function returns an array of strings called "words".
     * 
     * @return An array of strings called "words".
     */
    protected String[] getWords()
    {
        return words;
    }

    //SETTERS
    /**
     * This is a Java function that sets the value of a variable called "count" to a new integer value
     * passed as a parameter.
     * 
     * @param newCount newCount is an integer parameter that represents the new value to be assigned to
     * the variable "count". The method "setCount" is used to update the value of "count" with the new
     * value passed as an argument.
     */
    protected void setCount(int newCount)
    {
        count = newCount;
    }
    /**
     * This function adds a new string to an array of strings, either by creating a new array with the
     * new string or by copying the existing array and adding the new string to the end.
     * 
     * @param newWord A String variable representing the new word to be added to the words array.
     */
    protected void setWords(String newWord)
    {
        if(words == null) 
        {
            words = new String[1];
            words[0] = newWord;
        } 
        else
        {
            String[] newArray = new String[words.length + 1];
            System.arraycopy(words, 0, newArray, 0, words.length);
            newArray[words.length] = newWord;
            words = newArray;
        }
    }

    //PUSH METHOD
    /**
     * This function adds a new word to a list and increments a count variable.
     * 
     * @param word A string representing a word that needs to be added to a data structure (such as a
     * stack or a queue) for further processing.
     */
    protected void push(String word) 
    {
        setWords(word);
        setCount(count+1);
    }
}