import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();

        // Добавление контактов в телефонную книгу
        addContact(phoneBook, "Иванов", "+7 926 766 48 48");
        addContact(phoneBook, "Петров", "+7 123 456 78 90");
        addContact(phoneBook, "Иванов", "+7 987 654 32 10");
        addContact(phoneBook, "Сидоров", "+7 555 123 45 67");
        addContact(phoneBook, "Петров", "+7 111 222 33 44");

        // Вывод контактов в порядке убывания числа телефонов
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        Collections.sort(sortedEntries, (entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            System.out.println("Имя: " + entry.getKey());
            System.out.println("Телефоны:");
            for (String phone : entry.getValue()) {
                System.out.println(" - " + phone);
            }
            System.out.println();
        }
    }

    public static void addContact(Map<String, List<String>> phoneBook, String name, String phone) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phone);
    }
}
