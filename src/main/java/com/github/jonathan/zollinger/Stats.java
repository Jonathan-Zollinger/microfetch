package com.github.jonathan.zollinger;

import jakarta.inject.Singleton;
import oshi.hardware.GraphicsCard;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

import java.util.Map;
import java.util.stream.Collectors;

@Singleton
public class Stats {
    final OperatingSystem os;
    final HardwareAbstractionLayer hardware;

    public Stats(OperatingSystem os, HardwareAbstractionLayer hardware) {
        this.os = os;
        this.hardware = hardware;
    }

    public Map<String, String> getPrintOut() {
        return Map.of(
                "cpu", getCpu(),
                "gpu", getGpu(),
                "ram", getRam()
        );
    }

    private String getCpu() {
        return hardware.getProcessor().getProcessorIdentifier().getName();
    }

    private String getGpu() {
        return hardware.getGraphicsCards()
                .stream()
                .map(GraphicsCard::getName)
                .collect(Collectors.joining(", "));

    }

    private String getRam() {
        long potential = hardware.getMemory().getTotal();
        long actual = hardware.getMemory().getAvailable();
        return String.format("%s/%s (%.2f%s)",
                bytesToReadableSize(potential - actual).split(" ")[0],
                bytesToReadableSize(potential),
                (((float) 1.00 - ((float) actual / potential)) * 100), "%");

    }

    private String bytesToReadableSize(long bytes) {
        if (bytes < 1024) return bytes + " B";
        int z = (63 - Long.numberOfLeadingZeros(bytes)) / 10;
        return String.format("%.1f %sB", (double) bytes / (1L << (z * 10)), " KMGTPE".charAt(z));
    }

    private String getReadableTime(Long seconds) {
        long hours = seconds / 3600;
        seconds = seconds % 3600;
        long minutes = seconds / 60;
        seconds = seconds % 60;
        return hours + "h " + minutes + "m " + seconds + "s";
    }
}


