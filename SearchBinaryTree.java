public class SearchBinaryTree {
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

    SearchBinaryTree(){
        this.root = null;
    }

    public static void main(String args[]){
        SearchBinaryTree tr = new SearchBinaryTree();
        tr.insert(5);
        tr.insert(2);
        tr.insert(3);
        tr.insert(4);
        tr.insert(6);
        tr.insert(7);

        TreeNode node = tr.searchBinaryTree(10);
        if(node == null){
            System.out.println("not found");
        }else{
            System.out.println("found it");
        }
    }

    private TreeNode searchBinaryTree(int i) {
        return searchTree(root,i);
    }

    private TreeNode searchTree(TreeNode root, int i) {
        if(root == null || root.data == i){
            return root;
        }else{
            if(i < root.data){
                return searchTree(root.left, i);
            }else{
                return searchTree(root.right, i);
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
