public class QuickSort {
    public static void main(String args[]){
        int arr[] = {1,4,2,5,3,7,8,0,19,23,21,-1};
        int low =0, high = arr.length-1;
        sort(arr,low,high);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void sort(int[] arr, int low, int high) {
        if(low<high){
            int p = parition(arr,low,high);
            sort(arr,low,p-1);
            sort(arr,p+1,high);
        }
    }

    private static int parition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int p=-1;
        int j=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
                if(arr[i] == pivot){
                    p=j-1;
                }
            }
        }
        return p;
    }
}
