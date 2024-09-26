public class ObjectReference {

  private Integer id;
  private String value;
  private ObjectReference next;

  public static void main(String[] args) {
    ObjectReference objA = new ObjectReference();

    objA.setId(1);
    objA.setValue("A");
    objA.setNext(null);

    ObjectReference objB = new ObjectReference();

    objB.setId(2);
    objB.setValue("B");
    objB.setNext(null);

    objA.setNext(objB);

    System.out.println(String.format("objA: %s", objA));

    objB.setValue("B*");

    System.out.println(String.format("objA: %s",objA));

    ObjectReference objC = new ObjectReference();
    objC.setId(1);

    System.out.println("");
    System.out.println(String.format("objC: %s", objC));

    System.out.println(String.format("objA == objC      ===> %s", objA == objC));
    System.out.println(String.format("objA.equals(objC) ===> %s", objA.equals(objC)));
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

  public String toString() {
    return "[id = " + id + ", value = " + value + ", next = " + next + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ObjectReference other = (ObjectReference) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}