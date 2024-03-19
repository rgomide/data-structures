package br.com.gomide.hashing.service;

import br.com.gomide.hashing.model.HashTable;
import br.com.gomide.hashing.model.Node;
import br.com.gomide.hashing.model.NodeStatus;

public class HashQuadraticProb<T extends Comparable<T>> implements IHashing<T> {

  @Override
  public HashTable<T> createHashTable(int n) {
    return new HashTable<T>(n);
  }

  @Override
  public void insert(HashTable<T> hashTable, T[] values) {
    for (T value : values) {
      insert(hashTable, value);
    }
  }

  @Override
  public boolean insert(HashTable<T> hashTable, T value) {
    int tableSize = hashTable.getItems().size();

    int position = value.hashCode() % tableSize;

    for (int k = 0; k < tableSize - 1; k++) {
      position = (position + k) % tableSize;

      Node<T> element = hashTable.getItems().get(position);
      if (!element.getStatus().equals(NodeStatus.BUSY)) {
        element.setValue(value);
        element.setStatus(NodeStatus.BUSY);

        return true;
      }
    }

    return false;
  }

  @Override
  public boolean remove(HashTable<T> hashTable, T value) {
    int tableSize = hashTable.getItems().size();

    int position = value.hashCode() % tableSize;

    for (int k = 0; k < tableSize - 1; k++) {
      position = (position + k) % tableSize;

      Node<T> element = hashTable.getItems().get(position);
      if (element.getStatus().equals(NodeStatus.BUSY) && value.equals(element.getValue())) {
        element.setStatus(NodeStatus.REMOVED);

        return true;
      }
    }

    return false;
  }

  @Override
  public int findIndex(HashTable<T> hashTable, T value) {
    int tableSize = hashTable.getItems().size();

    for (int i = 0; i < tableSize - 1; i++) {
      int position = ((value.hashCode() % tableSize) + i) % tableSize;

      Node<T> element = hashTable.getItems().get(position);
      if (element.getStatus().equals(NodeStatus.BUSY) && value.equals(element.getValue())) {
        return position;
      }
    }

    return -1;
  }

  @Override
  public String toString(HashTable<T> hashTable) {
    return hashTable.toString();
  }

}
