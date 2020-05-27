
class TwoDimensionalArray {

  // 1. declaration
  int[][] arr;

  public TwoDimensionalArray(int rows, int columns) {

    // 2. initializiation of array:
    arr = new int[rows][columns]; // O(1)

    // 3. intitialization:
    for (int i = 0; i < rows; i++) { // O(m)

      for(int j = 0; j < columns; j++) { // O(n)

        arr[i][j] = (i * 100) + (j * 10) + 10; // O(1)

      }
    }

    // or in single statement:
    int[][] arr2 = new int[][]{{10, 20, 30, 40, 50, 60, 70, 80, 90, 100}, {110, 120, 130, 140, 150, 160, 170, 180, 190, 200}};  // O(1)
  }

  public int access(int row, int column) {
    try {

      return this.arr[row][column]; // O(1)

    } catch (ArrayIndexOutOfBoundsException e) {

      e.printStackTrace(); // O(1)
      return -1;

    }
  }

  public void traverse() {

    for (int i = 0; i < this.arr.length; i++) { // O(m)

      for (int j = 0; j < this.arr[i].length; j++) { // O(n)

        System.out.println("row, " + i + " , column, " + j + " value, " + this.arr[i][j]); // O(1)

      }
    }
  }

  public int[][] insert(int value, int row, int column) {

    try {

      this.arr[row][column] = value; // O(1)

    } catch (ArrayIndexOutOfBoundsException e) {

      e.printStackTrace(); // O(1)

    }

    return this.arr; // O(1)
  }

  public int[] search(int[][] arr, int value) {

    for (int i = 0; i < this.arr.length; i++) { // O(m)

      for (int j = 0; j < this.arr[i].length; j++) { // O(n)

        if (this.arr[i][j] == value) { // O(1)

          return new int[]{i, j}; // O(1)

        }

      }
    }

    return new int[]{-1, -1}; // O(1)
  }

  public int[][] delete(int row, int column) {
    try {

      this.arr[row][column] = Integer.MIN_VALUE; // O(1)

    } catch (ArrayIndexOutOfBoundsException e) {

      e.printStackTrace(); // O(1)

    }

    return this.arr; // O(1)
  }

  public void deleteArray() {

    this.arr = null; // O(1)

  }


  public static void main(String[] args) {

  }

}
