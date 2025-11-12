import utils.FileIO;
import utils.TextUI;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StartMenu {

    public ArrayList<User> users = new ArrayList<>();

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
                caseOne(io, scan);
                break;

            case "2":
                caseTwo(io, scan);
                break;

            default:
                System.out.println("Fail");
                showChoices();
                switchChoices(io);
                break;

        }


    }

    public void caseTwo(FileIO io, Scanner scan) throws FileNotFoundException {

        System.out.println("Create username:");
        String newUsername = scan.nextLine();

        System.out.println("Create password:");
        String newPassword = scan.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/login.csv", true))) {
            writer.write(newUsername + ";" + newPassword);
            writer.newLine();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void caseOne(FileIO io, Scanner scan) throws FileNotFoundException {


        System.out.println("Log in");

        System.out.println("enter username:");
        String username = scan.nextLine();

        System.out.println("enter password:");
        String password = scan.nextLine();


        ArrayList<String> usersData = io.readData("data/login.csv");

        if (usersData.isEmpty()) {
            System.out.println("No users available. Sign up");
            caseTwo(io, scan);
        }

        boolean login = false;
        BufferedReader br = new BufferedReader(new FileReader("data/login.csv"));
        String line;
        try{
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                String Storedusername = data[0].trim();
                String Storedpassword = data[1].trim();


                if (Storedusername.equals(username) && Storedpassword.equals(password)) {
                    System.out.println("User logged in");
                    login = true;
                    break;

                }
            }
            if(!login){
                        System.out.println("Wrong username or password. Try again.");
                        showChoices();
                        switchChoices(io);

                    }

                }

            catch (FileNotFoundException e) {

        }
        catch (IOException e){


        }

        }
    }




