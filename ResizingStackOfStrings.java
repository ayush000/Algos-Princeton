import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ayush000 on 17/09/15.
 */
public class ResizingStackOfStrings {
    private String[] s;
    private int N = 0;

    public ResizingStackOfStrings() {
        s = new String[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    public void push(String item) {
        if (N == s.length) {
            resize(2 * s.length);
        }
        s[N++] = item;
    }

    public String pop() {
        s[N] = null;
        if (N > 0 && N == s.length / 4) {
            resize(s.length / 2);
        }
        return s[--N];
    }

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new FileReader(new File("tobe.txt")));
        ResizingStackOfStrings stackOfStrings = new ResizingStackOfStrings();
        String line = br.readLine();
        String[] tokens = line.split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("-")) {
                System.out.println("Popped " + stackOfStrings.pop());
            } else {
                stackOfStrings.push(tokens[i]);
                System.out.println("Pushed " + tokens[i]);
            }
        }

    }
}
