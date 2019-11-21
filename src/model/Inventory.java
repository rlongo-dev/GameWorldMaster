package model;


public class Inventory {

  private long inventoryId;
  private String name;
  private long entityId;
  private long businessId;
  private long conditionId;


  public long getInventoryId() {
    return inventoryId;
  }

  public void setInventoryId(long inventoryId) {
    this.inventoryId = inventoryId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getEntityId() {
    return entityId;
  }

  public void setEntityId(long entityId) {
    this.entityId = entityId;
  }


  public long getBusinessId() {
    return businessId;
  }

  public void setBusinessId(long businessId) {
    this.businessId = businessId;
  }


  public long getConditionId() {
    return conditionId;
  }

  public void setConditionId(long conditionId) {
    this.conditionId = conditionId;
  }

}
