import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalOfTree {

    private TreeNode root;
    
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

    LevelOrderTraversalOfTree(){
        this.root = null;
    }

    public static void main(String args[]){
        LevelOrderTraversalOfTree tr = new LevelOrderTraversalOfTree();
        tr.createTree();
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
