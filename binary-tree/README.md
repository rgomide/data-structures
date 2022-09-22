# Binary Tree

In this folder we have a Binary Tree project with the [IBinaryTree](src/main/java/br/com/gomide/data_structures/binary_tree/IBinaryTree.java) interface and [Node](src/main/java/br/com/gomide/data_structures/binary_tree/Node.java) class.

The `IBinaryTree` contains the common methods like create a new tree, insert/remove elements, display a tree...

`Node` class represents a tree node. It have three attributes: `value`, `left` and `right`. 

The attribute `value` represents the node element. So it is a generic type extended from [Comparable](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html).

The `left` and `right` elements are pointers to the node's children.