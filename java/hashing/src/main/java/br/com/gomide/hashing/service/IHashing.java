package br.com.gomide.hashing.service;

import br.com.gomide.hashing.model.HashTable;

public interface IHashing<T extends Comparable<T>> {

  HashTable<T> createHashTable(int n);

  boolean insert(HashTable<T> hashTable, T value);

  boolean remove(HashTable<T> hashTable, T value);

  T search(HashTable<T> hashTable, T value);

  String toString(HashTable<T> hashTable);

}