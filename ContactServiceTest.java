package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.model.Contact;
import main.java.service.ContactService;

public class ContactServiceTest {

    private static final String VALID_ID = "1234567890";
    private static final String VALID_FIRST = "Carrie";
    private static final String VALID_LAST = "Cummings";
    private static final String VALID_PHONE = "8175550000";
    private static final String VALID_ADDRESS = "123 Main St Fort Worth TX";

    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
        service.addContact(contact);
    }

    // ── Add Contact Tests ─────────────────────────────────────────

    @Test
    void testAddContact_withValidContact_contactExistsInService() {
        Contact newContact = new Contact("0987654321", "Nikki", "Cummings", "8175551111", "456 Elm St Arlington TX");
        service.addContact(newContact);
        assertEquals(newContact, service.getContact("0987654321"));
    }

    @Test
    void testAddContact_withDuplicateId_throwsException() {
        Contact duplicate = new Contact(VALID_ID, "Dupe", "User", "8175552222", "789 Oak Ave Dallas TX");
        assertThrows(IllegalArgumentException.class, () -> service.addContact(duplicate));
    }

    @Test
    void testAddContact_withNullContact_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    // ── Delete Contact Tests ──────────────────────────────────────

    @Test
    void testDeleteContact_withValidId_contactIsNull() {
        service.deleteContact(VALID_ID);
        assertNull(service.getContact(VALID_ID));
    }

    @Test
    void testDeleteContact_withNonExistentId_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("0000000000"));
    }

    // ── Update Contact Tests ──────────────────────────────────────

    @Test
    void testUpdateContact_withValidFields_contactReflectsUpdates() {
        service.updateContact(VALID_ID, "Batman", "Wayne", "8175559999", "456 Elm St Arlington TX");
        Contact updated = service.getContact(VALID_ID);
        Contact expected = new Contact(VALID_ID, "Batman", "Wayne", "8175559999", "456 Elm St Arlington TX");
        assertEquals(expected, updated);
    }

    @Test
    void testUpdateContact_withNullFirstName_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updateContact(VALID_ID, null, VALID_LAST, VALID_PHONE, VALID_ADDRESS));
    }

    @Test
    void testUpdateContact_withFirstNameTooLong_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updateContact(VALID_ID, "CarrieLouise", VALID_LAST, VALID_PHONE, VALID_ADDRESS));
    }

    @Test
    void testUpdateContact_withNullLastName_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updateContact(VALID_ID, VALID_FIRST, null, VALID_PHONE, VALID_ADDRESS));
    }

    @Test
    void testUpdateContact_withLastNameTooLong_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updateContact(VALID_ID, VALID_FIRST, "CummingsLong", VALID_PHONE, VALID_ADDRESS));
    }

    @Test
    void testUpdateContact_withNullPhone_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updateContact(VALID_ID, VALID_FIRST, VALID_LAST, null, VALID_ADDRESS));
    }

    @Test
    void testUpdateContact_withInvalidPhone_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updateContact(VALID_ID, VALID_FIRST, VALID_LAST, "123", VALID_ADDRESS));
    }

    @Test
    void testUpdateContact_withNullAddress_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updateContact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, null));
    }

    @Test
    void testUpdateContact_withAddressTooLong_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updateContact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE,
                "1234 Very Long Street Address That Exceeds Limit"));
    }

    @Test
    void testUpdateContact_withNonExistentId_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updateContact("0000000000", VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS));
    }

    // ── Get Contact Tests ─────────────────────────────────────────

    @Test
    void testGetContact_withNonExistentId_returnsNull() {
        assertNull(service.getContact("0000000000"));
    }
}
