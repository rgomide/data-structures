package br.com.gomide.list.singly;

import br.com.gomide.list.ListNode;
import br.com.gomide.list.interfaces.ISinglyLinkedList;
import br.com.gomide.list.interfaces.IUnsortedList;

public class UnsortedSinglyLinkedList<T extends Object> implements ISinglyLinkedList<T>, IUnsortedList<T> {

  private ListNode<T> first;
  private ListNode<T> last;
  private ListNode<T> navigationPointer;

  @Override
  public void prepend(T value) {
    ListNode<T> newElement = new ListNode<T>(value);

    if (first == null) {
      this.first = newElement;
      this.last = newElement;
      this.navigationPointer = newElement;
    } else {
      newElement.setNext(this.first);
      this.first = newElement;
    }
  }

  @Override
  public void append(T value) {
    ListNode<T> newElement = new ListNode<T>(value);

    if (first == null) {
      this.first = newElement;
      this.last = newElement;
      this.navigationPointer = newElement;
    } else {
      this.last.setNext(newElement);
      this.last = newElement;
    }
  }

  @Override
  public T find(T value) {
    ListNode<T> element = this.first;

    while (element != null) {
      T currentValue = element.getValue();

      if (currentValue.equals(value)) {
        return currentValue;
      }

      element = element.getNext();
    }

    return null;
  }

  @Override
  public boolean remove(T value) {
    if (this.first == null || this.last == null) {
      return false;
    }

    if (this.first.getValue().equals(value)) {
      this.first = this.first.getNext();
      return true;
    }

    ListNode<T> element = this.first;
    ListNode<T> previousNode = null;

    while (element != null) {
      T currentValue = element.getValue();

      if (currentValue.equals(value)) {
        previousNode.setNext(element.getNext());
        element = null;
        return true;
      }

      previousNode = element;
      element = element.getNext();
    }

    return false;
  }

  @Override
  public void clear() {
    this.first = null;
    this.last = null;
    this.navigationPointer = null;
  }

  @Override
  public String listContent() {
    StringBuilder listContent = new StringBuilder();

    ListNode<T> element = this.first;

    while (element != null) {
      listContent.append(element.getValue());
      listContent.append(" -> ");

      element = element.getNext();
    }

    listContent.append("null");

    return listContent.toString();
  }

  @Override
  public void clearNavigation() {
    this.navigationPointer = this.first;
  }

  @Override
  public T getNextElement() {
    if (this.first == null || this.last == null) {
      return null;
    }

    if (this.navigationPointer == null) {
      return null;
    }

    T value = this.navigationPointer.getValue();
    this.navigationPointer = this.navigationPointer.getNext();
    return value;
  }

}
