import java.util.List;

public class Show {
    String title;
    int duration;
    Director director;
    List<Actor> listOfActors;

    public Show(String title, int duration, Director director, List<Actor> listOfActors) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = listOfActors;
    }

    public void printActors() {
        System.out.println("Список всех актёров, участвующих в спектакле \"" + title + "\":");
        if (listOfActors.isEmpty()) {
            System.out.println(" - Список пуст -");
        } else {
            for (Actor actor : listOfActors) {
                System.out.println(" - " + actor);
            }
        }
    }

    @Override
    public String toString() {
        return "Спектакль: " + title + " (" + duration + " мин)";
    }

    public void addActor(Actor newActor) {
        if (newActor != null && !listOfActors.contains(newActor)) {
            listOfActors.add(newActor);
            System.out.println("Актёр " + newActor.name + " " + newActor.surname + " добавлен в спектакль.");
        } else if (listOfActors.contains(newActor)) {
            System.out.println("Актёр уже участвует в спектакле.");
        }
    }

    public boolean replaceActor(Actor oldActor, Actor newActor) {
        if (oldActor == null || newActor == null) {
            System.out.println("Ошибка: актёр не может быть null.");
            return false;
        }

        int index = listOfActors.indexOf(oldActor);
        if (index == -1) {
            System.out.println("Актёр " + oldActor.name + " " + oldActor.surname + " не найден в спектакле.");
            return false;
        }

        listOfActors.set(index, newActor);
        System.out.println("Актёр " + oldActor.name + " " + oldActor.surname +
                " заменён на " + newActor.name + " " + newActor.surname + ".");
        return true;
    }
}


