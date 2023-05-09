// `package src;` is declaring the package name for the `Password1` class. This means that the
// `Password1` class belongs to the `src` package.
package src;
// `import java.util.Stack;` is importing the `Stack` class from the `java.util` package. This allows
// the `Password1` class to use the `Stack` data structure in its implementation.
import java.util.Stack;

/**
 * The Password1 class contains methods for checking if a password is balanced, a palindrome, has a
 * minimum length of 8, and contains at least 2 brackets.
 */
public class Password1
{
    // `private Stack<Character> password1Stack;` is declaring a private instance variable
    // `password1Stack` of type `Stack<Character>`. This variable is used in the `isBalancedPassword`
    // method to store opening brackets encountered in the password string, so that they can be matched
    // with closing brackets later on.
    private Stack<Character> password1Stack;

    // This is a constructor method for the `Password1` class. It initializes the private instance
    // variable `password1Stack` as a new instance of the `Stack<Character>` class. This allows the
    // `password1Stack` variable to be used in other methods of the `Password1` class.
    protected Password1()
    {
        password1Stack = new Stack<Character>();
    }

    /**
     * This function checks if a given password has balanced parentheses, brackets, and braces.
     * 
     * @param password1 The parameter "password1" is a String variable representing a password that
     * needs to be checked for balanced parentheses. The method checks if the password has balanced
     * parentheses (i.e., each opening parenthesis has a corresponding closing parenthesis) using a
     * stack data structure. If the password has balanced parentheses, the method returns
     * @return The method is returning a boolean value. It returns true if the input string password1
     * is balanced (i.e., all opening parentheses have a corresponding closing parentheses in the
     * correct order), and false otherwise.
     */
    protected boolean isBalancedPassword(String password1)
    {
        String openPrnths  = "([{";
        String closePrnths = ")]}";
        boolean balanced = true;
        
        int index = 0;
        while(balanced && index < password1.length()){
            char nextCh = password1.charAt(index);
            if(openPrnths.indexOf(nextCh) > -1){
                password1Stack.push(nextCh);
            }
            else if (closePrnths.indexOf(nextCh) > -1){
                if(password1Stack.isEmpty()){
                    System.out.println("An error occured while using pop() method...");
                    return false;
                }
                char topCh = password1Stack.pop();
                balanced =  openPrnths.indexOf(topCh) == closePrnths.indexOf(nextCh);
            }
           index++;
        }
        if((balanced && password1Stack.empty()))
            return true;
        System.out.println("The password1 is invalid due to (password1 is not balanced).Try again...");
        return false;
    }

    /**
     * This function checks if a given string is a palindrome after removing any parentheses and 
     * it is palindrome or it can be with swapping letters.
     * 
     * @param password1 The input string that is being checked for palindrome.
     * @return The method isPalindrome returns a boolean value, which is true if the input string is a
     * palindrome (reads the same forwards and backwards) and false otherwise.
     */
    protected boolean isPalindrome(String password1) 
    {  
        {  
            if (password1.length() == 0 || password1.length() == 1)
                return true;
    
            password1 = removeParentheses(password1);
            StringBuilder sb;
            boolean check = false;
            for(int i=1 ; i<password1.length() ; i++){
                if(password1.charAt(0) == password1.charAt(i)){
                    sb = new StringBuilder(password1);
                    sb.deleteCharAt(i);
                    password1 = sb.toString();
                    check = true;
                    break;
                }
            }
    
            if(check){
                return isPalindrome(password1.substring(1));
            }
            else{
                check = false;
                for(int i=2 ; i<password1.length(); i++){
                    if(password1.charAt(1) == password1.charAt(i)){
                        sb = new StringBuilder(password1);
                        sb.deleteCharAt(i);
                        sb.deleteCharAt(1);
                        password1 = sb.toString();
                        check = true;
                        break;
                    }
                }
                if(check)
                    return isPalindrome(password1);
                else
                    return false;
            }
        }
    }

    /**
     * The function removes all parentheses and brackets from a given string.
     * 
     * @param s The input string from which parentheses are to be removed.
     * @return The method is returning a string that is the input string with all parentheses (round,
     * curly, and square brackets) removed.
     */
    protected String removeParentheses(String s)
    {
        String result = "";
        for(int i=0 ; i<s.length() ; i++){
            if(!(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ||
                 s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']'))
                    result += s.charAt(i);
        }
        return result;
    }

    /**
     * This function checks if a given password has a minimum length of 8 characters and returns true
     * if it does, and false otherwise.
     * 
     * @param password1 The parameter "password1" is a String variable representing the password that
     * needs to be checked for length.
     * @return The method is returning a boolean value. If the length of the password1 is less than 8,
     * it will return false. Otherwise, it will return true.
     */
    protected boolean controlLength(String password1)
    {
        if(password1.length() < 8){
            System.out.println("The password1 is invalid due to (the minimum length of the password1 must be 8).Try again...");
            return false;
        }
        return true;
    }

    /**
     * This function checks if a given password contains at least two brackets.
     * 
     * @param password1 a String variable representing a password that needs to be checked for the
     * presence of at least 2 brackets (either round, square or curly). The method returns a boolean
     * value indicating whether the password is valid or not based on this criterion.
     * @return The method is returning a boolean value.
     */
    protected boolean controlBrackets(String password1)
    {
        int count = 0;

        for(int i=0 ; i<password1.length() ; i++){
            if(password1.charAt(i) == '(' || password1.charAt(i) == '[' || password1.charAt(i) == '{' ||
               password1.charAt(i) == ')' || password1.charAt(i) == ']' || password1.charAt(i) == '}'){
                    count++;    
            }
        }

        if(count<2){
            System.out.println("The password1 is invalid due to (password1 must contain at least 2 brackets).Try again...");
            return false;
        }

        return true;
    }
}