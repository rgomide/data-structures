package br.com.gomide.queue;

public class QueueNode<T extends Object> {

  private T value;

  private QueueNode<T> next;

  public QueueNode(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public QueueNode<T> getNext() {
    return next;
  }

  public void setNext(QueueNode<T> next) {
    this.next = next;
  }

}
