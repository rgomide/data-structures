package br.com.gomide.hashing.service;

import java.util.List;
import java.util.StringJoiner;

import br.com.gomide.hashing.model.HashTable;
import br.com.gomide.hashing.model.Node;

public class HashList<T extends Comparable<T>> extends Hash<T> {

  private int getIndex(HashTable<T> hashTable, T value) {
    int tableSize = hashTable.getItems().size();
    return value.hashCode() % tableSize;
  }

  @Override
  public boolean insert(HashTable<T> hashTable, T value) {
    int position = getIndex(hashTable, value);

    Node<T> newNode = new Node<>();
    newNode.setValue(value);

    newNode.setNext(hashTable.getItems().get(position));
    hashTable.getItems().set(position, newNode);

    return true;
  }

  @Override
  public boolean remove(HashTable<T> hashTable, T value) {
    int position = getIndex(hashTable, value);

    Node<T> node = hashTable.getItems().get(position);
    Node<T> previousNode = hashTable.getItems().get(position);

    if (value.equals(node.getValue())) {
      node = node.getNext();
      hashTable.getItems().set(position, node);
      return true;
    }

    while (node != null) {
      if (value.equals(node.getValue())) {
        previousNode.setNext(node.getNext());
        return true;
      }
      previousNode = node;
      node = node.getNext();
    }

    return false;
  }

  @Override
  public T find(HashTable<T> hashTable, T value) {
    int position = getIndex(hashTable, value);

    Node<T> node = hashTable.getItems().get(position);

    while (node != null) {
      if (value.equals(node.getValue())) {
        return node.getValue();
      }

      node = node.getNext();
    }

    return null;
  }

  @Override
  public String toString(HashTable<T> hashTable) {
    StringJoiner joiner = new StringJoiner(",");
    List<Node<T>> items = hashTable.getItems();

    for (int i = 0; i < items.size(); i++) {
      String currentItem = String.format("[%s]", i);

      Node<T> node = items.get(i);

      while (node.getValue() != null) {
        currentItem += String.format("->%s", node.getValue().toString());
        node = node.getNext();
      }

      currentItem += "->null";

      joiner.add(currentItem);
    }

    return joiner.toString();
  }

}
