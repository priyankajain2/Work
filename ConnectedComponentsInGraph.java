import java.util.LinkedList;

public class ConnectedComponentsInGraph {
    LinkedList<Integer> arr[];
    int V, E;
    boolean visited[];
    int compID[];
    int count;

    public ConnectedComponentsInGraph(int vertices){
        this.V = vertices;
        this.visited = new boolean[V];
        compID = new int[V];
        count=0;
        this.arr = new LinkedList[vertices];
        for(int i=0; i<vertices; i++){
            arr[i] = new LinkedList<>();
        }
    }

    public static void main(String args[]){
        ConnectedComponentsInGraph bd = new ConnectedComponentsInGraph(6);

        bd.addEdge(0,1);
        bd.addEdge(1,2);
        bd.addEdge(2,3);
        bd.addEdge(3,0);
        bd.addEdge(2,4);

        bd.dfs();

        boolean check = bd.checkIfConnectedOrNot(2,4);
        System.out.println("check if " + 2 + " and " + 4 + " are connected or not? " + check);
    }

    private boolean checkIfConnectedOrNot(int i, int j) {
        return compID[i] == compID[j];
    }

    private void dfs() {
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                dfs(arr,i);
                count++;
            }
        }
    }

    private void dfs(LinkedList<Integer>[] arr, int i) {
        visited[i] = true;
        compID[i] = count;
        for(int W : arr[i]){
            if(!visited[W]){
                dfs(arr,W);
            }
        }
    }

    private void addEdge(int i, int j) {
        this.arr[i].add(j);
        this.arr[j].add(i);
        E++;
    }

}
