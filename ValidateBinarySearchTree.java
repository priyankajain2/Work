public class ValidateBinarySearchTree {
    
    private static TreeNode root;
    
    private class TreeNode{
        int data;
        TreeNode right;
        TreeNode left;

        TreeNode(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    ValidateBinarySearchTree(){
        this.root = null;
    }

    public static void main(String args[]){
        ValidateBinarySearchTree tr = new ValidateBinarySearchTree();
        tr.insert(5);
        tr.insert(2);
        tr.insert(3);
        tr.insert(4);
        tr.insert(6);
        tr.insert(7);

        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        boolean state = tr.validateTree(root,min,max);
        System.out.println("valid binary search tree or not: " + state);
    }

    

    private boolean validateTree(TreeNode root, long min, long max) {
        if(root == null){
            return true;
        }
        if(root.data <= min || root.data >= max){
            return false;
        }
        boolean leftValid = validateTree(root.left, min, root.data);
        if(leftValid){
            boolean rightValid = validateTree(root.right, root.data, max);
            return rightValid;
        }
        return false;
    }

    public void insert(int value){
        root = insertHelp(root,value);
    }

    public TreeNode insertHelp(TreeNode root, int i) {
        if(root == null){
            root = new TreeNode(i);
            return root;
        }else{
            if(i < root.data){
                root.left = insertHelp(root.left, i);
            }else {
                root.right = insertHelp(root.right, i);
            }
        }
        return root;
    }
}
