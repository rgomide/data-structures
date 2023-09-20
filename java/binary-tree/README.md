# Binary Tree

In this folder we have a Binary Tree project with the [IBinaryTree](src/main/java/br/com/gomide/binary_tree/IBinaryTree.java) interface and [Node](src/main/java/br/com/gomide/binary_tree/Node.java) class.

The `IBinaryTree` contains the common methods like create a new tree, insert/remove elements, display a tree...

`Node` class represents a tree node. It have three attributes: `value`, `left` and `right`. 

The attribute `value` represents the node element. So it is a generic type extended from [Comparable](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html).

The `left` and `right` elements are pointers to the node's children.

## Exercise

We have a test class to check [BinaryTree](src/main/java/br/com/gomide/binary_tree/BinaryTree.java) implementation.

You should open the [BinaryTreeTest](src/test/java/br/com/gomide/binary_tree/BinaryTreeTest.java) to know how `BinaryTree` will work.

Complete the `BinaryTree` and `Node` implementations to make all tests green.