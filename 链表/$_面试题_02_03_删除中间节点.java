package leetcode.链表;

/**
 * @author lin
 * @creat 2022--12--10:49
 */
public class $_面试题_02_03_删除中间节点 {
             public class ListNode {
                 int val;
                ListNode next;
                 ListNode(int x) {
                     val = x;
                 }
            }

    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        //不断遍历到下一个节点
        node.next=node.next.next;
    }
}
