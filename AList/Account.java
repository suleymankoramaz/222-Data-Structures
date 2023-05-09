// Declaring a package called ArrayList.
package AList;
import java.util.ArrayList;

/**
 * This class is used to create an account object
 */
public class Account{
    
    //-----------VARIABLES-------------//

    /** The ID of the account*/ 
    private int     accountID;
    /** The username of the account*/ 
    private String  username;
    /** The birthdate of the account*/ 
    private String  birthdate;
    /** The location of the account*/ 
    private String  location;
    /** The control variable for check whether logged in or not*/ 
    private boolean isLogin;
    /** The ID number of account which is currently shown*/ 
    private int     currentAccount;
    /** The control variable for check whether posts are shown or not*/ 
    private boolean isPostsAreShown;

    //-----------ARRAYS-------------//

    /** The ArrayList for posts of the account*/ 
    private ArrayList<Post>    posts;
    /** The ArrayList for inbox of the account*/ 
    private ArrayList<Message> inbox;
    /** The ArrayList for outbox of the account*/ 
    private ArrayList<Message> outbox;
    /** The ArrayList for following of the account*/ 
    private ArrayList<Account> following;
    /** The ArrayList for followers of the account*/ 
    private ArrayList<Account> followers;
    /** The ArrayList for blocked accounts of the account*/ 
    private ArrayList<Account> blockedAccounts;
    /** The ArrayList for history */
    private ArrayList<String>  history;
    
    //-----------CONSTRUCTORS-------------//

    // This is the constructor for the Account class. It is used to create an instance of the Account
    // class.
    public Account(String username, String birthdate, String location, int accountID){
        this.username  = username;
        this.birthdate = birthdate;
        this.location  = location;
        this.accountID = accountID;
        this.posts           = new ArrayList<Post>(0);
        this.inbox           = new ArrayList<Message>(0);
        this.outbox          = new ArrayList<Message>(0);
        this.following       = new ArrayList<Account>(0);
        this.followers       = new ArrayList<Account>(0);
        this.blockedAccounts = new ArrayList<Account>(0);
        this.history         = new ArrayList<String>(0);
    }
    
    //-----------GETTERS-------------//

    /**
     * This function returns the accountID of the account
     * 
     * @return The accountID
     */
    public int       getAccountID(){
        return accountID;
    }
    /**
     * This function returns the username of the user
     * 
     * @return The username
     */
    public String    getUsername(){
        return username;
    }
    /**
     * This function returns the birthdate of the person
     * 
     * @return The birthdate of the person.
     */
    public String    getBirthdate(){
        return birthdate;
    }
    /**
     * This function returns the location of the event
     * 
     * @return The location of the event.
     */
    public String    getLocation(){
        return location;
    }
    /**
     * This function returns the value of the variable isLogin
     * 
     * @return isLogin
     */
    public boolean   getIsLogin(){
        return isLogin;
    }
    /**
     * This function returns the current account
     * 
     * @return The current account number.
     */
    public int       getCurrentAccount(){
        return currentAccount;
    }
    /**
     * This function returns a boolean value that indicates whether the posts are shown or not
     */
    public boolean   getIsPostAreShown(){
        return isPostsAreShown;
    }
    /**
     * This function returns an ArrayList of Post objects.
     * 
     * @return An ArrayList of Post objects.
     */
    public ArrayList<Post>    getPosts(){
        return posts;
    }
    /**
     * This function returns the inbox ArrayList.
     * 
     * @return The inbox ArrayList.
     */
    public ArrayList<Message> getInbox(){
        return inbox;
    }
    /**
     * This function returns the outbox ArrayList.
     * 
     * @return The outbox ArrayList.
     */
    public ArrayList<Message> getOutbox(){
        return outbox;
    }
    /**
     * This function returns the following ArrayList.
     * 
     * @return An ArrayList of Account objects.
     */
    public ArrayList<Account> getFollowing(){
        return following;
    }
    /**
     * This function returns an ArrayList of accounts that are following the account that called this
     * function.
     * 
     * @return An ArrayList of Account objects.
     */
    public ArrayList<Account> getFollowers(){
        return followers;
    }
    /**
     * This function returns an ArrayList of blocked accounts.
     * 
     * @return An ArrayList of blocked accounts.
     */
    public ArrayList<Account> getBlockedAccounts(){
        return blockedAccounts;
    }
    /**
     * This function returns an ArrayList of history strings.
     * 
     * @return An ArrayList of strings of history.
     */
    public ArrayList<String>  getHistory(){
        return history;
    }

