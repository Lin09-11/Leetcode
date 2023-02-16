package leetcode.链表;

/**
 * @author lin
 * @creat 2023--01--15:51
 */
public class $_剑指_Offer_06_从尾到头打印链表 {
       public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
         }
      }
    public int[] reversePrint(ListNode head) {
        ListNode node=head;
        int count=0;
        //遍历链表
        while (node!=null){
            count++;
            node=node.next;
        }
        //因为要求输出数组，所以要创建一个数组存放
        int[] nums=new int[count];
        node=head;
        for (int i=count-1;i>=0;i--){
            nums[i]=node.val;
            node=node.next;
        }
        return nums;
    }
}
