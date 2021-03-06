import java.lang.Math;

class FindTimeComplexity {

  public FindTimeComplexity() {}

  public int findBiggestNumIteratively(int[] nums) {

    int num = nums[0]; // O(1)

    for (int i = 1; i < nums.length; i++) { // O(n)

      if (nums[i] > num) { // O(1)

        num = nums[i]; // O(1)

      }

    }

    return num; // O(1)
  }

   public int findBiggestNumRecursively(int[] nums, int index, int num) {

    if (index == nums.length - 1) { // O(1)

      return num; // O(1)

    }

    int newNum = nums[index]; // O(1)

    if (newNum > num) { // O(1)

      num = newNum; // O(1)

    }

    return findBiggestNumRecursively(nums, index + 1, num); // T(n-1)
  }

  public int findNumIndexBinary(int[] nums, int num, int startIndex, int endIndex) {

    int diff = endIndex - startIndex; // O(1)

    if (diff == 1) { // O(1)

      return nums[startIndex] == num ? startIndex : -1; // O(1)

    }

    int midIndex = (int)(Math.floor(diff / 2)) + startIndex; // O(1)

    int midNum = nums[midIndex]; // O(1)

    if (num == midNum) { // O(1)

      return midIndex; // O(1)
    }

    return num > midNum // O(1)

      ? findNumIndexBinary(nums, num, midIndex + 1, endIndex) // T(n/2)

      : findNumIndexBinary(nums, num, startIndex, midIndex); // T(n/2)

  }

  public static void main(String[] args) {
    FindTimeComplexity ftc = new FindTimeComplexity();

    int arr[] = new int[]{12, 34, 235, 87, 65, 43, 199, 2993, 19, 23342};

    int biggestNumIterative = ftc.findBiggestNumIteratively(arr);
    System.out.println(biggestNumIterative); // 2993

    int biggestNumRecursive = ftc.findBiggestNumRecursively(arr, 0, 0);
    System.out.println(biggestNumRecursive); // 2993

    int sortedArr[] = new int[]{10, 20, 30, 40, 50, 60, 70};
    System.out.println(ftc.findNumIndexBinary(sortedArr, 60, 0, sortedArr.length));
  }
}
