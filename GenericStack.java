import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class GenericStack <Item> implements Iterable<Item>{
    @Override
    public Iterator<Item> iterator() {
        return new ListIter();
    }

    private class ListIter implements Iterator<Item>{

        private Node current=first;

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            Item item=current.item;
            current=current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    private class Node{
        Item item;
        Node next;
    }
    Node first=null;
    //    public StackOfStrings()                     //create an empty stack
//    {
//        first=new Node();
//    }
    public void push(Item item)               //insert a new string
    {
        Node oldFirst=first;
        first=new Node();
        first.next=oldFirst;
        first.item=item;
    }
    public Item pop()                         //remove and return the most recently added string
    {
        Item item=first.item;
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
    public Item top()
    {
        return first.item;
    }

    public static void main(String[] args) throws IOException{
        // write your code here
        BufferedReader br = new BufferedReader(new FileReader(new File("tobe.txt")));
        GenericStack<String> stackOfStrings=new GenericStack<>();
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
        for(String s:stackOfStrings)
        {
            System.out.println(s);
        }

    }
}
