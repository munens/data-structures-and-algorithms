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
      this.size += 1; //O(1)
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
      this.size += 1; //O(1)
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
        Node nextNode = currentNode.next; // O(1)

        if (currentIndex == nodeIndex) { // O(1)
          // set 'shadow' node to reference the next node
          node.setNext(nextNode); // O(1)
          // set previous node to reference 'shadow' node
          prevNode.setNext(node); // O(1)
          this.size += 1; //O(1)
        }

        currentIndex++; // O(1)
        currentNode = nextNode; // O(1)
      }
    }




    return;
  }
}
