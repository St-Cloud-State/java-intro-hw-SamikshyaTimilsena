package homework;

/**
 * @brief Represents a person with a first name, last name, and unique ID.
 *
 * This class provides methods to access the person's first name, last name, and ID,
 * as well as a method to get a string representation of the person.
 */
public class Person {
    private String firstName;
    private String lastName;
    private String id;

    /**
     * @brief Constructs a new {@code Person} with the specified first name, last name, and ID.
     *
     * @param firstName The first name of the person.
     * @param lastName The last name of the person.
     * @param id The unique ID of the person.
     */
    public Person(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    /**
     * @brief Returns the first name of this person.
     *
     * @return The first name of this person.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @brief Returns the last name of this person.
     *
     * @return The last name of this person.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @brief Returns the unique ID of this person.
     *
     * @return The unique ID of this person.
     */
    public String getId() {
        return id;
    }

    /**
     * @brief Returns a string representation of this person.
     *
     * @details The string representation is in the format: "firstName lastName, ID: id".
     *
     * @return A string representation of this person.
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + ", ID: " + id;
    }
}
