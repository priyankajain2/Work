public class ResizeArray {
    public static void main(String args[]){
        int arr[] = {1,5,3,7,2,8,5};
        arr = resizeArr(arr);
        printArray(arr);
        System.out.println(arr.length);
    }

    private static int[] resizeArr(int[] arr) {
        int arr2[] = new int[arr.length*2];
        for(int i=0; i<arr.length; i++){
            arr2[i] = arr[i];
        }
        return arr2;
    }

    private static void printArray(int[] arr) {
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
