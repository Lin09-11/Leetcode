package leetcode.链表;

/**
 * @author lin
 * @creat 2022--12--22:17
 */
public class $_24_两两交换链表中的节点 {
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
     * 使用虚拟节点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
           //创建一个虚拟头节点
        ListNode dummyNode = new ListNode(0);
        //将头节点的next指向头节点
        dummyNode.next = head;
        //将定义一个临时变量来遍历
        ListNode prev = dummyNode;

        while (prev.next != null && prev.next.next != null) {//如果后面没有2个元素，则反转结束
            ListNode temp = head.next.next; // 缓存 next
            prev.next = head.next;          // 将 prev 的 next 改为 head 的 next
            head.next.next = head;          // 将 head.next(prev.next) 的next，指向 head
            head.next = temp;               // 将head 的 next 接上缓存的temp
            prev = head;                    // 步进1位
            head = head.next;               // 步进1位
        }
        return dummyNode.next;
    }

    public ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null) return head;
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairs(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;

        return next;
    }
}
