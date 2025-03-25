package edu.uoc.pac2;

import java.time.LocalDate;

public class SmartDevice {
    private String serialNumber;
    private String ownerName;
    private String macAddress;
    private double price;
    private LocalDate purchaseDate;
    private LocalDate warrantyEndDate;
    private int batteryLife;
    private int currentBattery;
    private String softwareVersion;
    private boolean isConnectedByWifi;
    private static int warrantyYears = 2;
    private static int closeEndWarrantyMonths = 3;
    private static double batterySafeMode = 0.2;
    private static String[] softwareVersions = {"1.0", "1.1", "1.2", "1.3", "1.4", "1.5"};

    public SmartDevice(String serialNumber, String ownerName, String macAddress, double price,
                       LocalDate purchaseDate, int batteryLife, int currentBattery,
                       String softwareVersion, boolean isConnectedByWifi) {
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        if (serialNumber == null || !serialNumber.matches("[A-Z]{3}-[0-9]{3}-[A-Z]{3}")) {
            System.out.println("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'");
            if (this.serialNumber == null) this.serialNumber = "AAA-000-AAA";
            return;
        }
        this.serialNumber = serialNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            System.out.println("[ERROR] Owner name cannot be null, empty or blank");
            if (this.ownerName == null) this.ownerName = "Unknown";
            return;
        }
        this.ownerName = ownerName.trim();
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        if (macAddress == null || !macAddress.matches("([0-9A-F]{2}[:-]){5}([0-9A-F]{2})")) {
            System.out.println("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'");
            if (this.macAddress == null) this.macAddress = "00:00:00:00:00:00";
            return;
        }
        this.macAddress = macAddress;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            System.out.println("[ERROR] Price must be greater than 0");
            if (this.price == 0) this.price = 1.0;
            return;
        }
        this.price = price;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        if (purchaseDate == null || purchaseDate.isAfter(LocalDate.now())) {
            System.out.println("[ERROR] Purchase date cannot be null or in the future");
            if (this.purchaseDate == null) {
                this.purchaseDate = LocalDate.now();
                setWarrantyEndDate(this.purchaseDate.plusYears(warrantyYears));
            }
            return;
        }
        this.purchaseDate = purchaseDate;
        setWarrantyEndDate(purchaseDate.plusYears(warrantyYears));
    }

    public LocalDate getWarrantyEndDate() {
        return warrantyEndDate;
    }

    private void setWarrantyEndDate(LocalDate warrantyEndDate) {
        this.warrantyEndDate = warrantyEndDate;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        if (batteryLife <= 0) {
            System.out.println("[ERROR] Battery life must be greater than 0");
            return;
        }
        this.batteryLife = batteryLife;
    }

    public int getCurrentBattery() {
        return currentBattery;
    }

    public void setCurrentBattery(int currentBattery) {
        if (currentBattery < 0 || currentBattery > batteryLife) {
            System.out.println("[ERROR] Current battery must be between 0 and battery life");
            if (this.currentBattery == 0 && batteryLife > 0) this.currentBattery = batteryLife;
            return;
        }
        this.currentBattery = currentBattery;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    private boolean isValidSoftwareVersion(String softwareVersion) {
        if (softwareVersion == null || !softwareVersion.matches("\\d+\\.\\d+\\.\\d+")) {
            return false;
        }
        for (String validVersion : softwareVersions) {
            if (softwareVersion.startsWith(validVersion + ".")) {
                return true;
            }
        }
        return false;
    }

    public void setSoftwareVersion(String softwareVersion) {
        if (!isValidSoftwareVersion(softwareVersion)) {
            System.out.println("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5");
            if (this.softwareVersion == null) this.softwareVersion = "1.0.0";
            return;
        }
        this.softwareVersion = softwareVersion;
    }

    public boolean isConnectedByWifi() {
        return isConnectedByWifi;
    }

    public void setConnectedByWifi(boolean isConnectedByWifi) {
        this.isConnectedByWifi = isConnectedByWifi;
    }

    public boolean isInWarranty() {
        return LocalDate.now().isBefore(warrantyEndDate);
    }

    public int calculateRemainingMinutesBattery(int avgMAhPerHour) {
        if (avgMAhPerHour <= 0) return 0;
        return (currentBattery * 60) / avgMAhPerHour;
    }

    public double calculateBatteryPercentage() {
        return (double) currentBattery / batteryLife * 100;
    }

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

    public void updateSoftware(String newSoftwareVersion) {
        if (canUpdateSoftware(newSoftwareVersion)) {
            this.softwareVersion = newSoftwareVersion;
        } else {
            System.out.println("[ERROR] Software cannot be updated");
        }
    }
}