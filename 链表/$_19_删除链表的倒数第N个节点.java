package leetcode.链表;

/**
 * @author lin
 * @creat 2023--01--11:16
 */
public class $_19_删除链表的倒数第N个节点 {
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
     * 方法一：快指针向走n+1步
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //创建虚拟节点
        ListNode dummyHead=new ListNode(0);
        //将虚拟链表和头节点连接起来
        dummyHead.next=head;

        //将快指针指向虚拟头节点
        ListNode fast=dummyHead;
        //将慢指针指向虚拟头节点
        ListNode slow=dummyHead;

        //因为快指针要比慢指针向走n+1个节点，所以先+1
        n++;

        //将快指针先走n+1步
        for (int i=0;i<n;i++){
            fast=fast.next;
        }
        //前面快指针先走完后，且当快指针不为空的时候，那快指针就要和慢指针一起走
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }

        //此时slow指向待删除节点的前一个节点
        slow.next=slow.next.next;
        return dummyHead.next;

    }

    /**
     * 方法二：快指针向走n步
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        //创建虚拟节点
        ListNode dummyHead=new ListNode(0);
        //将虚拟链表和头节点连接起来
        dummyHead.next=head;

        //将快指针指向虚拟头节点
        ListNode fast=dummyHead;
        //将慢指针指向虚拟头节点
        ListNode slow=dummyHead;

        //将快指针先走n步
        for (int i=0;i<n;i++){
            fast=fast.next;
        }

        //前面快指针先走完后，且当快指针不为空的时候，那快指针就要和慢指针一起走
        //因为快指针就快走n步，所以要判断的是fast.next是否为空，而不是fast==null
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        //此时slow指向待删除节点的前一个节点
        slow.next=slow.next.next;
        return dummyHead.next;

    }
}
