public class SecondMaxInArray {
    public static void main(String args[]){
        int arr[] = {1,4,2,6,4,8,65,34,23,12,87,76};
        int max= Integer.MIN_VALUE;
        int secMax = max;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max){
                secMax = max;
                max = arr[i];
            }else if(arr[i] > secMax && arr[i] != max){
                secMax = arr[i];
            }
        }
        System.out.println("Second Max: " + secMax);
    }
}
