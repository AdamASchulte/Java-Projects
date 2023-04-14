package clockalg;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class CLOCKALG
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        File inputFile = new File(args[3]);
        Scanner inputScanner = new Scanner(inputFile);
        
        File outputFile = new File(args[4]);
        FileWriter outputWriter = new FileWriter(outputFile);
        
        char[][] info = new char[0][];
    }
    
}
