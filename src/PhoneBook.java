import java.util.*;

public class PhoneBook {
    private HashMap<String, List<Integer>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String name, Integer phoneNum) {
        if (phoneBook.containsKey(name)) {
            List<Integer> phoneList = phoneBook.get(name);
            phoneList.add(phoneNum);
        } else {
            List<Integer> phoneList = new ArrayList<>();
            phoneList.add(phoneNum);
            phoneBook.put(name, phoneList);
        }
    }

    public List<Integer> find(String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        } else {
            return new ArrayList<>();
        }
    }

    public void printPhoneBook() {
        List<Map.Entry<String, List<Integer>>> entries = new ArrayList<>(phoneBook.entrySet());

        entries.sort(Comparator.comparingInt(entry -> entry.getValue().size()));
        Collections.reverse(entries);

        for (Map.Entry<String, List<Integer>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public Map<String, List<Integer>> getPhoneBook() {
        return phoneBook;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("John", 123456789);
        phoneBook.add("Jane", 987654321);
        phoneBook.add("John", 999888777); // Добавляем еще один номер для существующей записи
        phoneBook.add("John",23213111);
        phoneBook.add("Bob",123345532);
        phoneBook.add("Bob", 1232547988);

        System.out.println("Phone numbers for John: " + phoneBook.find("John"));
        System.out.println("Phone numbers for Jane: " + phoneBook.find("Jane"));
        System.out.println("Phone numbers for Bob: " + phoneBook.find("Bob"));

        System.out.println("Entire Phone Book: " + phoneBook.getPhoneBook());

        phoneBook.printPhoneBook();

    }
}
