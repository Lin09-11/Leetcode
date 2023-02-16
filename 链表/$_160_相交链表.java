package leetcode.链表;

/**
 * @author lin
 * @creat 2022--12--23:25
 */
public class $_160_相交链表 {
     public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
             val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         //分别创建2个指针来遍历链表
        ListNode curA=headA;
        ListNode curB=headB;
        //分别创建两个变量来记录2个链表的长度
        int lengthA=0;
        int lengthB=0;
        while (curA!=null){//求链表A的长度
            curA=curA.next;
            lengthA++;
        }
        while (curB!=null){//求链表B的长度
            curB=curB.next;
            lengthB++;
        }
        curA=headA;
        curB=headB;
        //让curA为最长链表的头，lengthA为其长度
        //如果本来链表A就为最长的链表，则不用进入
        if (lengthB>lengthA){
            //1.交换两个链表的长度
            int tempLength=lengthA;
            lengthA=lengthB;
            lengthB=tempLength;
            //2.交换两个链表
            ListNode tempNode=curA;
            curA=curB;
            curB=tempNode;
        }
        //求长度差
        int len=lengthA-lengthB;
        //让curA和curB在同一个起点，则将链表A不断的向下遍历
        while (len-->0){
            curA=curA.next;
        }
        //不断的遍历curA和curB，直到遇到相同就返回
        while (curA!=null){
            if (curA==curB){
                return curA;
            }
            //如果找不到curA==curB，则一直往下遍历
            curA=curA.next;
            curB=curB.next;
        }
        return null;
    }
}
