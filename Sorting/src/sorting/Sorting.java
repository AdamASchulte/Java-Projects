
package sorting;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Sorting {

    
    public static void main(String[] args) {
        
        System.out.println("Enter array size");
        Scanner in = new Scanner(System.in);
        
        int size = in.nextInt();
        int[] array = new int[size];
        populateArray(array);
        
        long start = System.currentTimeMillis();
        BubbleSort(array);
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Bubble sort time: " + elapsed + " (ms) ");
        
        long start2 = System.currentTimeMillis();
        BubbleSortShortCircuit(array);
        long elapsed2 = System.currentTimeMillis() - start;
        System.out.println("Bubble sort short circuit time: " + elapsed2 + " (ms) ");
        
        long start3 = System.currentTimeMillis();
        selectionSort(array);
        long elapsed3 = System.currentTimeMillis() - start3;
        System.out.println("Selection sort time: " + elapsed3 + " (ms) ");
        
        long start4 = System.currentTimeMillis();
        insertionSort(array);
        long elapsed4 = System.currentTimeMillis() - start4;
        System.out.println("insertion sort time: " + elapsed4 + " (ms) ");
       // printArray(array);
        
        
       
        
    }
    
    public static void BubbleSort(int[] array)
    {
        for(int i = 0; i < array.length-1; i++)
        {
            for(int j = 0; j < array.length-1-i; j++)
            {
                if(array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    
    public static void printArray(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + ", ");
        }
    }
    
    public static void populateArray(int[] array)
    {
        Random rand = new Random();
        
        for(int i =0; i < array.length; i++)
        {
            array[i] = rand.nextInt(1001);
        }
    }
    
    public static void BubbleSortShortCircuit(int[] array)
    {
        for(int i = 0; i < array.length-1; i++)
        {
            boolean swap = false;
            for(int j = 0; j < array.length-1-i; j++)
            {
                if(array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swap = true;
                }
            }
            if(!swap)
            {
                break;
            }
        }
    }

    public static void selectionSort(int[] array)
    {
        int j;
        for (int i = 0; i < array.length - 1; i++)
        {
            int minIndex = i;
            
            for(j = i + 1; j < array.length; j++)
            {
               if(array[j] < array[minIndex])
                {
                   minIndex = j; 
                }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = array[minIndex];
            }   
        }
    }
    
    public static void insertionSort(int[] array){
        int i, key, j;
        for(i = 1; i < array.length; i++)
        {
            key = array[i];
            j = i - 1;
            
            while(j >= 0 && array[i] > key)
            {
                array[j+1] = array[i];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
    
    public static void JavaSort(int[] array)
    {
        Arrays.sort(array);
    }
    
    public static void mergeSort(int[] array) {
        if (array.length < 2)
            return;
        int mid = array.length / 2;
        int[] l = new int[mid];
        int[] r = new int[array.length - mid];
        for (int i = 0; i < mid; i++)
        {
            l[i] = array[i];
        }
        for (int i = mid; i < array.length; i++)
        {
            r[i - mid] = array[i];
        }
            mergeSort(l);
            mergeSort(r);
            merge(array, l, r, mid, array.length - mid);
    }
    
    public static void merge(int[] array, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                array[k] = l[i];
                i++;
            }
            else {
                array[k] = r[j];
                j++;
            }
            k++;
        }
        while (i < left)
            array[k++] = l[i++];
        while (j < right)
            array[k++] = r[j++];
    }
    
    public static int linearSearch(int[] array, int target)
    {
        for(int i = 0; i<array.length; i++)
        {
            if(target == array[i])
                return i;
        }
        return -1;
    }
    
    public static int binarySearch(int[] a, int target){
        int min = 0;
        int max = a.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (a[mid] < target) {
                min = mid + 1;
            }
            else if (a[mid] > target) {
                max = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}

    
   
