package edu.uoc.pac2;

import java.time.LocalDate;

public class SmartDevice {
    /*add:
    serialNumber
    ownerName
    MacAddress
    price
    purchaseDate
    warrantyEndDate
    batteryLife
    currentBattery
    softwareVersion
    isConnectedByWifi
    isInWarranty
    calculateBatteryPercentage
    warrantyStatus (null, closeEnd, onWarranty)
    canUpdateSoftware (newSoftwareVersion - softwareVersion)

     */
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
        /*CHECK NULL && XXX-00-XXX FORMAT*/
        if (serialNumber == null || !serialNumber.matches("[A-Z]{3}-[0-9]{3}-[A-Z]{3}")) {
            System.out.println("[ERROR] Serial number cannot be null and must have the format 'XXX-000-XXX'");
            if (this.serialNumber == null) this.serialNumber = "AAA-000-AAA";
            return;
        }
        this.serialNumber = serialNumber;
    }

    public void setOwnerName(String ownerName) {
        /*CHECK NULL Y ASIGNAR NOMBRE*/
        if (ownerName == null || ownerName.trim().isEmpty()) {
            System.out.println("[ERROR] Owner name cannot be null, empty or blank");
            if (this.ownerName == null) this.ownerName = "Unknown";
            return;
        }
        this.ownerName = ownerName.trim();
    }

    public String getOwnerName() {
        /*DEVOLVER OWNER*/
        return ownerName;
    }

    public void setMacAddress(String macAddress) {
        /*COMPROBAR NULL && XX:XX:XX:XX:XX:XX FORMAT*/
        if (macAddress == null || !macAddress.matches("([0-9A-F]{2}[:-]){5}([0-9A-F]{2})")) {
            System.out.println("[ERROR] MAC address cannot be null and must have the format 'XX:XX:XX:XX:XX:XX'");
            if (this.macAddress == null) this.macAddress = "00:00:00:00:00:00";
            return;
        }
        this.macAddress = macAddress;
    }

    public String getMacAddress() {
        /*DEVOLVER MAC*/
        return macAddress;
    }

    public void setPrice(double price) {
        /*asigna el precio del dispositivo inteligente validando que el parámetro recibido (price) sea superior a 0*/
        if (price <= 0) {
            System.out.println("[ERROR] Price must be greater than 0");
            if (this.price == 0) this.price = 1.0;
            return;
        }
        this.price = price;
    }

    public double getPrice() {
        /*DEVOLVER PRICE*/
        return price;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        /*check nulll && >current date*/
        if (purchaseDate == null || purchaseDate.isAfter(LocalDate.now())) {
            System.out.println("[ERROR] Purchase date cannot be null or in the future");
            if (this.purchaseDate == null) {
                this.purchaseDate = LocalDate.now();
                /*asignar años warranty*/
                setWarrantyEndDate(this.purchaseDate.plusYears(warrantyYears));
            }
            return;
        }
        this.purchaseDate = purchaseDate;
        /*asignar fin warranty*/
        setWarrantyEndDate(purchaseDate.plusYears(warrantyYears));
    }

    private void setWarrantyEndDate(LocalDate warrantyEndDate) {
        /*set final warranty*/
        this.warrantyEndDate = warrantyEndDate;
    }

    public LocalDate getPurchaseDate() {
        /*devolver purchase*/
        return purchaseDate;
    }

    public LocalDate getWarrantyEndDate() {
        /*devolver final warranty*/
        return warrantyEndDate;
    }

    public void setBatteryLife(int batteryLife) {
        /*check (batteryLife) sea superior a 0*/
        if (batteryLife <= 0) {
            System.out.println("[ERROR] Battery life must be greater than 0");
            return;
        }
        this.batteryLife = batteryLife;
    }

    public int getBatteryLife() {

        return batteryLife;
    }

    public int getCurrentBattery() {
        /*devolver batería*/
        return currentBattery;
    }

    public void setCurrentBattery(int currentBattery) {
        /*Debe validar que el parámetro recibido (currentBattery) sea superior o igual a 0 y, además, que no superior al valor máximo de la batería*/
        if (currentBattery < 0 || currentBattery > batteryLife) {
            System.out.println("[ERROR] Current battery must be between 0 and battery life");
            if (this.currentBattery == 0 && batteryLife > 0) this.currentBattery = batteryLife;
            return;
        }
        this.currentBattery = currentBattery;
    }

    private boolean isValidSoftwareVersion(String softwareVersion) {
        /*devuelve true si la versión recibida por parámetro (softwareVersion) no sea null y sea una versión válida.
        * Una versión de software es válida si sigue el siguiente formato:
major   Version.minorVersion.patchVersion*/
        if (softwareVersion == null || !softwareVersion.matches("\\d+\\.\\d+\\.\\d+")) {
            return true;
        }
        for (String validVersion : softwareVersions) {
            if (softwareVersion.startsWith(validVersion + ".")) {
                return false;
            }
        }
        return true;
    }

    public void setSoftwareVersion(String softwareVersion) {
        /*debe validar que el parámetro recibido (softwareVersion) sea una versión válida siguiendo las especificaciones detalladas en el punto anterior*/
        if (isValidSoftwareVersion(softwareVersion)) {
            System.out.println("[ERROR] The software version cannot be null, it must have the format X.X.X and must start with one of the following: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5");
            if (this.softwareVersion == null) this.softwareVersion = "1.0.0";
            return;
        }
        this.softwareVersion = softwareVersion;
    }

    public String getSoftwareVersion() {
        /*devolver versión software*/
        return softwareVersion;
    }

    public void setConnectedByWifi(boolean isConnectedByWifi) {
        this.isConnectedByWifi = isConnectedByWifi;
    }

    public boolean isConnectedByWifi() {
        return isConnectedByWifi;
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
        if (isValidSoftwareVersion(newSoftwareVersion) || !isConnectedByWifi ||
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