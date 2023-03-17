/**
 * This method creates a new tree returning the root Node. 
 * You can use a single or an array of elements.
 * 
 * @param {number|number[]} element 
 * @returns {object} tree - tree object
 */
function createTree(element) { }

/**
 * Calculates the degree of a single Node
 * 
 * @param {object} tree
 * @param {number} value
 * @returns {number} tree - degree value
 */
function degree(tree, value) { }

/**
 * Given a root node, inserts an element. Duplicated elements are now allowed.
 * 
 * @param {object} tree
 * @param {number} value
 */
function insert(tree, value) { }

/**
 * Given a root node, removes an element
 * 
 * @param {object} tree
 * @param {number} value
 * @returns {boolean} return true if a node was removed and false if not
 */
function remove(tree, value) { }

/**
 * Get the father node
 * 
 * @param {object} tree
 * @param {number} value
 * @returns {object} father - turns the father node element or undefined
 */
function getFather(tree, value) { }

/**
 * Get the brother node
 * 
 * @param {object} tree
 * @param {number} value
 * @returns {object} brother - returns the brother node or null
 */
function getBrother(tree, value) { }

/**
 * Find and return a Node by element
 * 
 * @param {object} tree
 * @param {number} value
 * @returns {object} element - return the Node that contains the element or null
 */
function getElement(tree, value) { }

/**
 * Calculate the tree depth
 * 
 * @param {object} tree
 * @returns {number} depth - tree depth
 */
function calculateTreeDepth(tree) { }

function calculateNodeLevel(tree, value) { }

/**
 * Should use the String representation of a tree. This is an example for a
 * <pre>
 * tree:
 * root:6 (left:2 (left:1 right:4 (left:3 ))right:8 )
 * </pre>
 * 
 * @param {object} node
 * @returns {string} String representation of a tree.
 */
function toString(tree) { }

module.exports = {
  createTree,
  degree,
  insert,
  remove,
  getFather,
  getBrother,
  getElement,
  calculateTreeDepth,
  calculateNodeLevel,
  toString
}