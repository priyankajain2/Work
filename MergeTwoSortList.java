public class MergeTwoSortList {
    
    Pnt head;

    static class Pnt{
        int data;
        Pnt next;

        Pnt(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String args[]){
        MergeTwoSortList ls = new MergeTwoSortList();
        MergeTwoSortList ls1 = new MergeTwoSortList();
        MergeTwoSortList ls2 = new MergeTwoSortList();

        ls = insert(ls,1);
        ls = insert(ls,1);
        ls = insert(ls,20);
        ls = insert(ls,30);
        ls = insert(ls,40);
        ls = insert(ls,50);

        ls1 = insert(ls1,2);
        ls1 = insert(ls1,4);
        ls1 = insert(ls1,25);
        ls1 = insert(ls1,35);
        ls1 = insert(ls1,45);
        
        printList(ls);
        printList(ls1);

        ls2 = MergeList(ls,ls1,ls2);
        printList(ls2);
    }

    private static MergeTwoSortList MergeList(MergeTwoSortList ls, MergeTwoSortList ls1, MergeTwoSortList ls2) {
        Pnt curr = ls.head;
        Pnt curr1 = ls1.head;
        Pnt curr2 = null;
        if(curr.data < curr1.data){
            Pnt newNode = new Pnt(curr.data);
            ls2.head = newNode;
            curr2 = ls2.head;
            curr = curr.next;
        }else if(curr1.data < curr.data){
            Pnt newNode = new Pnt(curr1.data);
            ls2.head = newNode;
            curr2 = ls2.head;
            curr1 = curr1.next;
        }else{
            Pnt newNode = new Pnt(curr.data);
            ls2.head = newNode;
            curr2 = ls2.head;
            Pnt newNode1 = new Pnt(curr1.data);
            curr2.next = newNode1;
            curr2 = curr2.next;
            curr = curr.next;
            curr1 = curr1.next;
        }
        while(curr != null && curr1 != null){
            if(curr.data < curr1.data){
                Pnt newNode = new Pnt(curr.data);
                curr2.next = newNode;
                curr = curr.next;
                curr2 = curr2.next;
            }else if(curr1.data < curr.data){
                Pnt newNode = new Pnt(curr1.data);
                curr2.next = newNode;
                curr1 = curr1.next;
                curr2 = curr2.next;
            }else{
                Pnt newNode = new Pnt(curr1.data);
                Pnt newNode1 = new Pnt(curr.data);
                curr2.next = newNode;
                curr2 = curr2.next;
                curr2.next = newNode1;
                curr2 = curr2.next;
                curr = curr.next;
                curr1 = curr1.next;
            }
        }
        if(curr == null){
            curr2.next = curr1;
        }else{
            curr2.next = curr;
        }
        return ls2;
    }

    private static void printList(MergeTwoSortList ls) {
        Pnt curr = ls.head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }


    private static MergeTwoSortList insert(MergeTwoSortList ls, int i) {
        Pnt curr = ls.head;
        Pnt newNode = new Pnt(i);
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
