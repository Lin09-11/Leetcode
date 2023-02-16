package leetcode.栈;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lin
 * @creat 2022--12--21:54
 */
public class $_145_二叉树的后序遍历 {
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
    public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result=new ArrayList<>();
            postorder(root,result);
            return result;
    }

    public void postorder(TreeNode root,List<Integer> list){
            if(root==null){
                return;
            }
            postorder(root.left,list);
            postorder(root.left,list);
            list.add(root.val);//最后加入
    }
}
