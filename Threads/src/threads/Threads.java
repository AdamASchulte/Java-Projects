
package threads;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Threads {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        File sudokuFile = new File(args[0]);
        Scanner sudokuScanner = new Scanner(sudokuFile);
        
        File outputFile = new File(args[1]);
        FileWriter fw = new FileWriter(outputFile);
        
        int[][] sudokuBoard = new int[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++)
            {
                sudokuBoard[i][j] = sudokuScanner.nextInt();
            }
        }
        
        int[] validRows = {0,0,0,0,0,0,0,0,0};
        int[] validColumns = {0,0,0,0,0,0,0,0,0};
        int[] validSquares = {0,0,0,0,0,0,0,0,0};
        
        RowThread myRowThread = new RowThread();
        myRowThread.run(sudokuBoard, validRows, fw);
        
        ColumnThread myColumnThread = new ColumnThread();
        myColumnThread.run(sudokuBoard, validColumns, fw);
        
        SquareThread mySquareThread = new SquareThread();
        mySquareThread.run(sudokuBoard, validSquares, fw);
        
        int numValidRows = 0;
        int numValidColumns = 0;
        int numValidSquares = 0;
        
        for(int y = 0; y < 9; y++)
        {
            numValidRows += validRows[y];
            numValidColumns += validColumns[y];
            numValidSquares += validSquares[y];
        }
        
        fw.write("Valid rows: " + numValidRows + "\n");
        fw.write("Valid columns: " + numValidColumns + "\n");
        fw.write("Valid subgrids: " + numValidSquares + "\n");
        
        int totalValids = numValidRows + numValidColumns + numValidSquares;
        if(totalValids == 27)
        {
            fw.write("This Sudoku solution is: Valid\n");
        }
        else{
            fw.write("This Sudoku solution is: Invalid\n");
        }
        
        fw.close();
    }
}

class RowThread extends Thread {
    public void start(int[][] sudokuBoard, int[] validRows, FileWriter fw) throws FileNotFoundException, IOException{
        run(sudokuBoard, validRows, fw);
    }
    public void run(int[][] sudokuBoard, int[] validRows, FileWriter fw) throws FileNotFoundException, IOException{
        int[] row = new int[9];
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                row[j] = sudokuBoard[i][j];
            }
            Arrays.sort(row);
            boolean isValid = true;
            int k = 0;
            while(isValid && k < 9)
            {
                if(row[k] != k + 1)
                {
                    isValid = false;
                }
                k++;
            }
            int rowNum = i + 1;
            if(isValid)
            {
                validRows[i] = 1;
                fw.write("[Thread 1] Row " + rowNum + ": Valid\n");
            }
            else
            {
                fw.write("[Thread 1] Row " + rowNum + ": InValid\n");   
            }
        }
    }
}

class ColumnThread extends Thread{
     public void start(int[][] sudokuBoard, int[] validColumns, FileWriter fw) throws FileNotFoundException, IOException{
        run(sudokuBoard, validColumns, fw);
    }
    public void run(int[][] sudokuBoard, int[] validColumns, FileWriter fw) throws FileNotFoundException, IOException{
        int[] column = new int[9];
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                column[j] = sudokuBoard[j][i];
            }
            Arrays.sort(column);
            boolean isValid = true;
            int k = 0;
            while(isValid && k < 9)
            {
                if(column[k] != k + 1)
                {
                    isValid = false;
                }
                k++;
            }
            int colNum = i + 1;
            if(isValid)
            {
                validColumns[i] = 1;
                fw.write("[Thread 2] Column " + colNum + ": Valid\n");
            }
            else
            {
                fw.write("[Thread 2] Column " + colNum + ": InValid\n");   
            }   
        }
    }
}

class SquareThread extends Thread{
    public void start(int[][] sudokuBoard, int[] validSquares, FileWriter fw) throws FileNotFoundException, IOException{
        run(sudokuBoard, validSquares, fw);
    }
    public void run(int[][] sudokuBoard, int[] validSquares, FileWriter fw) throws FileNotFoundException, IOException{
        int[] square = new int[9];
        for (int h = 0; h < 3; h++) 
        {
            for (int k = 0; k < 3; k++) 
            {
                for (int i = 0; i < 3; i++) 
                {
                    for (int j = 0; j < 3; j++) 
                    {
                        square[(i * 3) + j] = sudokuBoard[(h * 3) + i][(3 * k + j)];
                    }
                }
                
                Arrays.sort(square);
                boolean isValid = true;
                int x = 0;
                while(isValid && x < 9)
                {
                    if(square[x] != x + 1)
                    {
                        isValid = false;
                    }
                    x++;
                }
                if(isValid)
                {
                    validSquares[(h * 3) + k] = 1;
                    fw.write("[Thread 3] SubGrid " + "R"  + (1 + h * 3) + (2 + h * 3) + (3 + h * 3) + "C" + (1 + k * 3) + (2 + k * 3) + (3 + k * 3) + ": Valid\n");
                    
                }
                else
                {
                    fw.write("[Thread 3] SubGrid " + "R"  + (1 + h * 3) + (2 + h * 3) + (3 + h * 3) + "C" + (1 + k * 3) + (2 + k * 3) + (3 + k * 3) + ": InValid\n");   
                }
            }
        }
    }
}

