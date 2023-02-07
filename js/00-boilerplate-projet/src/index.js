function hello() {
  return 'world'
}

function sum(a, b) {
  if (isValidValue(a) && isValidValue(b)) {
    return a + b
  }
  throw 'Valores inválidos'
}

function isValidValue(value) {
  return typeof value == 'number' || value == null
}

module.exports = {
  hello,
  sum
}