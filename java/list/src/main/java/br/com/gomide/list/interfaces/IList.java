package br.com.gomide.list.interfaces;

public interface IList<T extends Object> {

  public boolean remove(T value);

  public T find(T value);

  public void clear();

  public void clearNavigation();

}