    //-----------SETTERS-------------//

    /**
     * This function sets the accountID variable to the value of the newAccountID variable.
     * 
     * @param newAccountID The new account ID to set the account to.
     */
    public void setAccountID(int newAccountID){
        accountID = newAccountID;
    }
    /**
     * This function sets the username to the value of the newUsername parameter.
     * 
     * @param newUsername The new username to set the username to.
     */
    public void setUsername(String newUsername){
        username = newUsername;
    }
    /**
     * This function sets the birthdate of the person to the value of the parameter newBirthdate.
     * 
     * @param newBirthdate The new birthdate of the person.
     */
    public void setBirthdate(String newBirthdate){
        birthdate = newBirthdate;
    }
    /**
     * This function sets the location of the object to the value of the parameter newLocation.
     * 
     * @param newLocation The new location of the event.
     */
    public void setLocation(String newLocation){
        location = newLocation;
    }
    /**
     * This function sets the value of the variable isLogin to the value of the variable newSituation
     * 
     * @param newSituation the new situation of the user, whether he is logged in or not.
     */
    public void setIsLogin(boolean newSituation){
        isLogin = newSituation;
    }
    /**
     * This function sets the current account to the account ID passed in as a parameter
     * 
     * @param accountID The account ID of the account you want to set as the current account.
     */
    public void setCurrentAccount(int accountID){
        currentAccount = accountID;
        setIsPostShown(false);
    }
    /**
     * This function sets the value of the boolean variable isPostsAreShown to the value of the boolean
     * variable newSituation
     * 
     * @param newSituation a boolean value that indicates whether the posts are shown or not.
     */
    public void setIsPostShown(boolean newSituation){
        isPostsAreShown = newSituation;
    }
    /**
     * This function is used to add or remove a post from the posts array
     * 
     * @param post The post object that you want to add or remove.
     * @param process 0 for adding a post, 1 for removing a post
     */
    public void setPosts(Post post, int process){
        if(process == 0){//add
            if(posts.add(post) == false)
                System.out.println("An error occured when adding post to the ArrayList.");
        }
        else if(process == 1){//remove
            if(posts.remove(post) == false)
                System.out.println("This post in not in the ArrayList.");
        }
    }
    /**
     * This function is used to add or remove a message from the inbox
     * 
     * @param message The message to be added or removed.
     * @param process 0 for adding a message, 1 for removing a message
     */
    public void setInbox(Message message, int process){
        if(process == 0){//add
            if(inbox.add(message) == false)
                System.out.println("An error occured when adding post to the ArrayList.");
        }
        else if(process == 1){//remove
            if(inbox.remove(message) == false)
                System.out.println("This post in not in the ArrayList.");
        }
    }
    /**
     * This function adds or removes a message from the outbox
     * 
     * @param message The message to be added or removed.
     * @param process 0 for add, 1 for remove
     */
    public void setOutbox(Message message, int process){
        if(process == 0){//add
            if(outbox.add(message) == false)
                System.out.println("An error occured when adding post to the ArrayList.");
        }
        else if(process == 1){//remove
            if(outbox.remove(message) == false)
                System.out.println("This post in not in the ArrayList.");
        }
    }
    /**
     * This function adds or removes an account from the following list of the current account
     * 
     * @param account The account that you want to add or remove from the following list.
     * @param process 0 for adding, 1 for removing
     */
    public void setFollowing(Account account, int process){
        if(process == 0){//add
            if(following.add(account) == false)
                System.out.println("An error occured when adding post to the ArrayList.");
        }
        else if(process == 1){//remove
            if(following.remove(account) == false)
                System.out.println("This post in not in the ArrayList.");
        }
    }
    /**
     * This function is used to add or remove an account from the followers array
     * 
     * @param account The account that is being added or removed from the followers list.
     * @param process 0 for adding, 1 for removing
     */
    public void setFollowers(Account account, int process){
        if(process == 0){//add
            if(followers.add(account) == false)
                System.out.println("An error occured when adding post to the ArrayList.");
        }
        else if(process == 1){//remove
            if(followers.remove(account) == false)
                System.out.println("This post in not in the ArrayList.");
        }
    } 
    /**
     * This function adds or removes an account from the blockedAccounts array
     * 
     * @param account The account that you want to add or remove from the blocked accounts list.
     * @param process 0 for adding, 1 for removing
     */
    public void setBlockedAccounts(Account account, int process){
        if(process == 0){//add
            if(blockedAccounts.add(account) == false)
                System.out.println("An error occured when adding post to the ArrayList.");
        }
        else if(process == 1){//remove
            if(blockedAccounts.remove(account) == false)
                System.out.println("This post in not in the ArrayList.");
        }
    }
    /**
     * This function adds or removes an activitie from the history array
     * 
     * @param activity The activity that you want to add or remove from history.
     * @param process 0 for adding, 1 for removing
     */
    public void setHistory(String activity,int process){
        if(process == 0){//add
            if(history.add(activity) == false)
                System.out.println("An error occured when adding post to the ArrayList.");
        }
        else if(process == 1){//remove
            if(history.remove(activity) == false)
                System.out.println("This post in not in the ArrayList.");
        }
    }

