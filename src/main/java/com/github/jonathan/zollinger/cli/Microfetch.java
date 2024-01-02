package com.github.jonathan.zollinger.cli;

import com.github.jonathan.zollinger.cli.util.AsciiEnumTypeConverter;
import com.github.jonathan.zollinger.cli.util.MicrofetchVersionProvider;
import com.github.jonathan.zollinger.model.AsciiEnum;
import io.micronaut.configuration.picocli.PicocliRunner;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.Arrays;

@Command(name = "microfetch",
        description = "System info tool written with Java, built with graalvm")
public class Microfetch implements Runnable {
    @Inject
    MicrofetchVersionProvider versionProvider;
    @Option(names = {"--distro", "--os"},
            description = "OS or linux distro",
            converter = AsciiEnumTypeConverter.class)
    AsciiEnum distro = AsciiEnum.LINUX;

    @Option(names = {"version", "--version", "-v"})
    boolean version = false;

    public static void main(String[] args) {
        PicocliRunner.run(Microfetch.class, args);
    }

    public void run() {
        if (version) {
            System.out.println(Arrays.toString(versionProvider.getVersion()));
        }else {
            System.out.println(distro);
        }
    }
}
