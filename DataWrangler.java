

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * This class uses a data file to create a graph that connects different cities.
 * 
 */

public class DataWrangler {

  public static CS400Graph<String> map = new CS400Graph<String>();

  /**
   * This method creates a graph of the various cities and their connections found in Map.txt.
   * 
   */
  public static void graph() {
    String source = "";
    String target = "";
    String weight = "";
    String[] location = new String[3]; // stores the locations and distance

    try {
      File file = new File("Map.txt"); // create a new file holding the Map.txt file
      Scanner sc = new Scanner(file);
      while (sc.hasNextLine()) { // go through the text file
        String str = sc.nextLine();
        location = str.toLowerCase().split(", "); // split to get location and destinations
        source = location[0];
        target = location[1];
        weight = location[2];
        int distance = Integer.parseInt(weight);
        map.insertVertex(source); // call insertVertex to add locations to graph
        map.insertVertex(target);
        map.insertEdge(source, target, distance); // call insertEdge to add to graph
      }
      sc.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error - file not found");
      e.printStackTrace();
    }

  }

  /**
   * This method calls the graph method and return the result of that call.
   * 
   * @return map after calling the graph method
   * 
   */
  public static CS400Graph<String> getMap() {
    graph();
    return map;
  }

  public static void main(String[] args) throws FileNotFoundException {
    graph();
  }

}


