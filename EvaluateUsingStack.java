/**
 * Created by ayush000 on 20/09/15.
 */
public class EvaluateUsingStack {
    public static void main(String[] args)
    {
        String input="1+((2+3)*(4*5)))";
        GenericStack<Character> ops=new GenericStack<>();
        GenericStack<Integer> vals=new GenericStack<>();
        for (int i=0;i<input.length();i++)
        {
            if(input.charAt(i)=='(');
            else if(input.charAt(i)=='*'||input.charAt(i)=='+') ops.push(input.charAt(i));
            else if(input.charAt(i)==')')
            {
                int x=vals.pop();
                int y=vals.pop();
                char op=ops.pop();
                if(op == '+')  vals.push(x+y);
                else vals.push(x*y);
            }
            else vals.push(Integer.parseInt(input.charAt(i)+""));

        }
        System.out.println(vals.pop());
    }
}
