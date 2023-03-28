public class MinInArray {
    public static void main(String args[]){
        int arr[] = {1,4,2,6,8,94,0,83,23,-1};
        int min=Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] < min){
                min=arr[i];
            }
        }
        System.out.println("Min: " + min);
    }
}
