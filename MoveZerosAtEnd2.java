public class MoveZerosAtEnd2 {
    public static void main(String args[]){
        int arr[] = {1,0,6,0,-9,7,4,2,0};
        zerosAtEnd(arr);
        printArray(arr);
    }

    private static void zerosAtEnd(int[] arr) {
        int j=0;
        for(int i=0; i<arr.length-1; i++){
            if(arr[j]==0 && arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] != 0){
                j++;
            }
        }
    }

    private static void printArray(int[] arr) {
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
