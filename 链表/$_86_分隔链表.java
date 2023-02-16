package leetcode.链表;

/**
 * @author lin
 * @creat 2023--01--12:18
 */
public class $_86_分隔链表 {
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
    public ListNode partition(ListNode head, int x) {
        //创建两个链表，一个存放小于x，一个存放大于等于x的
        ListNode lowerNode=new ListNode(-1);
        ListNode highNode=new ListNode(-1);
        //创建两个指针分别指向这两个链表
        ListNode lowerHead=lowerNode;
        ListNode highHead=highNode;
        //看头节点的下一个节点是否为空
        while (head!=null){
            if (head.val<x){//如果当前这个值是小于x，则将其存放在lowNode这个链表中
                lowerNode.next=head;
                lowerNode=lowerNode.next;
            }else {//如果当前这个值是大于或等于x，则将其存放在highNode这个链表中
                highNode.next=head;
                highNode=highNode.next;
            }
            //原来的链表的指针向后移动
            head=head.next;
        }
        //将小于x的链表拼接到大于或等于x的链表前面
        lowerNode.next=highHead.next;
        //大于或者等于x链表的最后一个节点的next指向Null
        highNode.next=null;
        return lowerHead.next;
    }
}
