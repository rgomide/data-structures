package br.com.gomide.list.interfaces;

public interface ISortedList<K extends Object, V extends Object> extends IList<K> {

  public void insert(K key, V value);

}
