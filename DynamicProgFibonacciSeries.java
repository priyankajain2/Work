public class DynamicProgFibonacciSeries {
    public static void main(String args[]){
        int a = recursiveFib(5);
        int b = bottomUpApproach(5);
        int memo[] = new int[6];
        int c = topDownApproach(memo,5);
        System.out.println(a==b && b==c);
    }

    private static int topDownApproach(int[] memo,int n) {
        if(memo[n] == 0){
            if(n<2){
                memo[n] = n;
            }else{
                memo[n] = topDownApproach(memo,n-1) + topDownApproach(memo,n-2);
            }
        }
        return memo[n];
    }

    private static int bottomUpApproach(int n) {
        int table[] = new int[n+1];
        table[0] = 0;
        table[1] = 1;
        for(int i=2; i<n+1; i++){
            table[i] = table[i-1] + table[i-2];
        }
        return table[n];
    }

    private static int recursiveFib(int n) {
        if(n == 0){return 0;}
        if(n == 1){return 1;}
        int left = recursiveFib(n-1);
        int right = recursiveFib(n-2);
        return left + right;
    }
}
