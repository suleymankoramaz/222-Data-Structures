// A package declaration. It tells the compiler that the class is part of the package `ArrayList`.
package LList;
/**
 * A Message object contains a messageID, senderUsername, receiverUsername, and content
 */
public class Message{
    
    /** The ID of the message*/
    private int messageID;
    /** The username of the sender*/
    private String senderUsername;
    /** The username of the receiver*/
    private String receiverUsername;
    /** The content of the message*/
    private String content;

    // This is a constructor. It is a special method that is called when an object is created.
    public Message(int messageID, String senderUsername, String receiverUsername, String content){
        this.messageID  = messageID;
        this.senderUsername   = senderUsername;
        this.receiverUsername = receiverUsername;
        this.content    = content;
    }

    /**
     * This function returns the messageID of the message
     * 
     * @return The messageID
     */
    public int    getMessageID(){
        return messageID;
    }
    /**
     * This function returns the username of the sender of the message
     * 
     * @return The senderUsername is being returned.
     */
    public String getSenderUsername(){
        return senderUsername;
    }
    /**
     * This function returns the receiverUsername
     * 
     * @return The receiverUsername is being returned.
     */
    public String getReceiverUsername(){
        return receiverUsername;
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
     * This function sets the messageID variable to the value of the newMessageID variable
     * 
     * @param newMessageID The new message ID to set.
     */
    public void setMessageID(int newMessageID){
        messageID = newMessageID;
    }
    /**
     * This function sets the senderUsername variable to the value of the newSenderUsername variable
     * 
     * @param newSenderUsername The username of the sender of the message.
     */
    public void setSenderID(String newSenderUsername){
        senderUsername = newSenderUsername;
    }
    /**
     * This function sets the receiverUsername variable to the value of the newReceiverUsername
     * parameter
     * 
     * @param newReceiverUsername The username of the person you want to send the message to.
     */
    public void setReceiverID(String newReceiverUsername){
        receiverUsername = newReceiverUsername;
    }
    /**
     * This function sets the content of the current object to the value of the parameter newContent.
     * 
     * @param newContent The new content of the message.
     */
    public void setContent(String newContent){
        content = newContent;
    }
}