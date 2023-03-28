import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    LinkedList<Integer> arr[];
    int V, E;

    public BreadthFirstSearch(int vertices){
        this.V = vertices;
        this.arr = new LinkedList[vertices];
        for(int i=0; i<vertices; i++){
            arr[i] = new LinkedList<>();
        }
    }

    public static void main(String args[]){
        BreadthFirstSearch bd = new BreadthFirstSearch(5);

        bd.addEdge(0,1);
        bd.addEdge(1,2);
        bd.addEdge(2,3);
        bd.addEdge(3,0);
        bd.addEdge(2,4);

        bd.bfs(0);
    }

    private void addEdge(int i, int j) {
        arr[i].add(j);
        arr[j].add(i);
        E++;
    }

    private void bfs(int s){
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;

        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u + " ");
            for(int i=0; i<arr[u].size(); i++){
                if(visited[arr[u].get(i)] == false){
                    q.add(arr[u].get(i));
                    visited[arr[u].get(i)] = true;
                }
            }
        }
    }
}
