package leetcode;
public class TreeNode implements Cloneable{	
	    int val = 0;
	    
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	    
	    @Override
	    protected Object clone() throws CloneNotSupportedException {
	    // TODO Auto-generated method stub
	    return super.clone();
	    }
}
