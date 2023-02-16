package leetcode.链表;

import org.w3c.dom.Node;

/**
 * @author lin
 * @creat 2022--12--22:52
 */
public class $_21_合并两个有序链表 {
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

            if(list1==null){
                return list2;
            }
            if(list2==null){
                return list1;
            }
            //定义新的节点用于形成链表
            ListNode node=new ListNode();
            //用来遍历
            ListNode temp=node;
            while (list1!=null && list2!=null){
                if(list2.val>=list1.val){//通过比较，将较小的值拼接到node上，并且将该链表后移一位
                    temp.next=list1;
                    list1=list1.next;
                }else if(list2.val< list1.val){
                    temp.next=list2;
                    list2=list2.next;
                }
                //node后移一位，指向尾节点
                temp=temp.next;
                //当一条链表遍历结束，则直接让node.next指向另外一条链表的空余，因为原本链表是升序
                if(list1==null){
                    temp.next=list2;
                    return node.next;
                }
                if(list2==null){
                    temp.next=list1;
                    //返回初始节点
                    return node.next;
                }
            }
            return node.next;
    }
}
