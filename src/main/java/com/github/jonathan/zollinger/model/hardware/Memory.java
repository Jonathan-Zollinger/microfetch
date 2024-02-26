package com.github.jonathan.zollinger.model.hardware;

import com.github.jonathan.zollinger.model.SystemProperties;
import oshi.hardware.GlobalMemory;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Memory extends SystemProperties {

    /**
     * Get name for system property.
     *
     * @return String value for system property name
     */
    public String name() {
        return "Memory";
    }

    /**
     * Get value for this system property.
     *
     * @return String for this system property value.
     */
    @Override
    public String Value() {
        GlobalMemory ram = systemInfo.getHardware().getMemory();
//      example output = "3400MiB / 7750MiB"
        return Arrays.stream(new long[]{
                ram.getTotal() - ram.getAvailable(),
                ram.getTotal()})
                .mapToObj(readableBytes::apply)
                .collect(Collectors.joining(" / "));
    }
}
