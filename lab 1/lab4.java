
class Node {
int data;
Node prev;
Node next;
public Node(int data) {
this.data = data;
this.prev = null;
this.next = null;
}
}
public class DoublyLinkedList {
private Node head;
public DoublyLinkedList() {
this.head = null; // Initializing an empty list


}
public void insertAtBeginning(int data) {
Node newNode = new Node(data);
if (head != null) {
head.prev = newNode;
newNode.next = head;
}
head = newNode;
}

public void insertAtEnd(int data) {
Node newNode = new Node(data);
if (head == null) {
head = newNode;
} else {
Node current = head;
while (current.next != null) {
current = current.next;
}
current.next = newNode;
newNode.prev = current;
}
}

public void insertAtPosition(int data, int position) {
if (position == 0) {
insertAtBeginning(data);
return;
}
Node newNode = new Node(data);
Node current = head;
for (int i = 1; i < position && current != null; i++) {
current = current.next;
}
if (current != null) {
newNode.next = current.next;
newNode.prev = current;
if (current.next != null) {
current.next.prev = newNode;
}
current.next = newNode;
} else {
System.out.println("Position out of bounds");
}
}

public void deleteByValue(int data) {
if (head == null) {
System.out.println("List is empty");
return;
}
if (head.data == data) {




head = head.next;
if (head != null) {
head.prev = null;
}
return;
}
Node current = head;
while (current != null && current.data != data) {
current = current.next;
}
if (current == null) {
System.out.println("Value not found");
} else {
if (current.prev != null) {
current.prev.next = current.next;
}
if (current.next != null) {
current.next.prev = current.prev;
}
}
}

public boolean find(int data) {
Node current = head;
while (current != null) {
if (current.data == data) {
return true;
}
current = current.next;
}
return false;
}

public void displayForward() {
if (head == null) {
System.out.println("List is empty");
} else {
Node current = head;
while (current != null) {
System.out.print(current.data + " <-> ");
current = current.next;
}
System.out.println("null");
}
}

public void displayBackward() {
if (head == null) {
System.out.println("List is empty");
} else {
Node current = head;
while (current.next != null) {
current = current.next;
}



while (current != null) {
System.out.print(current.data + " <-> ");
current = current.prev;
}
System.out.println("null");
}
}

public static void main(String[] args) {
DoublyLinkedList dll = new DoublyLinkedList();

dll.insertAtBeginning(10);
dll.insertAtEnd(20);
dll.insertAtEnd(30);
dll.insertAtPosition(25, 2); 

System.out.print("List in forward direction: ");
dll.displayForward(); 
System.out.print("List in backward direction: ");
dll.displayBackward(); 
dll.deleteByValue(25);
System.out.print("List after deletion: ");
dll.displayForward(); 

boolean found = dll.find(20);
System.out.println("Value 20 found: " + found); 
}
}