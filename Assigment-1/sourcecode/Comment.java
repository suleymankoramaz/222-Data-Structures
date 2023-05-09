// A package declaration. It is used to create a new package.
package homework1;
/**
 * This class is a subclass of Interaction. It has a constructor that calls the constructor of the
 * superclass Interaction. It has a getter method for the content of the comment
 */
public class Comment extends Interaction{
    
    /** The content of the Comment */
    private String content;

    // This is a constructor for the Comment class. It is calling the constructor of the superclass
    // Interaction.
    public Comment(int interactionID,int accountID, int postID,String content){
        super(interactionID,accountID,postID);
        this.content       = content;
    }

    /**
     * This function returns the content of the message
     * 
     * @return The content of the message.
     */
    public String getContent(){
        return content;
    }
}