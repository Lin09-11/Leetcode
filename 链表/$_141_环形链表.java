package leetcode.链表;

import java.awt.*;

/**
 * @author lin
 * @creat 2022--12--16:37
 *
 * https://leetcode.cn/problems/linked-list-cycle/
 */
public class $_141_环形链表 {

    class ListNode {
       int val;
       ListNode next;
         ListNode(int x) {
           val = x;
             next = null;
         }
    }
    public boolean hasCycle(ListNode head) {

        if(head==null || head.next==null)
            return false;

        //1.创建快慢指针

        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null && fast.next!=null){
            if(fast==slow){
                return true;
            }
            //慢指针一次走一步
            slow=slow.next;
            //快指针一次走2步
            fast=fast.next.next;
        }
        return false;
    }

}
