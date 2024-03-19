package br.com.gomide.hashing.service;

import br.com.gomide.hashing.model.HashTable;

public class HashLinearProb<T extends Comparable<T>> implements IHashing<T> {

  @Override
  public HashTable<T> createHashTable(int n) {
    return new HashTable<T>(n);
  }

  @Override
  public boolean insert(HashTable<T> hashTable, T value) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean remove(HashTable<T> hashTable, T value) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public T search(HashTable<T> hashTable, T value) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String toString(HashTable<T> hashTable) {
    return hashTable.toString();
  }

}
