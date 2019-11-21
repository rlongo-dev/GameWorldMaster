package model;


public class State {

  private long stateId;
  private String name;
  private long parentStateId;


  public long getStateId() {
    return stateId;
  }

  public void setStateId(long stateId) {
    this.stateId = stateId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getParentStateId() {
    return parentStateId;
  }

  public void setParentStateId(long parentStateId) {
    this.parentStateId = parentStateId;
  }

}
