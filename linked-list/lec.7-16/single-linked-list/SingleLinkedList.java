package linkedList;

class SingleLinkedList {

  // 1).
  private Node head; // O(1)
  private Node tail; // O(1)

  private int size; // O(1)

  public SingleLinkedList(int nodeValue) {

    this.head = new Node(); // O(1)
    this.tail = new Node(); // O(1)

    // 2).
    Node node = new Node(); // O(1)
    node.setValue(nodeValue); // O(1)
    node.setNext(null); // O(1)

    this.size = 1; // O(1)

    // 3).
    this.head = node; // O(1)
    this.tail = node; // O(1)

  }


  public void insert(int nodeIndex, int nodeValue) {

    if (nodeIndex > this.size || nodeIndex < 0) {
      System.out.println("Invalid node index: " + nodeIndex);
      return;
    }

    // 1. node at the start
    if (nodeIndex == 0) { // O(1)

      // - create 'shadow' node with value:
      Node node = new Node(); // O(1)
      node.setValue(nodeValue); // O(1)

      // - set 'shadow' node next property to current first node:
      node.setNext(this.head); // O(1)

      // - set head node to 'shadow', now new node in chain:
      this.head = node; // O(1)
      this.setSize(this.size + 1); //O(1)
      return;
    }

    // 2. node at the end
    if (nodeIndex == this.size) { // O(1)

      // - create 'shadow' node with value and non reference to next node:
      Node node = new Node(); // O(1)
      node.setValue(nodeValue); // O(1)
      node.setNext(null); // O(1)

      // - set last node next reference to 'shadow' node:
      this.tail.setNext(node); // O(1)

      // - set 'tail' node to 'shadow', now new node in chain.
      this.tail = node; // O(1)
      this.setSize(this.size + 1); //O(1)
      return;
    }

    // 3. place node at specific index:
    if (nodeIndex < this.size) { // O(1)

      // - create 'shadow' node
      Node node = new Node(); // O(1)
      node.setValue(nodeValue); // O(1)

      // - traverse through all nodes until we get to node at specific index:
      Node currentNode = this.head; // O(1)
      int currentIndex = 1; // O(1)

      while (currentIndex < this.size) { // O(n - 1)
        Node prevNode = currentNode; // O(1)
        Node nextNode = currentNode.getNext(); // O(1)

        if (currentIndex == nodeIndex) { // O(1)
          // set 'shadow' node to reference the next node
          node.setNext(nextNode); // O(1)
          // set previous node to reference 'shadow' node
          prevNode.setNext(node); // O(1)
          this.setSize(this.size + 1); //O(1)
        }

        currentIndex++; // O(1)
        currentNode = nextNode; // O(1)
      }
    }

    return;
  }

  public void setSize(int size) {
    this.size = size;
    return;
  }

  public void traverse() {

    Node currentNode = this.head; // O(1)
    int currentIndex = 0; // O(1)

    while(currentIndex < this.size) {  // O(n)
      System.out.println("index: " + currentIndex + ", value: " + currentNode.getValue()); // O(1)
      currentNode = currentNode.getNext(); // O(1)
      currentIndex++; // O(1)
    }
  }

  public int search(int nodeValueToSearch) {

    Node currentNode = this.head;  // O(1)
    for (int currentIndex = 0; currentIndex < this.size; currentIndex++) {  // O(n)
      int nodeValue = currentNode.getValue(); // O(1)
      if (nodeValue == nodeValueToSearch) { // O(1)
        return nodeValue; // O(1)
      }
      currentNode = currentNode.getNext(); // O(1)
    }

    System.out.println("Value could not be found, nodeValueToSearch: " + nodeValueToSearch);
    return Integer.MIN_VALUE;
  }

  public void deleteNode(int nodeIndex) {

    if (nodeIndex > this.size || nodeIndex < 0) { // O(1)
      System.out.println("Invalid node index: " + nodeIndex); // O(1)
      return; // O(1)
    }

    if (this.size == 1) { // O(1)
      this.head = null; // O(1)
      this.tail = null; // O(1)
      this.setSize(0); // O(1)
      return; // O(1)
    }

    if (nodeIndex == 0) {  // O(1)
      this.head = this.head.getNext(); // O(1)
      this.setSize(this.size - 1); // O(1)
      return; // O(1)
    }

    if (nodeIndex == this.size - 1) { // O(1)
      Node currentNode = this.head.getNext(); // O(1)
      for (int currentIndex = 0; currentIndex < this.size; currentIndex++) { // O(n - 2)
        if (currentIndex == this.size - 2) { // O(1)
          currentNode.setNext(null); // O(1)
          this.tail = currentNode; // O(1)
          this.setSize(this.size - 1); // O(1)
          return; // O(1)
        }

        currentNode = currentNode.getNext(); // O(1)
      }
    }

    Node prevNode = this.head; // O(1)
    for (int currentIndex = 1; currentIndex < this.size; currentIndex++) { // O(n - 2)
      Node nextNode = prevNode.getNext().getNext(); // O(1)
      if (nodeIndex == currentIndex) { // O(1)
        prevNode.setNext(nextNode); // O(1)
        this.setSize(this.size - 1); // O(1)
        return; // O(1)
      }

      prevNode = prevNode.getNext(); // O(1)
    }
  }

  public void delete() {
    this.head = null; //O(1)
    this.tail = null; //O(1)
    this.setSize(0); //O(1)
  }

  public static void main(String[] args) {
    SingleLinkedList sll = new SingleLinkedList(5);
    System.out.println("size: " + sll.size);
    sll.insert(sll.size, 6);
    sll.insert(0, 10);

    //sll.traverse();
    System.out.println("size: " + sll.size);

    sll.insert(2, 12);
    //sll.traverse();
    sll.insert(2, 24);
    System.out.println("size: " + sll.size);
    sll.traverse();

    // System.out.println(sll.search(24));
    // System.out.println(sll.search(11));
    sll.deleteNode(3);
    System.out.println("removed index: " + 3);
    System.out.println("size: " + sll.size);
    sll.traverse();
    sll.deleteNode(1);
    System.out.println("removed index: " + 1);
    System.out.println("size: " + sll.size);
    sll.traverse();
    sll.deleteNode(0);
    System.out.println("removed index: " + 0);
    System.out.println("size: " + sll.size);
    sll.traverse();
    sll.deleteNode(1);
    System.out.println("removed index: " + 1);
    System.out.println("size: " + sll.size);
    sll.traverse();

    sll.deleteNode(0);
    System.out.println("removed index: " + 0);
    System.out.println("size: " + sll.size);
    sll.traverse();
  }
}
