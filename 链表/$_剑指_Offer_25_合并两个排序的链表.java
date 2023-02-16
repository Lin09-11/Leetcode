package leetcode.链表;

/**
 * @author lin
 * @creat 2023--01--18:44
 */
public class $_剑指_Offer_25_合并两个排序的链表 {
       public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
          }
      }

    /**
     * 定义虚拟头节点，改变了原链表，两条链，两个指针同时遍历
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        //定义虚拟头节点
        ListNode dummyHead=new ListNode(-1);
        //辅助指针--指向虚拟指针
        ListNode cur=dummyHead;
        while (l1!=null && l2!=null){
            //如果l1的值比l2的小，则将cur指向l1
            if (l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else {
                cur.next=l2;
                l2=l2.next;
            }
            //指针向后移动
            cur=cur.next;
        }
        //当l2或者l1有一个指针指向null的时候，要将另外一条不为空的接上去
        if (l1!=null){
            cur.next=l1;
        }
        if (l2!=null){
            cur.next=l2;
        }
        return dummyHead.next;
    }

}
