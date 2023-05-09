// `package src;` is declaring that the class `Password2` belongs to the `src` package. This is used
// for organizing and grouping related classes together.
package src;


/**
 * The Password2 class contains methods to check if a given integer can be divided exactly by a set of
 * denominations and to check if the integer is within a certain range.
 */
public class Password2
{
    /**
     * The function checks if a given integer can be exactly divided by a set of denominations.
     * 
     * @param password2 an integer representing the amount of money that needs to be divided exactly
     * using the given denominations.
     * @param denominations an array of integers representing the available denominations of currency
     * that can be used to make change for a given amount.
     * @return The method is returning a boolean value indicating whether the given password2 can be
     * exactly divided by the denominations array.
     */
    protected boolean isExactDivision(int password2, int[] denominations)
    {
        if (password2 == 0) {
            return true;
        }
        
        if (denominations.length ==  0 || password2 < 0) {
            return false;
        }

        return isExactDivision(password2 - denominations[0], denominations) || isExactDivision(password2, removeFirstElement(denominations));
    }

    /**
     * The function removes the first element of an integer array and returns a new array with the
     * remaining elements.
     * 
     * @param arr an integer array that contains the elements to be modified.
     * @return The method is returning a new integer array that has all the elements of the input array
     * except for the first element.
     */
    protected int[] removeFirstElement(int[] arr) 
    {
        int newArr[] = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            newArr[i-1] = arr[i];
        }
        return newArr;
    }

    /**
     * This function checks if a given password size is between 10 and 10000 and returns true if it is,
     * otherwise it prints an error message and returns false.
     * 
     * @param password2 an integer representing the password length that needs to be checked.
     * @return If the password2 is between 10 and 10000, the method will return true. If the password2
     * is not within that range, the method will print an error message and return false.
     */
    protected boolean checkSize(int password2)
    {
        if(password2 > 10 && password2 < 10000)
            return true;
        System.out.println("The password2 is invalid due to (password2 must be between 10 and 10000).Try again...");
            return false;
    }
}