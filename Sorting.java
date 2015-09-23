import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by swarn on 23/09/15.
 */
public class Sorting {
    public void insertSort(Comparable[] a)
    {
        for(int i = 0;i<a.length;i++)
        {
            for (int j=i;j>0;j--)
            {
                if(less(a[j],a[j-1]))
                {
                    exch(a,j,j-1);
                }
                else break;
            }
        }
    }
    public void selectSort(Comparable[] a)
    {
        for (int i = 0;i < a.length;i++)
        {
            int min=i;
            for(int j = i; j<a.length;j++)
            {
                if(less(a[j],a[min]))
                {
                    min=j;
                }
            }
            exch(a,i,min);
        }
    }
    private boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)<0;
    }
    private void exch(Comparable[] a, int i, int j)
    {
        Comparable temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void main(String[] args) throws IOException {
        Integer[] a={1,2,34,5,21,5,12,2,2143};
        Sorting ins=new Sorting();
        ins.selectSort(a);
        for (Integer anA : a) {
            System.out.println(anA);
        }

    }
}
