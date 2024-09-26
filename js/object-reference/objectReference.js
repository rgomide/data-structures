const objA = {
  id: 1,
  value: 'A',
  next: null
}

const objB = {
  id: 2,
  value: 'B',
  next: null
}

objA.next = objB

console.log(objA)

objB.value = 'B*'

console.log(objA)