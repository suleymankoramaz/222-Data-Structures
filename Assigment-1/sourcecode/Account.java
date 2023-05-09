// Declaring a package called homework1.
package homework1;
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

    /** The array for posts of the account*/ 
    private Post[]    posts;
    /** The array for inbox of the account*/ 
    private Message[] inbox;
    /** The array for outbox of the account*/ 
    private Message[] outbox;
    /** The array for following of the account*/ 
    private Account[] following;
    /** The array for followers of the account*/ 
    private Account[] followers;
    /** The array for blocked accounts of the account*/ 
    private Account[] blockedAccounts;

    
    //-----------CONSTRUCTORS-------------//

    // This is the constructor for the Account class. It is used to create an instance of the Account
    // class.
    public Account(String username, String birthdate, String location, int accountID){
        this.username  = username;
        this.birthdate = birthdate;
        this.location  = location;
        this.accountID = accountID;
        this.posts = new Post[0];
        this.inbox = new Message[0];
        this.outbox = new Message[0];
        this.following = new Account[0];
        this.followers = new Account[0];
        this.blockedAccounts = new Account[0];
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
     * This function returns an array of Post objects.
     * 
     * @return An array of Post objects.
     */
    public Post[]    getPosts(){
        return posts;
    }
    /**
     * This function returns the inbox array.
     * 
     * @return The inbox array.
     */
    public Message[] getInbox(){
        return inbox;
    }
    /**
     * This function returns the outbox array.
     * 
     * @return The outbox array.
     */
    public Message[] getOutbox(){
        return outbox;
    }
    /**
     * This function returns the following array.
     * 
     * @return An array of Account objects.
     */
    public Account[] getFollowing(){
        return following;
    }
    /**
     * This function returns an array of accounts that are following the account that called this
     * function.
     * 
     * @return An array of Account objects.
     */
    public Account[] getFollowers(){
        return followers;
    }
    /**
     * This function returns an array of blocked accounts.
     * 
     * @return An array of blocked accounts.
     */
    public Account[] getBlockedAccounts(){
        return blockedAccounts;
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
            int post_check = 0;
            for(int i=0; i<posts.length; i++){
                if(posts[i].getPostID() == post.getPostID())
                    post_check++;
            }
            if(post_check == 0){
                int length = posts.length;
                Post[] newArray = new Post[length+1];
                for(int i=0; i<length; i++){
                    newArray[i] = posts[i];
                } 
                newArray[length] = post;
                posts = newArray;
            }
        }
        else if(process == 1){//remove
            Post[] newArray = new Post[posts.length-1];
            for(int i=0,k=0; i<posts.length; i++){
                if(posts[i].getPostID() == post.getPostID()){
                    continue;
                } 
                newArray[k++] = posts[i];
            }
            posts = newArray;
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
            int message_check = 0;
            for(int i=0; i<inbox.length; i++){
                if(inbox[i].getMessageID() == message.getMessageID())
                    message_check++;
            }
            if(message_check == 0){
                int length = inbox.length;
                Message[] newArray = new Message[length+1];
                for(int i=0; i<length; i++){
                    newArray[i] = inbox[i];
                } 
                newArray[length] = message;
                inbox = newArray;
            }
        }
        else if(process == 1){//remove
            Message[] newArray = new Message[inbox.length-1];
            for(int i=0,k=0; i<inbox.length-1; i++){
                if(inbox[i].getMessageID() == message.getMessageID()){
                    continue;
                } 
                newArray[k++] = inbox[i];
            }
            inbox = newArray;
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
            int message_check = 0;
            for(int i=0; i<outbox.length; i++){
                if(outbox[i].getMessageID() == message.getMessageID())
                    message_check++;
            }
            if(message_check == 0){
                int length = outbox.length;
                Message[] newArray = new Message[length+1];
                for(int i=0; i<length; i++){
                    newArray[i] = outbox[i];
                } 
                newArray[length] = message;
                outbox = newArray;
            }
        }
        else if(process == 1){//remove
            Message[] newArray = new Message[outbox.length-1];
            for(int i=0,k=0; i<outbox.length; i++){
                if(outbox[i].getMessageID() == message.getMessageID()){
                    continue;
                } 
                newArray[k++] = outbox[i];
            }
            outbox = newArray;
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
            int account_check = 0;
            for(int i=0; i<following.length; i++){
                if(following[i].accountID == account.accountID)
                    account_check++;
            }
            if(account_check == 0){
                int length = following.length;
                Account[] newArray = new Account[length+1];
                for(int i=0; i<length; i++){
                    newArray[i] = following[i];
                } 
                newArray[length] = account;
                following = newArray;
            }
        }
        else if(process == 1){//remove
            Account[] newArray = new Account[following.length-1];
            for(int i=0,k=0; i<following.length; i++){
                if(following[i].accountID == account.accountID){
                    continue;
                } 
                newArray[k++] = following[i];
            }
            following = newArray;
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
            int account_check = 0;
            for(int i=0; i<followers.length; i++){
                if(followers[i].accountID == account.accountID)
                    account_check++;
            }
            if(account_check == 0){
                int length = followers.length;
                Account[] newArray = new Account[length+1];
                for(int i=0; i<length; i++){
                    newArray[i] = followers[i];
                } 
                newArray[length] = account;
                followers = newArray;
            }
        }
        else if(process == 1){//remove
            Account[] newArray = new Account[followers.length-1];
            for(int i=0,k=0; i<followers.length; i++){
                if(followers[i].accountID == account.accountID){
                    continue;
                } 
                newArray[k++] = followers[i];
            }
            followers = newArray;
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
            int account_check = 0;
            for(int i=0; i<blockedAccounts.length; i++){
                if(blockedAccounts[i].accountID == account.accountID)
                    account_check++;
            }
            if(account_check == 0){
                int length = blockedAccounts.length;
                Account[] newArray = new Account[length+1];
                for(int i=0; i<length; i++){
                    newArray[i] = blockedAccounts[i];
                } 
                newArray[length] = account;
                blockedAccounts = newArray;
            }
        }
        else if(process == 1){//remove
            Account[] newArray = new Account[blockedAccounts.length-1];
            for(int i=0,k=0; i<blockedAccounts.length; i++){
                if(blockedAccounts[i].accountID == account.accountID){
                    continue;
                } 
                newArray[k++] = blockedAccounts[i];
            }
            blockedAccounts = newArray;
        }
    }

    //-----------METHODS-------------//
    /**
     * If the account is not logged in, and no other account is logged in, then log in the account
     * 
     * @param accounts An array of Account objects.
     */
    public void login(Account[] accounts){
        if(!getIsLogin()){
            if(!checkAnyLogin(accounts))
                setIsLogin(true);
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
                Account[] following = account.getFollowing();
                Account[] followers = account.getFollowers();
                Post[]    posts     = account.getPosts();

                System.out.println("--------------------------");
                System.out.printf("User ID: %d\n",account.getAccountID());
                System.out.printf("Username: %s\n",account.getUsername());
                System.out.printf("Location: %s\n",account.getLocation());
                System.out.printf("Birth Date: %s\n",account.getBirthdate());
                System.out.printf("%s is following %d account(s) and has %d follower(s).\n",account.getUsername(),following.length,followers.length);
                if(following.length > 0){
                    System.out.printf("%s is following: ",account.getUsername());
                    for(int j=0; j<following.length; j++)
                        System.out.printf("%s, ",following[j].getUsername());
                    System.out.println();
                }
                if(followers.length > 0){
                    System.out.printf("%s's follower(s): ",account.getUsername());
                    for(int j=0; j<followers.length; j++)
                        System.out.printf("%s, ",followers[j].getUsername());
                    System.out.println();
                }
                System.out.printf("%s has %d posts.\n\n",account.getUsername(),posts.length);
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
            Post[] userPosts = account.getPosts();
            if(userPosts.length > 0){
                for(int j=0; j<userPosts.length; j++)
                    System.out.printf("(PostID: %d) %s: %s\n",userPosts[j].getPostID(),account.getUsername(),userPosts[j].getContent());
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
    public void viewInteractions(Account account, Account[] accounts){
        if((getCurrentAccount() == account.getAccountID()) && getIsPostAreShown()){
            Post[] userPosts = account.getPosts();
            for(int i=0; i<userPosts.length; i++){
                
                System.out.println("---------------------------------");
                System.out.printf("(PostID: %d): %s\n",userPosts[i].getPostID(),userPosts[i].getContent());
                
                Like[] likes = userPosts[i].getLikes();
                Comment[] comments = userPosts[i].getComments();

                if(likes.length > 0){
                    System.out.printf("The post was liked by the following account(s): ");
                    String owner = "";
                    for(int j=0; j<likes.length; j++){ 
                        for(int k=0; k<accounts.length; k++){
                            if(accounts[k].getAccountID() == likes[j].getAccountID())
                                owner = accounts[k].getUsername();
                        }
                        System.out.printf("%s, ",owner);
                    }
                    System.out.println("");   
                }
                else    
                    System.out.println("The post has no likes.");

                if(comments.length > 0){
                    System.out.printf("The post has %d comment(s)...\n",comments.length);
                    String owner = "";
                    for(int j=0; j<comments.length; j++){
                        for(int k=0; k<accounts.length; k++){
                            if(accounts[k].getAccountID() == comments[j].getAccountID())
                                owner = accounts[k].getUsername();
                        }
                        System.out.printf("Comment %d: '%s' said '%s'\n",j+1,owner,comments[j].getContent());
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
        if(isLogin)
            setPosts(post,0);
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
            Post[] tempPosts = account.getPosts();
            for(int i=0; i<tempPosts.length; i++){
                if(tempPosts[i].getPostID() == postID){
                    int likeNumber = tempPosts[i].getLikes().length;
                    Like newLike = new Like(likeNumber,getAccountID(),postID);
                    tempPosts[i].setLikes(newLike,0);
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
            Post[] tempPosts = account.getPosts();
            for(int i=0; i<tempPosts.length; i++){
                if(tempPosts[i].getPostID() == postID){
                    int commentNumber = tempPosts[i].getComments().length;
                    Comment newComment = new Comment(commentNumber,getAccountID(),postID,content);
                    tempPosts[i].setComments(newComment,0);
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
                    Message newMessage = new Message(getOutbox().length,getUsername(),account.getUsername(),content);
                    setOutbox(newMessage,0);
                    account.setInbox(newMessage,0);
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
            Message[] temporary = getInbox();
            if(temporary.length > 0){
                System.out.println("----------------------------");
                for(int i=0; i<temporary.length; i++){
                    System.out.printf("Message ID: %d\n",temporary[i].getMessageID());
                    System.out.printf("From: %s\n",temporary[i].getSenderUsername());
                    System.out.printf("To: %s\n",temporary[i].getReceiverUsername());
                    System.out.printf("Message: %s\n",temporary[i].getContent());
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
            Message[] temporary = getOutbox();
            if(temporary.length > 0){
                System.out.println("----------------------------");
                for(int i=0; i<temporary.length; i++){
                    System.out.printf("Message ID: %d\n",temporary[i].getMessageID());
                    System.out.printf("From: %s\n",temporary[i].getSenderUsername());
                    System.out.printf("To: %s\n",temporary[i].getReceiverUsername());
                    System.out.printf("Message: %s\n",temporary[i].getContent());
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
        Account[] temp = getFollowing();
        for(int i=0; i<temp.length; i++){
            if(temp[i].getAccountID() == account.getAccountID())
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
        Account[] temp = getFollowers();
        for(int i=0; i<temp.length; i++){
            if(temp[i].getAccountID() == account.getAccountID())
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
        Account[] blockedAccounts = account.getBlockedAccounts();
        for(int i=0; i<blockedAccounts.length; i++){
            if(blockedAccounts[i].getAccountID() == getAccountID())
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
    public boolean checkAnyLogin(Account[] accounts){
        for(int i=0; i<accounts.length; i++){
            if(accounts[i].getIsLogin() && (accounts[i].getAccountID() != getAccountID())){
                System.out.println("An account already loged in.");
                return true;
            }
        }
        return false;   
    }
}