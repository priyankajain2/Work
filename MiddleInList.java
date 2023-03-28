public class MiddleInList {
    Noode head;

    static class Noode{
        int data;
        Noode next;

        Noode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String args[]){
        MiddleInList ls = new MiddleInList();
        ls = insert(ls,10);
        ls = insert(ls,20);
        ls = insert(ls,30);
        ls = insert(ls,40);
        Noode mid = findMiddle(ls);
        System.out.println("The middle element is " + mid.data);
    }

    private static Noode findMiddle(MiddleInList ls) {
        Noode slowptr = ls.head;
        Noode fastptr = ls.head;
        while(fastptr != null  && fastptr.next != null){
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
        }
        return slowptr;
    }

    private static MiddleInList insert(MiddleInList ls, int i) {
        Noode newNode = new Noode(i);
        if(ls.head == null){
            ls.head = newNode;
        }else{
            Noode curr = ls.head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
        return ls;
    }
}
