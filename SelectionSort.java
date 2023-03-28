public class SelectionSort {
    public static void main(String args[]){
        int arr[] = {1,6,3,76,43,23,65,90,0,8,13};
        sort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void sort(int[] arr) {
        int min = Integer.MAX_VALUE;
        int j=0,index =-1;
        for(int i=j; i<arr.length; i++){
            while(i != arr.length-1){
                if(arr[i] < min){
                    min = arr[i];
                    index = i;
                }
                i++;
            }
            i=j;
            
            int temp = arr[j];
            arr[j] = arr[index];
            arr[index] = temp;
            j++; min = Integer.MAX_VALUE;
        }
    }
}
