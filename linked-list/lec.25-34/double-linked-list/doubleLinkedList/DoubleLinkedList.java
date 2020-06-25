package doubleLinkedList;

class DoubleLinkedList {

   DoubleNode head; //O(1)
   DoubleNode tail; //O(1)

   int size = 0; //O(1)

   public DoubleLinkedList(int nodeValue) {

     DoubleNode node = new DoubleNode(); //O(1)
     node.setValue(nodeValue); //O(1)
     node.setPrev(null); //O(1)
     node.setNext(null); //O(1)

     this.head = node; //O(1)
     this.tail = node; //O(1)
     this.setSize(this.size + 1); //O(1)
   }

   public DoubleNode getHead() {
     return this.head;
   }

   public void setHead(DoubleNode head) {
     this.head = head;
   }

   public DoubleNode getTail() {
     return this.tail;
   }

   public void setTail(DoubleNode tail) {
     this.tail = tail;
   }

   public int getSize() {
     return this.size;
   }

   public void setSize(int size) {
     this.size = size;
   }

   public void insert(int nodeIndex, int nodeValue) {

     if (nodeIndex < 0 || nodeIndex > this.getSize()) {// O(1)
       System.out.println("nodeIndex is invalid: " + nodeIndex); // O(1)
       return; // O(1)
     }

     DoubleNode node = new DoubleNode(); // O(1)
     node.setValue(nodeValue); // O(1)

     // 1). Insertion of a node at the beginning
     if (nodeIndex == 0) {// O(1)

       if (this.getSize() == 0) {
         this.setHead(node); // O(1)
         this.setTail(node); // O(1)
         node.setNext(null); // O(1)
         node.setPrev(null); // O(1)
         this.setSize(this.getSize() + 1);
         return; // O(1)
       }

       node.setNext(this.getHead()); // O(1)
       node.setPrev(null); // O(1)
       this.getHead().setPrev(node); // O(1)
       this.setHead(node); // O(1)
       this.setSize(this.getSize() + 1); // O(1)
       return; // O(1)
     }

     // 2). Insertion of a node at the end
     if (nodeIndex == this.getSize()) { // O(1)
       node.setNext(null); // O(1)
       node.setPrev(this.getTail()); // O(1)
       this.getTail().setNext(node); // O(1)
       this.setTail(node);; // O(1)
       this.setSize(this.getSize() + 1); // O(1)
       return; // O(1)
     }

     // 3). Insertion of a node at specific index:
     DoubleNode currentNode = this.getHead().getNext(); // O(1)
     for (int currentIndex = 1; currentIndex < this.getSize(); currentIndex++) { // O(n-2)

       if (currentIndex == nodeIndex) { // O(1)
         node.setNext(currentNode); // O(1)
         node.setPrev(currentNode.getPrev()); // O(1)
         currentNode.getPrev().setNext(node); // O(1)
         currentNode.setPrev(node); // O(1)
         this.setSize(this.getSize() + 1); // O(1)
         return;
       }
       currentNode = currentNode.getNext(); // O(1)
     }
   }

   public void traverse() {
     DoubleNode currentNode = this.getHead();
     for (int currentIndex = 0; currentIndex < this.getSize(); currentIndex++) { // O(n)
       System.out.println("index: " + currentIndex + ", value: " + currentNode.getValue()); // O(1)
       currentNode = currentNode.getNext(); // O(1)
     }
   }

   public void revereTraverse() {
     DoubleNode currentNode = this.getTail();
     for (int currentIndex = this.getSize() - 1; currentIndex >= 0; currentIndex--) { // O(n)
       System.out.println("index: " + currentIndex + ", value: " + currentNode.getValue()); // O(1)
       currentNode = currentNode.getPrev(); // O(1)
     }
   }

