package leetcode.队列;

import java.util.Stack;

/**
 * @author lin
 * @creat 2022--12--20:47
 */
public class $_232_用栈实现队列 {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public $_232_用栈实现队列() {
        inStack=new Stack<>();
        outStack=new Stack<>();
    }

    //入队
    public void push(int x) {
        inStack.push(x);
    }

    //出队
    public int pop() {
        if(outStack.isEmpty()){//如果outStack为空，则将inStack弹出的弹入到outStack
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    //获取队头
    public int peek() {
        if(outStack.isEmpty()){//如果outStack为空，则将inStack弹出的弹入到outStack
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        //返回outStack中的栈顶元素
        return outStack.peek();
    }

    //判断是否为空
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
