/**
 * Represents a single contact in the Contact Book.
 *
 * Each contact stores a name, phone number, and email address.
 *
 * @author Sneha Timsina
 */
public class Contact {

    // Initialize instance variables
    private String name;
    private String phoneNumber;
    private String email;

    /**
     * Creates a new Contact object.
     *
     * @param name the contact's name
     * @param phoneNumber the contact's phone number
     * @param email the contact's email address
     */
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Returns the contact's name.
     *
     * @return the contact name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the contact's phone number.
     *
     * @return the contact phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns the contact's email address.
     *
     * @return the contact email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns a formatted String representation of the contact.
     *
     * @return formatted contact information
     */
    @Override
    public String toString() {
        return (name + " : " + phoneNumber + " ( " + email + " ) ");
    }
}