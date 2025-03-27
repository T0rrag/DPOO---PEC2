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

    /**Assign a serial number with the format: XXX-000-XXX.**/

    public void setSerialNumber(String serialNumber) throws Exception {
        if (serialNumber == null || !serialNumber.matches("[A-Z]{3}-[0-9]{3}-[A-Z]{3}")) {
            throw new Exception("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'");
        }
        this.serialNumber = serialNumber;
    }

    /** Return The serial number of the device. **/
    public String getSerialNumber() {
        return serialNumber;
    }

    /**Assign an owners name and check if its not null.**/
    public void setOwnerName(String ownerName) throws Exception {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new Exception("[ERROR] Owner name cannot be null, empty or blank");
        }
        this.ownerName = ownerName.trim();
    }

    /**Return owners name.**/
    public String getOwnerName() {
        return ownerName;
    }

    /** Check if MAC Address follows the format (XX:XX:XX:XX:XX:XX) and its not null**/
    public void setMacAddress(String macAddress) throws Exception {
        if (macAddress == null || !macAddress.matches("([0-9A-F]{2}[:-]){5}([0-9A-F]{2})")) {
            throw new Exception("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'");
        }
        this.macAddress = macAddress;
    }

    /** Return MAC Address **/
    public String getMacAddress() {
        return macAddress;
    }

    /**Assign a price for the device, given that price > 0 **/
    public void setPrice(double price) throws Exception {
        if (price <= 0) {
            throw new Exception("[ERROR] Price must be greater than 0");
        }
        this.price = price;
    }

    /**Return price **/
    public double getPrice() {
        return price;
    }

    /**Assign a Purchase date, that must be not null and less or equal our current local date **/
    public void setPurchaseDate(LocalDate purchaseDate) throws Exception {
        if (purchaseDate == null || purchaseDate.isAfter(LocalDate.now())) {
            throw new Exception("[ERROR] Purchase date cannot be null or in the future");
        }
        this.purchaseDate = purchaseDate;
        /**Calculate an end date based on remaining months since purchaseDate **/
        setWarrantyEndDate(purchaseDate.plusYears(warrantyYears));
    }

    /**Assign and end date based on remaining months since purchaseDate **/
    private void setWarrantyEndDate(LocalDate warrantyEndDate) {
        this.warrantyEndDate = warrantyEndDate;
    }

    /** Return the purchase date of the device **/
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    /** Return warranty end date of a given device **/
    public LocalDate getWarrantyEndDate() {
        return warrantyEndDate;
    }

    /** Check for battery life, it must be greather than 0. In our case we throw an exception if its less or equal than 0 **/
    public void setBatteryLife(int batteryLife) throws Exception {
        if (batteryLife <= 0) {
            throw new Exception("[ERROR] Battery life must be greater than 0");
        }
        this.batteryLife = batteryLife;
    }

    /** Return The maximum battery life in mAh **/
    public int getBatteryLife() {
        return batteryLife;
    }

    /** Get our current battery level**/
    public int getCurrentBattery() {
        return currentBattery;
    }

  /** Check if (currentBattery is less 0) and also (currentBattery is bigger than batteryLife) if there is an error, return prompt, else return currentBattery **/
    public void setCurrentBattery(int currentBattery) throws Exception {
        if (currentBattery < 0 || currentBattery > batteryLife) {
            throw new Exception("[ERROR] Current battery must be between 0 and battery life");
        }
        this.currentBattery = currentBattery;
    }

    /**Return true if a given version is not null and its a valid version. A valid version must follow the following format: majorVersion.minorVersion.patchVersion**/
    private boolean isValidSoftwareVersion(String softwareVersion) {
        if (softwareVersion == null || !softwareVersion.matches("\\d+\\.\\d+\\.\\d+")) {
            /**For invalid version**/
            return false;
        }
        for (String validVersion : softwareVersions) {
            if (softwareVersion.startsWith(validVersion + ".")) {
                /** For valid version**/
                return true;
            }
        }
        return false;
    }

    /**Check if softwareVersion is valid given the format: majorVersion.minorVersion.patchVersion  **/
      public void setSoftwareVersion(String softwareVersion) throws Exception {
        if (!isValidSoftwareVersion(softwareVersion)) {
            /** If its not valid, show prompt **/
            throw new Exception("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5");
        }
        this.softwareVersion = softwareVersion;
    }

    /** Return softwareVersion**/
    public String getSoftwareVersion() {
        return softwareVersion;
    }

    /** Check if its connected by wifi (true or false)**/
    public void setConnectedByWifi(boolean isConnectedByWifi) {
        this.isConnectedByWifi = isConnectedByWifi;
    }

    /** Return if its connected or not **/
    public boolean isConnectedByWifi() {
        return isConnectedByWifi;
    }

    /** Return if the device is still under warranty **/
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

    /** Return battery percentage ((currentBattery divided by batteryLife) * 100)  **/
    public double calculateBatteryPercentage() {
        return (double) currentBattery / batteryLife * 100;
    }

    /** Return one of the following based on duration: "Out of warranty", "Close to the end of the warranty", or "Warranty won't end soon" **/
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

    /** Check if i can update my software given that: new version is valid, is connected and has a minimum battery **/
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

    /** If the conditions are met, update the software. Create a newSoftwareVersion to store its values. If you can´t, throw exception. **/
    public void updateSoftware(String newSoftwareVersion) throws Exception {
        if (!canUpdateSoftware(newSoftwareVersion)) {
            throw new Exception("[ERROR] Software cannot be updated");
        }
        this.softwareVersion = newSoftwareVersion;
    }
}