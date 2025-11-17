package com.github.jonathan.zollinger.model;

import lombok.Getter;
import lombok.Setter;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class Statistics {
    @Setter
    String user, os;
    SystemInfo systemInfo;
    OperatingSystem operatingSystem;
    HardwareAbstractionLayer hardware;
    GlobalMemory memory;
    @Getter
    int totalRam, availableRam, storageSize;

    public Statistics() {
        systemInfo = new SystemInfo();
        operatingSystem = systemInfo.getOperatingSystem();
        hardware = systemInfo.getHardware();
        memory = hardware.getMemory();
        totalRam = Math.toIntExact(memory.getTotal());
        availableRam = Math.toIntExact(memory.getAvailable());
        storageSize = 0;
        hardware.getDiskStores().forEach(disk ->
                storageSize = storageSize + Math.toIntExact(disk.getSize()));
    }


    /**
     * returns the user if it's already been assigned, otherwise queries the user from the system environment variables
     *
     * @return the current username
     */
    public String getUser() {
        if (null == user) {
            user = System.getenv().get("USERNAME");
        }
        return user;
    }

    /**
     * returns the OS if it's already been assigned, otherwise queries the current OS family using the oshi library
     *
     * @return the current OS
     */
    public String getOS() {
        if (null == os) {
            os = operatingSystem.getFamily();
        }
        return os;
    }
}
