package LinkedList;

public class LoopInLL {

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static boolean hasLoop(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return  false;
    }

    public static void main(String[] args) {
        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        //creating a cycle
        //head.next.next.next.next.next = head.next; // 5 -> 2

        //findMiddle(head);
        reverseLinkedList(head);
        //System.out.println("Cycle detected: "+ hasLoop(head));
    }


    //Reverse a Singly Linked List
    public static void reverseLinkedList(Node head){

        Node prev = null;

        while(head != null){

            Node nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        Node temp  = prev;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }


    }

    //Find Middle of a Linked List in One Pass
    public static void findMiddle(Node head){

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);

    }

    //Find the intersection point of two linked list
    public static Node findIntersection(Node headA, Node headB){
        int lengthA = length(headA);
        int lengthB = length(headB);

        while(lengthA>lengthB){
            headA = headA.next;
            lengthA--;
        }

        while(lengthB > lengthA){
            headB = headB.next;
            lengthB--;
        }

        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    //finding length of the linked list
    public static int length(Node head){
        int count = 0;

        while (head != null){
            count++;
            head = head.next;
        }

        return count;
    }
}
