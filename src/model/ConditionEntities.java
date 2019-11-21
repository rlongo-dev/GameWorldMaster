package model;


public class ConditionEntities {

  private long conditionId;
  private long entityId;
  private String relationship;


  public long getConditionId() {
    return conditionId;
  }

  public void setConditionId(long conditionId) {
    this.conditionId = conditionId;
  }


  public long getEntityId() {
    return entityId;
  }

  public void setEntityId(long entityId) {
    this.entityId = entityId;
  }


  public String getRelationship() {
    return relationship;
  }

  public void setRelationship(String relationship) {
    this.relationship = relationship;
  }

}
