import java.util.List;

public class MusicalShow extends Show {
    MusicAuthor musicAuthor;  // изменено со String на MusicAuthor
    String librettoText;

    public MusicalShow(String title, int duration, Director director, List<Actor> listOfActors,
                       MusicAuthor musicAuthor, String librettoText) {
        super(title, duration, director, listOfActors);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    public void printLibretto() {
        System.out.println("=== Либретто спектакля \"" + title + "\" ===");
        System.out.println(librettoText);
    }
}
