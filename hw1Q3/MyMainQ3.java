package hw1Q3;


import java.io.*;
import java.util.Scanner;

/**
 * @brief Main class for managing {@code PersonList} operations.
 *
 * This class demonstrates creating a {@code PersonList} instance, reading data from an input file,
 * writing the data to an output file, and finding specific persons by their ID.
 */
public class MyMainQ3 {

    /**
     * @brief The entry point of the application.
     *
     * @details Creates a {@code PersonList} instance, reads data from an input file,
     *          writes the data to an output file, and performs additional operations such as finding
     *          specific persons by ID. The input file name and output file name are hardcoded.
     *
     * @param args Command line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        // Create a PersonList to manage Person objects
        PersonList personList = new PersonList();

        // File names 
        String inputFileName = "src/persons.txt";  // Input File
        String outputFileName = "output.txt";  // Output file

        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);

        try (Scanner fileScanner = new Scanner(inputFile);
             PrintWriter writer = new PrintWriter(outputFile)) {

            // Store data from the file into the PersonList
            personList.store(fileScanner);

            // Display data to the output file
            personList.display(writer);

            // Additional operations 
            System.out.println("\nFinding persons by ID:");
            String[] idsToFind = {"111", "222", "000"};
            for (String id : idsToFind) {
                int index = personList.find(id);
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
}

