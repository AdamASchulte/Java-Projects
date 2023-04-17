package clockalg;

public class Node {
    private page data;
    private Node next;
    
    public Node(page p)
    {
        data = p;
    }
    
    public Node getNext()
    {
        return next;
    }

    public void setNext(Node n)
    {
        next = n;
    }
    
    public page getPage()
    {
        return data;
    }
}

