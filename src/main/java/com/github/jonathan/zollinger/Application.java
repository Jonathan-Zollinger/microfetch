package com.github.jonathan.zollinger;

import io.micronaut.configuration.picocli.PicocliRunner;
import org.fusesource.jansi.AnsiConsole;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "microfetch", description = "...",
        mixinStandardHelpOptions = true)
public class Application implements Runnable {
    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    @Option(names = {"--distro", "--os"}, description = "OS or linux distro")
    String distro;

    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        PicocliRunner.run(Application.class, args);
        AnsiConsole.systemUninstall();

    }

    public void run() {

    }
}
