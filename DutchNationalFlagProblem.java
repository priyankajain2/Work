//sort array of 0's 1's and 2's. 
public class DutchNationalFlagProblem{
    public static void main(String args[]){
        // int arr[] = {2,1,0,2,1,1,1,2,0,2,2,0};
        int arr[] = {1,0,1,1,0,0,0,1,0};
        sort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void sort(int[] arr) {
        int j=0, k=arr.length-1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                swap(arr,i,j);
                j++;
            }
            if(arr[i] == 2){
                swap(arr,i,k);
                k--;
                i--;
            }
            if(k == i){
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}