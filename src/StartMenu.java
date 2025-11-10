import utils.FileIO;
import utils.TextUI;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StartMenu {

    public static String displayLogin(FileIO io) {
        System.out.println("Chose from below:");
        System.out.println("1. Login");
        System.out.println("2. Sign up");

        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        scan.nextLine();
        boolean login = true;

        while (login) {
            switch (choice) {

                case 1:
                    System.out.println("Log in");


                    System.out.println("enter username:");
                    String username = scan.nextLine();

                    System.out.println("enter password:");
                    String password = scan.nextLine();

                    ArrayList<String> usersData = new ArrayList<>();
                    ArrayList<String> filmData = io.readData("data/login.csv");



                    for (String s : usersData) {
                        String[] data = s.split(";");
                        String storedUsername = data[0];
                        String storedPassword = data[1];

                        if (storedUsername.equals(username) && storedPassword.equals(password)) {
                            System.out.println("User logged in");
                            login = false;


                        } else if (!storedUsername.equals(username) && !storedPassword.equals(password)) {
                            System.out.println("Wrong username or password. Try again.");
                            login = true;

                        }
                    }
                    break;

                case 2:

                    System.out.println("Sign up");


                    System.out.println("Create username:");
                    String newUsername = scan.nextLine();

                    System.out.println("Create password:");
                    String newPassword = scan.nextLine();

                    try (FileWriter writer = new FileWriter("data/login.csv", true)) { // true = append
                        writer.write(newUsername + ";" + newPassword + "\n");
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    login = false;
                    break;


            }

        }

        return "";
    }
}



