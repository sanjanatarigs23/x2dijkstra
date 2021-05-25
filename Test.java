



import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests backend's methods for the Fast Route program.
 */


class Test extends CS400Graph<String> {


  /**
   * This method tests the functionality of containsCity. containsCity should return true if graph
   * contains the entered city.
   */
  @org.junit.jupiter.api.Test
  void testContainsCity() {
    BackEnd map = new BackEnd();

    if (map.containsCity("seattle") == false) {
      fail("containsCity() fails");
    }

    if (map.containsCity("madison")) {
      fail("containsCity() fails");
    }
  }


  /**
   * This method tests the functionality of totalDistance method. totalDistance should return true
   * if the int value is correct.
   */
  @org.junit.jupiter.api.Test
  void distance() {
    BackEnd one = new BackEnd();
    String source = "seattle";
    String destination = "spokane";
    if (one.totalDistance(source, destination) != 50) {
      fail("Wrong distance.");
    }
  }


  /**
   * This method tests the functionality of shortestPath method. shortestPath should return true if
   * the method passes the correct shortest path.
   */
  @org.junit.jupiter.api.Test
  void shortestPath() {
    BackEnd two = new BackEnd();
    String source = "seattle";
    String destination = "spokane";

    if (!(two.fastestRoute(source, destination).toString().equals("[seattle, spokane]"))) {
      fail("Wrong shortest route.");
    }
  }

}
