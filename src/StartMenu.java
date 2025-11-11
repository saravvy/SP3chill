import utils.FileIO;
import utils.TextUI;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StartMenu {

    public void showChoices() {
        System.out.println("Chose from below:");
        System.out.println("1. Login");
        System.out.println("2. Sign up");
    }

    public void switchChoices(FileIO io) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();

        switch (choice) {

            case "1":

                System.out.println("Log in");

                System.out.println("enter username:");
                String username = scan.nextLine();

                System.out.println("enter password:");
                String password = scan.nextLine();

                ArrayList<String> users = io.readData("data/login.csv");
                if (!users.isEmpty()) {

                    for (String s : users) {
                        String[] data = s.split(";");
                        String storedUsername = data[0];
                        String storedPassword = data[1];

                        if (storedUsername.equals(username) && storedPassword.equals(password)) {
                            System.out.println("User logged in");

                        } else if (!storedUsername.equals(username) && !storedPassword.equals(password)) {
                            System.out.println("Wrong username or password. Try again.");
                            caseTwo(io);

                        } else {
                            System.out.println("hej");
                        }
                    }
                }
                break;

            case "2":
                caseTwo(io);
                break;
            default:
                System.out.println("Fail");
                showChoices();
                switchChoices(io);

        }


    }

    public void caseTwo(FileIO io) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Sign up");

        System.out.println("Create username:");
        String newUsername = scan.nextLine();

        System.out.println("Create password:");
        String newPassword = scan.nextLine();

        try (FileWriter writer = new FileWriter("data/login.csv", true)) { // true = append
            writer.write(newUsername + ";" + newPassword + "\n");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
