const { hello } = require('../src/index')

describe('tests for index.js', () => {

  describe('function hello', () => {

    test('it returns hello', () => {
      const helloResponse = hello()
      expect(helloResponse).toStrictEqual('world')
    })

  })
})