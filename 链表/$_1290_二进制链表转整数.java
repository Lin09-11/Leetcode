package leetcode.链表;

/**
 * @author lin
 * @creat 2022--12--11:00
 */
public class $_1290_二进制链表转整数 {
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
    public int getDecimalValue(ListNode head) {
        if(head==null){
            return 0;
        }
        int res=0;
        while (head!=null){
            res=(res<<1)+head.val;
            head=head.next;
        }
        return res;
    }

}
