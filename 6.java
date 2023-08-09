import java.util.*;

public class 6.java {
    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();

        // Добавляем записи в телефонную книгу
        addContact(phoneBook, "Иван", "+7 926 766 48 48");
        addContact(phoneBook, "Петр", "+7 925 123 45 67");
        addContact(phoneBook, "Иван", "+7 910 111 22 33");
        addContact(phoneBook, "Мария", "+7 987 654 32 10");

        // Выводим записи, отсортированные по убыванию числа телефонов
        List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            System.out.println("Имя: " + entry.getKey() + ", Телефоны: " + entry.getValue());
        }
    }

    public static void addContact(Map<String, Set<String>> phoneBook, String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
    }
}
