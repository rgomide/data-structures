const {
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
} = require('../src/binary-tree')

describe('binary-tree tests', () => {

  describe('createTree function', () => {

    test('create a new tree with an array of elements', () => {
      const elements = [6, 2, 8, 1, 4, 3]
      const tree = createTree(elements)
      const stringTree = toString(tree)

      expect(stringTree).toEqual("root:6 (left:2 (left:1 right:4 (left:3 ))right:8 )")
    })

    test('create a new tree with a single element', () => {
      const element = 6
      const tree = createTree(element)
      const stringTree = toString(tree)

      expect(stringTree).toEqual("root:6 ")
    })

  })

  describe('insert function', () => {

    test('perform a set of insertions', () => {
      const tree = createTree(6)

      let stringTree = toString(tree)
      expect(stringTree).toEqual("root:6 ")

      insert(tree, 2)
      stringTree = toString(tree)
      expect(stringTree).toEqual("root:6 (left:2 )")

      insert(tree, 8)
      stringTree = toString(tree)
      expect(stringTree).toEqual("root:6 (left:2 right:8 )")

      insert(tree, 1)
      stringTree = toString(tree)
      expect(stringTree).toEqual("root:6 (left:2 (left:1 )right:8 )")

      insert(tree, 1)
      stringTree = toString(tree)
      expect(stringTree).toEqual("root:6 (left:2 (left:1 )right:8 )")

      insert(tree, 4)
      stringTree = toString(tree)
      expect(stringTree).toEqual("root:6 (left:2 (left:1 right:4 )right:8 )")

      insert(tree, 3)
      stringTree = toString(tree)
      expect(stringTree).toEqual("root:6 (left:2 (left:1 right:4 (left:3 ))right:8 )")

      insert(tree, 3)
      stringTree = toString(tree)
      expect(stringTree).toEqual("root:6 (left:2 (left:1 right:4 (left:3 ))right:8 )")
    })

  })

  describe('remove function', () => {

    test('perform a set of removals', () => {
      const tree = createTree([37, 20, 10, 30, 80, 100, 5, 180, 90])

      let stringTree = toString(tree)
      expect(stringTree).toEqual("root:37 (left:20 (left:10 (left:5 )right:30 )right:80 (right:100 (left:90 right:180 )))")

      expect(remove(tree, 180)).toBeTruthy()
      stringTree = toString(tree)
      expect(stringTree).toEqual("root:37 (left:20 (left:10 (left:5 )right:30 )right:80 (right:100 (left:90 )))")

      remove(tree, 80)
      stringTree = toString(tree)
      expect(stringTree).toEqual("root:37 (left:20 (left:10 (left:5 )right:30 )right:100 (left:90 ))")

      remove(tree, 10)
      stringTree = toString(tree)
      expect(stringTree).toEqual("root:37 (left:20 (left:5 right:30 )right:100 (left:90 ))")

      remove(tree, 20)
      stringTree = toString(tree)
      expect(stringTree).toEqual("root:37 (left:30 (left:5 )right:100 (left:90 ))")

      remove(tree, 37)
      stringTree = toString(tree)
      expect(stringTree).toEqual("root:100 (left:90 (left:30 (left:5 )))")

      expect(remove(tree, 370)).toBeFalsy()
    })

  })

  describe('getElement function', () => {

    test('return an existing element', () => {
      const tree = createTree([6, 2, 8, 1, 4, 3])
      const node = getElement(tree, 8)

      expect(node.value).toEqual(8)
    })

    test('do not find an element', () => {
      const tree = createTree([6, 2, 8, 1, 4, 3])
      const node = getElement(tree, 10)

      expect(node).toBeUndefined()
    })

  })

  describe('degree function', () => {

    test('check nodes degrees', () => {
      const tree = createTree([6, 2, 8, 1, 4, 3])

      expect(degree(tree, 8)).toEqual(0)
      expect(degree(tree, 2)).toEqual(2)
      expect(degree(tree, 4)).toEqual(1)

      expect(degree(tree, 10)).toBeUndefined()
    })

  })

  describe('getFather function', () => {

    test('check fathers', () => {
      const tree = createTree([6, 2, 8, 1, 4, 3])

      expect(getFather(tree, 8).value).toEqual(6)
      expect(getFather(tree, 1).value).toEqual(2)

      expect(getFather(tree, 6)).toBeUndefined()
    })

  })

  describe('getBrother function', () => {

    test('check node brothers', () => {
      const tree = createTree([6, 2, 8, 1, 4, 3])

      expect(getBrother(tree, 8).value).toEqual(2)

      expect(getBrother(tree, 3)).toBeUndefined()
    })

  })

  describe('calculateTreeDepth function', () => {

    test('check tree depth', () => {
      const tree = createTree([6, 2, 8, 1, 4, 3])

      expect(calculateTreeDepth(tree)).toEqual(3)
    })

  })

  describe('calculateNodeLevel function', () => {

    test('check node levels', () => {
      const tree = createTree([6, 2, 8, 1, 4, 3])

      expect(calculateNodeLevel(tree, 8)).toEqual(1)
      expect(calculateNodeLevel(tree, 4)).toEqual(2)

      expect(calculateNodeLevel(tree, 40)).toBeUndefined()
    })

  })

})