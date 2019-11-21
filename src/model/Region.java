package model;


public class Region {

  private long regionId;
  private String name;
  private long worldId;
  private long parentRegionId;


  public long getRegionId() {
    return regionId;
  }

  public void setRegionId(long regionId) {
    this.regionId = regionId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getWorldId() {
    return worldId;
  }

  public void setWorldId(long worldId) {
    this.worldId = worldId;
  }


  public long getParentRegionId() {
    return parentRegionId;
  }

  public void setParentRegionId(long parentRegionId) {
    this.parentRegionId = parentRegionId;
  }

}
