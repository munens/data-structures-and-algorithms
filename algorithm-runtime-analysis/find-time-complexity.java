class AlgorithmRunTimeAnalysis {

  public AlgorithmRunTimeAnalysis() {}

  public int findBiggestNum(int[] nums) {

    int num = nums[0]; // O(n)

    for (int i = 0; i < nums.length; i++) { // O(n)

      if (nums[i] > num) { // O(1)

        num = nums[i]; // O(1)

      }

    }
    return num; // O(1)
  }


  public static void main(String[] args) {
    AlgorithmRunTimeAnalysis alrta = new AlgorithmRunTimeAnalysis();
    int arr[] = new int[]{12, 34, 235, 87, 65, 43, 199, 2993, 19, 23};
    int biggestNum = alrta.findBiggestNum(arr);
    System.out.println(biggestNum); // 2993
  }
}
