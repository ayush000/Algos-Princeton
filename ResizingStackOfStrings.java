import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by ayush000 on 17/09/15.
 */
public class ResizingStackOfStrings<Item> implements Iterable<Item> {
    private Item[] s;
    private int N = 0;

    public ResizingStackOfStrings() {
        s = (Item[])new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[])new Object[capacity];
        System.arraycopy(s, 0, copy, 0, N);
        s = copy;
    }

    public void push(Item item) {
        if (N == s.length) {
            resize(2 * s.length);
        }
        s[N++] = item;
    }

    public Item pop() {
        s[N] = null;
//        System.out.println("Length is "+s.length+", s[0] is "+s[0]);
        if (N > 0 && N == s.length / 4) {

            resize(s.length / 2);
        }
        return s[--N];
    }


    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new FileReader(new File("tobe.txt")));
        ResizingStackOfStrings<String> stackOfStrings = new ResizingStackOfStrings<String>();
        String line = br.readLine();
        String[] tokens = line.split("\\s+");
        for (String token : tokens) {
            if (token.equals("-")) {
                System.out.println("Popped " + stackOfStrings.pop());
            } else {
                stackOfStrings.push(token);
                System.out.println("Pushed " + token);
            }
        }
        System.out.println("Printing Stack");
//        System.out.println("N: "+N+", elem[N]: "+s[N]);
        for(String s:stackOfStrings)
        {
            System.out.println(s);
        }

    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    public class ReverseArrayIterator implements Iterator<Item>
    {
        private int current=N;

        @Override
        public boolean hasNext() {
            return current>0;
        }

        @Override
        public Item next() {
//            System.out.println("Current: "+current);
//            current=current-2;
            return s[--current];
//            return s[1];
        }

        @Override
        public void remove() {

        }
    }
}
