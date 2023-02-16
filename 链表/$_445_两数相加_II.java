package leetcode.链表;

import java.util.Stack;

/**
 * @author lin
 * @creat 2023--01--22:53
 */
public class $_445_两数相加_II {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //分别创建两个栈来存放链表的数值
            Stack<Integer> stack1 = new Stack<Integer>();
            Stack<Integer> stack2 = new Stack<Integer>();
            //分别将两个链表的值放入栈中
            while (l1 != null) {
                stack1.push(l1.val);
                //不断的遍历下一个值
                l1 = l1.next;
            }
            while (l2 != null) {
                stack2.push(l2.val);
                //不断的遍历下一个值
                l2 = l2.next;
            }
            //创建一个值查看是否要进位
            int next1 = 0;
            //创建一个指针指向新节点
            ListNode cur = null;
            //判断两个栈是否为空，如果不为空就出栈
            //为什么是“||”--因为可能一个先结束
            while (!stack1.isEmpty() || !stack2.isEmpty()) {
                //创建一个值来记录新链表的节点值
                int sum = 0;
                if (!stack1.isEmpty()) {
                    sum += stack1.pop();
                }
                if (!stack2.isEmpty()) {
                    sum += stack2.pop();
                }
                //当前的节点值是l1.val+l2.val+next1(是否进位）
                sum += next1;
                //创建一个新的节点存放新数值
                ListNode newNode = new ListNode(sum % 10);
                //next1表示是否要进位--就是十位数
                next1 = sum / 10;
                //将新节点往旧节点的前面插入---即：将新节点的next指向cur
                newNode.next = cur;
                //将cur指向新节点
                cur = newNode;
            }
            //最后要判断是否要进位，如果要进位就要新创建一个节点存放
            if (next1 != 0) {
                ListNode newNode1 = new ListNode(next1);
                newNode1.next = cur;
                cur = newNode1;
            }
            return cur;
        }
    }
}
