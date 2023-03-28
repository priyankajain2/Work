import java.util.LinkedList;
import java.util.Queue;

public class InsertBinarySearchTree {

    private TreeNode root;
    
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

    InsertBinarySearchTree(){
        this.root = null;
    }

    public static void main(String args[]){
        InsertBinarySearchTree tr = new InsertBinarySearchTree();
        tr.insert(5);
        tr.insert(2);
        tr.insert(3);
        tr.insert(4);
        tr.insert(6);
        tr.insert(7);

        tr.levelOrder();
    }

    private void levelOrder() {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            TreeNode temp = qu.poll();
            System.out.print(temp.data + " ");
            if(temp.left != null){
                qu.add(temp.left);
            }
            if(temp.right != null){
                qu.add(temp.right);
            }
        }
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
