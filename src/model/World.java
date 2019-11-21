package model;


public class World {

  private long worldId;
  private String name;
  private long parentWorldId;


  public long getWorldId() {
    return worldId;
  }

  public void setWorldId(long worldId) {
    this.worldId = worldId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getParentWorldId() {
    return parentWorldId;
  }

  public void setParentWorldId(long parentWorldId) {
    this.parentWorldId = parentWorldId;
  }

}
