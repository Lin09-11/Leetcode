package leetcode.链表;

/**
 * @author lin
 * @creat 2023--01--21:17
 */
public class $_328_奇偶链表 {
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
    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        //创建一个节点指向第一个节点（奇数节点）
        ListNode odd=head;
        //创建一个节点指向第二个节点（偶数节点）
        ListNode even=head.next;
        //创建一个指针指向第一个节点，因为最后奇数节点链表的最后一个节点指向偶数链表的第一个节点
        ListNode evenHead=head.next;

        //要判断偶数的下一个节点还存不存在
        while (even!=null && even.next!=null){
            //1.将奇数的next指向偶数的下一个节点
            odd.next=even.next;
            //2.将奇数的指针移动到下一个奇数上
            odd=odd.next;
            //3.偶数的next将指向新的奇数指针的下一个位置上
            even.next=odd.next;
            //4.将偶数的指针移动到下一个偶数上
            even=even.next;
        }
        //将奇数链表和偶数链表连接起来
        odd.next=evenHead;
        //因为第一个元素就是奇数链表的第一个节点
        return head;
    }
}
