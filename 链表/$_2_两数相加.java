package leetcode.链表;

import java.util.Currency;

/**
 * @author lin
 * @creat 2022--12--12:30
 */
public class $_2_两数相加 {
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
     * 使用递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //total记录和
        int total=l1.val+l2.val;
        //next1记录十位数的值
        int next1=total/10;
        //res记录下当前要加入新链表中的节点（也就是个位数）
        ListNode res=new ListNode(total%10);
        if (l1.next!=null || l2.next!=null ||next1!=0){
            if (l1.next!=null){
                l1=l1.next;
            }else {//l1.next==null
                l1=new ListNode(0);
            }
            if (l2.next!=null){
                l2=l2.next;
            }else {//l2.next==null
                l2=new ListNode(0);
            }
            l1.val=l1.val+next1;
            res.next=addTwoNumbers(l1,l2);
        }
        return res;
    }

    /**
     * 使用非递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        //记录l1.val+l2.val的值
        int total=0;
        //记录十位上的值
        int next1=0;
        //创建一个新的链表存放新值
        ListNode res=new ListNode();
        //创建一个临时遍历来遍历新链表
        ListNode cur=res;
        while (l1!=null && l2!=null){
            total=l1.val+l2.val+next1;
            //res记录下个位的值
            cur.next=new ListNode(total%10);
            //记录十位的值
            next1=total/10;
            l1=l1.next;
            l2=l2.next;
            //cur不断指向下一个节点
            cur=cur.next;
        }
        while (l1!=null){//此时l2==null
            total=l1.val+next1;
            cur.next=new ListNode(total%10);
            next1=total/10;
            l1=l1.next;
            cur=cur.next;
        }
        while (l2!=null){//此时l1==null
            total=l2.val+next1;
            cur.next=new ListNode(total%10);
            next1=total/10;
            l2=l2.next;
            cur=cur.next;
        }
        if (next1!=0){//此时l1.next和l2.next为0
            cur.next=new ListNode(next1);
        }
        return res.next;
    }

}
