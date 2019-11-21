package model;


public class Condition {

  private long conditionId;
  private String name;
  private String type;
  private long encounterId;


  public long getConditionId() {
    return conditionId;
  }

  public void setConditionId(long conditionId) {
    this.conditionId = conditionId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public long getEncounterId() {
    return encounterId;
  }

  public void setEncounterId(long encounterId) {
    this.encounterId = encounterId;
  }

}
