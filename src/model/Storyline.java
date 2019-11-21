package model;


public class Storyline {

  private long storylineId;
  private String name;
  private String description;
  private String type;
  private long beginTime;
  private long endTime;
  private long worldId;
  private long regionId;
  private long locationId;


  public long getStorylineId() {
    return storylineId;
  }

  public void setStorylineId(long storylineId) {
    this.storylineId = storylineId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public long getBeginTime() {
    return beginTime;
  }

  public void setBeginTime(long beginTime) {
    this.beginTime = beginTime;
  }


  public long getEndTime() {
    return endTime;
  }

  public void setEndTime(long endTime) {
    this.endTime = endTime;
  }


  public long getWorldId() {
    return worldId;
  }

  public void setWorldId(long worldId) {
    this.worldId = worldId;
  }


  public long getRegionId() {
    return regionId;
  }

  public void setRegionId(long regionId) {
    this.regionId = regionId;
  }


  public long getLocationId() {
    return locationId;
  }

  public void setLocationId(long locationId) {
    this.locationId = locationId;
  }

}
