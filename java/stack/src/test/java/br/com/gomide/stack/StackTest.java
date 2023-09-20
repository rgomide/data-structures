package br.com.gomide.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StackTest {

  @Nested
  @DisplayName("push action")
  class Push {

    @Test
    @DisplayName("push a single element")
    public void pushASingleElement() {
      Stack<Integer> stack = new Stack<Integer>();

      stack.push(10);

      Integer peekValue = stack.peek();
      String stackContent = stack.getContent();
      int total = stack.size();

      assertEquals(10, peekValue);
      assertEquals(1, total);
      assertEquals("TOP -> 10", stackContent);
    }

    @Test
    @DisplayName("push a set of elements")
    public void pushASetOfElement() {
      Stack<Integer> stack = new Stack<Integer>();

      stack.push(2);
      Integer peekValue = stack.peek();
      assertEquals(2, peekValue);

      stack.push(7);
      peekValue = stack.peek();
      assertEquals(7, peekValue);

      stack.push(4);
      peekValue = stack.peek();
      assertEquals(4, peekValue);

      int total = stack.size();
      assertEquals(3, total);

      String stackContent = stack.getContent();
      assertEquals("TOP -> 4 -> 7 -> 2", stackContent);
    }

    @Test
    @DisplayName("push an array of elements")
    public void pushAnArrayOfElement() {
      Integer[] elements = new Integer[] { 2, 4, 6, 7 };
      Stack<Integer> stack = new Stack<Integer>();

      stack.push(elements);

      int total = stack.size();
      assertEquals(4, total);

      String stackContent = stack.getContent();
      assertEquals("TOP -> 7 -> 6 -> 4 -> 2", stackContent);
    }

  }

  @Nested
  @DisplayName("pop action")
  class Pop {

    @Test
    @DisplayName("pop a single element")
    public void popASingleElement() {
      Integer[] elements = new Integer[] { 2, 4, 6, 7 };
      Stack<Integer> stack = new Stack<Integer>();

      stack.push(elements);
      Integer popedElement = stack.pop();

      assertEquals(7, popedElement);

      int total = stack.size();
      assertEquals(3, total);

      String stackContent = stack.getContent();
      assertEquals("TOP -> 6 -> 4 -> 2", stackContent);
    }

    @Test
    @DisplayName("pop all elements")
    public void popAllElements() {
      Integer[] elements = new Integer[] { 2, 4, 7 };
      Stack<Integer> stack = new Stack<Integer>();

      stack.push(elements);

      Integer popedElement = stack.pop();
      assertEquals(7, popedElement);

      popedElement = stack.pop();
      assertEquals(4, popedElement);

      popedElement = stack.pop();
      assertEquals(2, popedElement);

      popedElement = stack.pop();
      assertNull(popedElement);

      int total = stack.size();
      assertEquals(0, total);

      String stackContent = stack.getContent();
      assertEquals("", stackContent);
    }

  }

  @Test
  @DisplayName("isEmpty action")
  public void manageElementsAndCheckIsEmpty() {
    Integer[] elements = new Integer[] { 6, 7 };
    Stack<Integer> stack = new Stack<Integer>();

    stack.push(elements);
    assertFalse(stack.isEmpty());

    stack.pop();
    assertFalse(stack.isEmpty());

    stack.pop();
    assertTrue(stack.isEmpty());

    assertNull(stack.peek());

    stack.pop();
    assertTrue(stack.isEmpty());

    String stackContent = stack.getContent();
    assertEquals("", stackContent);
  }

  @Test
  @DisplayName("clear action")
  public void clearAstack() {
    Integer[] elements = new Integer[] { 6, 7, 9, 1 };
    Stack<Integer> stack = new Stack<Integer>();

    stack.push(elements);

    stack.clear();

    assertTrue(stack.isEmpty());

    int size = stack.size();

    assertEquals(0, size);

    String stackContent = stack.getContent();
    assertEquals("", stackContent);
  }

}
