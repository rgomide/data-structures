package br.com.gomide.binary_tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {

  @Test
  void createANewTree() {
    IBinaryTree<Integer> binaryTreeOps = new BinaryTree<>();
    Integer[] elements = new Integer[] { 6, 2, 8, 1, 4, 3 };

    Node<Integer> rootNode = binaryTreeOps.createTree(elements);

    assertEquals(binaryTreeOps.toString(rootNode), "root:6 (left:2 (left:1 right:4 (left:3 ))right:8 )");
  }

  @Test
  void performASetOfInsertions() {
    IBinaryTree<Integer> binaryTreeOps = new BinaryTree<>();
    Node<Integer> rootNode = binaryTreeOps.createTree(6);

    assertEquals(binaryTreeOps.toString(rootNode), "root:6 ");

    binaryTreeOps.insert(rootNode, 2);
    assertEquals(binaryTreeOps.toString(rootNode), "root:6 (left:2 )");

    binaryTreeOps.insert(rootNode, 8);
    assertEquals(binaryTreeOps.toString(rootNode), "root:6 (left:2 right:8 )");

    binaryTreeOps.insert(rootNode, 1);
    assertEquals(binaryTreeOps.toString(rootNode), "root:6 (left:2 (left:1 )right:8 )");

    binaryTreeOps.insert(rootNode, 1);
    assertEquals(binaryTreeOps.toString(rootNode), "root:6 (left:2 (left:1 )right:8 )");

    binaryTreeOps.insert(rootNode, 4);
    assertEquals(binaryTreeOps.toString(rootNode), "root:6 (left:2 (left:1 right:4 )right:8 )");

    binaryTreeOps.insert(rootNode, 3);
    assertEquals(binaryTreeOps.toString(rootNode), "root:6 (left:2 (left:1 right:4 (left:3 ))right:8 )");

    binaryTreeOps.insert(rootNode, 3);
    assertEquals(binaryTreeOps.toString(rootNode), "root:6 (left:2 (left:1 right:4 (left:3 ))right:8 )");
  }

  @Test
  void performASetOfRemovals() {
    IBinaryTree<Integer> binaryTreeOps = new BinaryTree<>();
    Integer[] elements = new Integer[] { 37, 20, 10, 30, 80, 100, 5, 180, 90 };

    Node<Integer> rootNode = binaryTreeOps.createTree(elements);

    assertEquals(binaryTreeOps.toString(rootNode),
        "root:37 (left:20 (left:10 (left:5 )right:30 )right:80 (right:100 (left:90 right:180 )))");

    binaryTreeOps.remove(rootNode, 180);
    assertEquals(binaryTreeOps.toString(rootNode),
        "root:37 (left:20 (left:10 (left:5 )right:30 )right:80 (right:100 (left:90 )))");

    binaryTreeOps.remove(rootNode, 80);
    assertEquals(binaryTreeOps.toString(rootNode),
        "root:37 (left:20 (left:10 (left:5 )right:30 )right:100 (left:90 ))");

    binaryTreeOps.remove(rootNode, 10);
    assertEquals(binaryTreeOps.toString(rootNode), "root:37 (left:20 (left:5 right:30 )right:100 (left:90 ))");

    binaryTreeOps.remove(rootNode, 20);
    assertEquals(binaryTreeOps.toString(rootNode), "root:37 (left:30 (left:5 )right:100 (left:90 ))");

    binaryTreeOps.remove(rootNode, 37);
    assertEquals(binaryTreeOps.toString(rootNode), "root:100 (left:90 (left:30 (left:5 )))");
  }

  @Test
  void getAnElement() {
    IBinaryTree<Integer> binaryTreeOps = new BinaryTree<>();
    Integer[] elements = new Integer[] { 6, 2, 8, 1, 4, 3 };

    Node<Integer> rootNode = binaryTreeOps.createTree(elements);

    Node<Integer> node = binaryTreeOps.getByElement(rootNode, 8);

    assertEquals(node.getValue(), 8);
  }

  @Test
  void dontFindRequiredElement() {
    IBinaryTree<Integer> binaryTreeOps = new BinaryTree<>();
    Integer[] elements = new Integer[] { 6, 2, 8, 1, 4, 3 };

    Node<Integer> rootNode = binaryTreeOps.createTree(elements);

    Node<Integer> node = binaryTreeOps.getByElement(rootNode, 10);

    assertNull(node);
  }

  @Test
  void checkNodeDegree() {
    IBinaryTree<Integer> binaryTreeOps = new BinaryTree<>();
    Integer[] elements = new Integer[] { 6, 2, 8, 1, 4, 3 };

    Node<Integer> rootNode = binaryTreeOps.createTree(elements);

    assertEquals(binaryTreeOps.degree(rootNode, 8), 0);
    assertEquals(binaryTreeOps.degree(rootNode, 2), 2);
    assertEquals(binaryTreeOps.degree(rootNode, 4), 1);
    assertNull(binaryTreeOps.degree(rootNode, 10));
  }

  @Test
  void getFather() {
    IBinaryTree<Integer> binaryTreeOps = new BinaryTree<>();
    Integer[] elements = new Integer[] { 6, 2, 8, 1, 4, 3 };

    Node<Integer> rootNode = binaryTreeOps.createTree(elements);

    assertEquals(binaryTreeOps.getFather(rootNode, 8).getValue(), 6);
    assertEquals(binaryTreeOps.getFather(rootNode, 1).getValue(), 2);
    assertNull(binaryTreeOps.getFather(rootNode, 6));
  }

  @Test
  void getBrother() {
    IBinaryTree<Integer> binaryTreeOps = new BinaryTree<>();
    Integer[] elements = new Integer[] { 6, 2, 8, 1, 4, 3 };

    Node<Integer> rootNode = binaryTreeOps.createTree(elements);

    assertEquals(binaryTreeOps.getBrother(rootNode, 8).getValue(), 2);
    assertNull(binaryTreeOps.getBrother(rootNode, 3));
  }

  @Test
  void calculateTreeDepths() {
    IBinaryTree<Integer> binaryTreeOps = new BinaryTree<>();
    Integer[] elements = new Integer[] { 6, 2, 8, 1, 4, 3 };

    Node<Integer> rootNode = binaryTreeOps.createTree(elements);

    assertEquals(binaryTreeOps.calculateTreeDepth(rootNode), 3);
  }

  @Test
  void calculateNodeLevel() {
    IBinaryTree<Integer> binaryTreeOps = new BinaryTree<>();
    Integer[] elements = new Integer[] { 6, 2, 8, 1, 4, 3 };

    Node<Integer> rootNode = binaryTreeOps.createTree(elements);

    assertEquals(binaryTreeOps.calculateNodeLevel(rootNode, 8), 1);
    assertEquals(binaryTreeOps.calculateNodeLevel(rootNode, 4), 2);
    assertNull(binaryTreeOps.calculateNodeLevel(rootNode, null));
  }

}
