import utils.FileIO;

import java.util.ArrayList;
import java.util.Scanner;

public class HoveMenu {


    public static void displayMainMenu(FileIO io) {
        Scanner input = new Scanner(System.in);

        System.out.println("                Main Menu         ");
        System.out.println("Choose an option:");
        System.out.println("1. Show all movies");
        System.out.println("2. Search a movie");

        String choice = input.nextLine();

        switch (choice) {
            case "1":

                FilmList filmList = new FilmList();
                filmList.addFilm(io);

                ArrayList<Film> films = filmList.getFilms();
                for (Film film : films) {
                    System.out.println(film);
                }

                break;


            case "2":


        }
    }
}
