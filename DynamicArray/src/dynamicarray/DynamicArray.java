
package dynamicarray;

public class DynamicArray {
    
    public static void main(String[] args) {
        DynArr ex = new DynArr();
      
        ex.printDynArr();
        
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
        
        myDynArr.resize(6);
        myDynArr.printDynArr();
    }
    
}
