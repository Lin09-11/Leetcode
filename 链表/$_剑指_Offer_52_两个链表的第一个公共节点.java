package leetcode.链表;

/**
 * @author lin
 * @creat 2023--01--11:30
 */
public class $_剑指_Offer_52_两个链表的第一个公共节点 {
       public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headB==null || headA==null){
            return null;
        }
        ListNode n1=headA;
        ListNode n2=headB;
        while (n1!=n2){
            n1=n1==null ? headB:n1.next;
            n2=n2==null ? headA:n2.next;
        }
        return n1;
    }
}
