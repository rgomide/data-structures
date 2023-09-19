package br.com.gomide.list;

public class ListNode<K extends Object, V extends Object> {

  private ListNode<K, V> next;

  private K key;

  private V value;

  public ListNode(V value) {
    this.value = value;
  }

  public ListNode(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public ListNode<K, V> getNext() {
    return next;
  }

  public void setNext(ListNode<K, V> next) {
    this.next = next;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

}