    //-----------METHODS-------------//
    /**
     * If the account is not logged in, and no other account is logged in, then log in the account
     * 
     * @param accounts An array of Account objects.
     */
    public void login(ArrayList<Account> accounts){
        if(!getIsLogin()){
            if(!checkAnyLogin(accounts)){
                setIsLogin(true);
                String newAction = "You logged in.";
                setHistory(newAction,0);
            }
        }
            
        else    
            System.out.println("Account already logged in.");
    }
    /**
     * This function logs out the current account
     */
    public void logout(){
        if(getIsLogin()){
            setIsLogin(false);
            setCurrentAccount(0);
            String newAction = "You logged out.";
            setHistory(newAction,0);
        }
        else
            System.out.println("Account not loged in.");
    }
    /**
     * It prints out the profile of the account that is passed as a parameter
     * 
     * @param account the account that you want to view
     */
    public void viewProfile(Account account){
        if(getIsLogin()){
            if(!isBlocked(account)){
                ArrayList<Account> following = account.getFollowing();
                ArrayList<Account> followers = account.getFollowers();
                ArrayList<Post>    posts     = account.getPosts();

                System.out.println("--------------------------");
                System.out.printf("User ID: %d\n",account.getAccountID());
                System.out.printf("Username: %s\n",account.getUsername());
                System.out.printf("Location: %s\n",account.getLocation());
                System.out.printf("Birth Date: %s\n",account.getBirthdate());
                System.out.printf("%s is following %d account(s) and has %d follower(s).\n",account.getUsername(),following.size(),followers.size());
                if(following.size() > 0){
                    System.out.printf("%s is following: ",account.getUsername());
                    for(int j=0; j<following.size(); j++)
                        System.out.printf("%s, ",following.get(j).getUsername());
                    System.out.println();
                }
                if(followers.size() > 0){
                    System.out.printf("%s's follower(s): ",account.getUsername());
                    for(int j=0; j<followers.size(); j++)
                        System.out.printf("%s, ",followers.get(j).getUsername());
                    System.out.println();
                }
                System.out.printf("%s has %d posts.\n\n",account.getUsername(),posts.size());
                setCurrentAccount(account.getAccountID());
            }
            else
                System.out.println("You do not have permission to see this profile.\n");
            
        }
        else
            System.out.println("You need to login.");
    }
    /**
     * It prints out all the posts of the account that is passed in as a parameter
     * 
     * @param account The account whose posts are to be viewed.
     */
    public void viewPosts(Account account){
        if(getCurrentAccount() == account.getAccountID()){
            ArrayList<Post> userPosts = account.getPosts();
            if(userPosts.size() > 0){
                for(int j=0; j<userPosts.size(); j++)
                    System.out.printf("(PostID: %d) %s: %s\n",userPosts.get(j).getPostID(),account.getUsername(),userPosts.get(j).getContent());
                setIsPostShown(true);
                System.out.println("");
            }
            else
                System.out.println("The user has no posts.\n");
        }
        else
            System.out.println("If you want to view posts, you need to view profile.");
    }
    /**
     * This function prints out the posts of the account passed in as a parameter, and prints out the
     * likes and comments of each post
     * 
     * @param account The account whose posts are to be viewed.
     * @param accounts an array of all the accounts in the system
     */
    public void viewInteractions(Account account, ArrayList<Account> accounts){
        if((getCurrentAccount() == account.getAccountID()) && getIsPostAreShown()){
            ArrayList<Post> userPosts = account.getPosts();
            for(int i=0; i<userPosts.size(); i++){
                
                System.out.println("---------------------------------");
                System.out.printf("(PostID: %d): %s\n",userPosts.get(i).getPostID(),userPosts.get(i).getContent());
                
                ArrayList<Like>    likes = userPosts.get(i).getLikes();
                ArrayList<Comment> comments = userPosts.get(i).getComments();

                if(likes.size() > 0){
                    System.out.printf("The post was liked by the following account(s): ");
                    String owner = "";
                    for(int j=0; j<likes.size(); j++){ 
                        for(int k=0; k<accounts.size(); k++){
                            if(accounts.get(k).getAccountID() == likes.get(j).getAccountID())
                                owner = accounts.get(k).getUsername();
                        }
                        System.out.printf("%s, ",owner);
                    }
                    System.out.println("");   
                }
                else    
                    System.out.println("The post has no likes.");

                if(comments.size() > 0){
                    System.out.printf("The post has %d comment(s)...\n",comments.size());
                    String owner = "";
                    for(int j=0; j<comments.size(); j++){
                        for(int k=0; k<accounts.size(); k++){
                            if(accounts.get(k).getAccountID() == comments.get(j).getAccountID())
                                owner = accounts.get(k).getUsername();
                        }
                        System.out.printf("Comment %d: '%s' said '%s'\n",j+1,owner,comments.get(j).getContent());
                    }
                }
                else
                    System.out.println("The post has no comments.");
            }
        }
        else
            System.out.println("If you want to view interactions, you need to view posts.");
    }
    /**
     * If the user is logged in, then share the post, otherwise, print a message
     * 
     * @param post The post you want to share.
     */
    public void sharePost(Post post){
        if(isLogin){
            setPosts(post,0);
            String newAction = "You share post: ID = " + post.getPostID();
            setHistory(newAction,0);
        }
        else
            System.out.println("You need to login.");
    }
    /**
     * If the user is logged in and the account is not blocked, then the user follows the account and
     * the account's followers are updated
     * 
     * @param account The account that you want to follow.
     */
    public void follow(Account account){
        if(isLogin){
            if(!isBlocked(account)){
                setFollowing(account,0);
                account.setFollowers(this,0);
                String newAction = "You followed " + account.getUsername();
                setHistory(newAction,0);
            }
        }
        else
            System.out.println("You need to login.");
    }
    /**
     * This function is used to like a post
     * 
     * @param postID The ID of the post that you want to like.
     * @param account The account that is being liked.
     */
    public void like(int postID, Account account){
        if(isPostsAreShown){
            ArrayList<Post> tempPosts = account.getPosts();
            for(int i=0; i<tempPosts.size(); i++){
                if(tempPosts.get(i).getPostID() == postID){
                    int likeNumber = tempPosts.get(i).getLikes().size();
                    Like newLike = new Like(likeNumber,getAccountID(),postID);
                    tempPosts.get(i).setLikes(newLike,0,0);
                    String newAction = "You liked " + account.getUsername() + "'s post: id = " + postID;
                    setHistory(newAction,0);
                }
            }
        }
    }
    /**
     * This function is used to add a comment to a post
     * 
     * @param postID The ID of the post you want to comment on.
     * @param account The account that the post is on.
     * @param content The content of the comment
     */
    public void comment(int postID,Account account, String content){
        if(isPostsAreShown){
            ArrayList<Post> tempPosts = account.getPosts();
            for(int i=0; i<tempPosts.size(); i++){
                if(tempPosts.get(i).getPostID() == postID){
                    int commentNumber = tempPosts.get(i).getComments().size();
                    Comment newComment = new Comment(commentNumber,getAccountID(),postID,content);
                    tempPosts.get(i).setComments(newComment,0,0);
                    String newAction = "You commented " + account.getUsername() + "'s post: id = " + postID;
                    setHistory(newAction,0);
                }
            }
        }
    }
    /**
     * If the user is logged in, and the account is not blocked, and the user is following the account,
     * then the user can send a message to the account
     * 
     * @param content The content of the message.
     * @param account The account that you want to send message to.
     */
    public void sendMessage(String content,Account account){
        if(isLogin){
            if(!isBlocked(account)){
                if(checkIsFollowing(account)){
                    Message newMessage = new Message(getOutbox().size(),getUsername(),account.getUsername(),content);
                    setOutbox(newMessage,0);
                    account.setInbox(newMessage,0);
                    String newAction = "You sent a message to " + account.getUsername();
                    setHistory(newAction,0);
                }
                else
                    System.out.println("You need to follow the account to send message.");
            }
            else
                System.out.println("You have no permission to send message to this account.");
        }
        else
            System.out.println("You need to login.");
    }
    /**
     * It checks the inbox of the user and prints out the messages
     */
    public void checkInbox(){
        if(isLogin){
            ArrayList<Message> temporary = getInbox();
            if(temporary.size() > 0){
                System.out.println("----------------------------");
                for(int i=0; i<temporary.size(); i++){
                    System.out.printf("Message ID: %d\n",temporary.get(i).getMessageID());
                    System.out.printf("From: %s\n",temporary.get(i).getSenderUsername());
                    System.out.printf("To: %s\n",temporary.get(i).getReceiverUsername());
                    System.out.printf("Message: %s\n",temporary.get(i).getContent());
                }
            }
        }
        else
            System.out.println("You need to login.");
    }
    /**
     * It prints out all the messages in the outbox
     */
    public void checkOutbox(){
        if(isLogin){
            ArrayList<Message> temporary = getOutbox();
            if(temporary.size() > 0){
                System.out.println("----------------------------");
                for(int i=0; i<temporary.size(); i++){
                    System.out.printf("Message ID: %d\n",temporary.get(i).getMessageID());
                    System.out.printf("From: %s\n",temporary.get(i).getSenderUsername());
                    System.out.printf("To: %s\n",temporary.get(i).getReceiverUsername());
                    System.out.printf("Message: %s\n",temporary.get(i).getContent());
                }
            }
        }
        else
            System.out.println("You need to login.");
    }
    /**
     * If the user is logged in, then the account is blocked, and if the user is following or is
     * followed by the account, then the following and follower relationships are removed
     * 
     * @param account The account that you want to block.
     */
    public void block(Account account){
        if(isLogin){
            setBlockedAccounts(account, 0);
            if(checkIsFollowing(account)){
                setFollowing(account, 1);
                account.setFollowers(this, 1);
            }
            if(checkIsFollower(account)){
                setFollowers(account, 1);
                account.setFollowing(this, 1);
            }
            String newAction = "You blocked " + account.getUsername();
            setHistory(newAction,0);
        }
        else
            System.out.println("You need to login.");
    }
    /**
     * This function checks if the account is following the account passed in as a parameter
     * 
     * @param account The account that you want to check if the current account is following.
     * @return A boolean value.
     */
    public boolean checkIsFollowing(Account account){
        ArrayList<Account> temp = getFollowing();
        for(int i=0; i<temp.size(); i++){
            if(temp.get(i).getAccountID() == account.getAccountID())
                return true;
        }
        return false;
    }
    /**
     * This function checks if the account passed in is a follower of the account that called the
     * function
     * 
     * @param account The account that you want to check if it's a follower of the current account.
     * @return A boolean value.
     */
    public boolean checkIsFollower(Account account){
        ArrayList<Account> temp = getFollowers();
        for(int i=0; i<temp.size(); i++){
            if(temp.get(i).getAccountID() == account.getAccountID())
                return true;
        }
        return false;
    }
    /**
     * If the account is blocked, return true, otherwise return false.
     * 
     * @param account The account that is trying to access the account.
     * @return A boolean value.
     */
    public boolean isBlocked(Account account){
        ArrayList<Account> blockedAccounts = account.getBlockedAccounts();
        for(int i=0; i<blockedAccounts.size(); i++){
            if(blockedAccounts.get(i).getAccountID() == getAccountID())
                return true;
        }
        return false;
    } 
    /**
     * This function checks if any account is logged in
     * 
     * @param accounts An array of Account objects.
     * @return A boolean value.
     */
    public boolean checkAnyLogin(ArrayList<Account> accounts){
        for(int i=0; i<accounts.size(); i++){
            if(accounts.get(i).getIsLogin() && (accounts.get(i).getAccountID() != getAccountID())){
                System.out.println("An account already loged in.");
                return true;
            }
        }
        return false;   
    }

