package com.github.jonathan.zollinger.cli;

import com.github.jonathan.zollinger.cli.util.MicrofetchVersionProvider;
import com.github.jonathan.zollinger.model.AsciiEnum;
import io.micronaut.configuration.picocli.PicocliRunner;
import jakarta.inject.Inject;
import oshi.SystemInfo;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.Arrays;
import java.util.Objects;

@Command(name = "microfetch",
        description = "System info tool written with Java, built with graalvm")
public class Microfetch implements Runnable {
    @Inject
    MicrofetchVersionProvider versionProvider;
    @Option(names = {"--distro", "--os"},
            description = "OS or linux distro",
            converter = AsciiEnumTypeConverter.class)
    AsciiEnum distro;

    @Option(names = {"version", "--version", "-v"})
    boolean version = false;

    public static void main(String[] args) {
        PicocliRunner.run(Microfetch.class, args);
    }

    public void run() {
        if (version) {
            System.out.println(Arrays.toString(versionProvider.getVersion()));
        } else System.out.println(Objects.requireNonNullElseGet(distro, () -> Arrays.stream(AsciiEnum.values())
                .filter(thistro -> thistro.name().equalsIgnoreCase(
                        new SystemInfo().getOperatingSystem().getFamily()))
                .findFirst()
                .orElse(AsciiEnum.LINUX)));
    }

    /**
     * Converts string to ascii enum object. If no match is found, default to linux
     */
    static class AsciiEnumTypeConverter implements CommandLine.ITypeConverter<AsciiEnum> {
        @Override
        public AsciiEnum convert(String string) {
            return Arrays.stream(AsciiEnum.values())
                    .filter(thistro -> thistro.name().equalsIgnoreCase(string))
                    .findFirst()
                    .orElse(AsciiEnum.LINUX);
        }
    }
}
