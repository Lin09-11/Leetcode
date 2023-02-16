package leetcode.栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lin
 * @creat 2022--12--21:30
 */
public class $_94_二叉树的中序遍历 {
      public class TreeNode {
            int val;
             TreeNode left;
             TreeNode right;
            TreeNode() {}
            TreeNode(int val) {
                this.val = val;
            }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
             }
      }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        //当前结点指向根节点
        TreeNode cur=root;
        while (cur!=null || !stack.isEmpty()){//当根节点存在或者栈不为空
            if(cur!=null){
                //如果当前根结点存在，则将根节点存放在栈里
                stack.push(cur);
                //然后遍历左子树
                cur=cur.left;
            }else {//cur==null
                cur=stack.pop();
                //将当前的接待你存放进链表
                list.add(cur.val);
                //然后遍历右子树
                cur=cur.right;
            }
        }
        //最后返回链表
        return list;
    }
}
