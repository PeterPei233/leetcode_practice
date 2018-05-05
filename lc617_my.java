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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null) return t2;
        merge(t1,t2,null,true);
        return t1;
    }
    // flag = true left child else right
    public void merge(TreeNode t1, TreeNode t2,TreeNode p , boolean flag){
        if(t1==null&&t2==null) return;
        if(t1==null){
            if(flag) p.left = t2;
            else p.right = t2;
        }
        else if(t2!=null){
            t1.val +=t2.val;
            merge(t1.left, t2.left,t1,true);
            merge(t1.right, t2.right,t1,false);
        }
    }
}