import java.util.Stack;

public class ValidParanthesesProblem {
    public static void main(String args[]){
        String str = "{{([])}}";
        boolean validOrNot = checkParanthese(str);
        System.out.println("Parantheses valid or not: " + validOrNot);
    }

    private static boolean checkParanthese(String str) {
        Stack<Character> st = new Stack<>();
        char[] strToArr = str.toCharArray();
        for(int i=0; i<strToArr.length; i++){
            if(strToArr[i] == '{' || strToArr[i] == '[' || strToArr[i] == '('){
                st.push(strToArr[i]);
            }else{
                if(st.peek() == '{' && strToArr[i] == '}' 
                    || st.peek() == '[' && strToArr[i] == ']' 
                    || st.peek() == '(' && strToArr[i] == ')'){
                        st.pop();
                }else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
