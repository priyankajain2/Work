public class FindMaxInTree {

    private static TreeNode root;
    
    private class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    FindMaxInTree(){
        FindMaxInTree.root = null;
    }

    private void createTree() {
        TreeNode newNode = new TreeNode(1);
        TreeNode newNode1 = new TreeNode(9);
        TreeNode newNode2 = new TreeNode(3);
        TreeNode newNode3 = new TreeNode(4);
        TreeNode newNode4 = new TreeNode(5);

        root = newNode;
        root.left = newNode1;
        root.right = newNode2;
        newNode1.left = newNode3;
        newNode1.right = newNode4;
    }

    public static void main(String args[]){
        FindMaxInTree tr = new FindMaxInTree();
        tr.createTree();
        int result = Integer.MIN_VALUE;
        int max = tr.findMax(root, result);
        System.out.println("maximum is: "+ max);
    }


    private int findMax(TreeNode root, int result) {
        if(root == null){
            return result;
        }
        if(root.data > result){
            result = root.data;
        }
        result = findMax(root.left, result);
        result = findMax(root.right, result);

        return result;
    }
}
