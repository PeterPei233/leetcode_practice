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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        return build(preorder,inorder,0,0,preorder.length);
    }
    TreeNode build(int[] preorder,int[] inorder,int in_begin,int pre_begin,int len){
        if(len == 0) return null;
        if(len == 1){
            return new TreeNode(preorder[pre_begin]);
        }
        int mid = 0;
    x:    for(;;pre_begin++){
            for(int  i= in_begin;i<in_begin+len;i++){
                if(preorder[pre_begin]==inorder[i]){
                    mid = i;
                    break x;
                }
            }
        }
        TreeNode root = new TreeNode(inorder[mid]);
        int length =  mid-in_begin;
        root.left = build(preorder,inorder,in_begin,pre_begin+1,length);
        if(length==0) pre_begin--;
        root.right = build(preorder,inorder,mid+1,pre_begin+2,len-length-1);
        return root;
        
    }
}