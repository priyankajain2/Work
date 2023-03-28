public class MoveZerosAtEnd {
    public static void main(String args[]){
        int arr[] = {1,0,5,2,0,7,0,4,0,2};
        ZerosAtEnd(arr);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void ZerosAtEnd(int[] arr) {
        int j=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] != 0){
                j++;
            }
        }
    }
}
