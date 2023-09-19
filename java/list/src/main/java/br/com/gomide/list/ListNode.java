package br.com.gomide.list;

public class ListNode<T extends Object> {

  private ListNode<T> next;

  private ListNode<T> previous;

  private T value;

  public ListNode(T value) {
    this.value = value;
  }

  public ListNode<T> getNext() {
    return next;
  }

  public void setNext(ListNode<T> next) {
    this.next = next;
  }

  public ListNode<T> getPrevious() {
    return previous;
  }

  public void setPrevious(ListNode<T> previous) {
    this.previous = previous;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

}
