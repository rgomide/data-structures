package br.com.gomide.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class QueueTest {

  @Nested
  @DisplayName("enqueue action")
  class Enqueue {

    @Test
    @DisplayName("enqueue a single element")
    public void enqueueASingleElement() {
      Queue<Integer> queue = new Queue<Integer>();

      queue.enqueue(10);

      Integer peekValue = queue.peek();
      String queueContent = queue.getContent();
      int total = queue.size();

      assertEquals(10, peekValue);
      assertEquals(1, total);
      assertEquals("FIRST -> 10", queueContent);
    }

    @Test
    @DisplayName("enqueue a set of elements")
    public void enqueueASetOfElement() {
      Queue<Integer> queue = new Queue<Integer>();

      queue.enqueue(2);
      Integer peekValue = queue.peek();
      assertEquals(2, peekValue);

      queue.enqueue(7);
      peekValue = queue.peek();
      assertEquals(2, peekValue);

      queue.enqueue(4);
      peekValue = queue.peek();
      assertEquals(2, peekValue);

      int total = queue.size();
      assertEquals(3, total);

      String queueContent = queue.getContent();
      assertEquals("FIRST -> 2 -> 7 -> 4", queueContent);
    }

    @Test
    @DisplayName("enqueue an array of elements")
    public void enqueueAnArrayOfElement() {
      Integer[] elements = new Integer[] { 2, 4, 6, 7 };
      Queue<Integer> queue = new Queue<Integer>();

      queue.enqueue(elements);

      int total = queue.size();
      assertEquals(4, total);

      String queueContent = queue.getContent();
      assertEquals("FIRST -> 2 -> 4 -> 6 -> 7", queueContent);
    }

  }

  @Nested
  @DisplayName("dequeue action")
  class Dequeue {

    @Test
    @DisplayName("dequeue a single element")
    public void dequeueASingleElement() {
      Integer[] elements = new Integer[] { 2, 4, 6, 7 };
      Queue<Integer> queue = new Queue<Integer>();

      queue.enqueue(elements);
      Integer dequeuedElement = queue.dequeue();

      assertEquals(2, dequeuedElement);

      int total = queue.size();
      assertEquals(3, total);

      String queueContent = queue.getContent();
      assertEquals("FIRST -> 4 -> 6 -> 7", queueContent);
    }

    @Test
    @DisplayName("dequeue all elements")
    public void dequeueAllElements() {
      Integer[] elements = new Integer[] { 2, 4, 7 };
      Queue<Integer> queue = new Queue<Integer>();

      queue.enqueue(elements);

      Integer dequeuedElement = queue.dequeue();
      assertEquals(2, dequeuedElement);

      dequeuedElement = queue.dequeue();
      assertEquals(4, dequeuedElement);

      dequeuedElement = queue.dequeue();
      assertEquals(7, dequeuedElement);

      dequeuedElement = queue.dequeue();
      assertNull(dequeuedElement);

      int total = queue.size();
      assertEquals(0, total);

      String queueContent = queue.getContent();
      assertEquals("", queueContent);
    }

  }

  @Test
  @DisplayName("isEmpty action")
  public void manageElementsAndCheckIsEmpty() {
    Integer[] elements = new Integer[] { 6, 7 };
    Queue<Integer> queue = new Queue<Integer>();

    queue.enqueue(elements);
    assertFalse(queue.isEmpty());

    queue.dequeue();
    assertFalse(queue.isEmpty());

    queue.dequeue();
    assertTrue(queue.isEmpty());

    assertNull(queue.peek());

    queue.dequeue();
    assertTrue(queue.isEmpty());

    String queueContent = queue.getContent();
    assertEquals("", queueContent);
  }

  @Test
  @DisplayName("clear action")
  public void clearAQueue() {
    Integer[] elements = new Integer[] { 6, 7, 9, 1 };
    Queue<Integer> queue = new Queue<Integer>();

    queue.enqueue(elements);

    queue.clear();

    assertTrue(queue.isEmpty());

    int size = queue.size();

    assertEquals(0, size);

    String queueContent = queue.getContent();
    assertEquals("", queueContent);
  }

}
