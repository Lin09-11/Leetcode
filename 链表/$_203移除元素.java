package leetcode.链表;

import org.w3c.dom.Node;


/**
 * @author lin
 * @creat 2022--12--20:09
 * https://leetcode.cn/problems/remove-linked-list-elements/
 *
 */
public class $_203移除元素 {
    public class ListNode {
        int val;
       ListNode next;
       ListNode() {

       }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
}
    /**
     * 不添加虚拟节点方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @param val
     * @return
     */
//方法一：不设虚拟结点
    public ListNode removeElements(ListNode head, int val) {
            while (head != null && head.val == val)
                head = head.next;
            ListNode prev = head;
            if (prev != null)
            {
                while (prev.next != null)
                {
                    if (prev.next.val == val)
                        prev.next = prev.next.next;
                    else
                        prev = prev.next;
                }
            }
            return head;
        }
//方法二：使用递归
    public ListNode removeElements2(ListNode head, int val) {
        if(head==null){//只有一个元素
            return head;
        }
        //当不至有一个元素的时候，就不断的指向下一个元素
        head.next=removeElements2(head.next,val);
        return head.val==val?head.next:head;
    }

    /**
     * 添加虚节点方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @param val
     * @return
     */
    //3.使用虚拟头节点
    public ListNode removeElements3(ListNode head,int val){
        if(head==null){
            return head;
        }
        //因为删除可能使用到头节点，所以使用虚拟头节点，设置虚拟头节点为dummy head
        ListNode dummyHead=new ListNode(-1,head);
        ListNode pre=dummyHead;
        ListNode cur=head;
        while (cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
            }else {
                pre=cur;
            }
            cur=cur.next;
        }
        //返回头节点
        return dummyHead;
    }
}
