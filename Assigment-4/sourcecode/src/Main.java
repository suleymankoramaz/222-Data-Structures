// `package src;` is declaring the package name for the Java class `Main`. This means that the `Main`
// class is part of the `src` package. Packages are used to organize related classes and provide a
// namespace to avoid naming conflicts.
package src;


/**
 * The Main class contains a main method that tests various inputs for a Test class.
 */
public class Main
{
    public static void main(String[] args) 
    {
        String testUsername_1  = "suleyman";      //correct username
        String testUsername_2  = "";              //minimum length error
        String testUsername_3  = "suleyman1";     //contains character that is not letter

        String testPassword1_1 = "{r(r[car]a)c}"; //correct password1   
        String testPassword1_2 = "{xacxcss";      //minimum brackets error
        String testPassword1_3 = "[{s}]";         //minimum length error
        String testPassword1_4 = "{r(r[car)a]c}"; //not balanced
        String testPassword1_5 = "{r(r[car]x)c}"; //not palidrome
        String testPassword1_6 = "{r(r[cr])c}";   //correct password1

        int    testPassword2_1 = 21;    //valid
        int    testPassword2_2 = 36;    //valid
        int    testPassword2_3 = 35;    //not valid
        int    testPassword2_4 = 95;    //valid 
        int    testPassword2_5 = 10001; //not valid
        
        Test testObj = new Test();

        //correct input
        System.out.println("\nTest 1:");
        System.out.println("Input: " + "username: '" + testUsername_1 + "' password1: '" + testPassword1_1 + "' password2: '" + testPassword2_4 + "'");
        testObj.testGivenInput(testUsername_1,testPassword1_1,testPassword2_4);

        //testing username
        System.out.println("\nTest 2:");
        System.out.println("Input: " + "username: '" + testUsername_2 + "' password1: '" + testPassword1_1 + "' password2: '" + testPassword2_4 + "'");
        testObj.testGivenInput(testUsername_2,testPassword1_1,testPassword2_4);
        System.out.println("\nTest 3:");
        System.out.println("Input: " + "username: '" + testUsername_3 + "' password1: '" + testPassword1_1 + "' password2: '" + testPassword2_4 + "'");
        testObj.testGivenInput(testUsername_3,testPassword1_1,testPassword2_4);
        System.out.println("\nTest 4:");
        System.out.println("Input: " + "username: '" + testUsername_1 + "' password1: '" + testPassword1_6 + "' password2: '" + testPassword2_1 + "'");
        testObj.testGivenInput(testUsername_1,testPassword1_6,testPassword2_1);

        //testing password1
        System.out.println("\nTest 5:");
        System.out.println("Input: " + "username: '" + testUsername_1 + "' password1: '" + testPassword1_2 + "' password2: '" + testPassword2_1 + "'");
        testObj.testGivenInput(testUsername_1,testPassword1_2,testPassword2_1);
        System.out.println("\nTest 6:");
        System.out.println("Input: " + "username: '" + testUsername_1 + "' password1: '" + testPassword1_3 + "' password2: '" + testPassword2_1 + "'");
        testObj.testGivenInput(testUsername_1,testPassword1_3,testPassword2_1);
        System.out.println("\nTest 7:");
        System.out.println("Input: " + "username: '" + testUsername_1 + "' password1: '" + testPassword1_4 + "' password2: '" + testPassword2_1 + "'");
        testObj.testGivenInput(testUsername_1,testPassword1_4,testPassword2_1);
        System.out.println("\nTest 8:");
        System.out.println("Input: " + "username: '" + testUsername_1 + "' password1: '" + testPassword1_5 + "' password2: '" + testPassword2_1 + "'");
        testObj.testGivenInput(testUsername_1,testPassword1_5,testPassword2_1);

        //testing password2
        System.out.println("\nTest 9:");
        System.out.println("Input: " + "username: '" + testUsername_1 + "' password1: '" + testPassword1_1 + "' password2: '" + testPassword2_3 + "'");
        testObj.testGivenInput(testUsername_1,testPassword1_1,testPassword2_3);
        System.out.println("\nTest 10:");
        System.out.println("Input: " + "username: '" + testUsername_1 + "' password1: '" + testPassword1_1 + "' password2: '" + testPassword2_5 + "'");
        testObj.testGivenInput(testUsername_1,testPassword1_1,testPassword2_5);
        
        System.out.println();
    }
}