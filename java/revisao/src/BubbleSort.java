public class BubbleSort {
  public static void main(String[] args) {
    int[] array = { 100, 2, 15, 80, 10, 11, 6, 7, 18, 20, 22 };

    bubbleSort(array);

    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
  }

  public static void bubbleSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length - 1; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
  }
}