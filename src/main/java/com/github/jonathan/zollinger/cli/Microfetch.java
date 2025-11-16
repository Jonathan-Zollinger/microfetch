package com.github.jonathan.zollinger.cli;

import com.github.jonathan.zollinger.cli.util.MicrofetchVersionProvider;
import com.github.jonathan.zollinger.model.AsciiEnum;
import com.github.jonathan.zollinger.model.OperatingSystem;
import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;
import picocli.CommandLine.ITypeConverter;
import picocli.CommandLine.Parameters;

import java.util.Arrays;

@Command(name = "microfetch",
        description = "System info tool written with Java, built with graalvm",
        mixinStandardHelpOptions = true,
        versionProvider = MicrofetchVersionProvider.class)
public class Microfetch implements Runnable {

    @Parameters(index = "0", arity = "0..1",
            description = "OS or linux distro",
            converter = AsciiEnumTypeConverter.class)
    AsciiEnum distro;

    public static void main(String[] args) {
        PicocliRunner.run(Microfetch.class, args);
    }

    @Override
    public void run() {
        System.out.println(distro);
    }


    /**
     * Converts string to ascii enum object. If no match is found, default to linux
     */
    static class AsciiEnumTypeConverter implements ITypeConverter<AsciiEnum> {
        @Override
        public AsciiEnum convert(String string) {
            return Arrays.stream(AsciiEnum.values())
                    .filter(thistro -> thistro.name().equalsIgnoreCase(string))
                    .findFirst()
                    .orElse(OperatingSystem.getOsFamily());
        }
    }
}
