//"src" package.
package src;

//IMPORTED PACKAGES
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

/**
 * The HW5 class
 */
public class HW5
{
    /**
     * This is the main function
     */
    public static void main(String[] args) 
    {
        HW5 obj = new HW5("tree.txt");
        obj.fillArray();
        obj.createTree();

        Scanner sc;
        String str;

        while(true)
        {
            System.out.println("-----------------------");
            System.out.println("1- BFS");
            System.out.println("2- DFS");
            System.out.println("3- Post Order Traversal");
            System.out.println("4- Move Node");
            System.out.println("5- Open Tree");
            System.out.println("6- Exit");
            System.out.println("-----------------------");
            System.out.print("Please select process: ");

            sc= new Scanner(System.in);
            try
            {
                str= sc.nextLine();
                if(str.equals("1"))
                {
                    System.out.print("Please enter input to BFS search: ");  
                    try 
                    {
                        str= sc.nextLine();
                        obj.BFS(str);
                    } 
                    catch (Exception e) 
                    {
                        System.out.print("An error occured while reading input");  
                    }
                }

                if(str.equals("2"))
                {
                    System.out.print("Please enter input to DFS search: ");  
                    try 
                    {
                        str= sc.nextLine();
                        obj.DFS(str);
                    } 
                    catch (Exception e) 
                    {
                        System.out.print("An error occured while reading input");  
                    }
                }

                if(str.equals("3"))
                {
                    System.out.print("Please enter input to POT search: ");  
                    try 
                    {
                        str= sc.nextLine();
                        obj.POT(str);
                    } 
                    catch (Exception e) 
                    {
                        System.out.print("An error occured while reading input");  
                    }
                }

                if(str.equals("4"))
                {
                    obj.move();
                }

                if(str.equals("5"))
                {
                    obj.toImage();
                }

                if(str.equals("6"))
                {
                    System.exit(0);
                }
            }
            catch(Exception e)
            {
                System.out.print("Please select process: ");
            }

            
        }
    }

    //VARIABLES
    private String filename;
    private ArrayList<ArrayList<String>> strArray;
    private DefaultMutableTreeNode root;


    // Default constructor 
    protected HW5()
    {
        strArray = new ArrayList<ArrayList<String>>();
        root = new DefaultMutableTreeNode("Root");
    }
    // Constructor string parameter for filename
    protected HW5(String file)
    {
        strArray = new ArrayList<ArrayList<String>>();
        root = new DefaultMutableTreeNode("Root");
        filename = file;
    }

    //GETTERS
    /**
    * Getter method returns the filename as a string. 
    * @return The method is returning a String value, which is the filename.
    */
    protected String getFilename()
    {   
        return filename;
    }
    /**
    * Getter method returns an ArrayList of ArrayLists of Strings.
    * @return An ArrayList of ArrayLists of Strings is being returned.
    */
    protected ArrayList<ArrayList<String>> getStrArray()
    {
        return strArray;
    }
    /**
    * Getter method returns the root node of a tree structure represented by a DefaultMutableTreeNode object in Java.
    * @return The method is returning a DefaultMutableTreeNode object named "root".
    */
    protected DefaultMutableTreeNode getRoot()
    {
        return root;
    }

    //SETTERS
    /**
    * Setter method sets the filename to a new value.
    * @param newFilename newFilename is a parameter of type String that represents the new filename
    * that we want to set for a file. This parameter is used in the method setFilename() to update the
    * value of the instance variable filename with the new filename.
    */
    protected void setFilename(String newFilename)
    {
        filename = newFilename;
    }
    /**
    * Setter method adds a new element to an ArrayList of Strings.
    * @param newElement newElement is an ArrayList of Strings that is being passed as a parameter to
    * the method setStrArray(). This ArrayList will be added to the existing strArray ArrayList.
    */
    protected void setStrArray(ArrayList<String> newElement)
    {
        strArray.add(newElement);
    }
    /**
    * Setter method sets the root node of a DefaultMutableTreeNode object to a new node.
    * @param newRoot newRoot is a DefaultMutableTreeNode object that represents the new root node to
    * be set in a tree data structure. This method is typically used in classes that implement the
    * TreeModel interface to update the root node of the tree.
    */
    protected void setRoot(DefaultMutableTreeNode newRoot)
    {
        root = newRoot;
    }

