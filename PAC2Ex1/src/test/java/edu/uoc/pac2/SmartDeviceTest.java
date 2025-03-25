package edu.uoc.pac2;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
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
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(14, SmartDevice.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(SmartDevice.class.getDeclaredField("serialNumber").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredField("serialNumber").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredField("serialNumber").getModifiers()));
            assertEquals(String.class, SmartDevice.class.getDeclaredField("serialNumber").getType());

            assertTrue(Modifier.isPrivate(SmartDevice.class.getDeclaredField("ownerName").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredField("ownerName").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredField("ownerName").getModifiers()));
            assertEquals(String.class, SmartDevice.class.getDeclaredField("ownerName").getType());

            assertTrue(Modifier.isPrivate(SmartDevice.class.getDeclaredField("macAddress").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredField("macAddress").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredField("macAddress").getModifiers()));
            assertEquals(String.class, SmartDevice.class.getDeclaredField("macAddress").getType());

            assertTrue(Modifier.isPrivate(SmartDevice.class.getDeclaredField("price").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredField("price").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredField("price").getModifiers()));
            assertEquals(double.class, SmartDevice.class.getDeclaredField("price").getType());

            assertTrue(Modifier.isPrivate(SmartDevice.class.getDeclaredField("purchaseDate").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredField("purchaseDate").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredField("purchaseDate").getModifiers()));
            assertEquals(LocalDate.class, SmartDevice.class.getDeclaredField("purchaseDate").getType());

            assertTrue(Modifier.isPrivate(SmartDevice.class.getDeclaredField("warrantyEndDate").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredField("warrantyEndDate").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredField("warrantyEndDate").getModifiers()));
            assertEquals(LocalDate.class, SmartDevice.class.getDeclaredField("warrantyEndDate").getType());

            assertTrue(Modifier.isPrivate(SmartDevice.class.getDeclaredField("batteryLife").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredField("batteryLife").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredField("batteryLife").getModifiers()));
            assertEquals(int.class, SmartDevice.class.getDeclaredField("batteryLife").getType());

            assertTrue(Modifier.isPrivate(SmartDevice.class.getDeclaredField("currentBattery").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredField("currentBattery").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredField("currentBattery").getModifiers()));
            assertEquals(int.class, SmartDevice.class.getDeclaredField("currentBattery").getType());

            assertTrue(Modifier.isPrivate(SmartDevice.class.getDeclaredField("softwareVersion").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredField("softwareVersion").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredField("softwareVersion").getModifiers()));
            assertEquals(String.class, SmartDevice.class.getDeclaredField("softwareVersion").getType());

            assertTrue(Modifier.isPrivate(SmartDevice.class.getDeclaredField("isConnectedByWifi").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredField("isConnectedByWifi").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredField("isConnectedByWifi").getModifiers()));
            assertEquals(boolean.class, SmartDevice.class.getDeclaredField("isConnectedByWifi").getType());

            assertTrue(Modifier.isPrivate(SmartDevice.class.getDeclaredField("warrantyYears").getModifiers()));
            assertTrue(Modifier.isStatic(SmartDevice.class.getDeclaredField("warrantyYears").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredField("warrantyYears").getModifiers()));
            assertEquals(int.class, SmartDevice.class.getDeclaredField("warrantyYears").getType());

            assertTrue(Modifier.isPrivate(SmartDevice.class.getDeclaredField("closeEndWarrantyMonths").getModifiers()));
            assertTrue(Modifier.isStatic(SmartDevice.class.getDeclaredField("closeEndWarrantyMonths").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredField("closeEndWarrantyMonths").getModifiers()));
            assertEquals(int.class, SmartDevice.class.getDeclaredField("closeEndWarrantyMonths").getType());

            assertTrue(Modifier.isPrivate(SmartDevice.class.getDeclaredField("batterySafeMode").getModifiers()));
            assertTrue(Modifier.isStatic(SmartDevice.class.getDeclaredField("batterySafeMode").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredField("batterySafeMode").getModifiers()));
            assertEquals(double.class, SmartDevice.class.getDeclaredField("batterySafeMode").getType());

            assertTrue(Modifier.isPrivate(SmartDevice.class.getDeclaredField("softwareVersions").getModifiers()));
            assertTrue(Modifier.isStatic(SmartDevice.class.getDeclaredField("softwareVersions").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredField("softwareVersions").getModifiers()));
            assertEquals(String[].class, SmartDevice.class.getDeclaredField("softwareVersions").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes!");
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructorSanity() {
        try {
            assertEquals(1, SmartDevice.class.getDeclaredConstructors().length);

            Constructor<SmartDevice> constructor = SmartDevice.class.getDeclaredConstructor(String.class, String.class, String.class, double.class, LocalDate.class, int.class, int.class, String.class, boolean.class);

            assertTrue(Modifier.isPublic(constructor.getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the constructor!");
        }
    }

    @Test
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(27, SmartDevice.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("getSerialNumber").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("getSerialNumber").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("getSerialNumber").getModifiers()));
            assertEquals(String.class, SmartDevice.class.getDeclaredMethod("getSerialNumber").getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("setSerialNumber", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("setSerialNumber", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("setSerialNumber", String.class).getModifiers()));
            assertEquals(void.class, SmartDevice.class.getDeclaredMethod("setSerialNumber", String.class).getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("getOwnerName").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("getOwnerName").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("getOwnerName").getModifiers()));
            assertEquals(String.class, SmartDevice.class.getDeclaredMethod("getOwnerName").getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("setOwnerName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("setOwnerName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("setOwnerName", String.class).getModifiers()));
            assertEquals(void.class, SmartDevice.class.getDeclaredMethod("setOwnerName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("getMacAddress").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("getMacAddress").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("getMacAddress").getModifiers()));
            assertEquals(String.class, SmartDevice.class.getDeclaredMethod("getMacAddress").getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("setMacAddress", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("setMacAddress", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("setMacAddress", String.class).getModifiers()));
            assertEquals(void.class, SmartDevice.class.getDeclaredMethod("setMacAddress", String.class).getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("getPrice").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("getPrice").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("getPrice").getModifiers()));
            assertEquals(double.class, SmartDevice.class.getDeclaredMethod("getPrice").getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("setPrice", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("setPrice", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("setPrice", double.class).getModifiers()));
            assertEquals(void.class, SmartDevice.class.getDeclaredMethod("setPrice", double.class).getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("getPurchaseDate").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("getPurchaseDate").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("getPurchaseDate").getModifiers()));
            assertEquals(LocalDate.class, SmartDevice.class.getDeclaredMethod("getPurchaseDate").getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("setPurchaseDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("setPurchaseDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("setPurchaseDate", LocalDate.class).getModifiers()));
            assertEquals(void.class, SmartDevice.class.getDeclaredMethod("setPurchaseDate", LocalDate.class).getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("getWarrantyEndDate").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("getWarrantyEndDate").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("getWarrantyEndDate").getModifiers()));
            assertEquals(LocalDate.class, SmartDevice.class.getDeclaredMethod("getWarrantyEndDate").getReturnType());

            assertTrue(Modifier.isPrivate(SmartDevice.class.getDeclaredMethod("setWarrantyEndDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("setWarrantyEndDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("setWarrantyEndDate", LocalDate.class).getModifiers()));
            assertEquals(void.class, SmartDevice.class.getDeclaredMethod("setWarrantyEndDate", LocalDate.class).getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("getBatteryLife").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("getBatteryLife").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("getBatteryLife").getModifiers()));
            assertEquals(int.class, SmartDevice.class.getDeclaredMethod("getBatteryLife").getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("setBatteryLife", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("setBatteryLife", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("setBatteryLife", int.class).getModifiers()));
            assertEquals(void.class, SmartDevice.class.getDeclaredMethod("setBatteryLife", int.class).getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("getCurrentBattery").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("getCurrentBattery").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("getCurrentBattery").getModifiers()));
            assertEquals(int.class, SmartDevice.class.getDeclaredMethod("getCurrentBattery").getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("setCurrentBattery", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("setCurrentBattery", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("setCurrentBattery", int.class).getModifiers()));
            assertEquals(void.class, SmartDevice.class.getDeclaredMethod("setCurrentBattery", int.class).getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("getSoftwareVersion").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("getSoftwareVersion").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("getSoftwareVersion").getModifiers()));
            assertEquals(String.class, SmartDevice.class.getDeclaredMethod("getSoftwareVersion").getReturnType());

            assertTrue(Modifier.isPrivate(SmartDevice.class.getDeclaredMethod("isValidSoftwareVersion", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("isValidSoftwareVersion", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("isValidSoftwareVersion", String.class).getModifiers()));
            assertEquals(boolean.class, SmartDevice.class.getDeclaredMethod("isValidSoftwareVersion", String.class).getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("setSoftwareVersion", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("setSoftwareVersion", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("setSoftwareVersion", String.class).getModifiers()));
            assertEquals(void.class, SmartDevice.class.getDeclaredMethod("setSoftwareVersion", String.class).getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("isConnectedByWifi").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("isConnectedByWifi").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("isConnectedByWifi").getModifiers()));
            assertEquals(boolean.class, SmartDevice.class.getDeclaredMethod("isConnectedByWifi").getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("setConnectedByWifi", boolean.class).getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("setConnectedByWifi", boolean.class).getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("setConnectedByWifi", boolean.class).getModifiers()));
            assertEquals(void.class, SmartDevice.class.getDeclaredMethod("setConnectedByWifi", boolean.class).getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("isInWarranty").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("isInWarranty").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("isInWarranty").getModifiers()));
            assertEquals(boolean.class, SmartDevice.class.getDeclaredMethod("isInWarranty").getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("calculateRemainingMinutesBattery", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("calculateRemainingMinutesBattery", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("calculateRemainingMinutesBattery", int.class).getModifiers()));
            assertEquals(int.class, SmartDevice.class.getDeclaredMethod("calculateRemainingMinutesBattery", int.class).getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("calculateBatteryPercentage").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("calculateBatteryPercentage").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("calculateBatteryPercentage").getModifiers()));
            assertEquals(double.class, SmartDevice.class.getDeclaredMethod("calculateBatteryPercentage").getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("warrantyStatus").getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("warrantyStatus").getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("warrantyStatus").getModifiers()));
            assertEquals(String.class, SmartDevice.class.getDeclaredMethod("warrantyStatus").getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("canUpdateSoftware", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("canUpdateSoftware", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("canUpdateSoftware", String.class).getModifiers()));
            assertEquals(boolean.class, SmartDevice.class.getDeclaredMethod("canUpdateSoftware", String.class).getReturnType());

            assertTrue(Modifier.isPublic(SmartDevice.class.getDeclaredMethod("updateSoftware", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(SmartDevice.class.getDeclaredMethod("updateSoftware", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(SmartDevice.class.getDeclaredMethod("updateSoftware", String.class).getModifiers()));
            assertEquals(void.class, SmartDevice.class.getDeclaredMethod("updateSoftware", String.class).getReturnType());
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the methods!");
        }
    }

    @Test
    @Order(4)
    @DisplayName("Minimum - setSerialNumber")
    public void testSetSerialNumber() {
        SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("ABC-123-DEF", smartDevice.getSerialNumber());

        smartDevice.setSerialNumber("DEF-321-ABC");
        assertEquals("DEF-321-ABC", smartDevice.getSerialNumber());

        smartDevice.setSerialNumber(null);
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setSerialNumber("");
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setSerialNumber("A");
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setSerialNumber("ABC123DEF");
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setSerialNumber("ABC-123.DEF");
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setSerialNumber("abc-123-def");
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setSerialNumber("ABCD-123-DEF");
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setSerialNumber("ABC-1234-DEF");
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setSerialNumber("ABC-1234-DEFG");
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setSerialNumber("ABC-1234-DE&");
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice(null, "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("A", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC123DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123.DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("abc-123-def", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABCD-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-1234-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-1234-DEFG", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-1234-DE&", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'", outContent.toString().trim());
        restoreStreams();
    }

    @Test
    @Order(5)
    @DisplayName("Minimum - setOwnerName")
    public void testSetOwnerName() {
        SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("Universitat Oberta de Catalunya", smartDevice.getOwnerName());

        smartDevice.setOwnerName("UOC");
        assertEquals("UOC", smartDevice.getOwnerName());

        smartDevice.setOwnerName(" UOC ");
        assertEquals("UOC", smartDevice.getOwnerName());

        smartDevice.setOwnerName(null);
        assertEquals("[ERROR] Owner name cannot be null, empty or blank", outContent.toString().trim());
        restoreStreams();

        smartDevice.setOwnerName("");
        assertEquals("[ERROR] Owner name cannot be null, empty or blank", outContent.toString().trim());
        restoreStreams();

        smartDevice.setOwnerName(" ");
        assertEquals("[ERROR] Owner name cannot be null, empty or blank", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", " UOC ", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("UOC", smartDevice.getOwnerName());

        smartDevice = new SmartDevice("ABC-123-DEF", null, "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] Owner name cannot be null, empty or blank", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] Owner name cannot be null, empty or blank", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", " ", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] Owner name cannot be null, empty or blank", outContent.toString().trim());
        restoreStreams();
    }

    @Test
    @Order(6)
    @DisplayName("Minimum - setMacAddress")
    public void testSetMacAddress() {
        SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("00:11:22:33:44:55", smartDevice.getMacAddress());

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "AA-33-CC-22-EE-11", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("AA-33-CC-22-EE-11", smartDevice.getMacAddress());

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "AA:BB:CC:DD:EE:FF", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("AA:BB:CC:DD:EE:FF", smartDevice.getMacAddress());

        smartDevice.setMacAddress("11:22:33:44:55:66");
        assertEquals("11:22:33:44:55:66", smartDevice.getMacAddress());

        smartDevice.setMacAddress("AA-33-CC-22-EE-11");
        assertEquals("AA-33-CC-22-EE-11", smartDevice.getMacAddress());

        smartDevice.setMacAddress("AA:BB:CC:DD:EE:FF");
        assertEquals("AA:BB:CC:DD:EE:FF", smartDevice.getMacAddress());

        smartDevice.setMacAddress(null);
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setMacAddress("");
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setMacAddress(" ");
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setMacAddress("AA:BB:CC:DD:EE");
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setMacAddress("AA:BB:CC:DD:EE:FF:GG");
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setMacAddress("AA-BB-CC-DD-EE");
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setMacAddress("AABBCCDDEEFF");
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setMacAddress("AA.BB.CC.DD.EE.FF");
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setMacAddress("AA:BB:CC:GG:HH:II");
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setMacAddress("AA:BB:CC:DD:EE:1G");
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setMacAddress("AA:BB:CC:DD:EE:FG");
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setMacAddress("ZZ:ZZ:ZZ:ZZ:ZZ:ZZ");
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice.setMacAddress("aa:bb:cc:dd:11:22");
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", null, 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", " ", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "AA:BB:CC:DD:EE", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "AA:BB:CC:DD:EE:FF:GG", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "AA-BB-CC-DD-EE", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "AABBCCDDEEFF", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "AA.BB.CC.DD.EE.FF", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "AA:BB:CC:GG:HH:II", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "AA:BB:CC:DD:EE:1G", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "AA:BB:CC:DD:EE:FG", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "ZZ:ZZ:ZZ:ZZ:ZZ:ZZ", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "aa:bb:cc:dd:11:22", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'", outContent.toString().trim());
        restoreStreams();
    }

    @Test
    @Order(7)
    @DisplayName("Minimum - setPrice")
    public void testSetPrice() {
        SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals(720.0, smartDevice.getPrice());

        smartDevice.setPrice(1000.0);
        assertEquals(1000.0, smartDevice.getPrice());

        smartDevice.setPrice(0.1);
        assertEquals(0.1, smartDevice.getPrice());

        smartDevice.setPrice(0.0);
        assertEquals("[ERROR] Price must be greater than 0", outContent.toString().trim());
        restoreStreams();

        smartDevice.setPrice(-1000.0);
        assertEquals("[ERROR] Price must be greater than 0", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 0.1, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals(0.1, smartDevice.getPrice());

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 0.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] Price must be greater than 0", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", -1000.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] Price must be greater than 0", outContent.toString().trim());
        restoreStreams();
    }

    @Test
    @Order(8)
    @DisplayName("Minimum - setPurchaseDate")
    public void testSetPurchaseDate() {
        SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals(LocalDate.now(), smartDevice.getPurchaseDate());

        smartDevice.setPurchaseDate(LocalDate.now().minusDays(1));
        assertEquals(LocalDate.now().minusDays(1), smartDevice.getPurchaseDate());

        smartDevice.setPurchaseDate(LocalDate.now().minusYears(3));
        assertEquals(LocalDate.now().minusYears(3), smartDevice.getPurchaseDate());

        smartDevice.setPurchaseDate(null);
        assertEquals("[ERROR] Purchase date cannot be null or in the future", outContent.toString().trim());
        restoreStreams();

        smartDevice.setPurchaseDate(LocalDate.now().plusDays(1));
        assertEquals("[ERROR] Purchase date cannot be null or in the future", outContent.toString().trim());
        restoreStreams();

        smartDevice.setPurchaseDate(LocalDate.now().plusYears(3));
        assertEquals("[ERROR] Purchase date cannot be null or in the future", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, null, 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] Purchase date cannot be null or in the future", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now().plusDays(1), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] Purchase date cannot be null or in the future", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now().plusYears(3), 5000, 4200, "1.0.0", false);
        assertEquals("[ERROR] Purchase date cannot be null or in the future", outContent.toString().trim());
        restoreStreams();
    }

    @Test
    @Order(9)
    @DisplayName("Minimum - setWarrantyEndDate")
    public void testSetWarrantyEndDate() {
        SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals(LocalDate.now().plusYears(2), smartDevice.getWarrantyEndDate());

        smartDevice.setPurchaseDate(LocalDate.now().minusDays(3));
        assertEquals(LocalDate.now().minusDays(3).plusYears(2), smartDevice.getWarrantyEndDate());

        smartDevice.setPurchaseDate(LocalDate.now().minusYears(3));
        assertEquals(LocalDate.now().minusYears(3).plusYears(2), smartDevice.getWarrantyEndDate());

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now().minusDays(1), 5000, 4200, "1.0.0", false);
        assertEquals(LocalDate.now().minusDays(1).plusYears(2), smartDevice.getWarrantyEndDate());

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now().minusYears(5), 5000, 4200, "1.0.0", false);
        assertEquals(LocalDate.now().minusYears(5).plusYears(2), smartDevice.getWarrantyEndDate());
    }

    @Test
    @Order(10)
    @DisplayName("Minimum - setBatteryLife")
    public void testSetBatteryLife() {
        SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals(5000, smartDevice.getBatteryLife());

        smartDevice.setBatteryLife(10000);
        assertEquals(10000, smartDevice.getBatteryLife());

        smartDevice.setBatteryLife(1);
        assertEquals(1, smartDevice.getBatteryLife());

        smartDevice.setBatteryLife(0);
        assertEquals("[ERROR] Battery life must be greater than 0", outContent.toString().trim());
        restoreStreams();

        smartDevice.setBatteryLife(-1000);
        assertEquals("[ERROR] Battery life must be greater than 0", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 10000, 4200, "1.0.0", false);
        assertEquals(10000, smartDevice.getBatteryLife());

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 1, 1, "1.0.0", false);
        assertEquals(1, smartDevice.getBatteryLife());

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), 0, 0, "1.0.0", false);
        assertEquals("[ERROR] Battery life must be greater than 0", outContent.toString().trim());
        assertEquals(0, smartDevice.getBatteryLife());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), -1, 0, "1.0.0", false);
        assertEquals("[ERROR] Battery life must be greater than 0", outContent.toString().trim());
        assertEquals(0, smartDevice.getBatteryLife());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 720.0, LocalDate.now(), -1000, 0, "1.0.0", false);
        assertEquals("[ERROR] Battery life must be greater than 0", outContent.toString().trim());
        assertEquals(0, smartDevice.getBatteryLife());
        restoreStreams();
    }

    @Test
    @Order(11)
    @DisplayName("Minimum - setCurrentBattery")
    public void testSetCurrentBattery() {
        SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals(4200, smartDevice.getCurrentBattery());

        smartDevice.setCurrentBattery(5000);
        assertEquals(5000, smartDevice.getCurrentBattery());

        smartDevice.setCurrentBattery(0);
        assertEquals(0, smartDevice.getCurrentBattery());

        smartDevice.setCurrentBattery(-1);
        assertEquals("[ERROR] Current battery must be between 0 and battery life", outContent.toString().trim());
        restoreStreams();

        smartDevice.setCurrentBattery(5001);
        assertEquals("[ERROR] Current battery must be between 0 and battery life", outContent.toString().trim());
        restoreStreams();

        smartDevice.setBatteryLife(5200);
        smartDevice.setCurrentBattery(5200);
        assertEquals(5200, smartDevice.getCurrentBattery());

        smartDevice.setCurrentBattery(5201);
        assertEquals("[ERROR] Current battery must be between 0 and battery life", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 0, "1.0.0", false);
        assertEquals(0, smartDevice.getCurrentBattery());

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, -1, "1.0.0", false);
        assertEquals("[ERROR] Current battery must be between 0 and battery life", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 5001, "1.0.0", false);
        assertEquals("[ERROR] Current battery must be between 0 and battery life", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5200, 5199, "1.0.0", false);
        assertEquals(5199, smartDevice.getCurrentBattery());

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5200, 5201, "1.0.0", false);
        assertEquals("[ERROR] Current battery must be between 0 and battery life", outContent.toString().trim());
        restoreStreams();
    }

    @Test
    @Order(12)
    @DisplayName("Minimum - setSoftwareVersion")
    public void testSetSoftwareVersion() {
        SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals("1.0.0", smartDevice.getSoftwareVersion());

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 10; j++) {
                smartDevice.setSoftwareVersion("1." + i + "." + j);
                assertEquals("1." + i + "." + j, smartDevice.getSoftwareVersion());
            }
        }

        smartDevice.setSoftwareVersion(null);
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice.setSoftwareVersion("");
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice.setSoftwareVersion(" ");
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice.setSoftwareVersion("1.0");
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice.setSoftwareVersion("1.0.a");
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice.setSoftwareVersion("a.a.a");
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice.setSoftwareVersion("1_1_1");
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice.setSoftwareVersion("1.1.%");
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice.setSoftwareVersion("1.6.0");
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice.setSoftwareVersion("2.0.0");
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice.setSoftwareVersion("0.0.0");
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 10; j++) {
                smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 4200, "1." + i + "." + j, false);
                assertEquals("1." + i + "." + j, smartDevice.getSoftwareVersion());
            }
        }

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 4200, null, false);
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 4200, "", false);
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 4200, " ", false);
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 4200, "1.0", false);
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 4200, "1.0.a", false);
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 4200, "a.a.a", false);
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 4200, "1_1_1", false);
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 4200, "1.1.%", false);
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 4200, "1.6.0", false);
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 4200, "2.0.0", false);
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 4200, "0.0.0", false);
        assertEquals("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5", outContent.toString().trim());
        restoreStreams();
    }

    @Test
    @Order(13)
    @DisplayName("Minimum - isConnectedByWifi")
    public void testIsConnectedByWifi() {
        SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertFalse(smartDevice.isConnectedByWifi());

        smartDevice.setConnectedByWifi(true);
        assertTrue(smartDevice.isConnectedByWifi());

        smartDevice.setConnectedByWifi(false);
        assertFalse(smartDevice.isConnectedByWifi());

        smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 4200, "1.0.0", true);
        assertTrue(smartDevice.isConnectedByWifi());
    }

    @Test
    @Order(14)
    @DisplayName("Minimum - isInWarranty")
    public void testIsInWarranty() {
        SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertTrue(smartDevice.isInWarranty());

        smartDevice.setPurchaseDate(LocalDate.now().minusYears(2).plusDays(1));
        assertTrue(smartDevice.isInWarranty());

        smartDevice.setPurchaseDate(LocalDate.now().minusYears(2));
        assertFalse(smartDevice.isInWarranty());

        smartDevice.setPurchaseDate(LocalDate.now().minusYears(2).minusDays(1));
        assertFalse(smartDevice.isInWarranty());

        smartDevice.setPurchaseDate(LocalDate.now().minusYears(3));
        assertFalse(smartDevice.isInWarranty());
    }

    @Test
    @Order(15)
    @DisplayName("Minimum - calculateRemainingMinutesBattery")
    public void testCalculateRemainingMinutesBattery() {
        SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals(504, smartDevice.calculateRemainingMinutesBattery(500));
        assertEquals(315, smartDevice.calculateRemainingMinutesBattery(800));

        smartDevice.setCurrentBattery(300);
        assertEquals(60, smartDevice.calculateRemainingMinutesBattery(300));
        assertEquals(36, smartDevice.calculateRemainingMinutesBattery(500));

        smartDevice.setCurrentBattery(0);
        assertEquals(0, smartDevice.calculateRemainingMinutesBattery(500));
    }

    @Test
    @Order(16)
    @DisplayName("Minimum - calculateBatteryPercentage")
    public void testCalculateBatteryPercentage() {
        SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now(), 5000, 4200, "1.0.0", false);
        assertEquals(84.0, smartDevice.calculateBatteryPercentage());

        smartDevice.setCurrentBattery(5000);
        assertEquals(100.0, smartDevice.calculateBatteryPercentage());

        smartDevice.setCurrentBattery(0);
        assertEquals(0.0, smartDevice.calculateBatteryPercentage());

        smartDevice.setCurrentBattery(2500);
        assertEquals(50.0, smartDevice.calculateBatteryPercentage());

        smartDevice.setCurrentBattery(1250);
        assertEquals(25.0, smartDevice.calculateBatteryPercentage());

        smartDevice.setCurrentBattery(3750);
        assertEquals(75.0, smartDevice.calculateBatteryPercentage());

        smartDevice.setBatteryLife(7500);
        assertEquals(50.0, smartDevice.calculateBatteryPercentage());

        smartDevice.setBatteryLife(10000);
        assertEquals(37.5, smartDevice.calculateBatteryPercentage());

        smartDevice.setBatteryLife(9777);
        assertEquals(38.36, smartDevice.calculateBatteryPercentage(), 0.01);
    }

    @Test
    @Order(17)
    @DisplayName("Minimum - warrantyStatus")
    public void testWarrantyStatus() {
        SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now().minusYears(3), 5000, 4200, "1.0.0", false);
        assertEquals("Out of warranty", smartDevice.warrantyStatus());
    }

    @Test
    @Order(18)
    @DisplayName("Minimum - canUpdateSoftware")
    public void testCanUpdateSoftware() {
        SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now().minusYears(3), 5000, 4200, "1.0.0", false);
        assertFalse(smartDevice.canUpdateSoftware("1.6.0"));
        assertFalse(smartDevice.canUpdateSoftware("1.0.1"));
    }

    @Test
    @Order(19)
    @DisplayName("Minimum - updateSoftware")
    public void testUpdateSoftware() {
        SmartDevice smartDevice = new SmartDevice("ABC-123-DEF", "Universitat Oberta de Catalunya", "00:11:22:33:44:55", 100.0, LocalDate.now().minusYears(3), 5000, 4200, "1.0.0", false);

        smartDevice.updateSoftware("1.6.0");
        assertEquals("1.0.0", smartDevice.getSoftwareVersion());
        assertEquals("[ERROR] Software cannot be updated", outContent.toString().trim());
        restoreStreams();

        smartDevice.updateSoftware("1.0.1");
        assertEquals("1.0.0", smartDevice.getSoftwareVersion());
        assertEquals("[ERROR] Software cannot be updated", outContent.toString().trim());
        restoreStreams();
    }

}
