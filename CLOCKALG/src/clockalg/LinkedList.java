package clockalg;

public class LinkedList {
    private Node first;
    private Node last;

    public LinkedList()
    {
        
    }
    
    public LinkedList(page data)
    {
        first = new Node(data);
    }

    public void addFirst(page data)
    {
        if(first == null)
        {
            first = new Node(data);
            first.setNext(first);
        }
        else if(last == null)
        {
            last = new Node(data);
            last.setNext(first);
            first.setNext(last);
        }
        else
        {            
            Node temp = first;
            first = new Node(data);
            first.setNext(temp);
            last.setNext(first);
        }
    }

    public void addLast(page data)
    {
        if(first == null)
        {
            first = new Node(data);
            first.setNext(first);
        }
        else if(last == null)
        {
            last = new Node(data);
            first.setNext(last);
            last.setNext(first);
        }
        else 
        {
            Node temp = last;
            last = new Node(data);
            temp.setNext(last);
            last.setNext(first);
        }
    }

    public void removePage(int pageNumber)
    {
        boolean notDeleted = true;
        Node x = first;
        Node prev = null;
        do {
            if(x.getPage().getNum() == pageNumber && x != first && x != last)
            {
                prev.setNext(x.getNext());
                notDeleted = false;
            }
            else if(x.getPage().getNum() == pageNumber && x == first)
            {
                first = x.getNext();
                last.setNext(first);
                notDeleted = false;
            }
            else if(x.getPage().getNum() == pageNumber && x == last)
            {
                last = prev;
                last.setNext(first);
                notDeleted = false;
            }
            prev = x;
            x = x.getNext();
        } while(x != first && notDeleted);
        if(notDeleted)
        {
            System.out.println("No data match, nothing deleted");
        }
    }

    public page getPage(int pgNum)
    {
        if(first == null)
        {
            System.out.println("No pages added to list");
            return null;
        }
        Node x = first;
        do {
            if(x.getPage().getNum() == pgNum)
            {
                return x.getPage();
            }
            x = x.getNext();
        } while(x != first);

        System.out.println("Page not Found");
        return null;
    }

    public boolean hasPage(int pgNumber)
    {
        if(first == null)
        {
            return false;
        }
        else
        {
            Node x = first;
            do {
                if(x.getPage().getNum() == pgNumber)
                {
                    return true;
                }
                x = x.getNext();
            } while(x != first);
        }

        return false;
    }

    public int getLength()
    {
        if(first == null)
        {
            return 0;
        }
        int i = 0;
        Node x = first;
        do {
            i++;
            x = x.getNext();
        } while(x != first);
        return i;
    }

}
