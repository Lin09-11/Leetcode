package leetcode.链表;

/**
 * @author lin
 * @creat 2022--12--11:11
 */
public class _剑指_Offer_22_链表中倒数第k个节点 {
        public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) {
                 val = x;
             }
        }
    public ListNode getKthFromEnd(ListNode head, int k) {
        //利用双指针
        ListNode fast=head;
        while (fast!=null){//如果头节点不为空
            fast=fast.next;
            if(k==0){
                head=head.next;
            }else {
                //因为从尾到头
                k--;
            }
        }
        return head;
    }
}
