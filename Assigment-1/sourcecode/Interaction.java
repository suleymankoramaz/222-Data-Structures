// A package declaration. It tells the compiler that the class is part of the homework1 package.
package homework1;
/**
 * Interaction is a class that represents an interaction between an account and a post
 */
public class Interaction{

    /** The ID of the interaction*/
    private int interactionID;
    /** The ID of the owner of the interaction*/
    private int accountID;
    /** The ID of the post of the interaction*/
    private int postID;

    // A constructor. It is a special method that is called when an object is created.
    public Interaction(int interactionID, int accountID, int postID){
        this.interactionID = interactionID;
        this.accountID = accountID;
        this.postID = postID;
    }

    /**
     * This function returns the interactionID of the current interaction
     * 
     * @return The interactionID
     */
    public int getInteractionID(){
        return interactionID;
    }
    /**
     * This function returns the accountID of the account
     * 
     * @return The accountID
     */
    public int getAccountID(){
        return accountID;
    }
    /**
     * This function returns the postID of the post
     * 
     * @return The postID
     */
    public int getPostID(){
        return postID;
    }
    /**
     * This function sets the interactionID variable to the value of the newInteractionID variable.
     * 
     * @param newInteractionID The new interaction ID to set.
     */
    public void setInteractionID(int newInteractionID){
        interactionID = newInteractionID;
    }
    /**
     * This function sets the accountID variable to the value of the newAccountID variable.
     * 
     * @param newAccountID The new account ID to set the account to.
     */
    public void setAccountID(int newAccountID){
        accountID = newAccountID;
    }
    /**
     * This function sets the postID variable to the value of the newPostID variable.
     * 
     * @param newPostID The new post ID to set.
     */
    public void setPostID(int newPostID){
        postID = newPostID;
    }
}