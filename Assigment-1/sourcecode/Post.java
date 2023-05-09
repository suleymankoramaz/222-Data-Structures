// A package declaration. It tells the compiler that the class is part of the homework1 package.
package homework1;
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
    private Like[] likes;
    /** The array for the comments of the post*/
    private Comment[] comments;

    // A constructor that initializes the postID, accountID, content, likes, and comments of a post.
    public Post(int postID, int accountID, String content){
        this.postID    = postID;
        this.accountID = accountID;
        this.content   = content;
        this.likes = new Like[0];
        this.comments = new Comment[0];
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
    public Like[] getLikes(){
        return likes;
    }
    /**
     * This function returns an array of Comment objects.
     * 
     * @return An array of comments.
     */
    public Comment[] getComments(){
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
    public void setLikes(Like like, int process){
        if(process == 0){//add
            int like_check = 0;
            for(int i=0; i<likes.length; i++){
                if(likes[i].getInteractionID() == like.getInteractionID())
                    like_check++;
            }
            if(like_check == 0){
                int length = likes.length;
                Like[] newArray = new Like[length+1];
                for(int i=0; i<length; i++){
                    newArray[i] = likes[i];
                } 
                newArray[length] = like;
                likes = newArray;
            }
        }
        else if(process == 1){//remove
            Like[] newArray = new Like[likes.length-1];
            int j = 0;
            for(int i=0; i<likes.length-1; i++){
                if(likes[j].getInteractionID() != like.getInteractionID()){
                    newArray[j] = likes[i];
                    j++;
                } 
            }
            likes = newArray;
        }
    }
    /**
     * This function is used to add or remove comments from the comments array
     * 
     * @param comment the comment object that is being added or removed
     * @param process 0 = add, 1 = remove
     */
    public void setComments(Comment comment, int process){
        if(process == 0){//add
            int comment_check = 0;
            for(int i=0; i<comments.length; i++){
                if(comments[i].getInteractionID() == comment.getInteractionID())
                    comment_check++;
            }
            if(comment_check == 0){
                int length = comments.length;
                Comment[] newArray = new Comment[length+1];
                for(int i=0; i<length; i++){
                    newArray[i] = comments[i];
                } 
                newArray[length] = comment;
                comments = newArray;
            }
        }
        else if(process == 1){//remove
            Comment[] newArray = new Comment[comments.length-1];
            int j = 0;
            for(int i=0; i<comments.length-1; i++){
                if(comments[j].getInteractionID() != comment.getInteractionID()){
                    newArray[j] = comments[i];
                    j++;
                } 
            }
            comments = newArray;
        }
    }
}