import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class Recursive {
    public static void main(String args[]){
        String[] y = {"1", "2", "15", "-7", "300"};
        Arrays.sort(y);
        for(int i=0; i<y.length; i++){
            System.out.println(y[i]);
        }

        System.out.println( Math.ceil(-1));

        IntBinaryOperator f2 = (int a, int b) -> Math.abs(2*a - 3*b);
        System.out.println(f2.applyAsInt(2, 3));
    }

    
}


