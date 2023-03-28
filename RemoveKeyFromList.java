public class RemoveKeyFromList {
    
    Pointer head;
    
    static class Pointer{
        int data;
        Pointer next;

        Pointer(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String args[]){
        RemoveKeyFromList ls = new RemoveKeyFromList();
        ls = insert(ls,10);
        ls = insert(ls,20);
        ls = insert(ls,11);
        ls = insert(ls,30);
        ls = insert(ls,40);
        ls = insert(ls,50);
        ls = removeKey(ls,11);
        printList(ls);
    }

    private static RemoveKeyFromList removeKey(RemoveKeyFromList ls, int i) {
        Pointer curr = ls.head;
        Pointer prev = null;
        boolean flag = false;
        if(ls.head.data == i){
            ls.head = ls.head.next;
        }else{
            while(flag != true && curr.next != null){
                if(curr.data == i){
                    prev.next = prev.next.next;
                    flag = true;
                }
                prev = curr;
                curr = curr.next;
            }
        }
        return ls;
    }

    private static void printList(RemoveKeyFromList ls) {
        Pointer curr = ls.head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private static RemoveKeyFromList insert(RemoveKeyFromList ls, int i) {
        Pointer newNode = new Pointer(i);
        Pointer curr = ls.head;
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
