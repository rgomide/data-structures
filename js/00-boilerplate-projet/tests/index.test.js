const { hello, sum } = require('../src/index')

describe('tests for index.js', () => {

  describe('function hello', () => {

    test('it returns hello', () => {
      const helloResponse = hello()
      expect(helloResponse).toStrictEqual('world')
    })

  })

  describe('function sum', () => {

    test('it returns 2 + 3 = 5', () => {
      const result = sum(2, 3)
      expect(result).toStrictEqual(5)
    })

    test('it returns 2 - 4 = -2', () => {
      const result = sum(2, -4)
      expect(result).toStrictEqual(-2)
    })

    test('it returns 3 + "abc" = undefined', () => {
      const result = sum(3, 'abc')
      expect(result).toBeUndefined()
    })

  })

})