    /*--------------NEW FEATURES------------------- */

     /**
     * The function allows an account to unlike a post by removing their like from the post's list of
     * likes.
     * 
     * @param postID The ID of the post that the user wants to unlike.
     * @param account The account of the user who is unliking the post.
     */
    public void unlike(int postID, Account account){
        if(isPostsAreShown){
            ArrayList<Post> tempPosts = account.getPosts();
            for(int i=0; i<tempPosts.size(); i++){
                if(tempPosts.get(i).getPostID() == postID){
                    ArrayList<Like> tempLikes = tempPosts.get(i).getLikes();
                    for(int j=0 ; j<tempLikes.size(); j++){
                        if(tempLikes.get(j).getAccountID() == this.getAccountID()){
                            tempPosts.get(i).setLikes(null,1,j);
                            String newAction = "You unliked " + account.getUsername() + "'s post: id = " + postID;
                            setHistory(newAction,0);
                        }
                    }    
                }
            }
        }
    }


    /**
     * The function allows a user to remove their comment from a specific post.
     * 
     * @param postID The ID of the post that the comment belongs to.
     * @param account An object of the class Account representing the account of the user who wants to
     * uncomment a comment on a post.
     * @param interactionID The interactionID parameter is an identifier for a specific comment
     * interaction on a post. It is used to locate the specific comment that needs to be uncommented.
     */
    public void uncomment(int postID, Account account,int interactionID){
        if(isPostsAreShown){
            ArrayList<Post> tempPosts = account.getPosts();
            for(int i=0; i<tempPosts.size(); i++){
                if(tempPosts.get(i).getPostID() == postID){
                    ArrayList<Comment> tempComments = tempPosts.get(i).getComments();
                    for(int j=0 ; j<tempComments.size(); j++){
                        if((tempComments.get(j).getAccountID() == this.getAccountID()) && (tempComments.get(j).getInteractionID() == interactionID)){
                            tempPosts.get(i).setComments(null,1,j);
                            String newAction = "You uncommented " + account.getUsername() + "'s post: id = " + postID;
                            setHistory(newAction,0);
                        }
                    }    
                }
            }
        }
    }


