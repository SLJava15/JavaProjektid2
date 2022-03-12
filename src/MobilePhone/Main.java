package MobilePhone;

// Create a program that implements a simple mobile phone with the following capabilities.
// Able to store, modify, remove and query contact names.
// You will want to create a separate class for Contacts (name and phone number).
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use name)
// Be sure not to expose the inner workings of the Arraylist to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with Contact objects only.


import java.sql.SQLOutput;
import java.util.Scanner;

    public class Main {

        private static Scanner scanner = new Scanner(System.in);
        private static MobilePhone mobilePhone = new MobilePhone("+372 56622233");

        public static void main(String[] args) {

            boolean quit = false;
            startPhone();
            while (!quit) {
                System.out.println("Enter action: (6 to show available actions)");
                int action = scanner.nextInt();
                scanner.nextLine();

                switch (action) {
                    case 0:
                        System.out.println("\n Shutting down ...");
                        quit = true;
                        break;
                    case 1:
                        //Print all contacts
                        mobilePhone.printContacts();
                        break;
                    case 2:
                        //Add new contact
                        addNewContact();
                        break;
                    case 3:
                        //Update contact
                        updateContact();
                        break;
                    case 4:
                        //Remove contact
                        removeContact();
                        break;
                    case 5:
                        //Query contact
                        queryContact();
                        break;
                    case 6:
                        //Print actions
                        printActions();
                        break;
                    default:
                        System.out.println("Enter option from 0 - 6");
                        break;
                }


            }


        }

        //Add new contact
        private static void addNewContact() {
            System.out.println("Please enter new Contact name");
            String name = scanner.nextLine();
            System.out.println("Please enter phone number");
            String phone = scanner.nextLine();

            Contact newContact = Contact.createContact(name, phone);
            if (mobilePhone.addNewContact(newContact)) {
                System.out.println("New contact added: name = " + name + ", number = " + phone);
            } else {
                System.out.println("Cannot add, " + name + " already on the list");
            }
        }

        //Start phone
        private static void startPhone() {
            System.out.println("Starting phone ...");
        }

        //Print all options
        private static void printActions() {
            System.out.println("\nAvailable actions:\npress");
            System.out.println("0  - to shutdown\n" +
                    "1  - to print contacts\n" +
                    "2  - to add a new contact\n" +
                    "3  - to update existing an existing contact\n" +
                    "4  - to remove an existing contact\n" +
                    "5  - query if an existing contact exists\n" +
                    "6  - to print a list of available actions.");
            System.out.println("Choose your action: ");
        }

        //Update contact
        private static void updateContact() {
            System.out.println("Enter existing contact name:");
            String name = scanner.nextLine();
            Contact existingContactRecord = mobilePhone.queryContact(name);
            if (existingContactRecord == null) {
                System.out.println("Contact not found");
                return;
            }

            System.out.println("Enter new contact name");
            String newName = scanner.nextLine();
            System.out.println("Enter new contact phone number");
            String newNumber = scanner.nextLine();

            Contact newContact = Contact.createContact(newName, newNumber);
            if (mobilePhone.updateContact(existingContactRecord, newContact)) {
                System.out.println("Successfully updated contact ");
            } else {
                System.out.println("Error updating contact");
            }

        }

        //Remove contact
        private static void removeContact() {
            System.out.println("Enter existing contact name");
            String name = scanner.nextLine();

            Contact existingContactRecord = mobilePhone.queryContact(name);

            if (existingContactRecord == null) {
                System.out.println("Contact not found");
                return;
            }

            if (mobilePhone.removeContact(existingContactRecord)) {
                System.out.println("Successfully deleted contact ");
            } else {
                System.out.println("Error deleting contact");
            }

        }

        //Query contact
        private static void queryContact() {
            System.out.println("Enter existing contact name");
            String name = scanner.nextLine();
            Contact existingContactRecord = mobilePhone.queryContact(name);
            if (existingContactRecord == null) {
                System.out.println("Contact not found");
                return;
            }

            System.out.println("Name: " + existingContactRecord.getName() + " phone number " + existingContactRecord.getPhoneNumber());

        }
}
