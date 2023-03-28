public class RemoveDuplicateFromList {

    Nodee head;

    static class Nodee{
        int data;
        Nodee next;

        Nodee(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String args[]){
        RemoveDuplicateFromList ls = new RemoveDuplicateFromList();
        ls = insert(ls,1);
        ls = insert(ls,1);
        ls = insert(ls,2);
        ls = insert(ls,2);
        ls = insert(ls,3);
        ls = insert(ls,3);
        ls = insert(ls,3);
        ls = removeDuplicate(ls);
        printList(ls);
    }

    private static RemoveDuplicateFromList removeDuplicate(RemoveDuplicateFromList ls) {
        Nodee currPtr = ls.head;
        Nodee nextPtr = currPtr.next;
        while(currPtr.next != null){
            if(currPtr.data == nextPtr.data){
                currPtr.next = nextPtr.next;
                nextPtr = nextPtr.next;
            }else{
                currPtr = currPtr.next;
                nextPtr = nextPtr.next;
            }
        }
        return ls;
    }

    private static void printList(RemoveDuplicateFromList ls) {
        Nodee curr = ls.head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private static RemoveDuplicateFromList insert(RemoveDuplicateFromList ls, int i) {
        Nodee curr = ls.head;
        Nodee newNode = new Nodee(i);
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
