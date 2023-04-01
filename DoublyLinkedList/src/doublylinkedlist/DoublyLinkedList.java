
package doublylinkedlist;

public class DoublyLinkedList {
    
    public static void main(String[] args) {
        
        LinkedList myList = new LinkedList();
        
        myList.add(2);
        myList.printList();
        
        myList.add(5);
        myList.add(10);
        myList.printList();
        
        myList.removeData(10);
        myList.printList();
        
        myList.add(4);
        myList.add(5);
        myList.printList();
        
        myList.removeSingleData(5);
        myList.printList();
        
        System.out.print("\n\n\n");
        
        LinkedList otherList = new LinkedList();
        
        otherList.addLast(8);
        otherList.printList();
        
        otherList.addLast(9);
        otherList.addLast(10);
        otherList.printList();
        
        otherList.removeData(10);
        otherList.printList();
        
        otherList.addLast(8);
        otherList.add(4);
        otherList.printList();
        
        otherList.removeSingleData(8);
        otherList.printList();
    }
    
}
