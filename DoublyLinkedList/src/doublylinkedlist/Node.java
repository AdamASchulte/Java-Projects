
package doublylinkedlist;

public class Node {
    
    private int data;
    private Node prev;
    private Node next;
    
    public Node(int d)
    {
        data = d;
    }
    
    public Node getPrev()
    {
        return prev;
    }
    
    public Node getNext()
    {
        return next;
    }
    
    public void setPrev(Node p)
    {
        prev = p; 
    }
    
    public void setNext(Node n)
    {
        next = n;
    }
    
    public int getData()
    {
        return data;
    }
}
