import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ayush000 on 18/09/15.
 */
public class ResizingQueueOfStrings {
    private int first = 0;
    private int last = -0;
    private String[] s;

    private void resize(int capacity) {
        String[] copy = new String[capacity];
//        System.out.println("Before resize, s.length: "+s.length+", first: "+first+", last: "+last);
        System.arraycopy(s, first, copy, first - first, last - first);      // Alternative to using for loop to copy
        s = copy;
        last = last - first;
        first = 0;


//        System.out.println("After resize, s.length: "+s.length+", first: "+first+", last: "+last);
    }

    public ResizingQueueOfStrings() {
        s = new String[1];
    }

    private String dequeue() {
        String item = s[first];
        if (((last - first) == s.length / 4) && first > 0) {
            resize(s.length / 2);
        }
        s[first++] = null;
        return item;
    }

    private void enqueue(String item) {
        if (last == s.length) {
            resize(2 * s.length);
        }
        System.out.println("s.length is " + s.length);
        System.out.println("last is " + last);
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
                System.out.println("Popped " + rqueueOfStrings.dequeue());
            } else {
                rqueueOfStrings.enqueue(token);
                System.out.println("Pushed " + token);
            }
        }
    }


}




