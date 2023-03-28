import java.util.Stack;

public class PostOrderTraversalOfTree {

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
        PostOrderTraversalOfTree tr = new PostOrderTraversalOfTree();
        tr.createTree();
        tr.recursiveWay(root);
        System.out.println();
        tr.iterativeWay();

    }

    private void iterativeWay() {
        if(root == null){
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(!st.isEmpty() || curr != null){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }else{
                TreeNode temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    System.out.print(temp.data + " ");
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        System.out.print(temp.data + " ");
                    }
                }else{
                    curr = temp;
                }
            }
        }
    }

    private void recursiveWay(TreeNode root) {
        if(root == null){
            return;
        }
        recursiveWay(root.left);
        recursiveWay(root.right);
        System.out.print(root.data + " ");
    }
}
