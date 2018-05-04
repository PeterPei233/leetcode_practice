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
    int count = 0;
    public TreeNode convertBST(TreeNode root) {
          if(root!=null){
            convertBST(root.right);
            count +=root.val;
            root.val = count;
            convertBST(root.left);            
        }
        return root;
    }
}