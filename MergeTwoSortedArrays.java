public class MergeTwoSortedArrays {
    public static void main(String args[]){
        int arr[] = {1,2,4,5,7};
        int arr1[] = {0,3,6,8,9};
        int result[] = merge(arr, arr1);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    private static int[] merge(int[] arr, int[] arr1) {
        int result[] = new int[arr.length + arr1.length];
        int m = arr.length, n = arr1.length;
        int i=0, j=0;
        int k=0;
        while(i<n && j<m){
            if(arr[i] < arr1[j]){
                result[k] = arr[i];
                k++; i++;
            }else{
                result[k] = arr1[j];
                k++; j++;
            }
        }
        while(i<n){
            result[k] = arr[i];
            k++; i++;
        }
        while(j<m){
            result[k] = arr1[j];
            k++; j++;
        }
        return result;
    }
}
