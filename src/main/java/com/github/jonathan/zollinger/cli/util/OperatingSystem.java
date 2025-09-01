package com.github.jonathan.zollinger.cli.util;

import com.github.jonathan.zollinger.model.AsciiEnum;

import java.util.Locale;

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
        final String osName = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
        return switch (osName) {
            case String s when s.startsWith("mac") || s.startsWith("darwin") -> AsciiEnum.MAC;
            case String s when s.contains("windows") -> AsciiEnum.WINDOWS;
            default -> AsciiEnum.LINUX; 
        };
    }
}
