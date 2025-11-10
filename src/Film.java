import java.util.ArrayList;

public class Film {


    private String name;
    private int year;
    private String genre;
    private int rating;

    public Film(String name, int year, String genre, int rating) {

    this.name = name;
    this.year = year;
    this.genre = genre;

    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }
}