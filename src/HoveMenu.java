import utils.FileIO;

import java.util.ArrayList;
import java.util.Scanner;

public class HoveMenu {


    public void displayMainMenu() {

        System.out.println("                Main Menu         ");
        System.out.println("Choose an option:");
        System.out.println("1. Show all movies");
        System.out.println("2. Search for a movie");

    }

        public void switchChoice(FileIO io) {
            Scanner input = new Scanner(System.in);

            String choice = input.nextLine();

            switch (choice) {
                case "1":

                    FilmList filmList = new FilmList();
                    filmList.addFilm(io);

                    ArrayList<Film> films = filmList.getFilms();
                    for (Film film : films) {
                        System.out.println(film);
                    }

                    System.out.println("Which movie do you wanna watch?");
                    Scanner scan = new Scanner(System.in);
                    String choicedMovie = scan.nextLine();



                    break;


                case "2":


            }
        }
    }
