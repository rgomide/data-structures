const { hello, sum } = require('../src/index')

describe('tests for index.js', () => {

  describe('function hello', () => {

    test('it returns hello', () => {
      const result = hello()
      expect(result).toEqual('world')
    })

  })

  describe('function sum', () => {

    test('it returns 3 + 5 = 8', () => {
      const result = sum(3, 5)
      expect(result).toStrictEqual(8)
    })

    test('it returns 3.2 + 1 = 4.2', () => {
      const result = sum(3.2, 1)
      expect(result).toStrictEqual(4.2)
    })

    test('it returns 5.4 + 2.1 = 7.5', () => {
      const result = sum(5.4, 2.1)
      expect(result).toStrictEqual(7.5)
    })

    test('it returns 2 + null = 2', () => {
      const result = sum(2, null)
      expect(result).toStrictEqual(2)
    })

    test('it returns "abc" + 2 = EXCEPTION', () => {
      try {
        const result = sum('abc', 2)
        expect(1).toEqual(2)
      } catch (exception) {
        console.log(exception)
        expect(exception).toEqual('Valores inválidos')
      }
    })

  })

})