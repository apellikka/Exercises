import java.util.ArrayList;

public class Main {


public static void main(String args[]) {

  ArrayList<Door> doors = new ArrayList<>();

  for(int i = 1; i < 101; i++) {
    Door door = new Door(i);
    doors.add(door);
}
  int modulo = 1;

  //Pass through the doors 100 times, each time opening or closing
  //the door depending on the status of the door.
  //1st time toggle all of the door
  //2nd time toggle every 2nd door
  //3rd time toggle every third door
  //and so on until the 100th door
  for(int passesLeft = 0; passesLeft < 100; passesLeft++) {
    for (int index = 0; index < 100; index++) {
      if (modulo == 1) {
        doors.get(index).toggleDoor();
      }
      if (modulo > 1 && doors.get(index).doorNumber() % modulo == 0) {
        doors.get(index).toggleDoor();
      }
    }
    modulo++;
  }

  //Print the doors which are open
    for (Door door : doors) {
      if (door.doorStatus() == false) {
      System.out.println(door + " is open");
    }
    }
}
}
