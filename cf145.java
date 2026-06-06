import java.util.Stack;

class cf145
{
    Stack<Integer> i = new Stack<Integer>();
    Stack<Integer> o = new Stack<Integer>();

    //Function to push an element in queue by using 2 stacks.
    void Push(int x)
    {
        i.push(x);
    }


    //Function to pop an element from queue by using 2 stacks.
    int Pop()
    {
        if(o.empty()){ //push all from s2 to s1 and return s1-pop
            while(!i.empty()){
                o.push( i.pop() );
            }
        }

        return (o.empty()) ? -1 : o.pop();
    }
}