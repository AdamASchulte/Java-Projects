package clock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Clock
{
    public static void main(String[] args)throws FileNotFoundException, IOException {
        File inputFile = new File(args[3]);
        Scanner inputScanner = new Scanner(inputFile);

        File outputFile = new File(args[4]);
        FileWriter outputWriter = new FileWriter(outputFile);
        LinkedList clock = new LinkedList();

        int memorySpace = Integer.parseInt(args[0]);
        int swapInCost = Integer.parseInt(args[1]);
        int swapOutCost = Integer.parseInt(args[2]);
        int numFree = memorySpace;

        int numReferences = 1;
        int totalReadFaults = 0;
        int totalWriteFaults = 0;
        long totalInCost = 0;
        long totalOutCost = 0;

        while (inputScanner.hasNext())
        {
            String line = inputScanner.nextLine();
            String action = line.substring(0, 1);
            int pageNum = Integer.parseInt(line.substring(2, 3));
            StringBuffer printInfo = new StringBuffer(numReferences + ": " + action + " " + pageNum + " ");
            numReferences++;
            Node temp = clock.getFirst();
            int victimPageNum = -1;

            if (!clock.hasPage(pageNum)) // if page fault, do this
            {
                printInfo.append("F ");
                totalInCost += swapInCost;
                if (numFree > 0) 
                {
                    page bruh = new page(pageNum);
                    clock.addLast(bruh);
                    printInfo.append("-1 " + swapInCost + " 0");
                    numFree--;
                    bruh.setRef(1);
                }
                else 
                {
                    boolean swappedPage = false;
                    int traversalNum = -1;
                    do {
                        if(temp.getPage().getRef() == 1)
                        {
                            temp.getPage().setRef(0);
                        }
                        else
                        {
                            if(temp.getPage().getMod() == 0)
                            {
                                victimPageNum = temp.getPage().getNum();
                                if(clock.getPage(victimPageNum).getMod() == 1)
                                    {
                                        totalOutCost += swapOutCost;
                                    }
                                temp.getPage().setData(pageNum);
                                swappedPage = true;
                                printInfo.append(victimPageNum + " " + swapInCost + " 0" );
                            }
                            else if(temp.getPage().getMod() == 1)
                            {
                                if(traversalNum > 0)
                                {
                                    victimPageNum = temp.getPage().getNum();
                                    if(clock.getPage(victimPageNum).getMod() == 1)
                                    {
                                        totalOutCost += swapOutCost;
                                    }
                                    temp.getPage().setData(pageNum);
                                    swappedPage = true;
                                    printInfo.append(victimPageNum + " " + swapInCost + " " + swapOutCost);
                                }
                            }
                        }
                        if(temp.getPage().getNum() == clock.getFirstPage().getNum())
                        {
                            traversalNum++;
                        }
                        temp = temp.getNext();
                        } while(!swappedPage);
                }

                if (action.equals("R")) 
                {
                    totalReadFaults += 1;
                    clock.getPage(pageNum).setRef(1);
                }
                if (action.equals("W")) 
                {
                    clock.getPage(pageNum).setMod(1);
                    totalWriteFaults += 1;
                }
            }
            else //not a page fault
            {
                printInfo.append("H -1 0 0");
                if(action.equals("W"))
                {
                    if(clock.getPage(pageNum).getMod() == 0)
                    {
                        clock.getPage(pageNum).setMod(1);
                    }
                    clock.getPage(pageNum).setRef(1);
                }

            }
            String yomama = printInfo.toString();
            outputWriter.write(yomama + "\n");
        }
        outputWriter.write("Total page references: " + --numReferences + "\n");
        outputWriter.write("Total read faults: " + totalReadFaults + "\n");
        outputWriter.write("Total write faults: " + totalWriteFaults + "\n");
        outputWriter.write("Total swap in cost: " + totalInCost + "\n");
        outputWriter.write("Total swap out cost: " + totalOutCost + "\n");

        inputScanner.close();
        outputWriter.close();
    }
}