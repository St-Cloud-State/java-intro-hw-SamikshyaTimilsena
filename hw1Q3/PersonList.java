package hw1Q3;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @brief Manages a list of {@code Person} objects using a {@code LinkedList}.
 *
 * This class provides methods to store {@code Person} objects from an input stream,
 * display them to an output stream, and find a person by ID.
 */
public class PersonList {
    private LinkedList<Person> list;

    /**
     * @brief Constructs a {@code PersonList} with an empty linked list.
     */
    public PersonList() {
        this.list = new LinkedList<>();
    }

    /**
     * @brief Stores person data from an input stream into the linked list.
     *
     * @details Reads lines from the provided {@code Scanner} input stream, parses each line into
     *          {@code Person} objects, and adds them to the linked list.
     *
     * @param scanner The {@code Scanner} object to read person data from.
     */
    public void store(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String firstName = parts[0].trim();
                String lastName = parts[1].trim();
                String id = parts[2].trim();
                list.add(new Person(firstName, lastName, id));
            }
        }
    }

    /**
     * @brief Displays all persons in the linked list to an output stream.
     *
     * @details Writes each {@code Person} object in the linked list to the provided
     *          {@code PrintWriter} output stream, with one person per line.
     *
     * @param writer The {@code PrintWriter} object to write person data to.
     */
    public void display(PrintWriter writer) {
        for (Person person : list) {
            writer.println(person);
        }
    }

    /**
     * @brief Finds a person by ID and returns the index in the linked list.
     *
     * @details Searches the linked list for a {@code Person} object with the specified ID.
     *          Returns the index of the person if found, otherwise returns -1.
     *
     * @param id The ID of the person to find.
     *
     * @return The index of the person with the specified ID, or -1 if not found.
     */
    public int find(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
