package leetcode.链表;

/**
 * @author lin
 * @creat 2022--12--14:09
 */
public class $_61_旋转链表 {
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next==null ){//判断当链表为空或者只有一个节点
            return head;
        }
        //创建一个临时节点
        ListNode cur=head;
        //保存链表长度--初始化为1
        int length=1;
        while (cur.next!=null){//使用cur不断遍历链表
            length++;
            cur=cur.next;
        }
        //此时的k是记录下每一个数应该移动的位数
        k=k%length;
        //使用两个指针分别指向新链表的尾节点和新链表的头节点
        //新链表的头节点--初始化指向头节点
        ListNode newHead=head;
        //指向新链表的尾节点--初始化指向头节点
        ListNode newTail=head;
        //创建一个变量来记录当前遍历到的旧链表的下标
        int index=0;
        while (newHead.next!=null){//如果
            if(index<k){//如果此时index小于要指向节点的下标，则要不断的向下遍历
                newHead=newHead.next;
                index++;
            }else {//index>=k的时候
                newHead=newHead.next;
                newTail=newTail.next;
                index++;
            }
        }
        //将原来的头节点赋值新头节点的下一个节点
        newHead.next=head;
        //将原来的头节点赋值给新的头节点
        head=newTail.next;
        //将新的尾节点的next置位空
        newTail.next=null;
        //返回头节点
        return head;
    }
}
