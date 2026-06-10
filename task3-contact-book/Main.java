import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;

/**
 * A console-based Contact Book application.
 *
 * Features:
 * - Add contacts
 * - View all contacts
 * - Search contacts by name
 * - Delete contacts
 * - Save contacts to a file
 * - Load contacts from a file when the program starts
 *
 * @author Sneha Timsina
 */
public class Main {

    /**
     * Saves all contacts from the ArrayList to contacts.txt.
     *
     * Each contact is stored on a separate line in the format:
     * name,phoneNumber,email
     *
     * @param contactList the list of contacts to save
     */
    public static void saveContacts(ArrayList<Contact> contactList) {

        try {
            PrintWriter writer = new PrintWriter("contacts.txt");

            // Write each contact to a new line in the file
            for (Contact contact : contactList) {
                writer.println(
                    contact.getName() + "," +
                    contact.getPhoneNumber() + "," +
                    contact.getEmail()
                );
            }

            writer.close();
        }
        catch (IOException e) {
            System.out.println("Error saving contacts.");
        }
    }

    /**
     * Loads contacts from contacts.txt and adds them to the ArrayList.
     *
     * If the file does not exist, the program starts with an empty contact list.
     *
     * @param contactList the list where loaded contacts will be stored
     */
    public static void loadContacts(ArrayList<Contact> contactList) {

        try {

            File file = new File("contacts.txt");

            // Exit method if no saved contacts file exists
            if (!file.exists()) {
                return;
            }

            Scanner fileScanner = new Scanner(file);

            // Read file line-by-line
            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();

                // Split contact information using commas
                String[] parts = line.split(",");

                // Ensure valid contact data before creating a Contact object
                if (parts.length == 3) {
                    Contact contact = new Contact(parts[0], parts[1], parts[2]);
                    contactList.add(contact);
                }
            }

            fileScanner.close();
        }
        catch (Exception e) {
            System.out.println("Error loading contacts.");
        }
    }

    /**
     * Main method that runs the Contact Book application.
     * 
     */
    public static void main(String[] args) {

        // Stores all contacts currently in memory
        ArrayList<Contact> contactList = new ArrayList<>();

        // Load previously saved contacts
        loadContacts(contactList);

        System.out.println(contactList.size() + " contacts loaded.");

        String input = "0";
        Scanner scanner = new Scanner(System.in);

        // Continue showing menu until user chooses Exit
        while (!(input.equals("5"))) {

            System.out.println(
                "Your Contact Book \nPress 1 to Add a Contact, 2 to View all Contacts, 3 to Search by Name, 4 to Delete Contact and 5 to EXIT "
            );

            input = scanner.nextLine();

            // Add Contact
            if (input.equals("1")) {

                System.out.println("Name of Contact: ");
                String name = scanner.nextLine();

                System.out.println("Phone Number: ");
                String phoneNumber = scanner.nextLine();

                System.out.println("Email: ");
                String email = scanner.nextLine();

                Contact contact = new Contact(name, phoneNumber, email);
                contactList.add(contact);

                System.out.println("Contact added successfully");
            }

            // View All Contacts
            else if (input.equals("2")) {

                if (contactList.size() > 0) {

                    // Display every contact currently stored
                    for (Contact contact : contactList) {
                        System.out.println(contact);
                    }

                } else {
                    System.out.println("The Contact Book is empty");
                }
            }

            // Search Contact
            else if (input.equals("3")) {

                System.out.println("Enter name of the saved contact you are trying to search: ");

                String searchName = scanner.nextLine();

                boolean found = false;

                // Perform case-insensitive partial name search
                for (Contact contact : contactList) {

                    if (contact.getName().toLowerCase().contains(searchName.toLowerCase())) {

                        System.out.println(contact);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("No matching contact found.");
                }
            }

            // Delete Contact
            else if (input.equals("4")) {

                System.out.println("Enter full name of saved contact you want to delete: ");

                String nameToDelete = scanner.nextLine();

                boolean found = false;

                for (int i = 0; i < contactList.size(); i++) {

                    Contact contact = contactList.get(i);

                    // Compare names ignoring capitalization differences
                    if (contact.getName().equalsIgnoreCase(nameToDelete)) {

                        System.out.println("Found:");
                        System.out.println(contact);

                        System.out.println("Delete this contact? (Y/N)");

                        String answer = scanner.nextLine();

                        if (answer.equalsIgnoreCase("Y")) {

                            // Remove contact from ArrayList
                            contactList.remove(i);

                            System.out.println("Contact deleted.");
                        }

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Contact not found.");
                }
            }

            // Exit Program
            else if (input.equals("5")) {

                // Save contacts before closing
                saveContacts(contactList);

                System.out.println("Contacts saved.");
                System.out.println("Closing Contact Book for today. See you Later!");
            }

            // Invalid menu option
            else {
                System.out.println("Invalid input, back to main menu.");
            }
        }

        scanner.close();
    }
}