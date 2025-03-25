package edu.uoc.pac2;

import java.time.LocalDate;

//Se incluyen métodos que no se utilizan pero aparecían en el enunciado
public class SmartDevice {
    /**Device serial number**/
    private String serialNumber;
    /**Name of the device owner**/
    private String ownerName;
    /**MAC address of the device**/
    private String macAddress;
    /** Price of the device**/
    private double price;
    /** Date of purchase**/
    private LocalDate purchaseDate;
    /** End date of warranty**/
    private LocalDate warrantyEndDate;
    /** Maximum battery capacity in mAh**/
    private int batteryLife;
    /**Current battery level in mAh**/
    private int currentBattery;
    /**Current software version**/
    private String softwareVersion;
    /**Wi-Fi connection status**/
    private boolean isConnectedByWifi;
    /** Warranty duration in years**/
    private static final int warrantyYears = 2;
    /** Months before warranty ends to consider it "close"**/
    private static final int closeEndWarrantyMonths = 3;
    /** Minimum battery percentage for safe mode**/
    private static final double batterySafeMode = 0.2;
    /** Valid software version prefixes**/
    private static final String[] softwareVersions = {"1.0", "1.1", "1.2", "1.3", "1.4", "1.5"};

    /**
     * Constructs a new SmartDevice with the specified attributes.
     * @param serialNumber The serial number (format: XXX-000-XXX)
     * @param ownerName The owner's name
     * @param macAddress The MAC address (format: XX:XX:XX:XX:XX:XX)
     * @param price The price of the device
     * @param purchaseDate The date of purchase
     * @param batteryLife The maximum battery capacity in mAh
     * @param currentBattery The current battery level in mAh
     * @param softwareVersion The software version (format: X.X.X)
     * @param isConnectedByWifi Whether the device is connected via Wi-Fi
     * @throws Exception If any parameter is invalid
     */

    public SmartDevice(String serialNumber, String ownerName, String macAddress, double price,
                       LocalDate purchaseDate, int batteryLife, int currentBattery,
                       String softwareVersion, boolean isConnectedByWifi) throws Exception {
        /* Métodos a añadir: */
        setSerialNumber(serialNumber);
        setOwnerName(ownerName);
        setMacAddress(macAddress);
        setPrice(price);
        setPurchaseDate(purchaseDate);
        setBatteryLife(batteryLife);
        setCurrentBattery(currentBattery);
        setSoftwareVersion(softwareVersion);
        setConnectedByWifi(isConnectedByWifi);
    }

    /**
     * Assign a serial number with the format: XXX-000-XXX.
     * @param setSerialNumber The serial number (format: XXX-000-XXX)
     * @return serial number of the device
     */

    public void setSerialNumber(String serialNumber) throws Exception {
        if (serialNumber == null || !serialNumber.matches("[A-Z]{3}-[0-9]{3}-[A-Z]{3}")) {
            throw new Exception("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'");
        }
        this.serialNumber = serialNumber;
    }

    /** @return The serial number of the device */
    public String getSerialNumber() {
        return serialNumber;
    }

