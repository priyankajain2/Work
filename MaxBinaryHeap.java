public class MaxBinaryHeap {
    static int[] heap;
    static int n;

    public MaxBinaryHeap(int capacity){
        heap = new int[capacity + 1];
        n=0;
    }
    
    public boolean isEmpty(){
        return n==0;
    }

    public int size(){
        return n;
    }

    public static void main(String args[]){
        MaxBinaryHeap hp = new MaxBinaryHeap(3);
        System.out.println(hp.isEmpty());
        System.out.println(hp.size());

        hp.insert(4);
        hp.insert(5);
        hp.insert(2);
        hp.insert(6);
        hp.insert(1);
        hp.insert(3);
        int deleted = MaxBinaryHeap.deleteMax();
        System.out.println("deleted element is:" + deleted );

        printHeap(hp.size());
    }

    private static int deleteMax() {
        int max = heap[1];
        swap(1,n);
        n--;
        topDownReheap(1);

        if(n>0 && n==(heap.length-1)/2){
            resize(heap.length/2);
        }

        return max;
    }

    private static void topDownReheap(int i) {
        while(2*i <= n){
            int j = 2*i;
            if(j<n && heap[j] < heap[j+1]){
                j++;
            }
            if(heap[i] >= heap[j]){
                break;
            }
            swap(i,j);
            i=j;
        }
    }

    private static void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private static void printHeap(int j) {
        for(int i=1; i<=j; i++){
            System.out.print(heap[i]  + " ");
        }
        System.out.println();
    }

    private void insert(int i) {
        if(n == heap.length - 1){
            resize(2*heap.length);
        }
        n++;
        heap[n] = i;
        bottomDownHeap(n);
    }

    private void bottomDownHeap(int k) {
        while(k>1 && heap[k/2] < heap[k]){
            int temp = heap[k/2];
            heap[k/2] = heap[k];
            heap[k] = temp;
            k=k/2; //bcz we need to continue till new value is inserted at correct position
        }
    }

    private static void resize(int i) {
        int[] temp = new int[2*i];
        for(int j=0; j<heap.length; j++){
            temp[j] = heap[j];
        }
        heap = temp;
    }

}
