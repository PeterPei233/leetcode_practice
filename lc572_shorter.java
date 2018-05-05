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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null) return false;
        if(s.val == t.val){
            if(equals(s,t)) return true;
        }
        return isSubtree(s.left,t)||isSubtree(s.right,t);
    }
    public boolean equals(TreeNode s, TreeNode t){
        if(s==null || t==null) return s==t;
        if(s.val!=t.val) return false;
        else return equals(s.left,t.left)&&equals(s.right,t.right);
    }    
}