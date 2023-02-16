package leetcode.链表;

import java.security.PrivateKey;
import java.util.function.Predicate;

/**
 * @author lin
 * @creat 2023--01--12:03
 */
public class $_面试题_17_12_BiNode {
       public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) {
              val = x;
          }
      }
    class Solution {

        private TreeNode pre;

        private TreeNode head;

        // BiNode
        public TreeNode convertBiNode(TreeNode root) {
            infixOrder(root);
            return head;
        }

        private void infixOrder(TreeNode node) {
            if (node == null) {
                return;
            }
            infixOrder(node.left);
            if (pre != null) {
                node.left = null;
                pre.right = node;
            } else {
                head = node;
            }
            pre = node;
            infixOrder(node.right);
        }
    }
}
