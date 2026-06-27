package com.github.jonathan.zollinger.model;

import java.util.Locale;

import static com.github.jonathan.zollinger.model.AsciiEnum.*;
import static java.util.Locale.ENGLISH;

public final class OperatingSystem {

    private OperatingSystem() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /**
     * Detects the operating system family and returns the corresponding ASCII art enum.
     * <p>
     * This method inspects the {@code os.name} system property to determine if the
     * current OS is macOS, Windows, or a Linux-based system (which serves as the default).
     * The returned {@link AsciiEnum} can then be used to display the appropriate ASCII logo.
     *
     * <p><b>Example Usage:</b></p>
     * <pre>{@code
     * AsciiEnum osArt = OperatingSystem.getOsFamily();
     * System.out.println(osArt); // This will print the ASCII art for the detected OS.
     * }</pre>
     *
     * @return The {@link AsciiEnum} corresponding to the detected OS family (e.g., {@code MAC}, {@code WINDOWS}, or {@code LINUX}).
     */
    public static AsciiEnum getOsFamily() {
        final String osName = System.getProperty("os.name").toLowerCase(ENGLISH);
        return switch (osName) {
            case String os when os.startsWith("mac") || os.startsWith("darwin") -> MAC;
            case String os when os.contains("windows") -> WINDOWS;
            default -> LINUX;
        };
    }
}
