import java.util.ArrayList;

public class Film {


    private String name;
    private String year;
    private String genre;
    private String rating;

    public Film(String name, String year, String genre, String rating) {

    this.name = name;
    this.year = year;
    this.genre = genre;
    this.rating = rating;

    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Film: "+name+ " Release year: " +year+" Genre: "+genre+" Rating: "+rating;
    }
}