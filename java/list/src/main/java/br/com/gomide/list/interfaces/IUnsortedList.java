package br.com.gomide.list.interfaces;

public interface IUnsortedList<T extends Object> extends IList<T> {

  default public void prepend(T[] values) {
    for (T value : values) {
      this.prepend(value);
    }
  }

  public void prepend(T value);

  default public void append(T[] values) {
    for (T value : values) {
      this.append(value);
    }
  }

  public void append(T value);
}