    //METHODS
    /**
    * Method that reads data from a file, splits it into an array of strings, and sets it as the value of a class variable.
    */
    protected void fillArray()
    {
        try
        {
            //variables
            ArrayList<String> temp = new ArrayList<String>(); //temp for one row of 2D array
            File fileObj = new File(filename);                //open file
            Scanner fileReader = new Scanner(fileObj);        //scanned variable to read

            //read until EOF
            while (fileReader.hasNextLine()) 
            {
                String line = fileReader.nextLine();
                String[] tempArray = line.split(";");
                temp = new ArrayList<String>(Arrays.asList(tempArray));
                setStrArray(temp);
            }
            fileReader.close();
        } 

        //if there is an error occured
        catch(FileNotFoundException e)
        {
            System.out.println("An error occurred while file reading.");
        }
    }

    /**
    * Method that creates a tree structure using an 2D ArrayList as input.
    */
    protected void createTree()
    {
        //variables
        boolean check;                   //control variable to check children 
        DefaultMutableTreeNode instant;  //instant ndoe variable while travelling
        DefaultMutableTreeNode tempNode; //for temporary node processes
        ArrayList<String> tempArray;     //temporary string array for get a row of 2D string array

        for(int i=0 ; i<strArray.size() ; i++)
        {
            //get row in the order
            tempArray = strArray.get(i);

            //start from root
            instant = getRoot();

            //check all columns
            for(int j=0 ; j<tempArray.size() ; j++)
            {
                check = false;

                //check instant node's children to control existence
                for(int k=0 ; k<instant.getChildCount() ; k++)
                {
                    DefaultMutableTreeNode currentChild = (DefaultMutableTreeNode) instant.getChildAt(k);

                    //it is exist, skip it and contuine
                    if(currentChild.getUserObject().equals(tempArray.get(j)))
                    {
                        check = true;
                        instant = currentChild;
                        break;
                    }
                }
                
                //it is not exist, create it and add to instant node. It is instant now
                if(!check)
                {
                    tempNode = new DefaultMutableTreeNode(tempArray.get(j));
                    instant.add(tempNode);
                    instant = tempNode;
                }      
            }
        }
    }

    /**
    * Method that displays tree as a visible window.
    */
    protected void toImage()
    {
        JFrame f = new JFrame();;
        JTree jt = new JTree(getRoot());
        f.add(jt);  
        f.setSize(500,500);  
        f.setVisible(true); 
    }

    /**
    * Method that performs BFS on a tree
    * @param input The value that is being searched for in the tree.
    */
    protected void BFS(String input)
    {
        //variables
        Queue<DefaultMutableTreeNode> queue = new LinkedList<>(); //queue
        DefaultMutableTreeNode temp; //for temporary treeNode processes
        int count = 1;               //count value
        boolean found = false;       //control variable to check found or not

        System.out.printf("Using BFS to find '%s' int the tree...\n",input);
        queue.add(getRoot());
        while(!queue.isEmpty())
        {

            //poll variable from queue
            temp = queue.poll();
            System.out.printf("Step %d -> %s ",count,temp.getUserObject());

            //if it is target
            if(temp.getUserObject().equals(input))
            {
                System.out.println("(Found!)");
                found = true;
                break;
            }
            System.out.println("");

            //if it is not target, contuine and add it's children to queue
            for(int i=0 ; i<temp.getChildCount() ; i++)
            {
                DefaultMutableTreeNode newQueueElement = (DefaultMutableTreeNode) temp.getChildAt(i);
                queue.add(newQueueElement);
            }
            count++;
        }

        //if it is not found
        if(!found)
            System.out.println("Not found.");
    }

