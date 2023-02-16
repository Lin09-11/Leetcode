package leetcode.链表;

import 链表.List;

/**
 * @author lin
 * @creat 2023--01--13:18
 */
public class $_92_反转链表II {

       public class ListNode {
          int val;
          ListNode next;
          ListNode(int val) {
              this.val = val;
          }
          ListNode(int val, ListNode next) {
              this.val = val;
              this.next = next;
          }
      }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //判断输入的m和n是否相等
        if (m==n) return head;
        //创建一个虚拟头节点
        ListNode dummy=new ListNode(-1);
        dummy.next=head;

        //创建一个指针指向虚拟节点
        ListNode pre=dummy;
        //分别创建两个指针指向m和n所在的位置
        ListNode m_node=head;
        ListNode n_node=head;

        //分别将两个指针指向m和n所在的位置
        for (int i=0;i<m;i++){
            //pre记得也要往下遍历
            pre=pre.next;
            m_node=m_node.next;
        }
        for (int i=0;i<n;i++){
            n_node=n_node.next;
        }
        //只要n和m没有指向同一个数值的时候，就要一直转换
        while (m_node!=n_node){
            /*1(pre)->2(m_node)->3->4(n_node)->5->null*/
            //1.先让1的next指向3
            pre.next=m_node.next;
            //2.让2的next指向5
            m_node.next=n_node.next;
            //3.让4的next指向2
            n_node.next=m_node;
            //4.改变m_node的指向，要求指向下一个数值（即下一个值---3）
            m_node=pre.next;
        }
        return dummy.next;
    }
}
