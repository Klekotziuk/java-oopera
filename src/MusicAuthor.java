public class MusicAuthor extends Person {
    String genre;

    public MusicAuthor(String name, String surname, String gender, String genre) {
        super(name, surname, gender);
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Автор музыки: " + name + " " + surname + " (жанр: " + genre + ")";
    }
}