    /**
    * Method that performs DFS on a tree
    * @param input The value that the DFS algorithm is searching for in the tree.
    */
    protected void DFS(String input)
    {
        //variables
        Stack<DefaultMutableTreeNode> stack = new Stack<DefaultMutableTreeNode>();  //stack
        DefaultMutableTreeNode temp; //for temporary treeNode processes
        int count = 1;               //count value
        boolean found = false;       //control for check found or not

        System.out.printf("Using DFS to find '%s' int the tree...\n",input);

        //push root to stack first
        stack.push(getRoot());
        while(!stack.isEmpty())
        {

            //pop top of the stack
            temp = stack.pop();
            System.out.printf("Step %d -> %s ",count,temp.getUserObject());

            //if it is target
            if(temp.getUserObject().equals(input))
            {
                System.out.println("(Found!)");
                found = true;
                break;
            }
            System.out.println("");

            //if it is not target contuine and push it's children to stack
            for(int i=0 ; i<temp.getChildCount() ; i++)
            {
                DefaultMutableTreeNode newStackElement = (DefaultMutableTreeNode) temp.getChildAt(i);
                stack.add(newStackElement);
            }
            count++;
        }

        //if it is not found
        if(!found)
            System.out.println("Not found.");
    }

    /**
    * Method that performs Post Order Traversal on a tree
    * @param input The value that we are searching for in the tree.
    */
    protected void POT(String input)
    {
        //variables
        Stack<DefaultMutableTreeNode> stack = new Stack<DefaultMutableTreeNode>(); //stack
        DefaultMutableTreeNode tempRoot = cloneTree(getRoot());                    //we are removing tree while process, so close tree to temporary tree
        DefaultMutableTreeNode temp;                                               //for temporary treeNode processes
        int count = 1;          //count value for step number
        boolean found = false;  //control variable to check found or not                                                  

        System.out.printf("Using Post Order Traversal to find '%s' int the tree...\n",input);

        //first push root to stack
        stack.push(tempRoot);
        while(!stack.isEmpty())
        {

            //get top of the stack
            temp = stack.peek();

            //if it has no child
            if(temp.isLeaf())
            {
                System.out.printf("Step %d -> %s ",count,temp.getUserObject());

                //if it is target, pop from stack and break
                if(temp.getUserObject().equals(input))
                {
                    System.out.println("(Found!)");
                    found = true;
                    stack.pop();
                    break;
                }

                //if it is not target, contuine
                else
                {
                    System.out.println("");
                    stack.pop();
                } 
                count++;
            }

            //if it has child, push it's children to stack and remove childrens from parent after push
            else
            {
                for(int i=temp.getChildCount()-1 ; i>=0 ; i--)
                {
                    DefaultMutableTreeNode currentChild = (DefaultMutableTreeNode) temp.getChildAt(i);
                    stack.push(currentChild);
                }
                temp.removeAllChildren();
            }
        }

        if(!found)
            System.out.println("Not found.");
    }

    /**
    * Method that moves a node or a group of nodes
    */
    protected void move()
    {   
        //treeNode variables
        DefaultMutableTreeNode instant = getRoot();  //holds instant node while travelling
        DefaultMutableTreeNode temp;                 //for temporar node processes
        DefaultMutableTreeNode parent;               //holds parent 

        //control variable
        boolean found;

        //getting inputs
        //-----------------------------------------------------------------
        String stringLine1;
        String stringLine2;
        Scanner sc= new Scanner(System.in);

        System.out.printf("Enter a string for problem/lecture/course: ");  
        try 
        {
            stringLine1= sc.nextLine();
        } 
        catch (Exception e) 
        {
            System.out.println("An error occured.Program could not move process.");
            return;
        }

        System.out.printf("Enter a string for the destination year: ");  
        try 
        {
            stringLine2= sc.nextLine();
        } 
        catch (Exception e) 
        {
            System.out.println("An error occured.Program could not move process.");
            return;
        }
        
        stringLine1 = stringLine1.replaceAll(" ","");
        String[] fromTree = stringLine1.split(",");
        //-----------------------------------------------------------------
        
        //finding target node
        for(String str : fromTree)
        {
            found = false;
            for(int i=0 ; i<instant.getChildCount() ; i++)
            {
                temp = (DefaultMutableTreeNode) instant.getChildAt(i);
                if(temp.getUserObject().equals(str))
                {
                    instant = temp;
                    found = true;
                    break;
                }
            }

            //there is no node that has same name with input
            if(!found)
                System.out.printf("Cannot move %s because it doesn't exist in the tree.\n",stringLine1.replaceAll(",","->"));
        }

        //clone target treeNode just before remove
        DefaultMutableTreeNode addTreeNode = cloneTree(instant);

        //remove process, while loop while the parent of the removed child became not leaf or reach root
        boolean exit = false;
        while(!exit)
        {
            parent = (DefaultMutableTreeNode) instant.getParent();
            parent.remove(instant);
            if(parent.isLeaf() && !parent.getUserObject().equals("Root"))
                instant = parent;
            else
                exit = true;
        }

        //add process, if return false it means overwritten
        if(!add(fromTree, stringLine2, addTreeNode))
            System.out.printf("\nMoved %s to %s.\n%s has been overwritten.\n\n",stringLine1,stringLine2,stringLine1);
    }

