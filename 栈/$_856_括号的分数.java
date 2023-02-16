package leetcode.栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author lin
 * @creat 2022--12--20:42
 * https://leetcode.cn/problems/score-of-parentheses/
 *
 */

/**
 stack
 定义：一个左括号 存储的是 自己本身 及其 内部的括号序列的值
 计算： 当我们遇到左括号的时候 入栈 当我们遇到右括号的时候 出栈 然后计算
 如果 我们匹配到是一个简单的括号序列 那么我们算1 并且把这个结果赋值给一个虚拟括号
 如果 匹配到一个复杂的括号序列 那么结果应该是原来序列的2倍 并且将结果赋值给一个虚拟括号
 举例：（ 3）=3*2=6
 */
public class $_856_括号的分数 {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack=new ArrayDeque<>();
        //添加额外的0
        stack.push(0);

        //用于计算当前的值
        int score=0;

        for(int i=0;i<s.length();i++){//遍历字符串
            if(s.charAt(i)=='('){//如果检测到是左括号则将其进栈
                stack.push(0);
            }else {//如果检测到是右括号则将其进栈
                //pop.peek()--pop.top()
                score=stack.peek()==0?1:2*stack.pop();//如果是简答括号则直接+1，如果是复杂则2倍
                stack.pop();//将对应的'('出栈
                stack.push(stack.peek()==0?score:score+stack.pop());//将score入栈
            }
        }
            return stack.peek();
    }
}
