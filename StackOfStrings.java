import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StackOfStrings {
    private class Node{
        String item;
        Node next;
    }
    Node first=null;
//    public StackOfStrings()                     //create an empty stack
//    {
//        first=new Node();
//    }
    public void push(String item)               //insert a new string
    {
        Node oldFirst=first;
        first=new Node();
        first.next=oldFirst;
        first.item=item;
    }
    public String pop()                         //remove and return the most recently added string
    {
        String item=first.item;
        first=first.next;
        return item;
    }
    public boolean isEmpty()                    //is the stack empty
    {
        return first==null;
    }
    public int size()                           //number of strings on the stack
    {
        return 0;
    }

    public static void main(String[] args) throws IOException{
	// write your code here
        BufferedReader br = new BufferedReader(new FileReader(new File("tobe.txt")));
        StackOfStrings stackOfStrings=new StackOfStrings();
        String line=br.readLine();
        String[] tokens=line.split("\\s+");
        for(int i=0;i<tokens.length;i++)
        {
            if(tokens[i].equals("-"))
            {
                System.out.println("Popped " + stackOfStrings.pop());
            }
            else
            {
                stackOfStrings.push(tokens[i]);
                System.out.println("Pushed "+tokens[i]);
            }
        }

    }
}
