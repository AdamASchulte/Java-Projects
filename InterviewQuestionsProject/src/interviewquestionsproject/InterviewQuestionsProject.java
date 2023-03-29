// Adam Schulte
// 89-332-1700
// Misty Burrow

package interviewquestionsproject;

import java.io.*;
import java.util.*;

public class InterviewQuestionsProject {

    
    public static void main(String[] args) {

        System.out.println(isPalendrome("RaceCar"));
        System.out.println(isPalendrome("HelloWorld"));
        System.out.println(isPalendrome("W"));
        System.out.println("---------------");
        System.out.println(IsBalancedExpression("{()}(){()}"));
        System.out.println(IsBalancedExpression("{(})"));
        System.out.println(IsBalancedExpression("{(5 + 6) - (3 * 4)}"));
        System.out.println("---------------");
        System.out.println(EvaluateExpression("45+34*-"));
        System.out.println(EvaluateExpression("138*+"));
        System.out.println(EvaluateExpression("6+38*"));
        System.out.println(EvaluateExpression("65+38*7"));
    }
    
    public static boolean isPalendrome(String input)
    {
        char[] Chars = input.toCharArray();
        Stack<Character> myStack = new Stack<>();
        
        for(int i = 0; i < Chars.length; i++)
        {
            myStack.push(Chars[i]);
        }
        
        String reversed = "";
        
        for(int i = 0; i < Chars.length; i++)
        {
            reversed += myStack.pop();
        }
        
        if(reversed.equalsIgnoreCase(input))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean IsBalancedExpression(String input)
    {
        char[] Chars = input.toCharArray();
        Stack<Character> myStack = new Stack<>();
        
        char v;
        
        for(int i = 0; i < Chars.length; i++)
        {
            if(Chars[i] == ')')
            {
                if(myStack.empty())
                {
                    return false;
                }
                else
                {
                    v = myStack.pop();
                    if(v != '(')
                    {
                        return false;
                    }
                }
            }
            
            if(Chars[i] == '}')
            {
                if(myStack.empty())
                {
                    return false;
                }
                else
                {
                    v = myStack.pop();
                    if(v != '{')
                    {
                        return false;
                    }
                }
            }
            if(Chars[i] == '(')
            {
                myStack.push(Chars[i]);
            }
            if(Chars[i] == '{')
            {
                myStack.push(Chars[i]);
            }
        }
        if(myStack.empty())
        {
            return true;
        }
        return false;
    }
    
    public static int EvaluateExpression(String Expr)
    {
        char[] ExpChars = Expr.toCharArray();
        Stack<Integer> myStack = new Stack<>();
        
        int numOne = 0;
        int numTwo = 0;
        
        for(int i = 0; i < ExpChars.length; i ++)
        {
            if(Character.isDigit(ExpChars[i]))
            {
                myStack.push(Character.getNumericValue(ExpChars[i]));
            }
            else if(ExpChars[i] == '+')
            {
                if(myStack.size() < 2)
                {
                    System.out.println("Invalid Expression");
                    return 0;
                }
                
                numOne = myStack.pop();
                numTwo = myStack.pop();
                
                myStack.push(numTwo + numOne);
            }
            else if(ExpChars[i] == '-')
            {
                if(myStack.size() < 2)
                {
                    System.out.println("Invalid Expression");
                    return 0;
                }
                
                numOne = myStack.pop();
                numTwo = myStack.pop();
                
                myStack.push(numTwo - numOne);
            }
            else if(ExpChars[i] == '*')
            {
                if(myStack.size() < 2)
                {
                    System.out.println("Invalid Expression");
                    return 0;
                }
                
                 numOne = myStack.pop();
                 numTwo = myStack.pop();
                
                myStack.push(numTwo * numOne);
            }
            else if(ExpChars[i] == '/')
            {
                if(myStack.size() < 2)
                {
                    System.out.println("Invalid Expression");
                    return 0;
                }
                
                numOne = myStack.pop();
                numTwo = myStack.pop();
                
                myStack.push(numTwo / numOne);
            }
            else
            {
                System.out.println("Invalid Expression");
                return 0;
            }
        }
        
        if(myStack.size() > 1)
                {
                    System.out.println("Invalid Expression");
                    return 0;
                }
        return myStack.pop();
    }
    
}