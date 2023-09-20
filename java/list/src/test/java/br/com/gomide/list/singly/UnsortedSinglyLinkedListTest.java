package br.com.gomide.list.singly;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;

public class UnsortedSinglyLinkedListTest {

  @Test
  @DisplayName("retrieve an empty list")
  public void retrieveAnEmptyList() {
    UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

    String content = list.listContent();

    assertEquals("null", content);
  }

  @Nested
  @DisplayName("insert action")
  class Insertion {

    @Test
    @DisplayName("insert elements at init successfully")
    public void insertElementsAtInitSuccessfully() {
      UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

      list.prepend(2);
      list.prepend(5);
      list.prepend(8);
      list.prepend(4);

      String content = list.listContent();

      assertEquals("4 -> 8 -> 5 -> 2 -> null", content);
    }

    @Test
    @DisplayName("insert elements at end successfully")
    public void insertElementsAtEndSuccessfully() {
      UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

      list.append(2);
      list.append(5);
      list.append(8);
      list.append(4);

      String content = list.listContent();

      assertEquals("2 -> 5 -> 8 -> 4 -> null", content);
    }

    @Test
    @DisplayName("insert elements successfully")
    public void insertElementsSuccessfuly() {
      UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

      list.append(2);
      list.prepend(5);
      list.prepend(8);
      list.append(4);

      String content = list.listContent();

      assertEquals("8 -> 5 -> 2 -> 4 -> null", content);
    }

  }

  @Nested
  @DisplayName("find action")
  class Find {

    @Test
    @DisplayName("find an existing element")
    public void findAnExistingElement() {
      Integer[] elements = new Integer[] { 2, 5, 8, 4 };
      UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

      list.prepend(elements);

      Integer value = list.find(5);

      assertEquals(5, value);
    }

    @Test
    @DisplayName("does not find an element")
    public void doesNotFindAnElement() {
      Integer[] elements = new Integer[] { 2, 5, 8, 4 };
      UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

      list.prepend(elements);

      Integer value = list.find(666);

      assertNull(value);
    }

  }

  @Nested
  @DisplayName("remove action")
  class Remove {

    @Test
    @DisplayName("remove an existing element")
    public void removeAnExistingElement() {
      Integer[] elements = new Integer[] { 2, 5, 8, 4 };
      UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

      list.append(elements);

      boolean removed = list.remove(5);
      String content = list.listContent();

      assertTrue(removed);
      assertEquals("2 -> 8 -> 4 -> null", content);
    }

    @Test
    @DisplayName("remove the last element")
    public void removeTheLastElement() {
      Integer[] elements = new Integer[] { 2, 5, 8, 4 };
      UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

      list.append(elements);

      boolean removed = list.remove(4);
      String content = list.listContent();

      assertTrue(removed);
      assertEquals("2 -> 5 -> 8 -> null", content);
    }

    @Test
    @DisplayName("remove the first element")
    public void removeTheFirstElement() {
      Integer[] elements = new Integer[] { 2, 5, 8, 4 };
      UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

      list.append(elements);

      boolean removed = list.remove(2);
      String content = list.listContent();

      assertTrue(removed);
      assertEquals("5 -> 8 -> 4 -> null", content);
    }

    @Test
    @DisplayName("remove the first element of a single list")
    public void removeTheFirstElementOfASingleList() {
      Integer[] elements = new Integer[] { 2 };
      UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

      list.append(elements);

      boolean removed = list.remove(2);
      String content = list.listContent();

      assertTrue(removed);
      assertEquals("null", content);
    }

    @Test
    @DisplayName("does not remove an element")
    public void doesNotRemoveAnElement() {
      Integer[] elements = new Integer[] { 2, 5, 8, 4 };
      UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

      list.append(elements);

      boolean removed = list.remove(666);
      String content = list.listContent();

      assertFalse(removed);
      assertEquals("2 -> 5 -> 8 -> 4 -> null", content);
    }

  }

  @Nested
  @DisplayName("navigation action")
  class Navigate {

    @Test
    @DisplayName("navigate through all elements")
    public void navigateThroughAllElements() {
      Integer[] elements = new Integer[] { 2, 5, 8 };
      UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

      list.append(elements);

      Integer element = list.getNextElement();
      assertEquals(2, element);

      element = list.getNextElement();
      assertEquals(5, element);

      element = list.getNextElement();
      assertEquals(8, element);

      element = list.getNextElement();
      assertNull(element);
    }

    @Test
    @DisplayName("navigate through elements and restart navigation pointer")
    public void navigateThroughElementsAndRestartNavigationPointer() {
      Integer[] elements = new Integer[] { 2, 5, 8 };
      UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

      list.append(elements);

      Integer element = list.getNextElement();
      assertEquals(2, element);

      element = list.getNextElement();
      assertEquals(5, element);

      list.clearNavigation();

      element = list.getNextElement();
      assertEquals(2, element);

      element = list.getNextElement();
      assertEquals(5, element);

      element = list.getNextElement();
      assertEquals(8, element);

      element = list.getNextElement();
      assertNull(element);
    }

  }

  @Test
  @DisplayName("clear a list")
  public void clearAListWithElements() {
    Integer[] elements = new Integer[] { 2, 5, 8, 4 };
    UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

    list.append(elements);

    list.clear();
    String content = list.listContent();

    assertEquals("null", content);
  }

}
