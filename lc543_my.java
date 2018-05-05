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
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        diameterBST(root);
        return max;
    }
    public int height(TreeNode root){
        if(root==null) return 0;
        else{
            int cur = Math.max(height(root.left),height(root.right))+1;
            root.val = cur;
            return cur;
        }
    }
    public void diameterBST(TreeNode root){
        if(root==null||2*root.val<=max||root.val==1) return;
        else if(root.left==null){
            if(root.right.val>max) max = root.right.val;
            diameterBST(root.right);
        }
        else if(root.right==null){
            if(root.left.val>max) max = root.left.val;
            diameterBST(root.left);
        }
        else{
            int cur = root.left.val+root.right.val;
            if(cur>max) max =cur;
            diameterBST(root.left);
            diameterBST(root.right);
        }
    }
}