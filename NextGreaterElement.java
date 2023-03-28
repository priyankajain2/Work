import java.util.Stack;

public class NextGreaterElement {
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,7};
        int arr2[] = nextGreaterEle(arr);
        for(int i=0; i<arr2.length; i++){
            System.out.print(arr2[i]);
        }
    }

    private static int[] nextGreaterEle(int[] arr) {
        int result[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            if(st.isEmpty()){
                result[i] = -1;
            }else{
                while(!st.isEmpty() && arr[i]>=st.peek()){
                    st.pop();
                }
                result[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return result;
    }
}
