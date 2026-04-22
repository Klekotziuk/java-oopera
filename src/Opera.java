import java.util.List;

public class Opera extends MusicalShow {
    int choirSize;

    public Opera(String title, int duration, Director director, List<Actor> listOfActors,
                 MusicAuthor musicAuthor, String librettoText, int choirSize) {
        super(title, duration, director, listOfActors, musicAuthor, librettoText);
        this.choirSize = choirSize;
    }

    @Override
    public String toString() {
        return super.toString() + "\nТип: Опера\nРазмер хора: " + choirSize + " человек";
    }
}
