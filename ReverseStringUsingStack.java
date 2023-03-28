public class ReverseStringUsingStack {
    public static void main(String args[]){
        stackimplement st = new stackimplement();
        String str = "class";
        str = reverseString(str,st);
        System.out.println("New String = " + str);

    }

    private static String reverseString(String str, stackimplement st) {
        char[] strToArr = str.toCharArray();
        //char[] str2 = new char[strToArr.length];
        for(int i=0; i< strToArr.length; i++){
            st.push(strToArr[i]);
            //str2[strToArr.length-i-1] = strToArr[i];              one way of doing it in just single line
        }
        for(int i=0; i<strToArr.length; i++){
            strToArr[i] = (char)st.pop();
        }
        return new String(strToArr);
    }
}
