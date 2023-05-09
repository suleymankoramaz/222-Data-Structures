// A package declaration. It declares a package named homework1.
package homework1;
/**
 * Like is a subclass of Interaction, and it has a constructor that takes in an interactionID, an
 * accountID, and a postID.
 */
public class Like extends Interaction{
    
    // A constructor that takes in an interactionID, an accountID, and a postID.
    public Like(int interactionID,int accountID, int postID){
        super(interactionID,accountID,postID);
    }
}