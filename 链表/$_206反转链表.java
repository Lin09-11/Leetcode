package leetcode.链表;


/**
 * @author lin
 * @creat 2022--12--12:50
 *
 * https://leetcode.cn/problems/reverse-linked-list/
 */
public class $_206反转链表 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
       ListNode(int val) {
            this.val = val;
        }
       ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //方法一：使用递归的方式进行反转

    public ListNode reverse(ListNode pre,ListNode cur){
        if (cur==null){//终止遍历的条件就是cur==null
            return pre;//返回新链表的头节点
        }
        ListNode temp=null;
        temp=cur.next;//记录下一个节点的位置
        //改变链表的方向
        cur.next=pre;
        //更新pre和cur的位置
        //pre=cur;
        //cur=temp;
        return reverse(cur,temp);
    }

    public ListNode reverseList(ListNode head) {
        //这里为什么传入的是null,head
        //因为初始化pre是指向头节点的前面，cur指向头节点
        return reverse(null,head);
    }

    //方法二：使用双指针
    public ListNode reverseList2(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        ListNode temp=cur.next;
        while (cur!=null){
            temp=cur.next;//保存下一个节点，要不然找不到
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


