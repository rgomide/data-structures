package br.com.gomide.queue.interfaces;

public interface IQueue<T extends Object> {

  public void enqueue(T[] values);

  public void enqueue(T value);

  public T dequeue();

  public boolean isEmpty();

  public T peek();

  public int size();

  public String getContent();

  public void clear();

}
