package br.com.gomide.stack;

import br.com.gomide.stack.interfaces.IStack;

public class Stack<T extends Object> implements IStack<T> {

  private StackNode<T> next;
  private int size;

  @Override
  public void push(T[] value) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'push'");
  }

  @Override
  public void push(T value) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'push'");
  }

  @Override
  public T pop(T value) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'pop'");
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'size'");
  }

  @Override
  public String getContent() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getContent'");
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'clear'");
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
  }

}
