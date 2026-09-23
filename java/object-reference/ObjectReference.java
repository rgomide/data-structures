import java.util.Objects;

public class ObjectReference {

  private Integer id;
  private String value;
  private ObjectReference next;

  public ObjectReference(Integer id, String value) {
    this.id = id;
    this.value = value;
    // next começa como null por padrão: atributos de referência não inicializados valem null
  }

  public static void main(String[] args) {
    // 1. Encadeando objetos por referência
    ObjectReference objA = new ObjectReference(1, "A");
    ObjectReference objB = new ObjectReference(2, "B");

    objA.setNext(objB); // objA.next aponta para o MESMO objeto que objB

    System.out.println("== 1. Encadeamento ==");
    printChain(objA);

    // 2. Alterar objB reflete em objA.next, pois ambos referenciam o mesmo objeto
    objB.setValue("B*");

    System.out.println("\n== 2. Alteração via outra referência ==");
    printChain(objA);
    System.out.printf("objA.getNext() == objB ===> %s%n", objA.getNext() == objB);

    // 3. Atribuição copia a referência, não o objeto (aliasing)
    ObjectReference alias = objA;
    alias.setValue("A*");

    System.out.println("\n== 3. Aliasing ==");
    System.out.printf("objA: %s%n", objA);
    System.out.printf("alias == objA ===> %s%n", alias == objA);

    // 4. Java passa a referência por valor
    System.out.println("\n== 4. Passagem de referência para método ==");
    changeValue(objA);
    System.out.printf("após changeValue:   %s%n", objA);
    reassign(objA);
    System.out.printf("após reassign:      %s%n", objA);

    // 5. == compara referências; equals compara conteúdo (aqui, apenas o id)
    ObjectReference objC = new ObjectReference(1, "C");

    System.out.println("\n== 5. == vs equals ==");
    System.out.printf("objC: %s%n", objC);
    System.out.printf("objA == objC      ===> %s%n", objA == objC);
    System.out.printf("objA.equals(objC) ===> %s%n", objA.equals(objC));

    // 6. Removendo um nó: basta deixar de referenciá-lo
    ObjectReference objD = new ObjectReference(3, "D");
    objB.setNext(objD);                 // A -> B -> D
    objA.setNext(objA.getNext().getNext()); // A -> D (B fica inalcançável a partir de A)

    System.out.println("\n== 6. Removendo B do encadeamento ==");
    printChain(objA);

    // 7. Acessar membro de uma referência nula lança NullPointerException
    System.out.println("\n== 7. Referência nula ==");
    try {
      objD.getNext().getValue();
    } catch (NullPointerException e) {
      System.out.println("NullPointerException: objD.getNext() é null");
    }
  }

  private static void changeValue(ObjectReference obj) {
    obj.setValue("alterado"); // altera o objeto apontado: visível para quem chamou
  }

  private static void reassign(ObjectReference obj) {
    obj = new ObjectReference(99, "novo"); // altera só a cópia local da referência
  }

  // Percorre o encadeamento seguindo as referências next até encontrar null
  private static void printChain(ObjectReference start) {
    StringBuilder sb = new StringBuilder();
    ObjectReference current = start;
    while (current != null) {
      sb.append(current.getValue()).append(" -> ");
      current = current.getNext();
    }
    System.out.println(sb.append("null"));
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public ObjectReference getNext() {
    return next;
  }

  public void setNext(ObjectReference next) {
    this.next = next;
  }

  // Mostra apenas o id do próximo: imprimir next inteiro seria recursivo e
  // entraria em loop infinito (StackOverflowError) em encadeamentos circulares
  @Override
  public String toString() {
    Integer nextId = next == null ? null : next.getId();
    return "[id = " + id + ", value = " + value + ", next.id = " + nextId + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    ObjectReference other = (ObjectReference) obj;
    return Objects.equals(id, other.id);
  }

}
