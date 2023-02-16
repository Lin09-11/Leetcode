package leetcode.双指针;

/**
 * @author lin
 * @creat 2023--01--19:59
 */
public class $_142_环形链表 {
       class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
      }

    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null && fast.next!=null){//因为fast一次走两步，所以要判断当前和下一个是否为空
            //如果不为空，则fast一次走2步，slow一次走1步
            fast=fast.next.next;
            slow=slow.next;
            //判断是否有环---他们一定在环中相遇
            if (slow==fast){
                ListNode index1=fast;//或者ListNode index1=slow;---用于记录fast和slow相遇的位置
                /*创建一个新的节点指向头节点，然后让index1和index2往前走，直到相遇点就是环的入口*/
                ListNode index2=head;
                while (index2!=index1){
                    //当index1和index2没有相遇时，两者都一直往前走
                    index1=index1.next;
                    index2=index2.next;
                }
                return index1;//return index2;
            }
        }
        return null;
    }
}
