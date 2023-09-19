package br.com.gomide.list.singly;

import br.com.gomide.list.ListNode;
import br.com.gomide.list.interfaces.ISinglyLinkedList;
import br.com.gomide.list.interfaces.IUnsortedList;

public class UnsortedSinglyLinkedList<T extends Object> implements ISinglyLinkedList<T>, IUnsortedList<T> {

  private ListNode<T, T> first;
  private ListNode<T, T> last;

  @Override
  public void insertAtInit(T value) {
    ListNode<T, T> newElement = new ListNode<T, T>(value);

    if (first == null) {
      this.first = newElement;
      this.last = newElement;
    } else {
      newElement.setNext(this.first);
      this.first = newElement;
    }
  }

  @Override
  public void insertAtEnd(T value) {
    ListNode<T, T> newElement = new ListNode<T, T>(value);

    if (first == null) {
      this.first = newElement;
      this.last = newElement;
    } else {
      this.last.setNext(newElement);
      this.last = newElement;
    }
  }

  @Override
  public T find(T value) {
    ListNode<T, T> element = this.first;

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

    ListNode<T, T> element = this.first;
    ListNode<T, T> previousNode = null;

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
  }

  @Override
  public String listContent() {
    StringBuilder listContent = new StringBuilder();

    ListNode<T, T> element = this.first;

    while (element != null) {
      listContent.append(element.getValue());
      listContent.append(" -> ");

      element = element.getNext();
    }

    listContent.append("null");

    return listContent.toString();
  }

}
