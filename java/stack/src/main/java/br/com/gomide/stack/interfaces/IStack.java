package br.com.gomide.stack.interfaces;

public interface IStack<T extends Object> {

  public void push(T[] value);

  public void push(T value);

  public T pop(T value);

  public int size();

  public String getContent();

  public void clear();

  public boolean isEmpty();

}
