public class ReverseArray {
    public static void main(String args[]){
        int arr[] = {1,5,3,76,85,34,23,12,7,4,0};
        int revArr[] = new int[arr.length];
        int j=0;
        for(int i=arr.length-1; i>=0; i--){
            revArr[j] = arr[i];
            j++;
        }
        for(int i=0; i<revArr.length; i++){
            System.out.print(revArr[i]+ " ");
        }
        System.out.println();

        reverseArr(revArr,0,arr.length-1);

    }

    private static void reverseArr(int[] arr, int start, int end) {
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
