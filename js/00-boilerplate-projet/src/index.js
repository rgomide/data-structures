function hello() {
  return 'world'
}

function sum(a, b) {
  if (isNumber(a) && isNumber(b)) {
    return a + b
  } else {
    return undefined
  }
}

function isNumber(value) {
  return typeof value == 'number'
}

module.exports = {
  hello,
  sum
}