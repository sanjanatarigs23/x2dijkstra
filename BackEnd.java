
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BackEnd extends CS400Graph<String> {
  static CS400Graph<String> map = DataWrangler.getMap();

  /**
   * This method prints out whatever is in the text file with just cities
   */
  public void printCities() {
    Scanner sc;
    try {
      File file = new File("Locations.txt");
      sc = new Scanner(file);
      while (sc.hasNextLine()) {
        System.out.println(sc.nextLine());
      }
    } catch (FileNotFoundException e) {
      System.out.print("File not found.");
    }
  }

  /**
   * This method checks to see if the passed city is in the text file with just the cities
   * 
   * @param city string input with city that user wants to input
   * @return true if list already contain inputed city false if input does not exist
   * 
   */
  public boolean containsCity(String city) {
    return map.containsVertex(city);
  }


  /**
   * Uses Dijkstra's shortest path algorithm to find and return the shortest path between two
   * vertices in this graph: start and end. This path contains an ordered list of the data within
   * each node on this path, and also the distance or cost of all edges that are a part of this
   * path.
   * 
   * @param depart  city within first node in path
   * @param arrival city item within last node in path
   * @return the shortest path from one city to another, as computed by Dijkstra's algorithm
   * @throws NoSuchElementException when no path from one city to another can be found, including
   *                                when no vertex containing depart or arrival can be found
   */
  public List<String> fastestRoute(String depart, String arrival) {
    if (depart == null || arrival == null) {
      throw new NullPointerException("invalid input!");
    }
    return map.shortestPath(depart, arrival);
  }

  /**
   * This method returns the total number of miles that it takes to go on the shortest path.
   * 
   * @param depart  city within first node in path
   * @param arrival city item within last node in path
   * @return total miles between the two paths
   */
  public int totalDistance(String depart, String arrival) {
    if (fastRouteCheck(depart, arrival)) {
      return map.getPathCost(depart, arrival);
    } else {
      return -1;
    }
  }

  /**
   * This method checks the validity of city input
   * 
   * @param city string user input
   * @return true is input city contain only letters false if not
   */
  public static boolean validCity(String city) {
    if (city == null) {
      return false;
    }
    int len = city.length();
    for (int i = 0; i < len; i++) {
      if ((Character.isLetter(city.charAt(i)) == false)) {
        return false;
      }
    }
    return true;
  }

  /**
   * This method check if a valid path can be found
   * 
   * @param depart  city within first node in path
   * @param arrival city item within last node in path
   * @return false is exceptions occur during finding shortest route, true if route is successfully
   *         found
   */
  public boolean fastRouteCheck(String depart, String arrival) {
    try {
      fastestRoute(depart, arrival);

    } catch (NoSuchElementException e) {
      return false;
    } catch (NullPointerException e1) {
      return false;
    }
    return true;
  }
}
