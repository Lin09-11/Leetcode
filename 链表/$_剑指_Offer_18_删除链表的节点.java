package leetcode.链表;

/**
 * @author lin
 * @creat 2023--01--17:48
 */
public class $_剑指_Offer_18_删除链表的节点 {
       public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) {
                 val = x;
             }
        }
    public ListNode deleteNode(ListNode head, int val) {
        //创建一个虚拟头节点
        ListNode dummyHead=new ListNode(-1);
        head=dummyHead.next;
        //让指针指向虚拟头节点
        ListNode pre=dummyHead;
        //判断当前链表是否为空
        while (pre.next!=null){
            if (pre.next.val==val){//此时指向的是头节点
                pre.next=pre.next.next;
            }else {//如果不是则就指向下一个元素接着查看
                pre=pre.next;
            }
        }
        return dummyHead.next;
    }
}