    /**
    * Method that adds a new node to a tree structure
    * @param strFrom An array of strings representing the path to the node where the new node will be
    * added. The first element of the array is the root node and the last element is the parent node
    * of the new node.
    * @param strTo A string representing the destination node where the new node will be added as a
    * child node.
    * @param treeNode A DefaultMutableTreeNode object that represents the node to be added to the
    * tree.
    * @return A boolean value is being returned.
    */
    protected boolean add(String[] strFrom, String strTo, DefaultMutableTreeNode treeNode)
    {

        //treeNode variables
        DefaultMutableTreeNode instant = getRoot();  //holds instant node while traveling
        DefaultMutableTreeNode temp;                 //for temporary node processes

        //control variables for control children
        boolean exist     = false;
        boolean exist2    = false;
        boolean exist3    = false;

        //control variable for control if overwritten
        boolean isWritten = false;
        
        //check first root children
        for(int i=0 ; i<instant.getChildCount() ; i++)
        {
            temp = (DefaultMutableTreeNode) instant.getChildAt(i);
            if(temp.getUserObject().equals(strTo))
            {
                exist = true;
                instant = temp;
                break;
            }
        }

        //if there is no such an node, create and add
        if(!exist)
        {
            temp = new DefaultMutableTreeNode(strTo);
            instant.add(temp);
            instant = temp;

            //after adding first node, add the others excluding last one (last one will added as a node)
            for(int i=1 ; i<strFrom.length-1 ; i++)
            {
                temp = new DefaultMutableTreeNode(strFrom[i]);
                instant.add(temp);
                instant = temp;
            }
        }

        //if there is an node, add
        else
        {

            //add the others excluding last one (last one will added as a node)
            for(int i=1 ; i<strFrom.length-1 ; i++)
            {
                exist2 = false;
                for(int j=0 ; j<instant.getChildCount() ; j++)
                {
                    temp = (DefaultMutableTreeNode) instant.getChildAt(j);
                    if(temp.getUserObject().equals(strFrom[i])){
                        exist2 = true;
                        instant = temp;
                    }
                }

                if(!exist2)
                {
                    temp = new DefaultMutableTreeNode(strFrom[i]);
                    instant.add(temp);
                    instant = temp;
                    isWritten = true;
                }
                        
                
            }
        }

        //add last node, control is there any node same with our node
        for(int j=0 ; j<instant.getChildCount() ; j++)
        {
            temp = (DefaultMutableTreeNode) instant.getChildAt(j);

            //if theer is, overwrite
            if(temp.getUserObject().equals(treeNode.getUserObject()))
            {
                DefaultMutableTreeNode parent = (DefaultMutableTreeNode) temp.getParent();
                parent.remove(temp);
                parent.add(treeNode);    
                exist3 = true;
            }
        }

        //if there is no, overwrite
        if(!exist3)
        {
            instant.add(treeNode);
            isWritten = true;
        }

        //control overwritten or not
        if(!isWritten || (strFrom[0].equals(strTo)))
            return false;

        return true;
    }

    /**
    * Method that clones a tree structure
    * @param root The root node of the tree that needs to be cloned.
    * @return The method is returning a cloned copy of the input tree, represented as a
    * DefaultMutableTreeNode object.
    */
    protected DefaultMutableTreeNode cloneTree(DefaultMutableTreeNode root)
    {
        if (root == null) 
        {
            return null;
        }
        DefaultMutableTreeNode cloneRoot = new DefaultMutableTreeNode(root.getUserObject());
        for(int i=0 ; i<root.getChildCount() ; i++) 
        {
            DefaultMutableTreeNode temp = (DefaultMutableTreeNode) root.getChildAt(i);
            cloneRoot.add(cloneTree(temp));
        }
        return cloneRoot;
    }
}