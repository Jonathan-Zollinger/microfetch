package com.github.jonathan.zollinger.cli.util;

import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import picocli.CommandLine.IVersionProvider;

@Singleton
public class MicrofetchVersionProvider implements IVersionProvider {

    @Value("${micronaut.application.version}")
    String version;

    public String[] getVersion() {
        if (null == version) {
            version = "not found";
        }
        return new String[]{"Microfetch Version " + version};
    }
}

