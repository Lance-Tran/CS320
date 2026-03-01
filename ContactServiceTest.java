package cs320ProjectOne;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    @Test
    void testAddContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertNotNull(service.getContact("12345"));
        assertEquals("John", service.getContact("12345").getFirstName());
    }

    @Test
    void testAddDuplicateContactId() {
        Contact contact1 = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact1);
        
        Contact contact2 = new Contact("12345", "Jane", "Smith", "0987654321", "456 Oak Ave");
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    void testDeleteContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.deleteContact("12345");
        assertNull(service.getContact("12345"));
    }

    @Test
    void testUpdateContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        
        service.updateContact("12345", "Johnny", "Doeman", "5555555555", "A New Address");
        
        Contact updatedContact = service.getContact("12345");
        assertEquals("Johnny", updatedContact.getFirstName());
        assertEquals("5555555555", updatedContact.getPhone());
    }
}