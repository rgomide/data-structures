package br.com.gomide.hashing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class HashTable<T extends Comparable<T>> {
  private List<Node<T>> items;

  public HashTable(int n) {
    this.items = new ArrayList<Node<T>>(n);

    for (int i = 0; i < n; i++) {
      this.items.add(new Node<>());
    }
  }

  public List<Node<T>> getItems() {
    return items;
  }

  public String toString() {
    StringJoiner joiner = new StringJoiner(",");

    for (int i = 0; i < items.size(); i++) {
      Node<T> item = items.get(i);
      String message = String.format("%d->%s", i, item.toString());

      joiner.add(message);
    }

    return joiner.toString();
  }

}
