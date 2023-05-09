// A package declaration. It tells the compiler that the class is part of the LinkedList package.
package LList;
import java.util.LinkedList;
/**
 * The Post class is a class that contains the postID, accountID, content, likes, and comments of a
 * post
 */
public class Post{

    /** The ID of the post*/
    private int    postID;
    /** The ID of the post owner*/
    private int    accountID;
    /** The content of the post*/
    private String content;

    /** The array for the likes of the post*/
    private LinkedList<Like> likes;
    /** The array for the comments of the post*/
    private LinkedList<Comment> comments;

    // A constructor that initializes the postID, accountID, content, likes, and comments of a post.
    public Post(int postID, int accountID, String content){
        this.postID    = postID;
        this.accountID = accountID;
        this.content   = content;
        this.likes = new LinkedList<Like>();
        this.comments = new LinkedList<Comment>();
    }

    
    /**
     * This function returns the postID of the post
     * 
     * @return The postID
     */
    public int    getPostID(){
        return postID;
    }
    /**
     * This function returns the accountID of the account
     * 
     * @return The accountID
     */
    public int    getAccountID(){
        return accountID;
    }
    /**
     * This function returns the content of the message
     * 
     * @return The content of the message.
     */
    public String getContent(){
        return content;
    }
    /**
     * This function returns an array of Like objects.
     * 
     * @return An array of Like objects.
     */
    public LinkedList<Like> getLikes(){
        return likes;
    }
    /**
     * This function returns an array of Comment objects.
     * 
     * @return An array of comments.
     */
    public LinkedList<Comment> getComments(){
        return comments;
    }

    
    /**
     * This function sets the postID variable to the value of the newPostID variable.
     * 
     * @param newPostID The new post ID to set.
     */
    public void setPostID(int newPostID){
        postID = newPostID;
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
     * This function sets the content of the current object to the value of the parameter newContent.
     * 
     * @param newContent The new content of the message.
     */
    public void setContent(String newContent){
        content = newContent;
    }
    /**
     * This function is used to add or remove a like from the likes array
     * 
     * @param like the like object that is being added or removed
     * @param process 0 for adding a like, 1 for removing a like
     */
    public void setLikes(Like like, int process, int index){
        if(process == 0){//add
            likes.add(like);
        }
        else if(process == 1){//remove
            System.out.println("\nLIKE REMOVE GIRDI\n");
            likes.remove(index);
        }
    }
    /**
     * This function is used to add or remove comments from the comments array
     * 
     * @param comment the comment object that is being added or removed
     * @param process 0 = add, 1 = remove
     */
    public void setComments(Comment comment, int process , int index){
        if(process == 0){//add
            comments.add(comment);
        }
        else if(process == 1){//remove
            System.out.println("\nCOMMENT REMOVE GIRDI\n");
            comments.remove(index);
        }
    }
}