class InsertTraverse1DArray {
  public InsertTraverse1DArray() {

  }

  public int[] insert(int[] array, int value, int index) { // O(1)
    array[index] = value; // O(1)
    return array; // O(1)
  }

  public void traverse(int[] array) {
    for (int i = 0; i < array.length; i++) { // O(n)
      System.out.println(array[i]); // ... // O(1)
    }
  }

  public int access(int[] array, int index) {
    if (index < 0 || index > array.length - 1) {
      System.out.println("value does not exist at index = ", index );
      return -1;
    }

    return array[index];
  }

  public int search(int[] array, int value) {
    for (int i = 0; i < array.length - 1; i++) { // O(n)

      if (array[i] == value) { // O(1)

        return i; // O(1)

      }
    }

    return -1; // O(1)
  }

  public int[] delete(int[] array, int index) {

    if (index < 0 || index > array.length - 1) { // O(1)

      System.out.println("value does not exist at index = ", index ); // O(1)

      return array; // O(1)

    }

    array[index] = 0; // O(1)

    return array; // O(1)
  }


  public static void main(String[] vals) {

    InsertTraverse1DArray it1da = new InsertTraverse1DArray();
    int arr[] = new int[10];
    arr = it1da.insert(arr, 5, 0);
    arr = it1da.insert(arr, 7, 1);

    it1da.traverse(arr);
    System.out.println(arr);
  }
}
