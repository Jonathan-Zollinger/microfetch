package com.github.jonathan.zollinger;

import com.github.jonathan.zollinger.model.AsciiEnum;
import io.micronaut.configuration.picocli.PicocliRunner;
import org.fusesource.jansi.AnsiConsole;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "microfetch", description = "...",
        mixinStandardHelpOptions = true)
public class Application implements Runnable {
    @Option(names = {"--distro", "--os"}, description = "OS or linux distro")
    String distro = "alpine";

    public static void main(String[] args) {
        PicocliRunner.run(Application.class, args);
    }

    public void run() {
        AnsiConsole.systemInstall();
        AsciiEnum.ALPINE.render();
        AnsiConsole.systemUninstall();
    }
}
