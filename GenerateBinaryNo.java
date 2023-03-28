public class GenerateBinaryNo {
    public static void main(String args[]){
        int n = 7;
        String[] result = generateBinary(n);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }
    }

    private static String[] generateBinary(int n) {
        String[] result = new String[n];
        QueueImplementation qu = new QueueImplementation();
        for(int i=0; i<n; i++){
            if(qu.isEmpty()){
            result[0] = "1";
            qu.enqueue(1);
            }else{
                int value = qu.dequeue();
                String node1 = Integer.toString(value) + "0";
                String node2 = Integer.toString(value) + "1";
                result[i] = node1;
                qu.enqueue(Integer.parseInt(node1));
                qu.enqueue(Integer.parseInt(node2));
                if(++i < n){
                    result[i] = node2;
                }
            }
        }
        return result;
    }
}
