public class Director extends Person {
    int numberOfShows;

    public Director(String name, String surname, String gender, int numberOfShows) {
        super(name, surname, gender);
        this.numberOfShows = numberOfShows;
    }

    @Override
    public String toString() {
        return "Режиссёр: " + name + " " + surname +
                "\nПол: " + gender +
                "\nКоличество постановок: " + numberOfShows;
    }
}

