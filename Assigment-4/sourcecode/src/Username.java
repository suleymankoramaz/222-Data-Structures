// `package src;` is declaring the package name for the `Username` class. This means that the
// `Username` class belongs to the `src` package.
package src;
// `import java.util.Stack;` is importing the `Stack` class from the `java.util` package. This allows
// the `Username` class to use the `Stack` class without having to fully qualify it with its package
// name every time it is used.
import java.util.Stack;

/**
 * The Username class checks if a given username is valid and if it is contained in a given password.
 */
public class Username
{
    // Declaring an instance variable `usernameStack` of type `Stack<Character>`. This variable will be
    // used to store the characters of a given username in a stack data structure.
    private Stack<Character> usernameStack;

    // This is a constructor method for the `Username` class. It initializes a new instance of the
    // `Stack` class and assigns it to the `usernameStack` instance variable. This means that every
    // time a new `Username` object is created, its `usernameStack` variable will be initialized with a
    // new empty stack.
    protected Username()
    {
        usernameStack = new Stack<Character>();
    }

    /**
     * The recursive function checks if a given username is valid based on its length and if it contains only
     * letters.
     * 
     * @param username A string representing the username that needs to be checked for validity.
     * @return The method is returning a boolean value, either true or false, depending on whether the
     * input username is valid or not.
     */
    protected boolean checkIfValidUsername(String username)
    {
        if(username.length() == 0){
            System.out.println("The username is invalid due to (minimum length of the username must be 1).Try again...");
            return false;
        }
        else{
            if(!((username.charAt(0)>64 && username.charAt(0)<91) || (username.charAt(0)>96 && username.charAt(0)<122))){
                System.out.println("The username is invalid due to (the username must contains only letters).Try again...");
                return false;
            }
            else{
                if(username.length() == 1)
                    return true;
                else
                    return checkIfValidUsername(username.substring(1));
            }
        }
    }

    /**
     * This function checks if a given password contains at least one letter from a given username by
     * filling a stack with the username and then checking if each letter is present in the password.
     * 
     * @param username The username is a String variable that represents the username entered by the
     * user.
     * @param password1 The password that needs to be checked for containing at least one letter from
     * the username.
     * @return The method is returning a boolean value, which indicates whether the given password
     * contains at least one letter from the given username.
     */
    protected boolean containsUserNameSpirit(String username, String password1)
    {   
        fillStack(username);
        boolean check = false;
        
        while(!usernameStack.isEmpty()){
            if(password1.indexOf(usernameStack.pop()) > -1)
                check = true;
        }
        if(!check)
            System.out.println("The username is invalid due to (passowrd1 must contains at least one of the letter of the username).Try again...");
        return check;
    }

    /**
     * The function fills a stack with each character of a given string.
     * 
     * @param username The parameter "username" is a String variable that represents the username of a
     * user.
     */
    protected void fillStack(String username)
    {
        for(int i=0 ; i<username.length() ; i++)
            usernameStack.push(username.charAt(i));
    }
}