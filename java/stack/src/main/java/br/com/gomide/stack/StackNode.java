package br.com.gomide.stack;

public class StackNode<T extends Object> {

  private T value;

  private StackNode<T> next;

  public StackNode(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public StackNode<T> getNext() {
    return next;
  }

  public void setNext(StackNode<T> next) {
    this.next = next;
  }

}
