package model;


public class Attribute {

  private long attributeId;
  private String name;
  private long parentAttributeId;


  public long getAttributeId() {
    return attributeId;
  }

  public void setAttributeId(long attributeId) {
    this.attributeId = attributeId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getParentAttributeId() {
    return parentAttributeId;
  }

  public void setParentAttributeId(long parentAttributeId) {
    this.parentAttributeId = parentAttributeId;
  }

}
