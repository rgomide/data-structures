package br.com.gomide.list.interfaces;

public interface IUnsortedList<T extends Object> extends IList<T> {

  default public void insertAtInit(T[] values) {
    for (T value : values) {
      this.insertAtInit(value);
    }
  }

  public void insertAtInit(T value);

  default public void insertAtEnd(T[] values) {
    for (T value : values) {
      this.insertAtEnd(value);
    }
  }

  public void insertAtEnd(T value);
}
