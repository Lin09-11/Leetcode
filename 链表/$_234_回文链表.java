package leetcode.链表;

/**
 * @author lin
 * @creat 2023--01--15:01
 */
public class $_234_回文链表 {
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

    /**
     * 双指针+反转链表
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 快指针走两步，慢指针走一步，快指针走到尾巴，则慢指针走了刚好一般
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 如果快指针不为null，则表示是奇数个
        if (fast != null) {
            slow = slow.next;
        }
        // 反转链表
        ListNode after = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = after;
            after = slow;
            slow = temp;
        }
        fast = head;
        // 遍历正反链表，对比数据
        while (fast != null && after != null) {
            if (fast.val != after.val) {
                return false;
            }
            fast = fast.next;
            after = after.next;
        }
        return true;
    }
}
