/**
 * The contact service shall be able to add contacts with a unique ID.
 * The contact service shall be able to delete contacts per contact ID.
 * The contact service shall be able to update contact fields per contact ID.
 * The following fields are updatable:
 * firstName
 * lastName
 * Number
 * Address
*/

package cs320ProjectOne;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Cannot add a null contact.");
        }
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID '" + contact.getContactId() + "' already exists.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with ID '" + contactId + "' not found.");
        }
        contacts.remove(contactId);
    }

    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contactToUpdate = contacts.get(contactId);
        if (contactToUpdate == null) {
            throw new IllegalArgumentException("Contact with ID '" + contactId + "' not found for update.");
        }

        // The setters in Contact.java will handle the validation
        contactToUpdate.setFirstName(firstName);
        contactToUpdate.setLastName(lastName);
        contactToUpdate.setPhone(phone);
        contactToUpdate.setAddress(address);
    }
    
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}