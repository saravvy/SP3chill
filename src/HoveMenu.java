import utils.FileIO;

import java.util.ArrayList;
import java.util.Scanner;



public class HoveMenu {


    public void displayMainMenu() {

        System.out.println("                Main Menu         ");
        System.out.println("Choose an option:");
        System.out.println("1. Show all movies & Search ");
        System.out.println("2. Search for a genre");

    }

    public void switchChoice(FileIO io) {
        Scanner scan = new Scanner(System.in);

        String choice = scan.nextLine();

        boolean found = false;
        FilmList filmList = new FilmList();
        filmList.addFilm(io);
        ArrayList<Film> films = filmList.getFilms();
        switch (choice) {
            case "1":


                for (Film film : films) {
                    System.out.println(film);
                }
                while (found == false) {


                    System.out.println("Which movie do you wanna watch?");

                    String choicedMovie = scan.nextLine().toLowerCase();


                    for (Film b : films) {
                        if (b.getName().toLowerCase().trim().equals(choicedMovie.trim())) {
                            //films.add(b);

                            System.out.println(b);
                            System.out.println("Playing movie.....");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Film not found. Try again");

                    }
                }
                break;

            case "2":

                while (found == false) {


                    System.out.println("Which genre do you wanna watch?");

                    String choicedGenre = scan.nextLine().toLowerCase();


                    for (Film b : films) {
                        if (b.getGenre().toLowerCase().trim().equals(choicedGenre.trim())) {
                            if (!films.isEmpty()) {
                                ArrayList<String> genres = new ArrayList<>();

                                for (Film o : films) {
                                    String[] filmGenres = b.getGenre().split(",");
                                    for (String g : filmGenres) {
                                        genres.add(g.trim().toLowerCase());

                                        for (String u : genres) {
                                            System.out.println(g);
                                            found = true;

                                            break;
                                        }
                                    }
                                    if (!found) {
                                        System.out.println("Film not found. Try again");

                                    }
                                }



                            }

                        }
                    }
                } break;

            default:
        }

        }
    }


