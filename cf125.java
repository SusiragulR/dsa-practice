import java.util.Stack;

public class cf125 {
    int minEle;
    Stack<Integer> s;

    // Constructor
    cf125()
    {
        minEle=Integer.MAX_VALUE;
    }

    /*returns min element from stack*/
    int getMin()
    {
        s.push(minEle);
        return s.pop();
    }

    /*returns popped element from stack*/
    int pop()
    {
        return s.pop();
    }

    /*push element x into the stack*/
    void push(int x)
    {
        if(x<minEle) minEle=x;
        else s.push(x);
    }
}
