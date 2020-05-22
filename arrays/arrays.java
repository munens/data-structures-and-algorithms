public class array {
  // creating an array:

  // 1, declaration:
  int arr[];

  public array() {

    // 2. initialization of array:
    arr = new int[5];

    // 3. initialization:
    arr[0] = 1;
    arr[1] = 2;
    arr[2] = 3;
    arr[3] = 4;
    arr[4] = 5;

    System.out.println(arr); // [I@5a4041cc
    System.out.println(arr[2]); // 3

    // or in one go:
    int arr2[] = new int[]{1, 2, 3, 4 , 5}; // [I@4f51b3e0
    System.out.println(arr2);
  }

  public static void main(String[] args) {
    array arr = new array();
  }
}
