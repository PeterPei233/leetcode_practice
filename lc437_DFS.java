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
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        else return noJumpPath(root,sum)+pathSum(root.right,sum)+pathSum(root.left,sum);
    }
    public int noJumpPath(TreeNode root, int sum){
        if(root==null) return 0;
        else return noJumpPath(root.right,sum-root.val)+noJumpPath(root.left,sum-root.val)+ (root.val==sum?1:0);
    }
}