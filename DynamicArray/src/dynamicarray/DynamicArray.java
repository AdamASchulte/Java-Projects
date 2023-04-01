
package dynamicarray;

public class DynamicArray {
    
    public static void main(String[] args) {
        DynArr ex = new DynArr();
        ex.remove();
        ex.printDynArr();
        ex.removeIndex(0);
        
        ex.add(1);
        ex.printDynArr();
        
        
        DynArr myDynArr = new DynArr(1);
        
        myDynArr.add(50);
        myDynArr.add(30);
        myDynArr.add(45);
        myDynArr.add(8);
        myDynArr.add(31);
        myDynArr.DynArrSort();
        myDynArr.printDynArr();
        
        
        
        myDynArr.replace(27, 4);
        myDynArr.printDynArr();
        
        myDynArr.add(70);
        myDynArr.printDynArr();
        
        
        myDynArr.DynArrSort();
        myDynArr.printDynArr();
        
        
        int[] temp = {5, 6, 7, 8, 9};
        myDynArr.add(temp);
        myDynArr.printDynArr();
        
        myDynArr.shrink(6);
        myDynArr.printDynArr();
        
        myDynArr.shrink(5);
        myDynArr.printDynArr();
        
        myDynArr.remove();
        myDynArr.printDynArr();
        
        myDynArr.removeIndex(1);
        myDynArr.printDynArr();
        
        myDynArr.add(19);
        myDynArr.printDynArr();
        
        System.out.println(myDynArr.getNumElements());
    }
    
}
