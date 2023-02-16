package leetcode.链表;

import javax.swing.*;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author lin
 * @creat 2023--01--20:26
 */
public class $_82删除排序链表中的重复元素 {
       public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) {
             this.val = val;
         }
         ListNode(int val, ListNode next) {
             this.val = val;
             this.next = next;
         }
     }

    public ListNode deleteDuplicates(ListNode head) {
           if (head==null && head.next==null)//判断当前链表是否为空
                return head;
            //创建一个虚拟头节点
            ListNode dummyHead=new ListNode(0);
            dummyHead.next=head;
            //创建pre指针指向虚拟头节点
            ListNode pre=dummyHead;
            //创建tail指针指向头节点（也就是在dummyHead的后一个位置）
            ListNode tail=pre.next;
            while (tail.next!=null){//判断第二个节点是否为空
                while (tail.val==tail.next.val){//此时第一个节点的值跟第二个节点的值相等。则将指针向下继续遍历
                    tail=tail.next;
                }
                if(tail.next==pre.next) {//此时判断的是第三个节点和第一个节点的值是否相等，如果相等则指针接着向下遍历
                    tail = tail.next;
                }else {//此时tail.next！=pre.next（也就是第三个节点和第一个节点的值不相等
                       // 说明后面没有相同的元素，就可以将pre和tail之间的值删除，并使得pre指向第四个节点
                    pre.next=tail.next;
                }
            }
            return dummyHead.next;
        }
}