    /**
     * This function unblocks a specified account if the user is logged in and adds a corresponding
     * action to the user's history.
     * 
     * @param account The "account" parameter is an object of the "Account" class, which represents a
     * user account in a system. It is used as an input to the "unblock" method to specify which
     * account should be unblocked.
     */
    public void unblock(Account account){
        if(isLogin){
            setBlockedAccounts(account, 1);
            String newAction = "You unblocked " + account.getUsername();
            setHistory(newAction,0);
        }
        else
            System.out.println("You need to login.");
    }


    /**
     * This function allows a user to unfollow another account if they are not blocked and are
     * currently logged in.
     * 
     * @param account The "account" parameter is an object of the "Account" class, which represents the
     * user account that the current user wants to unfollow.
     */
    public void unfollow(Account account){
        if(isLogin){
            if(!isBlocked(account)){
                setFollowing(account,1);
                account.setFollowers(this,1);
                String newAction = "You unfollowed " + account.getUsername();
                setHistory(newAction,0);
            }
        }
        else
            System.out.println("You need to login.");
    }


    /**
     * This function shows the user's history of actions if they are logged in, otherwise it prompts
     * them to log in first.
     */
    public void showHistory(){
        if(isLogin){
            ArrayList<String> tempHistory = this.getHistory();
            if(tempHistory.size()>0){
                for(int i=0; i<tempHistory.size(); i++)
                    System.out.println(tempHistory.get(i));
            }
            else
                System.out.println("You have no action yet.");
        }
        else
            System.out.println("You should login first.");
    }
}