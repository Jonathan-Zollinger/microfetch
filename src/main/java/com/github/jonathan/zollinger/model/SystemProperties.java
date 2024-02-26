package com.github.jonathan.zollinger.model;

import jakarta.inject.Inject;
import oshi.SystemInfo;

import java.util.function.Function;

public abstract class SystemProperties {

    @Inject
    protected SystemInfo systemInfo;

    /**
     * Get name system property.
     *
     * @return String value for system property name
     */
    protected abstract String name();

    /**
     * Get value for this system property.
     *
     * @return String for this system property value.
     */
    protected abstract String Value();

    protected Function<Long, String> readableBytes = bytes -> {
        if (bytes < 1024) return bytes + " B";
        int z = (63 - Long.numberOfLeadingZeros(bytes)) / 10;
        return String.format("%.1f %sB", (double)bytes / (1L << (z * 10)),
                new String[]{"", "KiB", "MiB", "GiB", "TiB", "PiB", "EiB"}[z]);
    };
}
