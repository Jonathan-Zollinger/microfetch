package com.github.jonathan.zollinger;

import io.micronaut.configuration.picocli.PicocliRunner;
import jakarta.inject.Inject;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.Map;

@Command(name = "microfetch", description = "...",
        mixinStandardHelpOptions = true)
public class MicrofetchCommand implements Runnable {

    @Inject
    Stats stats;

    public static void main(String[] args) {
        PicocliRunner.run(MicrofetchCommand.class, args);
    }

    public void run() {
        Map<String, String> properties = stats.getPrintOut();
    }


    public static class ManifestVersionProvider implements CommandLine.IVersionProvider {
        public String[] getVersion() {
            return new String[]{MicrofetchCommand.class.getPackage().getImplementationVersion()};
        }
    }
}
