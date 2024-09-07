package homework;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @brief Main class for managing a list of {@code Person} objects.
 *
 * This class demonstrates reading a list of {@code Person} objects from a file,
 * storing them in a linked list, displaying the list to an output file,
 * and finding specific persons by their ID.
 */
public class MyMainQ2 {

    /**
     * @brief The entry point of the application.
     *
     * @details Creates a linked list to store {@code Person} objects, reads data from an input file,
     *          writes the data to an output file, and performs additional operations such as finding
     *          specific persons by ID. The input file name and output file name are hardcoded.
     *
     * @param args Command line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        // Create a linked list to store Person objects
        LinkedList<Person> personList = new LinkedList<>();

        // File names 
        String inputFileName = "src/persons.txt";  //Input file
        String outputFileName = "output.txt";  // Output file

        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);

        try (Scanner fileScanner = new Scanner(inputFile);
             PrintWriter writer = new PrintWriter(outputFile)) {

            // Store data from the file into the linked list
            store(fileScanner, personList);

            // Display data to the output file
            display(writer, personList);

            // Additional operations 
            System.out.println("\nFinding persons by ID:");
            String[] idsToFind = {"111", "222", "000"};
            for (String id : idsToFind) {
                int index = find(id, personList);
                if (index != -1) {
                    System.out.println("Person with ID " + id + " found at index " + index);
                } else {
                    System.out.println("Person with ID " + id + " not found.");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @brief Stores person data from an input stream into a linked list.
     *
     * @details Reads lines from the provided {@code Scanner} input stream, parses each line into
     *          {@code Person} objects, and adds them to the specified linked list.
     *
     * @param scanner The {@code Scanner} object to read person data from.
     * @param list The {@code LinkedList} where {@code Person} objects are stored.
     */
    public static void store(Scanner scanner, LinkedList<Person> list) {
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
     * @param list The {@code LinkedList} containing {@code Person} objects to be displayed.
     */
    public static void display(PrintWriter writer, LinkedList<Person> list) {
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
     * @param list The {@code LinkedList} to search through.
     *
     * @return The index of the person with the specified ID, or -1 if not found.
     */
    public static int find(String id, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
