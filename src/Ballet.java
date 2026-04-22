import java.util.List;

public class Ballet extends MusicalShow {
    Choreographer choreographer;

    public Ballet(String title, int duration, Director director, List<Actor> listOfActors,
                  MusicAuthor musicAuthor, String librettoText, Choreographer choreographer) {
        super(title, duration, director, listOfActors, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }

    @Override
    public String toString() {
        return super.toString() + "\nТип: Балет\n" + choreographer;
    }
}
