
public class Door {
  private boolean doorIsClosed;
  private int doorNumber;

  public Door(int doorNumber) {
    //initially all the doors are closed
    this.doorIsClosed = true;
    this.doorNumber = doorNumber;
  }

  public void toggleDoor() {
    //open or close the door depending on the status
    if (this.doorIsClosed == false) {
      this.doorIsClosed = true;
    } else {
    this.doorIsClosed = false;
  }
}

  public int doorNumber() {
    return this.doorNumber;
  }

  public String toString() {
    return "Door number " + this.doorNumber();
  }

  public boolean doorStatus() {
    return this.doorIsClosed;
  }
}
