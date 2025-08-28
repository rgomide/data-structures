function createHeap(array) {
  // Create a heap from the input array
  let heap = [...array];
  // Starting from the last non-leaf node, heapify each node
  for (let i = Math.floor(heap.length / 2); i >= 0; i--) {
    heapify(heap, i, heap.length);
  }
  return heap;
}

function heapify(heap, i, heapSize) {
  let left = 2 * i + 1;
  let right = 2 * i + 2;
  let largest = i;
  if (left < heapSize && heap[left].matricula > heap[largest].matricula) {
    largest = left;
  }
  if (right < heapSize && heap[right].matricula > heap[largest].matricula) {
    largest = right;
  }
  if (largest !== i) {
    [heap[i], heap[largest]] = [heap[largest], heap[i]];
    heapify(heap, largest, heapSize);
  }
}

function heapSort(array) {
  let heap = createHeap(array);
  let sortedArray = [];
  while (heap.length > 0) {
    // Remove the maximum element from the heap and add it to the sorted array
    sortedArray.unshift(heap.shift());
    // Re-heapify the remaining elements
    heap = createHeap(heap);
  }
  return sortedArray;
}

const alunos = [
  { nome: 'João', matricula: 1 },
  { nome: 'Maria', matricula: 2 },
  { nome: 'JOSÉ', matricula: 3 },
  { nome: 'DENECLEY', matricula: 3 },
  { nome: 'ALVIM', matricula: 3 },
  { nome: 'Ana', matricula: 5 },
  { nome: 'Luiza', matricula: 9 },
]

const alunosOrdenadoEstavel = Array.from(alunos).sort((a, b) => a.matricula - b.matricula)
const alunosOrdenadoInstavel = heapSort(Array.from(alunos))

console.log('\x1b[36m%s\x1b[0m', 'Array Original:')
console.log(alunos)
console.log('\x1b[36m%s\x1b[0m', 'Ordenação Estável:')
console.log(alunosOrdenadoEstavel)
console.log('\x1b[36m%s\x1b[0m', 'Ordenação Instável:')
console.log(alunosOrdenadoInstavel)