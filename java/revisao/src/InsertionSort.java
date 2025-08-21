public class InsertionSort {
  public static void main(String[] args) {
    int[] array = { 100, 2, 15, 80, 10, 11, 6, 7, 18, 20, 22 };

    insertionSort(array);

    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
  }

  public static void insertionSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      // find min
      int minIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }

      // swap
      int temp = array[i];
      array[i] = array[minIndex];
      array[minIndex] = temp;
    }
  }

}
