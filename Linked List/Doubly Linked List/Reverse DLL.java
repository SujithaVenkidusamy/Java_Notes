//Step-1: Create class
class Node{
    int data;
    Node next;
    Node prev;
	
    //Step-2: Create a constructor
    Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
} 

//Step-4:
class LinkedList{
    Node head,tail;
    //Insert at Begining
    public void insertAtBegining(int data){
        Node newNode=new Node(data);
        if(head==null){// If the list is empty
            head=tail=newNode;// Set both head and tail to new node
        }
        else{
            newNode.next=head;// Point new node's next to current head
            head.prev=newNode;// Set current head's previous to new node
            head=newNode;// Update head to new node
        }
    }
    
    //Insert at End
    public void insertAtEnd(int data){
        Node newNode=new Node(data);
        if(tail==null){// If the list is empty
            head=tail=newNode;// Set both head and tail to new node
        }
        else{
            tail.next=newNode;// Link the current tail to the new node
            newNode.prev=tail;// Set the new node's previous to current tail
            tail=newNode;// Update tail to the new node
        }
            
    }
    
    public void reverse() {
        Node current = head;
        Node temp = null;

        // Swap next and prev for all nodes
        while (current != null) {
            temp = current.prev; // Store the previous node
            current.prev = current.next; // Swap prev and next
            current.next = temp; // Complete the swap
            current = current.prev; // Move to the next node (which is now prev)
        }

        // Update head and tail
        if (temp != null) {
            tail = head; // The old head becomes the new tail
            head = temp.prev; // The new head is the last processed node
        }
    }
    
    
    //Display 
    public void display() {
        Node temp = head;
        if(temp == null) { 
            System.out.print("List is Empty");// Handle empty list case
            return;
        }    
        while(temp!=null){ // Traverse the list
            System.out.print(temp.data);// Print current node's data
            
            if (temp.next!= null) { // If there's a next node
                System.out.print(" <-> ");
            }
        temp = temp.next;// Move to the next node
        }
        System.out.println();
    }
}
        
    

//Step-3: Main class
public class Main{
	public static void main(String[] args) {
		LinkedList link=new LinkedList();
		link.insertAtBegining(300);// Insert data at the beginning //Node 3
		link.insertAtBegining(200);//Node 2
		link.insertAtBegining(100);//Node 1
		System.out.println("The List:");
		link.display();// Display the linked list
		link.reverse(); // Reverse the linked list
        System.out.println("Reversed List:");
        link.display(); // Display the reversed linked list
	}
}
