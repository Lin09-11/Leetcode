package leetcode.链表;

/**
 * @author lin
 * @creat 2022--12--9:59
 */
public class $_2181_合并零之间的节点 {
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

    public ListNode mergeNodes(ListNode head) {
             //创建一个新的链表
            ListNode node=new ListNode(-1);
            //创建一个当前节点遍历链表
            ListNode cur=node;
            //新的一个数值
            int sum=0;
            //不断的往下遍历
            head=head.next;
            while (head!=null){//判断头节点不为空
                if(head.val!=0){
                    sum+=head.val;
                }else {//head.val==0
                    cur.next=new ListNode(sum);
                    cur=cur.next;
                    sum=0;
                }
                head=head.next;
            }
            return cur.next;
    }
}
