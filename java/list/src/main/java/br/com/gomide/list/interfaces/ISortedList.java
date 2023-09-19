package br.com.gomide.list.interfaces;

public interface ISortedList<T extends Comparable<?>> extends IList<T> {

  public void insert(T value);

}
