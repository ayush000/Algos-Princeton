import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Math.*;

/**
 * Created by swarn on 23/09/15.
 */
public class Sorting {
    public static boolean isSorted(Comparable[] a){


        //assume is sorted, attempt to prove otherwise

        for(int i = 0; i < a.length-1; i ++){ //because we are always comparing to the next one and the last one doesn't have a next one we end the loop 1 earlier than usual

            if (less(a[i+1],a[i])) {
                return false; //proven not sorted
            }

        }

        return true; //got to the end, must be sorted
    }
    public void insertSort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                } else break;
            }
        }
    }

    public void selectSort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public void shellSort(Comparable[] a)
    {
        int N=a.length;
        int h=1;
        while (h<N/3)
        {
            h=3*h+1;
        }
        while (h>=1) {
        for (int i = h; i < a.length; i++) {
            for (int j = i; j >= h; j-=h) {
                if (less(a[j], a[j - h])) {
                    exch(a, j, j - 1);
                } else break;
            }
        }
            h=h/3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        Integer[] a = new Integer[100000];
        for(int i=0;i<100000;i++)
        {
            a[i]= (int) (Math.random() * 10001);
        }
        long avg=0;
//        for(int i=0;i<5;i++) {
            long startTime = System.currentTimeMillis();
            Sorting ins = new Sorting();
            ins.selectSort(a);
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
//            avg+=totalTime;
//        }
//        for (Integer anA : a) {
//            System.out.println(anA);
//        }
        System.out.println("The array is sorted: "+isSorted(a));

        System.out.println("Time taken: "+totalTime);

    }
}
