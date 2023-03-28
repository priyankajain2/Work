import java.util.EmptyStackException;

public class StackImplementation {

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

    StackImplementation(){
        top = null;
        length = 0;
    }

    public static void main(String args[]){
        StackImplementation st = new StackImplementation();
        st.push(1);
        st.push(2);
        st.push(3);
        st.pop();
        st.push(4);
        st.push(5);
        st.pop();
        st.pop();
        st.pop();
        //st.pop();
        //st.pop();
        boolean EnptyOrNot = st.isEmpty();
        System.out.println("Enpty or Node? " + EnptyOrNot);
        int len = st.length();
        System.out.println("Lenght of stack: " + len);
        st.print();
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

    private void pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        Node temp = top.next;
        top.next = null;
        top = temp;
        length--;
    }

    private void push(int i) {
        Node newNode = new Node(i);
        newNode.next = top;
        top = newNode;
        length++;
    }
}