    /*CHECK NULL Y ASIGNAR NOMBRE*/
    public void setOwnerName(String ownerName) throws Exception {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new Exception("[ERROR] Owner name cannot be null, empty or blank");
        }
        this.ownerName = ownerName.trim();
    }

    /*DEVOLVER OWNER*/
    public String getOwnerName() {
        return ownerName;
    }

    /*COMPROBAR NULL && XX:XX:XX:XX:XX:XX FORMAT*/
    public void setMacAddress(String macAddress) throws Exception {
        if (macAddress == null || !macAddress.matches("([0-9A-F]{2}[:-]){5}([0-9A-F]{2})")) {
            throw new Exception("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'");
        }
        this.macAddress = macAddress;
    }

    /*DEVOLVER MAC*/
    public String getMacAddress() {
        return macAddress;
    }

    /*asigna el precio del dispositivo inteligente validando que el parámetro recibido (price) sea superior a 0*/
    public void setPrice(double price) throws Exception {
        if (price <= 0) {
            throw new Exception("[ERROR] Price must be greater than 0");
        }
        this.price = price;
    }

    /*DEVOLVER PRICE*/
    public double getPrice() {
        return price;
    }

    /*check nulll && >current date*/
    public void setPurchaseDate(LocalDate purchaseDate) throws Exception {
        if (purchaseDate == null || purchaseDate.isAfter(LocalDate.now())) {
            throw new Exception("[ERROR] Purchase date cannot be null or in the future");
        }
        this.purchaseDate = purchaseDate;
        /*asignar fin warranty*/
        setWarrantyEndDate(purchaseDate.plusYears(warrantyYears));
    }

    /*set final warranty*/
    private void setWarrantyEndDate(LocalDate warrantyEndDate) {
        this.warrantyEndDate = warrantyEndDate;
    }

    /** @return The purchase date of the device */
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    /** @return The warranty end date of the device */
    public LocalDate getWarrantyEndDate() {
        return warrantyEndDate;
    }

    /*check (batteryLife) sea superior a 0*/
    public void setBatteryLife(int batteryLife) throws Exception {
        if (batteryLife <= 0) {
            throw new Exception("[ERROR] Battery life must be greater than 0");
        }
        this.batteryLife = batteryLife;
    }

    /** @return The maximum battery life in mAh */
    public int getBatteryLife() {
        return batteryLife;
    }

    /*devolver batería*/
    public int getCurrentBattery() {
        return currentBattery;
    }

    /*Debe validar que el parámetro recibido (currentBattery) sea superior o igual a 0 y, además, que no superior al valor máximo de la batería*/
    public void setCurrentBattery(int currentBattery) throws Exception {
        if (currentBattery < 0 || currentBattery > batteryLife) {
            throw new Exception("[ERROR] Current battery must be between 0 and battery life");
        }
        this.currentBattery = currentBattery;
    }

    /*devuelve true si la versión recibida por parámetro (softwareVersion) no sea null y sea una versión válida.
     * Una versión de software es válida si sigue el siguiente formato: majorVersion.minorVersion.patchVersion*/
    private boolean isValidSoftwareVersion(String softwareVersion) {
        if (softwareVersion == null || !softwareVersion.matches("\\d+\\.\\d+\\.\\d+")) {
            return false;  // Fixed: Return false for invalid versions
        }
        for (String validVersion : softwareVersions) {
            if (softwareVersion.startsWith(validVersion + ".")) {
                return true;  // Fixed: Return true for valid versions
            }
        }
        return false;
    }

    /*debe validar que el parámetro recibido (softwareVersion) sea una versión válida siguiendo las especificaciones detalladas en el punto anterior*/
    public void setSoftwareVersion(String softwareVersion) throws Exception {
        if (!isValidSoftwareVersion(softwareVersion)) {  // Fixed: Throw exception for invalid versions
            throw new Exception("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5");
        }
        this.softwareVersion = softwareVersion;
    }

    /*devolver versión software*/
    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setConnectedByWifi(boolean isConnectedByWifi) {
        this.isConnectedByWifi = isConnectedByWifi;
    }

    /** @return True if the device is connected via Wi-Fi */
    public boolean isConnectedByWifi() {
        return isConnectedByWifi;
    }

    /** @return True if the device is still under warranty */
    public boolean isInWarranty() {
        return LocalDate.now().isBefore(warrantyEndDate);
    }

    /**
     * Calculates the remaining battery life in minutes based on average consumption.
     * @param avgMAhPerHour Average consumption in mAh per hour
     * @return Remaining minutes of battery life, or 0 if avgMAhPerHour is invalid
     */
    public int calculateRemainingMinutesBattery(int avgMAhPerHour) {
        if (avgMAhPerHour <= 0) return 0;
        return (currentBattery * 60) / avgMAhPerHour;
    }

    /** @return The current battery percentage */
    public double calculateBatteryPercentage() {
        return (double) currentBattery / batteryLife * 100;
    }

    /** @return The warranty status: "Out of warranty", "Close to the end of the warranty", or "Warranty won't end soon" */
    public String warrantyStatus() {
        if (!isInWarranty()) {
            return "Out of warranty";
        }
        LocalDate closeDate = warrantyEndDate.minusMonths(closeEndWarrantyMonths);
        if (LocalDate.now().isAfter(closeDate)) {
            return "Close to the end of the warranty";
        }
        return "Warranty won't end soon";
    }

    /**
     * Checks if the software can be updated to the new version.
     * @param newSoftwareVersion The version to update to
     * @return True if update is possible, false otherwise
     */
    public boolean canUpdateSoftware(String newSoftwareVersion) {
        if (!isValidSoftwareVersion(newSoftwareVersion) || !isConnectedByWifi ||
                calculateBatteryPercentage() < (batterySafeMode * 100)) {
            return false;
        }
        String[] currentParts = softwareVersion.split("\\.");
        String[] newParts = newSoftwareVersion.split("\\.");

        int currentMajor = Integer.parseInt(currentParts[0]);
        int currentMinor = Integer.parseInt(currentParts[1]);
        int currentPatch = Integer.parseInt(currentParts[2]);

        int newMajor = Integer.parseInt(newParts[0]);
        int newMinor = Integer.parseInt(newParts[1]);
        int newPatch = Integer.parseInt(newParts[2]);

        if (newMajor > currentMajor) return true;
        if (newMajor < currentMajor) return false;
        if (newMinor > currentMinor) return true;
        if (newMinor < currentMinor) return false;
        return newPatch > currentPatch;
    }

    /**
     * Updates the software version if conditions are met.
     * @param newSoftwareVersion The new software version to install
     * @throws Exception If the software cannot be updated
     */
    public void updateSoftware(String newSoftwareVersion) throws Exception {
        if (!canUpdateSoftware(newSoftwareVersion)) {
            throw new Exception("[ERROR] Software cannot be updated");
        }
        this.softwareVersion = newSoftwareVersion;
    }
}