
public class StackExercise {
    public static void main(String[] args)
    {
        ResizingQueueOfStrings<Integer> st=new ResizingQueueOfStrings<>();
        ResizingQueueOfStrings<Integer> q=new ResizingQueueOfStrings<>();
//        int[] outSeq={3, 6, 7, 5, 4, 2, 1, 9, 0, 8};
//        int[] outSeq={5, 4, 3, 2, 1, 0, 6, 7, 8, 9};
//        int[] outSeq={1, 0, 3, 5, 6, 4, 8, 7, 9, 2};
//        int[] outSeq={0, 4, 3, 5, 7, 2, 9, 8, 6, 1};

//        int[] outSeq={0, 5, 6, 1, 7, 8, 4, 9, 2, 3};
//        int[] outSeq={2, 5, 7, 8, 6, 9, 0, 1, 4, 3};
        int[] outSeq={0, 1, 2, 3, 4, 5, 6, 7, 9};
//        int[] outSeq={0, 1, 2, 3, 4, 5, 9, 7, 8, 6};
//        int[] outSeq={3, 4, 6, 9, 5, 8, 0, 2, 1, 7};
        for (int anOutSeq : outSeq) {
            q.enqueue(anOutSeq);
        }
        int out=q.dequeue();
        for(int i=0;i<10;i++)
        {
            st.enqueue(i);
            System.out.println("Enqd: " + i+", top: "+st.top());
            while (!st.isEmpty()&&out==st.top())
            {
//                System.out.println("DQd " + out);
//                System.out.println("Top: "+st.top());

//                System.out.println("DQd2 "+out);
                System.out.println(st.dequeue());
                if(st.isEmpty()&&q.isEmpty())
                {
                    break;
                }
                out=q.dequeue();
//                System.out.println("Oout: "+out);

            }
        }
//        System.out.println("Deq: "+st.pop());
    }
}
