package br.com.gomide.hashing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.gomide.hashing.model.HashTable;

public class HashLinearProbTest {
  @Test
  void createANewHashTable() {
    IHashing<Integer> hashingService = new HashLinearProb<Integer>();
    HashTable<Integer> hashTable = hashingService.createHashTable(8);

    assertEquals(hashTable.getItems().size(), 8);

    assertEquals(hashingService.toString(hashTable),
        "0->FREE:,1->FREE:,2->FREE:,3->FREE:,4->FREE:,5->FREE:,6->FREE:,7->FREE:");
  }
}
