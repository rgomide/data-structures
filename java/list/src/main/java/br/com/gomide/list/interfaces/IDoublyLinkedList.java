package br.com.gomide.list.interfaces;

public interface IDoublyLinkedList<T extends Object> extends IList<T> {

  public String listContent();

  public String listContentReverse();

  public T getNextElement();

  public T getPreviousElement();

}