public class RecursivePreorderTraversalOfTree {

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

    public static void main(String aargs[]){
        RecursivePreorderTraversalOfTree tr = new RecursivePreorderTraversalOfTree();

        tr.createTree();
        recursivePreOrder(root);
    }

    private static void recursivePreOrder(TreeNode root) {
        if(root == null){
            return;
        }else{
            System.out.print(root.data + " ");
            recursivePreOrder(root.left);
            recursivePreOrder(root.right);
        }
    }

    private void createTree() {
        TreeNode newNode = new TreeNode(1);
        TreeNode newNode1 = new TreeNode(2);
        TreeNode newNode2 = new TreeNode(3);
        TreeNode newNode3 = new TreeNode(4);
        TreeNode newNode4 = new TreeNode(5);

        root = newNode;
        root.left = newNode1;
        root.right = newNode2;
        newNode1.left = newNode3;
        newNode1.right = newNode4;
    }
}
