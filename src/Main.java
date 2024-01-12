import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    getUserInput();
  }

  public static void getUserInput() {
    Scanner sc = new Scanner(System.in);
    boolean running = true;
    ArrayList<String> groceryList = new ArrayList<>();

    while (running) {
      System.out.print("""
          Available actions\s
          0 - to shutdown\s
          1 - to add item(s) to list (comma separated list)\s
          2 - to remove any items (comma separated list)\s
          Enter a number for which action you want to do:\s"""
      );
      String response = sc.nextLine();
      int choice = Integer.parseInt(response);

      if (choice == 0) {
        System.out.println("Quiting application...");
        printList(groceryList);
        running = false;
      } else if (choice == 1) {
        System.out.println("Enter list items...");
        String userInput = sc.nextLine();
        String[] list = userInput.split(",");

        for (int i = 0; i < list.length; i++) {
          if (!groceryList.contains(list[i])) {
            groceryList.add(list[i]);
          }
        }

        printList(groceryList);
      } else if (choice == 2) {
        System.out.println("Enter items to remove...");
        String items = sc.nextLine();
        String[] removed = items.split(",");

        for (int i = 0; i < removed.length; i++) {
          groceryList.remove(removed[i]);
        }

        printList(groceryList);
      }
    }
  }

  public static void printList(ArrayList<String> list) {
    list.sort(Comparator.naturalOrder());
    System.out.println("Grocery list = " + list);
    System.out.println();
  }
}
