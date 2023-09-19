package br.com.gomide.list.circular;

import br.com.gomide.list.interfaces.IDoublyLinkedList;
import br.com.gomide.list.interfaces.ISortedList;

public class CircularSortedDoublyLinkedList<T extends Comparable<?>>
    implements ISortedList<T>, IDoublyLinkedList<T> {

  @Override
  public boolean remove(T value) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'remove'");
  }

  @Override
  public T find(T value) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'find'");
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'clear'");
  }

  @Override
  public String listContent() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'listContent'");
  }

  @Override
  public String listContentReverse() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'listContentReverse'");
  }

  @Override
  public void insert(T value) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insert'");
  }

  @Override
  public void clearNavigation() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'clearNavigation'");
  }

  @Override
  public T getNextElement() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getNextElement'");
  }

  @Override
  public T getPreviousElement() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getPreviousElement'");
  }

}
