package main.java.com.datastructures.solutions.linkedlists;

public class AddNumbersLinkedList {

    //The digits are stored in reverse order
    public Node addReverseNumber(Node number1, Node number2){
        Node num1 = number1;
        Node num2 = number2;
        int num1Length = ReverseLinkedList.findLinkedListLength(num1);
        int num2Length = ReverseLinkedList.findLinkedListLength(num2);
        Node head = new Node(0);
        Node result = head;

        if(num2Length > num1Length)
            addLinkedList(num2, num1, result);
        else
            addLinkedList(num1, num2, result);

        return head.next;
    }

    //add two linked lists
    private void addLinkedList(Node num1, Node num2, Node result){
        int carry = 0;
        while(num1 != null && num2 != null) {
            int currentSum = num1.val + num2.val + carry;
            carry = currentSum/10;
            Node newNode = new Node(currentSum%10 , null);
            result.next = newNode;
            num1 = num1.next;
            num2 = num2.next;
            result = result.next;
        }
        if(num1 != null)
        {
            while(num1 != null)
            {
                int currentSum = num1.val + carry;
                carry = currentSum/10;
                Node newNode = new Node(currentSum%10, null);
                result.next = newNode;
                num1 = num1.next;
            }
        }

        if(carry > 0)
        {
            Node newNode = new Node(carry, null);
            result.next = newNode;
        }

    }

    //find length of linked list

    //main
    public static void main(String[] args){
        AddNumbersLinkedList list = new AddNumbersLinkedList();
        //Number 617
        Node n1 = new Node(7);
        Node n2 = new Node(1);
        Node n3 = new Node(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        //Number 592
        Node n4 = new Node(2);
        Node n5 = new Node(9);
        Node n6 = new Node(5);
        Node n7 = new Node(7);
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = null;

        ReverseLinkedList.printLinkedList(list.addReverseNumber(n1, n4));
    }
}
