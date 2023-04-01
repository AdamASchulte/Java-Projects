
package doublylinkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    
    private Node first;
    private Node last;
    
    //constructors: empty of with data of first node
    public LinkedList()
    {
        
    }
    
    public LinkedList(int data)
    {
        first = new Node(data);
    }
    
    
    //add elements to list
    public void add(int data)
    {
        if(first == null)
        {
            first = new Node(data);
            first.setNext(first);
            first.setPrev(first);
        }
        else if(last == null)
        {
            last = new Node(data);
            last.setPrev(first);
            last.setNext(first);
            first.setNext(last);
            first.setPrev(last);
        }
        else
        {            
            Node temp = first;
            first = new Node(data);
            temp.setPrev(first);
            first.setNext(temp);
            first.setPrev(last);
            last.setNext(first);
            
        }
    }
    
    public void addLast(int data)
    {
        if(first == null)
        {
            first = new Node(data);
            first.setNext(first);
            first.setPrev(first);
        }
        else if(last == null)
        {
            last = new Node(data);
            first.setNext(last);
            first.setPrev(last);
            last.setNext(first);
            last.setPrev(first);
        }
        else 
        {
            Node temp = last;
            last.getPrev().setNext(temp);
            last = new Node(data);
            last.setPrev(temp);
            temp.setNext(last);
            last.setNext(first);
        }
    }
    
    //remove a node based on data it stores. will remove all instances of said data
    public void removeData(int d)
    {
        Node x = first;
        do {
            if(x.getData() == d && x != first && x != last)
            {
                x.getNext().setPrev(x.getPrev());
                x.getPrev().setNext(x.getNext());
            }
            else if(x.getData() == d && x == first)
            {
                first = x.getNext();
                x.getNext().getNext().setPrev(first);
                first.setPrev(last);
                last.setNext(first);
            }
            else if(x.getData() == d && x == last)
            {
                last = x.getPrev();
                x.getPrev().getPrev().setNext(last);
                last.setPrev(x.getPrev().getPrev());
                last.setNext(first);
            }
            x = x.getNext();
        } while(x != first);
    }
    
    //allows user to remove the first instance of data
    public void removeSingleData(int d)
    {
        boolean notDeleted = true;
        Node x = first;
        do {
            if(x.getData() == d && x != first && x != last)
            {
                x.getNext().setPrev(x.getPrev());
                x.getPrev().setNext(x.getNext());
                notDeleted = false;
            }
            else if(x.getData() == d && x == first)
            {
                first = x.getNext();
                x.getNext().getNext().setPrev(first);
                first.setPrev(last);
                last.setNext(first);
                notDeleted = false;
            }
            else if(x.getData() == d && x == last)
            {
                last = x.getPrev();
                x.getPrev().getPrev().setNext(last);
                last.setPrev(x.getPrev().getPrev());
                last.setNext(first);
                notDeleted = false;
            }
            x = x.getNext();
        } while(x != first && notDeleted);
    }
    
    
    //allows user to traverse the list and print the data of each node in the linked list
    public void printList()
    {
        if(last == null)
        {
            System.out.print(first.getData());
        }
        else
        {
            System.out.print(first.getData());
            Node x = first.getNext();
            do {
                System.out.print(", " + x.getData());
                x = x.getNext();
            } while(x != first);
        }
        
        System.out.println();
    }
    
}
