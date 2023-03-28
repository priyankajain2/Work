public class BinarySearch {
    public static void main(String args[]){
        int[] arr = {1,3,4,5,7,9,10,13,20,34,45};
        int index = search(arr,5);
        System.out.println("5 is found at position: " + index);
    }

    private static int search(int[] arr, int i) {
        int low = 0;
        int high = arr.length -1 ;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == i){ return mid;}
            if(arr[mid] > i){
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
