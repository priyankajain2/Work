public class SquareOfSortedArray{
    public static void main(String args[]){
        int arr[] = {-4,-1,0,3,10};
        arr = sqOfArr(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static int[] sqOfArr(int[] arr) {
        int result[] = new int[arr.length];
        int j=arr.length-1,i=0, k=arr.length-1;
        while(i<=k){
            if(arr[i]* arr[i] > arr[k]*arr[k]){
                result[j] = arr[i]*arr[i];
                j--; i++;
            }else{
                result[j] = arr[k] * arr[k];
                k--;
                j--;
            }
        }
        return result;
    }
}