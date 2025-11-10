import utils.FileIO;

import java.util.ArrayList;


public class FilmList {

    public void addFilm(FileIO io) {
        ArrayList<Film> film = new ArrayList<>();
        ArrayList<String> filmData = io.readData("data/film.csv");
        if (!filmData.isEmpty()) {
            for (String s : filmData) {
                String[] values = s.split(";");//
                String name = values[0];
                int year = Integer.parseInt(values[1]);
                String genre = values[2];
                int rating = Integer.parseInt(values[3]);


                film.add(new Film(name, year, genre, rating));


            }

        }
    }


}

