package dynamicarray;
public class DynArr {
    
    private int l = 0;
    private int[] arr = new int[1];
    private int numElements = 0;
    
    
    //constructors: can instantiate a DynArr with or without a predetermined size
    public DynArr(int size)
    {
        l = size;
    }
    public DynArr(){}
    
    
    // allows user to add an element to the next available index of a DynArr
    public void add(int element)
    {
        if(l == 0)
        {
            arr[0] = element;
            l = 1;
        }
        else if(arr.length == 1 && checkFull())
        {
            int temp = arr[1 - 1];
            arr = new int[5];
            arr[0] = temp;
            arr[1] = element;
            l = 5;
        }
        else if(checkFull())
        {
            int tempIndex = l;
            this.doubleSize();
            arr[tempIndex] = element;
        }
        else
        {
            arr[numElements] = element;
        }
        numElements++;
    }
    
    //allows a user to add an array to the end of the DynArr
    public void add(int[] addArr)
    {
        for(int j = 0; j < addArr.length; j++)
        {
            add(addArr[j]);
        }
    }
    public void replace(int newElement, int index)
    {
        if(index >= 0 && index <= l - 1)
        {
            arr[index] = newElement;
        }
        else
        {
            System.out.println("Invalid index");
        }
    }
    
    //checks if every element in a DynArr was set by a user
    public boolean checkFull(){
        if(l == numElements)
        {
            return true;
        }
        return false;
    }
    
    //prints the elements of a DynArr comma separated
    public void printDynArr()
    {
        if(l != 0)
        {
            for(int i = 0; i < numElements; i++)
            {
                System.out.print(arr[i] + ", ");
            }
            System.out.println();
        }
        else
        {
            System.out.println("This DynArr is empty");
        }
    }
    
    // not finished, wont change the size
    public void resize(int size)
    {
        l = size;
        if(size > 0 && size > l)
        {
            
        }
        else if(size > 0){
            int[] temp = arr;
            int[] arr = new int[size];
            for(int i = 0; i < size; i++)
            {
                arr[i] = temp[i];
            }
        }
        else if(size == 0)
        {
            int[] arr = new int[0];
        }
        else
        {
            System.out.println("Inavlid DynArr size. Must be greater than 0");
        }
    }
    
    //calls quickSort on the DynArr to allow user to conveniently sort the DynArr
    public void DynArrSort()
    {
        quickSort(0, numElements - 1);
    }
    
    //every time the DynArr is full and a user wants to add more elements, the DynArr doubles its size and refills itself with the previous DynArr's contents
     private void doubleSize()
    {
        int[] temp = arr;
        arr = new int[l * 2];
        for(int i = 0; i < l; i++)
        {
            arr[i] = temp[i];
        }
        l = l * 2;
    }
     
     //basic quickSort algorithm
    private void quickSort(int left, int right)
    {
        if(left < right)
        {
            int p = partition(arr, left, right);
            if(left < p)
            {
                quickSort(left, p);
            }
            if(p+1 < right)
            {
                quickSort(p+1, right);
            }    
        }
    }
    
    //swaps and partitions the array to sort
    private static int partition(int[] nums, int left, int right)
    {
        int pivot = nums[left];
        int i = left - 1;
        int j = right + 1;
        while(i < j)
        {
            i++;
            while(nums[i] < pivot)
            {
                i++;
            }
            j--;
            while(nums[j] > pivot)
            {
                j--;
            }
            if(i < j)
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return j;
    }
}


