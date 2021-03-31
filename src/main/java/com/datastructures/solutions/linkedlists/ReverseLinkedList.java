package main.java.com.datastructures.solutions.linkedlists;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
    Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
}
//Reverse Linked List
public class ReverseLinkedList {

    public Node reverse(Node head)
    {
        Node current = head;
        Node prev = null;

        while(current != null)
        {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public static void printLinkedList(Node head)
    {
        Node current = head;
        while(current != null)
        {
            System.out.print(current.val + " --> ");
            current = current.next;
        }
        System.out.println(" ");
    }

    public static int findLinkedListLength(Node head)
    {
        Node current = head;
        int length = 0;
        while(current != null)
        {
            length++;
            current = current.next;
        }
        return length;
    }

    public static void main(String[] args)
    {
        ReverseLinkedList rll = new ReverseLinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        System.out.println("Length of the list is "+ ReverseLinkedList.findLinkedListLength(n1));
        ReverseLinkedList.printLinkedList(n1); //1 --> 2 --> 3 --> 4 -->
        ReverseLinkedList.printLinkedList(rll.reverse(n1)); // 4 --> 3 --> 2 --> 1 -->

    }
}
