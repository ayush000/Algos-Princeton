import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ayush000 on 18/09/15.
 */
public class QueueOfStrings {
    private class Node {
        String item;
        Node next;
    }

    Node first = null;
    Node last = null;

    public QueueOfStrings()         //create empty queue
    {

    }

    public void enqueue(String item)           //insert a new string in queue
    {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (this.isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
    }

    public String dequeue()         //remove and return least recently used string
    {
        String item = first.item;
        first = first.next;

        if (this.isEmpty()) {
            last = null;
        }
        return item;
    }

    boolean isEmpty()               //is the queue empty?
    {
        return first == null;
    }

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new FileReader(new File("tobe.txt")));
        QueueOfStrings stackOfStrings = new QueueOfStrings();
        String line = br.readLine();
        String[] tokens = line.split("\\s+");
        for (String token : tokens) {
            if (token.equals("-")) {
                System.out.println("Popped " + stackOfStrings.dequeue());
            } else {
                stackOfStrings.enqueue(token);
                System.out.println("Pushed " + token);
            }
        }

    }
}
