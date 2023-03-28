import java.util.EmptyStackException;

public class stackimplement {
    
    private Node top;
    private int length;

    private class Node{
        private int data;
        private Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    stackimplement(){
        this.top = null;
        this.length = 0;
    }

    public static void main(String args[]){
        stackimplement st = new stackimplement();
        
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        int deletedEle = st.pop();
        System.out.println("deleted element is: " + deletedEle);
        st.print();
        boolean emptyOrNot = st.isEmpty();
        System.out.println("Empty or Not? " + emptyOrNot);
        int len = st.length();
        System.out.println("Length of stack: " + len);
    }

    private void print() {
        Node curr = top;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private int length() {
        return length;
    }

    private boolean isEmpty() {
        if(length == 0){
            return true;
        }
        return false;
    }

    int pop() {
        if(length ==0){
            throw new EmptyStackException();
        }
        int result = top.data;
        Node temp = top.next;
        top.next = null;
        top = temp;
        length--;
        return result;
    }

    void push(int i) {
        Node newnode = new Node(i);
        newnode.next = top;
        top = newnode;
        length++;
    }

}
