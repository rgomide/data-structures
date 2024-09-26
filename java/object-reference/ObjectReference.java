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

    System.out.println(objA);

    objB.setValue("B*");

    System.out.println(objA);
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
    return "ObjectReference [id = " + id + ", value = " + value + ", next = " + next + "]";
  }

}