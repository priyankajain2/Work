public class GraphsAsMatrix {

    int matrix[][];
    int V,E;

    public GraphsAsMatrix(int vertices){
        this.matrix = new int[vertices][vertices];
        V = vertices;
        E = 0;
    }

    private void addEdge(int i, int j) {
        this.matrix[i][j] = 1;
        this.matrix[j][i] = 1;
        E++;
    }

    private void print() {
        for(int i=0; i<V; i++){
            for(int j=0; j<E; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        GraphsAsMatrix g = new GraphsAsMatrix(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(0,3);
        g.addEdge(2,3);
        
        g.print();
    }
}
