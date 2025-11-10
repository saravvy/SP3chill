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
        String choice = scan.nextLine();
        boolean login = true;

            switch (choice) {

                case "1":
                    while (login) {
                        System.out.println("Log in");


                        System.out.println("enter username:");
                        String username = scan.nextLine();

                        System.out.println("enter password:");
                        String password = scan.nextLine();

                        ArrayList<String> users = new ArrayList<>();

                        try {
                            ArrayList<String> usersData = io.readData("data/login.csv");
                            if (!usersData.isEmpty()) {
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

                        }  } } catch (NoSuchElementException e) {
                            System.out.println("No users found. Please sign up first.");
                            choice = "2";
                        }




                            }


                    break;

                case "2":

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

                    break;


            }



        return "";
    }
}



