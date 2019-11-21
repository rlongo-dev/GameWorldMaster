package model;


public class Entity {

  private long entityId;
  private String name;
  private long encounterId;


  public long getEntityId() {
    return entityId;
  }

  public void setEntityId(long entityId) {
    this.entityId = entityId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getEncounterId() {
    return encounterId;
  }

  public void setEncounterId(long encounterId) {
    this.encounterId = encounterId;
  }

}
