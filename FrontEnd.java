
import java.util.Scanner;

/**
 * Class for user interfaces
 */
public class FrontEnd {
  private static BackEnd backend = new BackEnd();

  public static void main(String[] args) {
    System.out.println("Welcome to Fast Route!");
    System.out.println("This app will give you the best route to your destination.");
    System.out.println("---------------------------------");

    start(Menu());
  }
  
  

  /**
   * method to print out the menu and return user input
   * 
   * @return user input
   */
  public static String Menu() { // prints the menu which gives users some options

    System.out.println("");
    System.out.println("---------------------------------");
    System.out.println("Please follow the User Guide below:");
    System.out.println("1. Enter 'HELP' for the main menu");
    System.out.println("2. Enter 'LIST' for a list of all the cities in this map");
    System.out.println("3. Enter 'MAP' to get the best route to your destination");
    System.out.println("---------------------------------");
    System.out.println("4. Enter 'QUIT' to leave");
    System.out.println("---------------------------------");
    Scanner scnr = new Scanner(System.in);
    System.out.println("Please enter:");
    String word = scnr.nextLine().toUpperCase().trim();
    return word;
  }

  /**
   * method to repeat application
   * 
   * @param word user input
   */
  public static void start(String word) {
    UserInterface(word);
  }

  public static void UserInterface(String word) {

    if (word.equals("HELP")) { // if the user wants to see the menu again
      String newWord = Menu();
      UserInterface(newWord);
    } else if (word.equals("LIST")) { // user wants to see list of cities
      backend.printCities();
      start(Menu());
    } else if (word.equals("MAP")) { // user wants to get shortest distance
      System.out.println("Please enter the city you are starting from:");
      Scanner scnr = new Scanner(System.in);
      String source = scnr.nextLine().toLowerCase().trim();
      if (backend.containsCity(source)) { // make sure source exists in our database
        System.out.println("Please enter the city you would like to go to:");
        String destination = scnr.nextLine().toLowerCase().trim();
        if (backend.containsCity(destination)) { // make sure destination exists
          if (backend.fastRouteCheck(source, destination)) { // only print if a path exists
            System.out.print("Here is the shortest route to " + destination + " : ");
            System.out.println(backend.fastestRoute(source, destination));
            System.out.println("The total distance between these locations: "
                + backend.totalDistance(source, destination));
            start(Menu());
          } else {
            System.out.println("There is no path from " + source + " to " + destination);
            start(Menu());
          }
        }
      } else {
        System.out.println(
            "Sorry, this city is not registered in our map. Please try again with another city.");
        start(Menu());
      }

    } else if (word.equals("QUIT")) { // if user wants to exit
      System.out.println("Thank you for using Fast Route! See you next time!");
      System.exit(0);
    } else {
      System.out.println("---------------------------------");
      System.out.println("You have entered an incorrect word. Please try again.");
      System.out.println("---------------------------------");
      start(Menu());
    }

  }
}
