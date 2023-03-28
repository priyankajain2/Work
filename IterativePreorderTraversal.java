import java.util.Stack;

public class IterativePreorderTraversal {
    
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

    public static void main(String args[]){
        IterativePreorderTraversal tr = new IterativePreorderTraversal();

        tr.createTree();
        iterativePreorder(root);
    }

    private static void iterativePreorder(TreeNode root2) {
        if(root == null){
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            System.out.print(temp.data + " ");
            if(temp.right != null){
                st.push(temp.right);
            }
            if(temp.left != null){
                st.push(temp.left);
            }
        }

    }
}
