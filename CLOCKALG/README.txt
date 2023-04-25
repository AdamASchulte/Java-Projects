Adam Schulte
Chen 4103
Last update: 04/24/2023
To compile: javac *.java
To run: java ClockAlg <memory space> <swap in cost> <swap out cost> <inputfileName> <outputFileName>
sample run: java ClockAlg 3 10 20 input.txt output.txt

This project is fully implemented. The class LinkedList may or may not have extra useless functions. I used my own design for a linked list that I have on my own gitHub. 
Essentially, I created a page class that stores the modbit and refbit, a Node class that stores pages, and a LinkedList class that stores Nodes. I like to have the 
LinkedList class to make it easier to use, but I know it's not entirely necessary. It might be more confusing because of the sheer amound of self made functions.

The only problem my program might have as far as I can tell is logical errors. Someone showed us what their program was outputting, and it was using different logic than mine,
but I believe I am using the correct logic. Ref bits are updated to 1 upon first entry to the list, and upon a read call. The ref bit can be set back to 0 when the page is being 
traversed during the victim selection. Mod bit is updated to 1 upon a write call and cannot be set back to 0. my program will not select a victim with a 0 ref bit and 1 mod bit 
on the first traversal, but will select the first case of 0 ref bit and 0 mod bit on the second traversal. There cannot be more than 2 traversals in my implementation. A victim 
can only be a page with ref bit 0 and mod bit 0 on the first traversal, and can be a page with ref bit 0 and mod bit 1 on the second traversal. No ref bit can be 1 on the second traversal.