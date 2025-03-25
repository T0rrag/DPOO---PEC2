package edu.uoc.pac2;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SmartDeviceTest {

    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUpStreams() {
        restoreStreams();
    }

    @BeforeEach
    public void restoreStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @Order(1)
    @DisplayName("Exception setSerialNumber")
    public void testExceptionSetSerialNumber() {
        Exception exception = assertThrows(Exception.class, () -> new SmartDevice(null, "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false));
        assertFalse(exception instanceof IllegalArgumentException);
        assertFalse(exception instanceof NullPointerException);
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", exception.getMessage());

        assertEquals("", outContent.toString());
        restoreStreams();

        try {
            SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
            exception = assertThrows(Exception.class, () -> smartDevice.setSerialNumber(null));
            assertFalse(exception instanceof IllegalArgumentException);
            assertFalse(exception instanceof NullPointerException);
            assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", exception.getMessage());

            assertEquals("", outContent.toString());
            restoreStreams();
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    @Order(2)
    @DisplayName("Exception setOwnerName")
    public void testExceptionSetOwnerName() {
        Exception exception = assertThrows(Exception.class, () -> new SmartDevice("ABC-123-DEF", null, "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false));
        assertFalse(exception instanceof IllegalArgumentException);
        assertFalse(exception instanceof NullPointerException);
        assertEquals("[ERROR] Owner name cannot be null, empty or blank", exception.getMessage());

        assertEquals("", outContent.toString());
        restoreStreams();

        try {
            SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
            exception = assertThrows(Exception.class, () -> smartDevice.setOwnerName(null));
            assertFalse(exception instanceof IllegalArgumentException);
            assertFalse(exception instanceof NullPointerException);
            assertEquals("[ERROR] Owner name cannot be null, empty or blank", exception.getMessage());

            assertEquals("", outContent.toString());
            restoreStreams();
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    @Order(3)
    @DisplayName("Exception setMacAddress")
    public void testExceptionSetMacAddress() {
        Exception exception = assertThrows(Exception.class, () -> new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", null, 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false));
        assertFalse(exception instanceof IllegalArgumentException);
        assertFalse(exception instanceof NullPointerException);
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", exception.getMessage());

        assertEquals("", outContent.toString());
        restoreStreams();

        try {
            SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
            exception = assertThrows(Exception.class, () -> smartDevice.setMacAddress(null));
            assertFalse(exception instanceof IllegalArgumentException);
            assertFalse(exception instanceof NullPointerException);
            assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", exception.getMessage());

            assertEquals("", outContent.toString());
            restoreStreams();
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    @Order(4)
    @DisplayName("Exception setPrice")
    public void testExceptionSetPrice() {
        Exception exception = assertThrows(Exception.class, () -> new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", -720.0, LocalDate.now(), 5000, 4200, "1.0.0", false));
        assertFalse(exception instanceof IllegalArgumentException);
        assertFalse(exception instanceof NullPointerException);
        assertEquals("[ERROR] Price must be greater than 0", exception.getMessage());

        assertEquals("", outContent.toString());
        restoreStreams();

        try {
            SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
            exception = assertThrows(Exception.class, () -> smartDevice.setPrice(-720.0));
            assertFalse(exception instanceof IllegalArgumentException);
            assertFalse(exception instanceof NullPointerException);
            assertEquals("[ERROR] Price must be greater than 0", exception.getMessage());

            assertEquals("", outContent.toString());
            restoreStreams();
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    @Order(5)
    @DisplayName("Exception setPurchaseDate")
    public void testExceptionSetPurchaseDate() {
        Exception exception = assertThrows(Exception.class, () -> new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, null, 5000, 4200, "1.0.0", false));
        assertFalse(exception instanceof IllegalArgumentException);
        assertFalse(exception instanceof NullPointerException);
        assertEquals("[ERROR] Purchase date cannot be null or in the future", exception.getMessage());

        assertEquals("", outContent.toString());
        restoreStreams();

        try {
            SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
            exception = assertThrows(Exception.class, () -> smartDevice.setPurchaseDate(null));
            assertFalse(exception instanceof IllegalArgumentException);
            assertFalse(exception instanceof NullPointerException);
            assertEquals("[ERROR] Purchase date cannot be null or in the future", exception.getMessage());

            assertEquals("", outContent.toString());
            restoreStreams();
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    @Order(6)
    @DisplayName("Exception setBatteryLife")
    public void testExceptionSetBatteryLife() {
        Exception exception = assertThrows(Exception.class, () -> new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 0, 4200, "1.0.0", false));
        assertFalse(exception instanceof IllegalArgumentException);
        assertFalse(exception instanceof NullPointerException);
        assertEquals("[ERROR] Battery life must be greater than 0", exception.getMessage());

        assertEquals("", outContent.toString());
        restoreStreams();

        try {
            SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
            exception = assertThrows(Exception.class, () -> smartDevice.setBatteryLife(0));
            assertFalse(exception instanceof IllegalArgumentException);
            assertFalse(exception instanceof NullPointerException);
            assertEquals("[ERROR] Battery life must be greater than 0", exception.getMessage());

            assertEquals("", outContent.toString());
            restoreStreams();
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    @Order(7)
    @DisplayName("Exception setCurrentBattery")
    public void testExceptionSetCurrentBattery() {
        Exception exception = assertThrows(Exception.class, () -> new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, -1, "1.0.0", false));
        assertFalse(exception instanceof IllegalArgumentException);
        assertFalse(exception instanceof NullPointerException);
        assertEquals("[ERROR] Current battery must be between 0 and battery life", exception.getMessage());

        assertEquals("", outContent.toString());
        restoreStreams();

        try {
            SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
            exception = assertThrows(Exception.class, () -> smartDevice.setCurrentBattery(-1));
            assertFalse(exception instanceof IllegalArgumentException);
            assertFalse(exception instanceof NullPointerException);
            assertEquals("[ERROR] Current battery must be between 0 and battery life", exception.getMessage());

            assertEquals("", outContent.toString());
            restoreStreams();
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    @Order(8)
    @DisplayName("Exception setSoftwareVersion")
    public void testExceptionSetSoftwareVersion() {
        Exception exception = assertThrows(Exception.class, () -> new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, null, false));
        assertFalse(exception instanceof IllegalArgumentException);
        assertFalse(exception instanceof NullPointerException);
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", exception.getMessage());

        assertEquals("", outContent.toString());
        restoreStreams();

        try {
            SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
            exception = assertThrows(Exception.class, () -> smartDevice.setSoftwareVersion(null));
            assertFalse(exception instanceof IllegalArgumentException);
            assertFalse(exception instanceof NullPointerException);
            assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", exception.getMessage());

            assertEquals("", outContent.toString());
            restoreStreams();
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    @Order(9)
    @DisplayName("Exception updateSoftware")
    public void testUpdateSoftware() {
        try {
            SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", true);

            Exception exception = assertThrows(Exception.class, () -> smartDevice.updateSoftware(null));
            assertFalse(exception instanceof IllegalArgumentException);
            assertFalse(exception instanceof NullPointerException);
            assertEquals("[ERROR] Software cannot be updated", exception.getMessage());

            assertEquals("", outContent.toString());
            restoreStreams();
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

}
