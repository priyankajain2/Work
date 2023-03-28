import java.util.Stack;
import java.util.LinkedList;

public class depthFirstSearch {
    LinkedList<Integer> arr[];
    int V, E;

    public depthFirstSearch(int vertices){
        this.V = vertices;
        this.arr = new LinkedList[vertices];
        for(int i=0; i<vertices; i++){
            arr[i] = new LinkedList<>();
        }
    }

    public static void main(String args[]){
        depthFirstSearch bd = new depthFirstSearch(6);

        bd.addEdge(0,1);
        bd.addEdge(1,2);
        bd.addEdge(2,3);
        bd.addEdge(3,0);
        bd.addEdge(2,4);

        bd.dfs(0);
        System.out.println();
        bd.dfsRecursive();
    }

    private void dfsRecursive() {
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfs(i,visited);
            }
        }
    }

    private void dfs(int i, boolean[] visited) {
        visited[i] = true;
        System.out.print(i + " ");
        for(int u : arr[i]){
            if(!visited[u]){
                dfs(u,visited);
            }
        }
    }

    private void dfs(int i) {
        boolean visited[] = new boolean[V];
        Stack<Integer> s = new Stack<>();
        s.add(i);
        while(!s.isEmpty()){
            int u = s.pop();
            if(!visited[u]){
                visited[u] = true;
                System.out.print(u + " ");
                for(int v: arr[u]){
                    if(!visited[v]){
                        s.add(v);
                    }
                }
            }
        }
    }

    private void addEdge(int i, int j) {
        this.arr[i].add(j);
        this.arr[j].add(i);
        E++;
    }

    
}
