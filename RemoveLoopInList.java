public class RemoveLoopInList {
    
    Pointe head;

    static class Pointe{
        int data;
        Pointe next;

        Pointe(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String args[]){
        RemoveLoopInList ls = new RemoveLoopInList();
        ls = insert(ls,10);
        ls = insert(ls,20);
        ls = insert(ls,30);
        ls = insert(ls,40);
        ls = insert(ls,50);
        ls = insert(ls,60);
        makeLoop(ls);
        ls = removeLoop(ls);
        printList(ls);
    }

    private static void printList(RemoveLoopInList ls) {
        Pointe curr = ls.head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private static void makeLoop(RemoveLoopInList ls) {
        Pointe curr = ls.head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = ls.head.next.next.next;
    }

    private static RemoveLoopInList removeLoop(RemoveLoopInList ls) {
        Pointe slowPtr = ls.head;
        Pointe fastPtr = ls.head;
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr){
                return remove(slowPtr,ls);
            }
        }
        System.out.println("No Loop Detected");
        return ls;
    }

    private static RemoveLoopInList remove(RemoveLoopInList.Pointe slowPtr, RemoveLoopInList ls) {
        Pointe fastPtr = ls.head;
        while(slowPtr.next != fastPtr.next){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        slowPtr.next = null;
        return ls;
    }

    private static RemoveLoopInList insert(RemoveLoopInList ls, int i) {
        Pointe curr = ls.head;
        Pointe newNode = new Pointe(i);
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
