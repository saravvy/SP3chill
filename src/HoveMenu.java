import utils.FileIO;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class HoveMenu {


    public void menuText() {
        System.out.println("                Main Menu         ");

    }

    public void displayMainMenu(FileIO io) throws IOException {


        System.out.println("Choose an option:");
        System.out.println("1. Show all movies");
        System.out.println("2. Search for a movie by name");
        System.out.println("3. Log out");

        switchChoice(io);


    }

    public void switchChoice(FileIO io) throws IOException {
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();


        switch (choice) {
            case "1":
                showAllMovies(io, scan);
                break;

            case "2":
                searchMovie(io, scan);

                break;

            case "3":
                logout(io, scan);
                break;


            default:
                System.out.println("invalid choice");
                menuText();
                displayMainMenu(io);

                break;
        }

    }


    public void showAllMovies(FileIO io, Scanner scan) throws IOException {

        boolean found = false;

        FilmList filmList = new FilmList();
        filmList.addFilm(io);
        ArrayList<Film> films = filmList.getFilms();


        for (Film film : films) {
            System.out.println(film);
        }
        System.out.println("What do you want to do now?");
        displayMainMenu(io);


    }

    public void searchMovie(FileIO io, Scanner scan) throws IOException {
        boolean found = false;
        FilmList filmList = new FilmList();
        filmList.addFilm(io);
        ArrayList<Film> films = filmList.getFilms();

        while (!found) {
            System.out.println("Which movie do you wanna watch?");

            String choicedMovie = scan.nextLine().toLowerCase();


            for (Film b : films) {
                if (b.getName().toLowerCase().trim().equals(choicedMovie.trim())) {
                    //films.add(b);

                    System.out.println(b);
                    System.out.println("Playing movie.....");

                    System.out.println("Finished movie");

                    System.out.println("What do you want to do now?");
                    displayMainMenu(io);
                    found = true;
                        break;
                }
            }
            if (!found) {
                System.out.println("Film not found. Try again");

            }
        }


    }

        public void logout(FileIO io, Scanner scan) {
            System.out.println("Logging out.....");

        }


    }


