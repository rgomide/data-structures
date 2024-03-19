package br.com.gomide.hashing.service;

import br.com.gomide.hashing.model.HashTable;

public abstract class Hash<T extends Comparable<T>> implements IHashing<T> {
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
  public String toString(HashTable<T> hashTable) {
    return hashTable.toString();
  }

}
