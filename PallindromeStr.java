public class PallindromeStr {
    public static void main(String args[]){
        String s = "madaam";
        Boolean flag = true;
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                flag = false;
                break;
            }
        }
        if(flag == false){
            System.out.println("Not Pallindrome");
        }else{
            System.out.println("Pallindrome");
        }

    }
}
