public class FindMissingInArray {
    public static void main(String args[]){
        int arr[] = {2,1,5,3,6,7,8};
        int len = arr.length +1;
        int sum = (len*(len+1))/2;
        int sumArr = 0;
        for(int i=0; i<arr.length; i++){
            sumArr = sumArr + arr[i];
        }
        System.out.println(sum - sumArr);
    }
}
