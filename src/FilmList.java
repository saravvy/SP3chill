import utils.FileIO;

import java.util.ArrayList;


public class FilmList {
    private ArrayList<Film> film = new ArrayList<>();

    public void addFilm(FileIO io) {

        ArrayList<String> filmData = io.readData("data/film.csv");
        if (!filmData.isEmpty()) {
            for (String s : filmData) {
                String[] values = s.split(";");//
                String name = values[0];
                String year =  values[1];
                String genre = values[2];
                String rating =  values[3];


                film.add(new Film(name, year, genre, rating));


            }

        }
    }
            public ArrayList<Film> getFilms() {
                return film;

            }

}

