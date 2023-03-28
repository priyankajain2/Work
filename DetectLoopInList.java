public class DetectLoopInList {
    
    Point head;
    
    static class Point{
        int data;
        Point next;

        Point(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String args[]){
        DetectLoopInList ls = new DetectLoopInList();
        ls = insert(ls,10);
        ls = insert(ls,20);
        ls = insert(ls,30);
        ls = insert(ls,40);
        ls = insert(ls,50);
        ls = insert(ls,60);
        makeLoop(ls);
        detectLoop(ls);
    }

    private static void makeLoop(DetectLoopInList ls) {
        Point curr = ls.head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = ls.head.next.next.next;
    }

    private static void detectLoop(DetectLoopInList ls) {
        Point slowPtr = ls.head;
        Point fastPtr = ls.head;
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr){
                System.out.println("Loop Detected");
                return;
            }
        }
        System.out.println("No Loop Detected");
    }

    private static DetectLoopInList insert(DetectLoopInList ls, int i) {
        Point curr = ls.head;
        Point newNode = new Point(i);
        if(ls.head == null){
            ls.head = newNode;
        }else{
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
                
        return ls;
    }
}
