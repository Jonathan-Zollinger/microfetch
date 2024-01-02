package com.github.jonathan.zollinger.cli;

import com.github.jonathan.zollinger.cli.util.AsciiEnumTypeConverter;
import com.github.jonathan.zollinger.cli.util.MicrofetchVersionProvider;
import com.github.jonathan.zollinger.model.AsciiEnum;
import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "microfetch",
        description = "System info tool written with Java, built with graalvm",
        versionProvider = MicrofetchVersionProvider.class)
public class Microfetch implements Runnable {
    @Option(names = {"--distro", "--os"},
            description = "OS or linux distro",
            converter = AsciiEnumTypeConverter.class)
    AsciiEnum distro = AsciiEnum.LINUX;

    public static void main(String[] args) {
        PicocliRunner.run(Microfetch.class, args);
    }

    public void run() {
        System.out.println(distro);
    }
}
