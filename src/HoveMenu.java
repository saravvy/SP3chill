import java.util.Scanner;

public class HoveMenu {


    public static void displayMainMenu(){
        Scanner input = new Scanner(System.in);

        System.out.println("                Main Menu         ");
        System.out.println("Choose an option:");
        System.out.println("1. Show all movies");
        System.out.println("2. Search a movie");

        int choice = input.nextInt();
    }
}
