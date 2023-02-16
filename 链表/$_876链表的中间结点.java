package leetcode.链表;

/**
 * @author lin
 * @creat 2022--12--21:28
 *
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 */
public class $_876链表的中间结点 {
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
     }

    public ListNode middleNode(ListNode head) {
          //使用快慢指针
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        return slow;
    }
}
