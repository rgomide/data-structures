public class BinarySearch {
  public static void main(String[] args) {
    int[] array = { 1, 2, 5, 8, 10, 11, 12, 15, 18, 20, 22 };

    for (int i = 0; i < array.length; i++) {
      int target = array[i];
      int result = binarySearch(array, target);
      System.out.println("Target: " + target + " Result: " + result);
    }

  }

  public static int binarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (array[mid] == target) {
        return mid;
      }

      if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1;
  }
}
