import java.util.LinkedList;

public class GraphsAsList {

    LinkedList<Integer> arr[];
    int V, E;

    public GraphsAsList(int vertices){
        this.arr = new LinkedList[vertices];
        this.V = vertices;
        this.E = 0;
        for(int i=0; i<vertices; i++){
            arr[i] = new LinkedList<>();
        }
    }

    private void addEdge(int i, int j) {
        arr[i].add(j);
        arr[j].add(i);
        E++;
    }

    private void print() {
        for(int i=0; i<V; i++){
            System.out.print(i + ": ");
            for(int W=0; W< arr[i].size(); W++){
                System.out.print(arr[i].get(W) +  " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        GraphsAsList g = new GraphsAsList(4);

        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);

        g.print();
    }
}
