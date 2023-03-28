public class MergeSort {
    public static void main(String args[]){
        int arr[] = {1,3,2,7,87,5,43,76,90,12,0};
        int temp[] = new int[arr.length];
        int low=0, high = arr.length-1;
        sort(arr,temp,low,high);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void sort(int[] arr, int[] temp, int low, int high) {
        if(low < high){
            int mid = low + (high - low)/2;
            sort(arr,temp,low,mid);
            sort(arr,temp,mid+1,high);
            merge(arr,temp,low,mid,high);
        }
    }

    private static void merge(int[] arr, int[] temp, int low, int mid, int high) {
        for(int i=0; i<arr.length; i++){
            temp[i] = arr[i];
        }
        int i=low, j=mid+1, k=low;
        while(i<=mid && j<=high){
            if(temp[i] <= temp[j]){
                arr[k] = temp[i];
                i++;
            }else{
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            arr[k] = temp[i];
            i++; k++;
        }
        while(j<=high){
            System.out.println("hi");
            arr[k] = temp[j];
            j++; k++;
        }
    }
}
