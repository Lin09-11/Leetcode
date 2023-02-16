package leetcode.栈;

import 链表.ArrayList;
import 链表.List;

/**
 * @author lin
 * @creat 2022--12--21:46
 */
public class $_144_二叉树的前序遍历 {
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

        public List<Integer> preorderTraversal(TreeNode root){
             List<Integer> result=new ArrayList<Integer>();
             preorder(root,result);//调用函数
            return result;
        }
        public void preorder(TreeNode root,List<Integer> result){
             if(root==null){
                 return;
             }
             //如果根节点不为空，则将根节点的数值加入
             result.add(root.val);
             preorder(root.left,result);
             preorder(root.right,result);
        }

}
