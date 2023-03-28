import java.util.Stack;

public class InorderTraversalOfTree {
    
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
        InorderTraversalOfTree tr = new InorderTraversalOfTree();
        tr.createTree();
        recursiveInorder(root);
        System.out.println();
        iterativeInOrder(root);
    }

    private static void iterativeInOrder(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode temp = root;
        while(!st.isEmpty() || temp!=null){
            if(temp != null){
                st.push(temp);
                temp = temp.left;
            }else{
                temp = st.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    private static void recursiveInorder(TreeNode root) {
        if(root == null){
            return;
        }else{
            recursiveInorder(root.left);
            System.out.print(root.data + " ");
            recursiveInorder(root.right);
        }
    }

}
