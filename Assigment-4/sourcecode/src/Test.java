// `package src;` is declaring the package name for the Test class. This means that the Test class
// belongs to the `src` package.
package src;
/**
 * The Test class contains a method that checks the validity of a given username, password1, and
 * password2 based on certain criteria.
 */
public class Test
{
    /**
     * The function tests if a given username and passwords meet certain criteria and prints a message
     * indicating if they are valid or not.
     * 
     * @param username A string representing the username to be checked.
     * @param password1 This parameter represents a string that is supposed to be a password. The
     * method checks if the password meets certain criteria such as length, balanced brackets, and
     * being relocatable to a palindrome.
     * @param password2 An integer value representing a password.
     */
    protected void testGivenInput(String username , String password1 , int password2)
    {
        Username  u  = new Username();
        Password1 p1 = new Password1();
        Password2 p2 = new Password2();
        int denominations[] = {4,17,29};
        if( u.checkIfValidUsername(username) && u.containsUserNameSpirit(username,password1) &&
            p1.controlLength(password1) && p1.controlBrackets(password1) && p1.isBalancedPassword(password1) &&
            p2.checkSize(password2)){
                if(p1.isPalindrome(password1)){
                    if(p2.isExactDivision(password2,denominations))
                        System.out.println("The username and passwords are valid. The door is opening, please wait...");
                    else
                        System.out.println("The password2 is invalid due to (password2 must be summation of denominations).Try again...");
                }
                else
                    System.out.println("The password1 is invalid due to (password1 must be relocatable to palindrome).Try again...");
            }   
    }
}