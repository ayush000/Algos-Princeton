
public class Shuffling {
    public void linearShuffle(Comparable[] a)
    {
        for(int i=0;i<a.length;i++)
        {

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
}
