package leetcode.链表;

/**
 * @author lin
 * @creat 2022--12--11:17
 *
 * https://leetcode.cn/problems/delete-node-in-a-linked-list/
 */
public class $_237删除链表中的节点 {

     public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public void deleteNode(ListNode node) {

         //1.将待删除节点的下一个节点覆盖待删除节点的位置
         node.val=node.next.val;
         //2.将待删除节点的next指向下一个节点的下一个节点
        node.next=node.next.next;
    }
}
