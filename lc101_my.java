/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        if(root.left==null&&root.right==null) return true;
        else return symmetricNodes(root.left,root.right);
    }
    public static boolean symmetricNodes(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        else if(left==null||right==null) return false;
        else if(left.val!=right.val) return false;
        else return symmetricNodes(left.left,right.right)&&symmetricNodes(left.right,right.left);
    }
}