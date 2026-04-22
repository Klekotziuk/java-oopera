public class Choreographer extends Person {
    String style;

    public Choreographer(String name, String surname, String gender, String style) {
        super(name, surname, gender);
        this.style = style;
    }

    @Override
    public String toString() {
        return "Хореограф: " + name + " " + surname + " (стиль: " + style + ")";
    }
}