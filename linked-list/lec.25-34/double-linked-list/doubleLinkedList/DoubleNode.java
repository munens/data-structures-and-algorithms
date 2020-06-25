package doubleLinkedList;

class DoubleNode {

  private int value;
  private DoubleNode next;
  private DoubleNode prev;

  public DoubleNode() {}

  public int getValue() {
    return this.value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public DoubleNode getPrev() {
    return this.prev;
  }

  public void setPrev(DoubleNode prev) {
    this.prev = prev;
  }

  public DoubleNode getNext() {
    return this.next;
  }

  public void setNext(DoubleNode next) {
    this.next = next;
  }
}
