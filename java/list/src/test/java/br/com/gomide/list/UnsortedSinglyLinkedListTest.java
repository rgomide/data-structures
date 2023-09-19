package br.com.gomide.list;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnsortedSinglyLinkedListTest {

  @Test
  public void retrieveAnEmptyList() {
    UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

    String content = list.listContent();

    assertEquals("null", content);
  }

  @Test
  public void insertElementsAtInitSuccessfully() {
    UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

    list.insertAtInit(2);
    list.insertAtInit(5);
    list.insertAtInit(8);
    list.insertAtInit(4);

    String content = list.listContent();

    assertEquals("4 -> 8 -> 5 -> 2 -> null", content);
  }

  @Test
  public void insertElementsAtEndSuccessfully() {
    UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

    list.insertAtEnd(2);
    list.insertAtEnd(5);
    list.insertAtEnd(8);
    list.insertAtEnd(4);

    String content = list.listContent();

    assertEquals("2 -> 5 -> 8 -> 4 -> null", content);
  }

  @Test
  public void insertElementsSuccessfuly() {
    UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

    list.insertAtEnd(2);
    list.insertAtInit(5);
    list.insertAtInit(8);
    list.insertAtEnd(4);

    String content = list.listContent();

    assertEquals("8 -> 5 -> 2 -> 4 -> null", content);
  }

  @Test
  public void findAnExistingElement() {
    Integer[] elements = new Integer[] { 2, 5, 8, 4 };
    UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

    list.insertAtInit(elements);

    Integer value = list.find(5);

    assertEquals(5, value);
  }

  @Test
  public void doesNotFindAnElement() {
    Integer[] elements = new Integer[] { 2, 5, 8, 4 };
    UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

    list.insertAtInit(elements);

    Integer value = list.find(666);

    assertNull(value);
  }

  @Test
  public void removeAnExistingElement() {
    Integer[] elements = new Integer[] { 2, 5, 8, 4 };
    UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

    list.insertAtEnd(elements);

    boolean removed = list.remove(5);
    String content = list.listContent();

    assertTrue(removed);
    assertEquals("2 -> 8 -> 4 -> null", content);
  }

  @Test
  public void removeTheLastElement() {
    Integer[] elements = new Integer[] { 2, 5, 8, 4 };
    UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

    list.insertAtEnd(elements);

    boolean removed = list.remove(4);
    String content = list.listContent();

    assertTrue(removed);
    assertEquals("2 -> 5 -> 8 -> null", content);
  }

  @Test
  public void removeTheFirstElement() {
    Integer[] elements = new Integer[] { 2, 5, 8, 4 };
    UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

    list.insertAtEnd(elements);

    boolean removed = list.remove(2);
    String content = list.listContent();

    assertTrue(removed);
    assertEquals("5 -> 8 -> 4 -> null", content);
  }

  @Test
  public void removeTheFirstElementOfASingleList() {
    Integer[] elements = new Integer[] { 2 };
    UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

    list.insertAtEnd(elements);

    boolean removed = list.remove(2);
    String content = list.listContent();

    assertTrue(removed);
    assertEquals("null", content);
  }

  @Test
  public void doesNotRemoveAnElement() {
    Integer[] elements = new Integer[] { 2, 5, 8, 4 };
    UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

    list.insertAtEnd(elements);

    boolean removed = list.remove(666);
    String content = list.listContent();

    assertFalse(removed);
    assertEquals("2 -> 5 -> 8 -> 4 -> null", content);
  }

  @Test
  public void clearAListWithElements() {
    Integer[] elements = new Integer[] { 2, 5, 8, 4 };
    UnsortedSinglyLinkedList<Integer> list = new UnsortedSinglyLinkedList<Integer>();

    list.insertAtEnd(elements);

    list.clear();
    String content = list.listContent();

    assertEquals("null", content);
  }

}
