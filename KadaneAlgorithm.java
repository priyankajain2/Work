public class KadaneAlgorithm {
    //basically finding maximum sum in any size subarray. 
    public static void main(String args[]){
        int arr [] = {1,2,-2,3,5,-10,5,6};
        int result = findMax(arr);
        System.out.println(result);
    }

    private static int findMax(int[] arr) {
        int maxSoFar = arr[0];
        int currMax = arr[0];
        for(int i=1; i<arr.length; i++){
            currMax = currMax + arr[i];
            if(currMax < arr[i]){
                currMax = arr[i];
            }
            if(maxSoFar < currMax){
                maxSoFar = currMax;
            }
        }
        return maxSoFar;
    }
}
