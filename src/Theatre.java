import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Theatre {
    static Scanner scanner;
    static Show dramaShow;
    static MusicalShow operaShow;
    static Ballet balletShow;
    static List<Actor> allActors = new ArrayList<>();
    static List<Director> allDirectors = new ArrayList<>();

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        // 1. Создаём трёх актёров
        Actor actor1 = new Actor("Иван", "Иванов", "Мужской", 180);
        Actor actor2 = new Actor("Мария", "Петрова", "Женский", 165);
        Actor actor3 = new Actor("Пётр", "Сидоров", "Мужской", 175);
        allActors.add(actor1);
        allActors.add(actor2);
        allActors.add(actor3);

        // 2. Создаём двух режиссёров
        Director director1 = new Director("Александр", "Смирнов", "Мужской", 15);
        Director director2 = new Director("Елена", "Васильева", "Женский", 8);
        allDirectors.add(director1);
        allDirectors.add(director2);

        // 3. Создаём автора музыки и хореографа
        MusicAuthor musicAuthor = new MusicAuthor("Пётр", "Чайковский", "Мужской", "Классика");
        Choreographer choreographer = new Choreographer("Мариус", "Петипа", "Мужской", "Классический балет");

        // 4. Создаём три спектакля
        dramaShow = new Show("Вишнёвый сад", 180, director1, new ArrayList<>());
        operaShow = new MusicalShow("Евгений Онегин", 210, director2, new ArrayList<>(),
                musicAuthor, "Либретто оперы: Татьяна пишет письмо Онегину...");
        balletShow = new Ballet("Лебединое озеро", 150, director1, new ArrayList<>(),
                musicAuthor, "Либретто балета: Принц Зигфрид влюбляется в Одетту...", choreographer);

        // 5. Распределяем актёров по спектаклям
        dramaShow.addActor(actor1);
        dramaShow.addActor(actor2);
        operaShow.addActor(actor2);
        operaShow.addActor(actor3);
        balletShow.addActor(actor1);
        balletShow.addActor(actor3);

        // 6. Выводим список актёров для каждого спектакля
        System.out.println("=== СПИСКИ АКТЁРОВ ПО СПЕКТАКЛЯМ ===");
        System.out.println("\nДрама \"" + dramaShow.title + "\":");
        dramaShow.printActors();

        System.out.println("\nОпера \"" + operaShow.title + "\":");
        operaShow.printActors();

        System.out.println("\nБалет \"" + balletShow.title + "\":");
        balletShow.printActors();

        // 7. Заменяем актёра в одном спектакле
        System.out.println("\n=== ЗАМЕНА АКТЁРА ===");
        System.out.println("Замена в опере: Мария Петрова -> Иван Иванов");
        operaShow.replaceActor(actor2, actor1);
        System.out.println("\nОбновлённый список актёров оперы:");
        operaShow.printActors();

        // 8. Пробуем заменить несуществующего актёра
        System.out.println("\n=== ПОПЫТКА ЗАМЕНЫ НЕСУЩЕСТВУЮЩЕГО АКТЁРА ===");
        Actor fakeActor = new Actor("Василий", "Несуществующий", "Мужской", 170);
        dramaShow.replaceActor(fakeActor, actor3);

        // 9. Выводим либретто для оперы и балета
        System.out.println("\n=== ЛИБРЕТТО ===");
        System.out.println("\nЛибретто оперы \"" + operaShow.title + "\":");
        operaShow.printLibretto();
        System.out.println("\nЛибретто балета \"" + balletShow.title + "\":");
        balletShow.printLibretto();

        // 10. Запускаем интерактивное меню
        System.out.println("\n=== ИНТЕРАКТИВНОЕ МЕНЮ ===");
        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.println("\nВыберите спектакль (1 - Опера, 2 - Балет):");
                    String choice = scanner.nextLine();
                    if (choice.equals("1")) {
                        operaShow.printLibretto();
                    } else if (choice.equals("2")) {
                        balletShow.printLibretto();
                    }
                    break;
                case "2":
                    System.out.println("\nИнформация о режиссёре оперы:");
                    System.out.println(operaShow.director);
                    break;
                case "3":
                    System.out.println("\nВыберите спектакль (1 - Драма, 2 - Опера, 3 - Балет):");
                    String showChoice = scanner.nextLine();
                    switch (showChoice) {
                        case "1" -> dramaShow.printActors();
                        case "2" -> operaShow.printActors();
                        case "3" -> balletShow.printActors();
                    }
                    break;
                case "4":
                    addNewActorMenu();
                    break;
                case "5":
                    replaceActorMenu();
                    break;
                case "0":
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверная команда.");
            }
        }
    }

    private static void addNewActorMenu() {
        System.out.println("Введите имя нового актёра:");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию:");
        String surname = scanner.nextLine();
        System.out.println("Введите пол (Мужской/Женский):");
        String gender = scanner.nextLine();
        System.out.println("Введите рост (см):");
        int height = Integer.parseInt(scanner.nextLine());

        Actor newActor = new Actor(name, surname, gender, height);
        allActors.add(newActor);

        System.out.println("В какой спектакль добавить? (1 - Драма, 2 - Опера, 3 - Балет):");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> dramaShow.addActor(newActor);
            case "2" -> operaShow.addActor(newActor);
            case "3" -> balletShow.addActor(newActor);
        }
    }

    private static void replaceActorMenu() {
        System.out.println("Введите имя актёра для замены:");
        String oldName = scanner.nextLine();
        System.out.println("Введите фамилию актёра для замены:");
        String oldSurname = scanner.nextLine();

        Actor oldActor = findActorByName(oldName, oldSurname);
        if (oldActor == null) {
            System.out.println("Актёр не найден.");
            return;
        }

        System.out.println("Введите имя нового актёра:");
        String newName = scanner.nextLine();
        System.out.println("Введите фамилию нового актёра:");
        String newSurname = scanner.nextLine();

        Actor newActor = findActorByName(newName, newSurname);
        if (newActor == null) {
            System.out.println("Актёр не найден.");
            return;
        }

        System.out.println("В каком спектакле заменить? (1 - Драма, 2 - Опера, 3 - Балет):");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> dramaShow.replaceActor(oldActor, newActor);
            case "2" -> operaShow.replaceActor(oldActor, newActor);
            case "3" -> balletShow.replaceActor(oldActor, newActor);
        }
    }

    private static Actor findActorByName(String name, String surname) {
        for (Actor actor : allActors) {
            if (actor.name.equalsIgnoreCase(name) && actor.surname.equalsIgnoreCase(surname)) {
                return actor;
            }
        }
        return null;
    }

    private static void printMenu() {
        System.out.println("\nВыберите команду:");
        System.out.println("1 - Распечатать текст либретто");
        System.out.println("2 - Распечатать информацию о режиссёре спектакля");
        System.out.println("3 - Распечатать список всех актёров, участвующих в спектакле");
        System.out.println("4 - Добавить нового актёра в спектакль");
        System.out.println("5 - Заменить одного актёра в спектакле на другого");
        System.out.println("0 - Выход");
    }
}
