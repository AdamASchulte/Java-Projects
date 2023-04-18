package clockalg;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import clockalg.LinkedList;

public class CLOCKALG {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File inputFile = new File(args[3]);
        Scanner inputScanner = new Scanner(inputFile);

        File outputFile = new File(args[4]);
        FileWriter outputWriter = new FileWriter(outputFile);

        LinkedList clock = new LinkedList();

        int memorySpace = Integer.parseInt(args[0]);
        int swapInCost = Integer.parseInt(args[1]);
        int swapOutCost = Integer.parseInt(args[2]);

        int numReferences = 1;
        int totalReadFaults = 0;
        int totalWriteFaults = 0;
        long totalInCost = 0;
        long totalOutCost = 0;

        while (inputScanner.hasNext()) {
            String line = inputScanner.nextLine();
            String action = line.substring(0, 1);
            int pageNum = Integer.parseInt(line.substring(2, 3));
            StringBuffer printInfo = new StringBuffer(numReferences + ": " + action + " " + pageNum + " ");
            System.out.println(printInfo);

            // if (!clock.hasPage(pageNum)) // if page fault, do this
            // {
            // printInfo.append("F ");
            // totalInCost += swapInCost;
            // if (memorySpace < clock.getLength()) {
            // page bruh = new page(pageNum);
            // clock.addFirst(bruh);
            // printInfo.append("-1 " + swapInCost + " 0");
            // } else {
            // // select victim using algorithm, if page checked has ref bit = 1, set to 0.
            // if ref bit and mod bit = 0, it is victim
            // // swap victim and new page
            // // printInfo.append("victimpageNum" + " ")
            // // printInfo.append(swapInCost + " ")
            // // if modified: printInfo.append(swapOutCost)
            // // if not modified: printInfo.append("0")
            // totalOutCost += swapOutCost;
            // }

            // if (action.equals("R")) {
            // totalReadFaults += 1;
            // }

            // if (action.equals("W")) {
            // clock.getPage(pageNum).setMod();
            // totalWriteFaults += 1;
            // }
            // } else // if not a page fault do this
            // {
            // //check read/write, update bits
            // if(action.equals("R"))
            // {
            // clock.getPage(pageNum).setRef();
            // }
            // printInfo.append("H -1 0 0");

            // if(action.equals("W"))
            // {
            // clock.getPage(pageNum).setMod();
            // clock.getPage(pageNum).setRef();
            // }

            // }
            // System.out.println(printInfo);
            // numReferences++;
        }

        inputScanner.close();
        outputWriter.close();
    }

}
