//TODO
//addNewContact
//findContact
//updateContact
package MobilePhone;
import java.util.ArrayList;

public class MobilePhone {
    //Fields
    private String myNumber;
    private ArrayList <Contact> myContacts;

    //Methods
    //Constructor

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    //addNewContacts
    public boolean addNewContact(Contact contact) {

        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already in the list");
            return false;
        }

        myContacts.add(contact);
        return true;
    }

    //Find contact by name
    private int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    //Find contact by contact
    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    //Update contact
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + " was not found");
            return false;
        } else if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName() + " already exists. Update was not successful");
            return false;
        }

        myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    //print contact list
    public void printContacts() {
        System.out.println("Contact list");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println((i + 1) + ". " + myContacts.get(i).getName() + " ->" + myContacts.get(i).getPhoneNumber());
        }
    }

    //Query Contact
    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return myContacts.get(position);
        }
        return null;
    }

    //Remove Contact
    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if (position < 0) {
            System.out.println(contact.getName() + " was not found");
            return false;
        }
        myContacts.remove(position);
        System.out.println(contact.getName() + " was deleted");
        return true;
    }

}