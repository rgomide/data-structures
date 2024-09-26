const isEqual = (a, b) => {
  return JSON.stringify(a) === JSON.stringify(b)
}

const a = { id: 1 }
const b = { id: 1 }
const c = a

console.log('a               ===>', a)
console.log('b               ===>', b)
console.log('c               ===>', c)

console.log('')

console.log('a == a          ===>', a == a)
console.log('a == b          ===>', a == b)
console.log('a == c          ===>', a == c)
console.log('a === a         ===>', a === a)
console.log('a === b         ===>', a === b)
console.log('a === c         ===>', a === c)
console.log('Object.is(a, a) ===>', Object.is(a, a))
console.log('Object.is(a, b) ===>', Object.is(a, b))
console.log('Object.is(a, c) ===>', Object.is(a, c))
console.log('isEqual(a, b)   ===>', isEqual(a, b))