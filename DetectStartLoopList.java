public class DetectStartLoopList {
    
    Pointerr head;

    static class Pointerr{
        int data;
        Pointerr next;

        Pointerr(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String args[]){
        DetectStartLoopList ls = new DetectStartLoopList();
        ls = insert(ls,10);
        ls = insert(ls,20);
        ls = insert(ls,30);
        ls = insert(ls,40);
        ls = insert(ls,50);
        ls = insert(ls,60);
        makeLoop(ls);
        Pointerr start = startLoop(ls);
        System.out.println(start.data);
    }

    private static DetectStartLoopList.Pointerr startLoop(DetectStartLoopList ls) {
        Pointerr slowPtr = ls.head;
        Pointerr fastPtr = ls.head;
        boolean flag = false;
        while(fastPtr != null && fastPtr.next != null && flag != true){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr){
                flag = true;
            }
        }
        if(flag == true){
            slowPtr = ls.head;
            while(slowPtr != fastPtr){
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
        }

        return slowPtr;
    }

    // private static void detectLoop(DetectStartLoopList ls) {
    //     Pointerr slowPtr = ls.head;
    //     Pointerr fastPtr = ls.head;
    //     while(fastPtr != null && fastPtr.next != null){
    //         slowPtr = slowPtr.next;
    //         fastPtr = fastPtr.next.next;
    //         if(slowPtr == fastPtr){
    //             System.out.println("Loop Detected");
    //             return;
    //         }
    //     }
    //     System.out.println("No Loop Detected");
    // }

    private static DetectStartLoopList insert(DetectStartLoopList ls, int i) {
        Pointerr curr = ls.head;
        Pointerr newNode = new Pointerr(i);
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

    private static void makeLoop(DetectStartLoopList ls) {
        Pointerr curr = ls.head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = ls.head.next.next;
    }

    
}
