package circularSingleLinkedList;

class Node {

  private int value;
  private Node next;

  public Node() {}

  public int getValue() {
    return this.value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Node getNext() {
    return this.next;
  }

  public void setNext(Node next) {
    this.next = next;
  }
}