   public int search(int nodeValue) {
     DoubleNode currentNode = this.getHead(); // O(1)
     for (int currentIndex = 0; currentIndex < this.getSize(); currentIndex++) { // O(n)
       int currentNodeValue = currentNode.getValue(); // O(1)
       if (currentNodeValue == nodeValue) { // O(1)
         return currentNodeValue; // O(1)
       }

       currentNode = currentNode.getNext(); // O(1)
     }

     return Integer.MIN_VALUE; // O(1)
   }

   public void deleteNode(int nodeIndex) {

     if (nodeIndex < 0 || nodeIndex > this.getSize()) {
       System.out.println("nodeIndex is invalid: " + nodeIndex); // O(1)
       return; // O(1)
     }

     if (this.getSize() == 1) { // O(1)
       this.setHead(null); // O(1)
       this.setTail(null); // O(1)
       this.setSize(0); // O(1)
       return; // O(1)
     }

     if (nodeIndex == 0) { // O(1)
       DoubleNode firstNode = this.getHead().getNext(); // O(1)
       firstNode.setPrev(null); // O(1)
       this.setHead(firstNode); // O(1)
       this.setSize(this.getSize() - 1); // O(1)
       return; // O(1)
     }

     if (nodeIndex == this.getSize() - 1) { // O(1)
       DoubleNode lastNode = this.getTail().getPrev(); // O(1)
       lastNode.setNext(null); // O(1)
       this.setTail(lastNode); // O(1)
       this.setSize(this.getSize() - 1); // O(1)
       return; // O(1)
     }


     DoubleNode currentNode = this.getHead().getNext(); // O(1)
     for (int currentIndex = 1; currentIndex < this.getSize() - 1; currentIndex++) { // O(n - 2)
       if (nodeIndex == currentIndex) { // O(1)
         DoubleNode prevNode = currentNode.getPrev(); // O(1)
         DoubleNode nextNode = currentNode.getNext(); // O(1)
         prevNode.setNext(nextNode); // O(1)
         nextNode.setPrev(prevNode); // O(1)
         this.setSize(this.getSize() - 1); // O(1)
         return; // O(1)
       }
       currentNode = currentNode.getNext(); // O(1)
     }
   }

   public void delete() {

     DoubleNode currentNode = this.getHead(); // O(1)

     this.setHead(null); // O(1)
     this.setTail(null); // O(1)

     for (int currentIndex = 0; currentIndex < this.getSize(); currentIndex++) { // O(n)
       currentNode.setPrev(null); // O(1)
       currentNode = currentNode.getNext(); // O(1)
     }
   }

   public static void main(String[] args) {

     DoubleLinkedList dll = new DoubleLinkedList(5);
     dll.traverse();

     dll.deleteNode(0);

     dll.insert(0, 5);
     System.out.println("search: 5: " + dll.search(5));
     dll.insert(1, 10);
     System.out.println("search 10: " + dll.search(10));

     dll.traverse();

     System.out.println("-----------------");

     dll.insert(1, 15);
     System.out.println("search 15: " + dll.search(15));
     System.out.println("search 10: " + dll.search(10));

     dll.traverse();

     System.out.println("-----------------");

     dll.revereTraverse();

     System.out.println("-----------------");

     dll.deleteNode(0);
     dll.traverse();


     System.out.println("-----------------");

     dll.insert(0, 5);
     dll.insert(dll.getSize(), 20);
     dll.insert(1, 8);

     dll.traverse();

     System.out.println("--------delete last node--------");
     dll.deleteNode(dll.getSize() - 1);
     dll.traverse();

     System.out.println("-------delete node 2----------");
     dll.deleteNode(2);
     dll.traverse();

     System.out.println("--------delete node 1---------");
     dll.deleteNode(1);
     dll.traverse();

     System.out.println("--------delete node 1---------");
     dll.deleteNode(1);
     dll.traverse();

     System.out.println("--------delete node 0---------");
     dll.deleteNode(0);
     dll.traverse();
   }
}
