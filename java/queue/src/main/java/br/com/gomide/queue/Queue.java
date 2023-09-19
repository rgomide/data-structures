package br.com.gomide.queue;

import br.com.gomide.queue.interfaces.IQueue;

public class Queue<T extends Object> implements IQueue<T> {

  private QueueNode<T> first;
  private QueueNode<T> last;
  private int size;

  @Override
  public void enqueue(T value) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'enqueue'");
  }

  @Override
  public T dequeue() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'dequeue'");
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
  }

  @Override
  public T peek() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'peek'");
  }

  @Override
  public void enqueue(T[] value) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'enqueue'");
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'count'");
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

}
