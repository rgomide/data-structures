package br.com.gomide.hashing.service;

import br.com.gomide.hashing.model.HashTable;
import br.com.gomide.hashing.model.Node;
import br.com.gomide.hashing.model.NodeStatus;

public class HashLinearProb<T extends Comparable<T>> extends Hash<T> {

  @Override
  public boolean insert(HashTable<T> hashTable, T value) {
    int tableSize = hashTable.getItems().size();

    for (int i = 0; i < tableSize - 1; i++) {
      int position = ((value.hashCode() % tableSize) + i) % tableSize;

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

    for (int i = 0; i < tableSize - 1; i++) {
      int position = ((value.hashCode() % tableSize) + i) % tableSize;

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

}
