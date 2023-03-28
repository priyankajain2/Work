public class InsertionSort {
    public static void main(String args[]){
        int arr[] = {1,3,2,7,87,5,43,76,90,12,0};
        sort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void sort(int[] arr) {
        for(int i=1; i<arr.length; i++){
            int temp = arr[i];
            int j = i-1;
            while(j>=0 && arr[j] > temp){
                arr[j+1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
}
