package circularSingleLinkedList;

class CircularSingleLinkedList {

  // 1). Create a head component and tail component.
  Node next; // O(1)
  Node head; // O(1)
  Node tail; // O(1)

  int size = 0; // O(1)

  public CircularSingleLinkedList(int nodeValue) {
    head = new Node(); // O(1)
    tail = new Node(); // O(1)

    // 2). Create a node that takes a value and whose next reference, references itself.
    Node node = new Node(); // O(1)
    node.setValue(nodeValue); // O(1)
    node.setNext(node); // O(1)

    // 3). Make the head and tail component reference this node.
    this.head = node;  // O(1)
    this.tail = node; // O(1)

    this.setSize(1); // O(1)
  }

  public Node getHead() {
    return this.head;
  }

  public void setHead(Node head) {
    this.head = head;
  }

  public Node getTail() {
    return tail;
  }

  public void setTail(Node tail) {
    this.tail = tail;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public void insert(int nodeIndex, int nodeValue) {

    if (nodeIndex < 0 || nodeIndex > this.size) { // O(1)
      System.out.println("nodeIndex is invalid: " + nodeIndex); // O(1)
      return; // O(1)
    }

    Node node = new Node(); // O(1)
    node.setValue(nodeValue); // O(1)

    // 1). Insertion of a node at the beginning
    if (nodeIndex == 0) { // O(1)
      node.setNext(this.head); // O(1)
      this.head = node; // O(1)

      if (this.size == 0) {
        this.tail = node;
      }

      this.tail.setNext(node); // O(1)
      this.setSize(this.size + 1); // O(1)
      return; // O(1)
    }

    // 2). Insertion of node at the end
    if (nodeIndex == this.size) { // O(1)
      node.setNext(this.head); // O(1)
      this.tail.setNext(node); // O(1)
      this.tail = node; // O(1)
      this.setSize(this.size + 1); // O(1)
      return; // O(1)
    }

    // 3). Insertion of a node at a specific index.
    Node prevNode = this.head;  // O(1)
    for (int currentIndex = 1; currentIndex < this.size; currentIndex++) { // O(n - 1)
      Node nextNode = prevNode.getNext(); // O(1)
      if (currentIndex == nodeIndex) { // O(1)
        prevNode.setNext(node); // O(1)
        node.setNext(nextNode); // O(1)
        this.setSize(this.size + 1); // O(1)
        return; // O(1)
      }
      prevNode = prevNode.getNext(); // O(1)
    }

  }

  public void traverse() {
    Node currentNode = this.head; // O(1)
    for (int currentIndex = 0; currentIndex < this.size; currentIndex++) {  // O(n)
      System.out.println("index: " + currentIndex + ", value: " + currentNode.getValue()); // O(1)
      currentNode = currentNode.getNext(); // O(1)
    }
  }

  public int search(int nodeValue) {
    Node currentNode = this.head; // O(1)
    for (int currentIndex = 0; currentIndex < this.size; currentIndex++) { // O(n)
      int currentNodeValue = currentNode.getValue();
      if (nodeValue == currentNodeValue) { // O(1)
        return currentNodeValue; // O(1)
      }

      currentNode = currentNode.getNext(); // O(1)
    }

    return Integer.MIN_VALUE; // O(1)
  }


  public void deleteNode(int nodeIndex) {

    if (nodeIndex < 0 || nodeIndex >= this.size) { // O(1)
      System.out.println("Invalid node index: " + nodeIndex); // O(1)
      return; // O(1)
    }

    if (this.size == 1) { // O(1)
      this.tail.setNext(null); // O(1)
      this.head = null; // O(1)
      this.tail = null; // O(1)
      this.setSize(0); // O(1)
      return; // O(1)
    }

    Node currentNode = this.head; // O(1)

    if (nodeIndex == 0) { // O(1)
      Node nextNode = currentNode.getNext(); // O(1)
      this.head = nextNode; // O(1)
      this.tail.setNext(nextNode); // O(1)
      this.setSize(this.size - 1); // O(1)
      return; // O(1)
    }

    if (nodeIndex == this.size - 1) { // O(1)
      currentNode = currentNode.getNext();
      for (int currentIndex = 1; currentIndex < this.size; currentIndex++) { // O(n-2)
        if (currentIndex == this.size - 2) { // O(1)
          currentNode.setNext(this.head); // O(1)
          this.tail = currentNode; // O(1)
          this.setSize(this.size - 1); // O(1)
          return; // O(1)
        }
        currentNode = currentNode.getNext(); // O(1)
      }
    }

    Node prevNode = currentNode; // O(1)
    currentNode = currentNode.getNext(); // O(1)
    Node nextNode = currentNode.getNext(); // O(1)
    for (int currentIndex = 1; currentIndex < this.size; currentIndex++) { // O(n-2)

      if (nodeIndex == currentIndex) { // O(1)
        prevNode.setNext(nextNode); // O(1)
        this.setSize(this.size - 1); // O(1)
        return; // O(1)
      }

      prevNode = prevNode.getNext(); // O(1)
      currentNode = currentNode.getNext(); // O(1)
      nextNode = nextNode.getNext(); // O(1)
    }


  }

  public void delete() {
    this.head = null;
    this.tail.setNext(null);
    this.tail = null;
    this.setSize(0);
  }

  public static void main(String[] args) {
    CircularSingleLinkedList csll = new CircularSingleLinkedList(5);
    csll.traverse();

    csll.deleteNode(0);

    csll.insert(0, 5);
    System.out.println("search: 5: " + csll.search(5));
    csll.insert(1, 10);
    System.out.println("search 10: " + csll.search(10));

    csll.traverse();

    System.out.println("-----------------");

    csll.insert(1, 15);
    System.out.println("search 15: " + csll.search(15));
    System.out.println("search 10: " + csll.search(10));

    csll.traverse();

    System.out.println("-----------------");

    csll.deleteNode(0);
    csll.traverse();


    System.out.println("-----------------");

    csll.insert(0, 5);
    csll.insert(csll.getSize(), 20);
    csll.insert(1, 8);

    csll.traverse();
    System.out.println("-----------------");

    csll.deleteNode(csll.getSize() - 1);
    csll.traverse();
    System.out.println("-----------------");

    csll.deleteNode(2);
    csll.traverse();
    System.out.println("-----------------");

    csll.deleteNode(1);
    csll.traverse();
    System.out.println("-----------------");

    csll.deleteNode(1);
    csll.traverse();
    System.out.println("-----------------");

    csll.deleteNode(1);
    csll.traverse();
    System.out.println("-----------------");

    csll.deleteNode(0);
    csll.traverse();
  }
}
