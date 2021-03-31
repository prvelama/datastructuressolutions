package main.java.com.datastructures.solutions.linkedlists;

public class BinaryToDecimalLinkedList {
    public Node reverseLinkedList(Node head)
    {
        Node prev = null;
        Node next;
        Node current = head;

        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public int getDecimalValue(Node head) {
        head = reverseLinkedList(head);
        ReverseLinkedList.printLinkedList(head);
        Node current = head;
        int sum = 0;
        int counter = 0;

        while(current != null)
        {
            if(current.val == 1)
                sum += Math.pow(2,counter);
            counter++;
            current = current.next;
        }

        return sum;
    }

    public static void main(String[] args){
        BinaryToDecimalLinkedList b = new BinaryToDecimalLinkedList();
        int num;
        //Number 617
        Node n1 = new Node(0);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(0);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        ReverseLinkedList.printLinkedList(n1);

        num = b.getDecimalValue(n1);
        System.out.println(num);
    }
}
