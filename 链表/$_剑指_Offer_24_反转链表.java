package leetcode.链表;

/**
 * @author lin
 * @creat 2023--01--18:11
 */
public class $_剑指_Offer_24_反转链表 {
        public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
          }
      }

    public ListNode reverseList(ListNode head) {
            ListNode pre=null;
            ListNode cur=head;
            while (cur!=null){
                ListNode temp=cur.next;//保存下一个节点，要不然找不到
                //将链表方向进行改变
                cur.next=pre;
                //将cur赋值给pre
                pre=cur;
                //将temp赋值给cur
                cur=temp;
            }
            //返回新链表的头节点，此时cur指向null
            return pre;
        }
    }

