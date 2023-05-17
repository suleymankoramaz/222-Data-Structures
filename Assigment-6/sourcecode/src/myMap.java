// `package src;` is declaring the package name for the Java file. In this case, the package name is
// "src". This is used to organize related classes and interfaces into a single unit, and to avoid
// naming conflicts between classes with the same name in different packages.
package src;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Arrays;

/**
 * The class myMap is a Java implementation of a map that stores information about the frequency of
 * letters in a given string and the words that contain those letters.
 */
public class myMap
{
    //VARIABLES
    private LinkedHashMap<String,info> map;
    private String str;
    private int mapSize;

    //CONSTRUCTOR
    // This is a constructor for the `myMap` class that takes a `String` parameter `strValue`. It sets
    // the `str` variable of the `myMap` object to the value of `strValue` and initializes the `map`
    // variable as a new `LinkedHashMap` object with `String` keys and `info` values. The `protected`
    // access modifier means that this constructor can only be accessed within the same package or by
    // subclasses of the `myMap` class.
    protected myMap(String strValue)
    {
        str = strValue;
        map = new LinkedHashMap<String,info>();
    }
    // This is a constructor for the `myMap` class that takes three parameters: a
    // `LinkedHashMap<String,info>` object `mapValue`, a `String` object `strValue`, and an `int`
    // object `mapSizeValue`. It sets the `map`, `str`, and `mapSize` variables of the `myMap` object
    // to the values of `mapValue`, `strValue`, and `mapSizeValue`, respectively. The `protected`
    // access modifier means that this constructor can only be accessed within the same package or by
    // subclasses of the `myMap` class.
    protected myMap(LinkedHashMap<String,info> mapValue, String strValue, int mapSizeValue)
    {
        map = mapValue;
        str = strValue;
        mapSize = mapSizeValue;
    }

    //GETTERS
    /**
     * The function returns a LinkedHashMap object containing key-value pairs of type String and info.
     * 
     * @return A LinkedHashMap with String keys and values of type "info".
     */
    protected LinkedHashMap<String,info> getMap()
    {
        return map;
    }
    /**
     * The function returns a string value.
     * 
     * @return The method is returning a String variable named "str".
     */
    protected String getStr()
    {
        return str;
    }
    /**
     * The function returns the size of a map.
     * 
     * @return The method is returning an integer value which represents the size of the map.
     */
    protected int getMapSize()
    {
        return mapSize;
    }

    //SETTERS
    /**
     * This is a Java function that sets the value of a LinkedHashMap variable called "map" to a new
     * value passed as a parameter.
     * 
     * @param newValue newValue is a LinkedHashMap object that contains String keys and info values.
     * This parameter is used to set the value of the map instance variable to a new LinkedHashMap
     * object.
     */
    protected void setMap(LinkedHashMap<String,info> newValue)
    {
        map = newValue;
    }
    /**
     * This is a Java function that sets the value of a string variable called "str" to a new value
     * passed as a parameter.
     * 
     * @param newValue newValue is a parameter of type String that represents the new value that will
     * be assigned to the instance variable "str". The method "setStr" is used to set the value of
     * "str" to the new value passed as an argument.
     */
    protected void setStr(String newValue)
    {
        str = newValue;
    }
    /**
     * This is a Java function that sets the value of a variable called "mapSize" to a new integer
     * value.
     * 
     * @param newValue newValue is a parameter of type int that represents the new value to be assigned
     * to the variable mapSize.
     */
    protected void setMapSize(int newValue)
    {
        mapSize = newValue;
    }

    /**
     * This function builds a map of characters as keys and a list of words containing that character
     * as values.
     */
    protected void buildMap()
    {
        String[] wordArray = getStr().split(" ");
        for(String word : wordArray)
        {
            for(int i=0 ; i<word.length() ; i++)
            {
                String key = Character.toString(word.charAt(i));
                if(!getMap().containsKey(key))
                {
                    info newInfo = new info();
                    newInfo.push(word);
                    LinkedHashMap<String, info> newMap = cloneMap();
                    getMap().clear();
                    getMap().putAll(newMap);
                    getMap().put(key, newInfo);    
                }
                else
                {
                    info newInfo = getMap().get(key);
                    newInfo.push(word);
                    getMap().put(key, newInfo);
                }
            }
        }
        setMapSize(getMap().size());
    }

    /**
     * This function clones a LinkedHashMap with values of type "info".
     * 
     * @return The method `cloneMap()` is returning a new `LinkedHashMap` object that is a clone of the
     * original map, with the same keys and values.
     */
    protected LinkedHashMap<String, info> cloneMap() 
    {
        LinkedHashMap<String, info> clonedMap = new LinkedHashMap<>();

        for(String key : getMap().keySet()) 
        {
            info originalValue = getMap().get(key);
            info clonedValue = new info(originalValue.getCount(), originalValue.getWords());
            clonedMap.put(key, clonedValue);
        }

        return clonedMap;
    }

    
    /**
     * This overrided function returns a string representation of a map containing letter counts and associated
     * words.
     * 
     * @return A string representation of the object, which includes information about the count and
     * words associated with each letter in the map.
     */
    public String toString()
    {
        String rtn = "";
        for(String key : getMap().keySet()) 
        {
            info info = getMap().get(key);
            rtn = rtn + "Letter: " + key + " - Count: " + info.getCount();
            rtn = rtn + " - Words: [" + String.join(", ", info.getWords()) + "]\n";
        }
        return rtn;
    }

}