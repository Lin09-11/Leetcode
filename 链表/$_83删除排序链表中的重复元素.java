package leetcode.链表;

/**
 * @author lin
 * @creat 2022--12--21:00
 *
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 */
public class $_83删除排序链表中的重复元素 {
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next==null) {
            return head;
        }
        if (head.val == head.next.val) {
            head = deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}
