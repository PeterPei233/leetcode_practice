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
        Map<Integer,Integer> res = new HashMap<>();
        for(int i =0;i<inorder.length;i++) res.put(inorder[i],i);
        
        return build(preorder,inorder,0,0,preorder.length,res);
    }
    TreeNode build(int[] preorder,int[] inorder,int in_begin,int pre_begin,
                   int len,Map<Integer,Integer> res){
        if(len == 0) return null;
        if(len == 1){
            return new TreeNode(preorder[pre_begin]);
        }
        int mid = res.get(preorder[pre_begin]);
        TreeNode root = new TreeNode(inorder[mid]);
        int length =  mid-in_begin;
        root.left = build(preorder,inorder,in_begin,pre_begin+1,length,res);
        // the begin of the new preorder should be related to the length of the left part
        root.right = build(preorder,inorder,mid+1,pre_begin+length+1,len-length-1,res);
        return root;
        
    }
}