// `package LDLList;` is declaring the package name for the `LDLinkedList` class. This means that the
// `LDLinkedList` class is part of the `LDLList` package, which is a way of organizing related classes
// and interfaces in Java.
package LDLList;

import java.util.AbstractList;
import java.util.List;

/**
 * The LDLinkedList class is a generic linked list implementation that allows for adding, removing, and
 * marking objects in the list.
 */
public class LDLinkedList<T> extends AbstractList<T> implements List<T> {
    
    // `private Node<T> head;` is declaring a private instance variable `head` of type `Node<T>`. This
    // variable is used to keep track of the first node in the linked list.
    private Node<T> head;
    
    // The line `private boolean marked;` is declaring a private instance variable `marked` of type
    // `boolean`. This variable is likely used to keep track of whether an object has been marked or
    // not in the `myremove` method of the `LDLinkedList` class. If `marked` is true, it means that an
    // object has been marked, and if it is false, it means that no object has been marked.
    private boolean marked;
    
    // The line `private T markedObject;` is declaring a private instance variable `markedObject` of
    // type `T`. This variable is likely used to keep track of an object that has been marked in the
    // `myremove` method of the `LDLinkedList` class. The `myremove` method allows for a temporary mark
    // to be set on an object while another object is being removed from the linked list. The
    // `markedObject` variable is used to store the object that has been marked.
    private T markedObject;

    /**
     * This is a generic class for creating nodes with data and a reference to the next node.
     */
    private static class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
        }
    }

    /**
     * This function returns the head node of a linked list.
     * 
     * @return The method `getHead()` is returning the head node of a linked list, which is of type
     * `Node<T>`.
     */
    public Node<T> getHead(){
        return head;
    }
    /**
     * This function returns the value of a boolean variable named "marked".
     * 
     * @return The method is returning a boolean value, which is the value of the variable "marked".
     */
    public boolean getMarked(){
        return marked;
    }
    /**
     * This function returns an object of type T that has been marked.
     * 
     * @return The method is returning an object of type T, which is the type of the variable
     * markedObject.
     */
    public T getMarkedObject(){
        return markedObject;
    }
    
    /**
     * This function sets the head of a linked list to a new value.
     * 
     * @param newValue The new value that will be assigned to the head of the linked list. It is of
     * type Node<T>, which means it is a reference to a node object that contains a value of type T and
     * a reference to the next node in the list.
     */
    public void setHead(Node<T> newValue){
        head = newValue;
    }
    /**
     * This function sets the value of a boolean variable called "marked".
     * 
     * @param newValue newValue is a boolean parameter that represents the new value to be set for the
     * "marked" variable. If newValue is true, it means the object is marked, and if it is false, it
     * means the object is not marked.
     */
    public void setMarked(boolean newValue){
        marked = newValue;
    }
    /**
     * This function sets the value of a variable called "markedObject" to a new value of type T.
     * 
     * @param newValue The new value that will be assigned to the variable markedObject. The data type
     * of newValue should be the same as the data type of markedObject.
     */
    public void setMarkedObject(T newValue){
        markedObject = newValue;
    }
    

    /**
     * This function returns the data at a specified index in a linked list.
     * 
     * @param index The index parameter is an integer value representing the position of the node in
     * the linked list whose data we want to retrieve. The first node in the linked list has an index
     * of 0, the second node has an index of 1, and so on.
     * @return The method `get` returns the data stored in the node at the specified index in the
     * linked list.
     */
    public T get(int index){
        Node<T> current = getHead();
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    /**
     * This function returns the size of a linked list by iterating through each node and incrementing
     * a counter.
     * 
     * @return The size of the linked list is being returned.
     */
    public int size(){
        int size = 0;
        Node<T> current = getHead();
        while(current != null){
            size++;
            current = current.next;
        }
        return size;
    }

    /**
     * This function adds a new node containing an object to the end of a linked list.
     * 
     * @param object The object of type T that is being added to the linked list.
     * @return A boolean value of true is being returned.
     */
    public boolean add(T object){
        Node<T> newNode = new Node<>(object);
        if(getHead() == null){
            setHead(newNode);
        } 
        else{
            Node<T> current = getHead();
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        return true;
    }

    /**
     * This function removes an object from a collection while allowing for a temporary mark to be set
     * on another object.
     * 
     * @param obj The parameter `obj` is of type `T`, which means it can be any object of a generic
     * type `T`. This method is likely part of a class that implements some kind of data structure, and
     * `obj` represents the object that the method is trying to remove from that data structure.
     * @return The method is returning a boolean value. If the object was successfully removed, it will
     * return true. If the object was not found in the data structure, it will return false.
     */
    public boolean myremove(T obj){
        if(getMarked()){
            pureRemove(getMarkedObject());
            setMarked(false);
            return pureRemove(obj); 
        }
        else{
            setMarked(true);
            setMarkedObject(obj);
            return true;
        }
    }

    /**
     * The function removes the first occurrence of a given object from a linked list.
     * 
     * @param obj The parameter "obj" is an object of type T that we want to remove from the linked
     * list.
     * @return The method is returning a boolean value. It returns true if the object is successfully
     * removed from the linked list, and false if the object is not found in the linked list.
     */
    public boolean pureRemove(T obj){
        if(getHead() == null){
            return false;
        }
        if(head.data.equals(obj)){
            setHead(head.next);
            return true;
        }
        Node<T> current = head;
        while (current.next != null){
            if (current.next.data.equals(obj)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }
}