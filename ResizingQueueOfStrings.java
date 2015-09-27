import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by ayush000 on 18/09/15.
 */
public class ResizingQueueOfStrings<Item> implements Iterable<Item> {
    private int first = 0;
    private int last = -0;
    private Item[] s;

    private void resize(int capacity) {
        Item[] copy = (Item[])new Object[capacity];
//        System.out.println("Before resize, s.length: "+s.length+", first: "+first+", last: "+last);
        System.arraycopy(s, first, copy, 0, last - first);      // Alternative to using for loop to copy
        s = copy;
        last = last - first;
        first = 0;


//        System.out.println("After resize, s.length: "+s.length+", first: "+first+", last: "+last);
    }

    public ResizingQueueOfStrings() {
        s = (Item[])new Object[1];
    }
    public boolean isEmpty()
    {
        return last<=first;
    }
    public Item top()
    {
        return s[first];
    }

    public Item dequeue() {
        Item item = s[first];
        if (((last - first) == s.length / 4) && first > 0) {
            resize(s.length / 2);
        }
        s[first++] = null;
        return item;
    }

    public void enqueue(Item item) {
        if (last == s.length) {
            resize(2 * s.length);
        }
//        System.out.println("s.length is " + s.length);
//        System.out.println("last is " + last);
        s[last++] = item;
    }

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new FileReader(new File("tobe.txt")));
        ResizingQueueOfStrings rqueueOfStrings = new ResizingQueueOfStrings();
        String line = br.readLine();
        String[] tokens = line.split("\\s+");
        for (String token : tokens) {
            if (token.equals("-")) {
//                System.out.println("Popped " + rqueueOfStrings.dequeue());
            } else {
                rqueueOfStrings.enqueue(token);
                System.out.println("Pushed " + token);
            }
        }
    }


    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }
    public class QueueIterator implements Iterator<Item>
    {
        private int current=first;

        @Override
        public boolean hasNext() {
            return first<=last;
        }

        @Override
        public Item next() {
            return s[current++];
        }
    }
}




