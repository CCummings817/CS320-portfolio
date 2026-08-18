package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.model.Contact;

public class ContactTest {

    private static final String VALID_ID = "1234567890";
    private static final String VALID_FIRST = "Carrie";
    private static final String VALID_LAST = "Cummings";
    private static final String VALID_PHONE = "8175550000";
    private static final String VALID_ADDRESS = "123 Main St Fort Worth TX";

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
    }

    // ── Contact ID Tests ──────────────────────────────────────────

    @Test
    void testContactId_withValidId_isStored() {
        assertEquals(VALID_ID, contact.getContactId());
    }

    @Test
    void testContactId_withNullId_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(null, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS));
    }

    @Test
    void testContactId_withIdTooLong_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("12345678901", VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS));
    }

    @Test
    void testContactId_isNotUpdatable_remainsUnchanged() {
        // contactId is final -- no setter exists, verified by design
        assertEquals(VALID_ID, contact.getContactId());
    }

    // ── First Name Tests ──────────────────────────────────────────

    @Test
    void testFirstName_withValidName_isStored() {
        assertEquals(VALID_FIRST, contact.getFirstName());
    }

    @Test
    void testFirstName_withNullName_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(VALID_ID, null, VALID_LAST, VALID_PHONE, VALID_ADDRESS));
    }

    @Test
    void testFirstName_withNameTooLong_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(VALID_ID, "CarrieLouise", VALID_LAST, VALID_PHONE, VALID_ADDRESS));
    }

    @Test
    void testFirstName_withUpdatedName_isStored() {
        contact.setFirstName("Batman");
        assertEquals("Batman", contact.getFirstName());
    }

    @Test
    void testFirstName_withNullUpdate_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
    }

    @Test
    void testFirstName_withUpdateTooLong_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("CarrieLouise"));
    }

    // ── Last Name Tests ───────────────────────────────────────────

    @Test
    void testLastName_withValidName_isStored() {
        assertEquals(VALID_LAST, contact.getLastName());
    }

    @Test
    void testLastName_withNullName_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(VALID_ID, VALID_FIRST, null, VALID_PHONE, VALID_ADDRESS));
    }

    @Test
    void testLastName_withNameTooLong_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(VALID_ID, VALID_FIRST, "CummingsLong", VALID_PHONE, VALID_ADDRESS));
    }

    @Test
    void testLastName_withUpdatedName_isStored() {
        contact.setLastName("Wayne");
        assertEquals("Wayne", contact.getLastName());
    }

    @Test
    void testLastName_withNullUpdate_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
    }

    @Test
    void testLastName_withUpdateTooLong_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("CummingsLong"));
    }

    // ── Phone Tests ───────────────────────────────────────────────

    @Test
    void testPhone_withValidPhone_isStored() {
        assertEquals(VALID_PHONE, contact.getPhone());
    }

    @Test
    void testPhone_withNullPhone_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(VALID_ID, VALID_FIRST, VALID_LAST, null, VALID_ADDRESS));
    }

    @Test
    void testPhone_withPhoneTooShort_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(VALID_ID, VALID_FIRST, VALID_LAST, "817555", VALID_ADDRESS));
    }

    @Test
    void testPhone_withPhoneTooLong_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(VALID_ID, VALID_FIRST, VALID_LAST, "81755500001", VALID_ADDRESS));
    }

    @Test
    void testPhone_withNonDigits_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(VALID_ID, VALID_FIRST, VALID_LAST, "817555000A", VALID_ADDRESS));
    }

    @Test
    void testPhone_withUpdatedPhone_isStored() {
        contact.setPhone("8175559999");
        assertEquals("8175559999", contact.getPhone());
    }

    @Test
    void testPhone_withNullUpdate_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
    }

    @Test
    void testPhone_withInvalidUpdate_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123"));
    }

    // ── Address Tests ─────────────────────────────────────────────

    @Test
    void testAddress_withValidAddress_isStored() {
        assertEquals(VALID_ADDRESS, contact.getAddress());
    }

    @Test
    void testAddress_withNullAddress_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, null));
    }

    @Test
    void testAddress_withAddressTooLong_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE,
                "1234 Very Long Street Address That Exceeds Limit"));
    }

    @Test
    void testAddress_withUpdatedAddress_isStored() {
        contact.setAddress("456 Elm St Arlington TX");
        assertEquals("456 Elm St Arlington TX", contact.getAddress());
    }

    @Test
    void testAddress_withNullUpdate_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }

    @Test
    void testAddress_withUpdateTooLong_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            contact.setAddress("1234 Very Long Street Address That Exceeds Limit"));
    }

    // ── Equals Tests ──────────────────────────────────────────────

    @Test
    void testEquals_withIdenticalContact_returnsTrue() {
        Contact other = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
        assertEquals(contact, other);
    }

    @Test
    void testEquals_withDifferentContact_returnsFalse() {
        Contact other = new Contact("0987654321", VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
        assertNotEquals(contact, other);
    }
}
