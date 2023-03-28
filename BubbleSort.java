public class BubbleSort {
    public static void main(String args[]){
        int arr[] = {4,2,6,45,76,12,0,9,8,11,54};
        sort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void sort(int[] arr) {
        boolean isSwapped;
        for(int i=0; i<arr.length-1; i++){
            isSwapped = false;
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }
            if(isSwapped == false){
                break;
            }
        }
    }
}
