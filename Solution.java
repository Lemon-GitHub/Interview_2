package Interview_2;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if((p == null && q != null) || (p != null && q == null)){
            return false;
        }
        //两棵非空树
        if(p.val != q.val){
            return false;
        }
        return (isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        //两棵空树 true
        if(s == null && t == null){
            return true;
        }
        //一棵空树 一棵非空 false
        if(s == null || t == null){
            return false;
        }
        //两棵非空树
        boolean ret = false;
        if (s.val == t.val) {
            ret = isSameTree(s, t);
        }
        //  b) 递归的判定一下, t 是否被 s 的左子树包含
        if (!ret) {
            ret = isSubtree(s.left, t);
        }
        //  c) 递归的判定一下, t 是否被 s 的右子树包含
        if (!ret) {
            ret = isSubtree(s.right, t);
        }
        return ret;
    }
}
