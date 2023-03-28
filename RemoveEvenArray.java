public class RemoveEvenArray {
    public static void main(String args[]){
        int allArr[] = {1,25,6,34,6,8,9,85};
        int outcount = 0;
        for(int i=0; i<allArr.length; i++){
            if(allArr[i]%2 == 1){
                outcount++;
            }
        }
        int j=0;
        int outArr[] = new int[outcount];
        for(int i=0; i<allArr.length; i++){
            if(allArr[i]%2 == 1){
                outArr[j] = allArr[i];
                j++;
            }
        }
        for(int i=0; i<outArr.length; i++){
            System.out.print(outArr[i] + " ");
        }
    }
}
