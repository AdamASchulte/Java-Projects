package clockalg;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class CLOCKALG
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        File inputFile = new File(args[3]);
        Scanner inputScanner = new Scanner(inputFile);
        
        File outputFile = new File(args[4]);
        FileWriter outputWriter = new FileWriter(outputFile);
        
        LinkedList clock = new LinkedList();

        while(inputScanner.hasNext())
        {
            String line = inputScanner.nextLine();
            String action = line.substring(0,1);
            String pageNum = line.substring(2,3);

            if(action.equals("R"))
            {
                
            }


            System.out.print(action + " ");
            System.out.println(pageNum);


        }
        

        inputScanner.close();
        outputWriter.close();
    }
    
}
