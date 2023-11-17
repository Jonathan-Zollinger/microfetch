package com.github.jonathan_zollinger.jeofetch.utils;

import com.github.jonathan_zollinger.jeofetch.assets.AsciiArtEnum;
import org.fusesource.jansi.AnsiRenderer;
import picocli.CommandLine;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class AsciiUtil {

    static Pattern ANSI_PATTERN = Pattern.compile("\\u001B[^m]*m");
    static Pattern LAST_ANSI_PATTERN = Pattern.compile(ANSI_PATTERN.pattern() + "(?![\\s\\S]*" + ANSI_PATTERN.pattern() + ")");
    static String COLOR_RESET = "[0m";
    private CommandLine.Model.CommandSpec spec;
    String stencil = "@|%s %s|@";
    String propertiesFormatter;

    public void printSnapshot(CommandLine.Model.CommandSpec spec, String[] image, Map<String, String> properties) {
        propertiesFormatter = "%" + getMaxLength(properties.keySet().toArray(new String[0])) + "s";
        this.spec = spec;
        int line = 0;
        while ((image.length - properties.keySet().size()) / 2 > line) {
            spec.commandLine().getOut().println(image[line]);
            line++;
        }
        line = printLayer(line, Collections.singletonMap("hostname", properties.get("hostname")), boldPaint, image);
        line = printLayer(line, properties, image);
        while (image.length > line) {
            spec.commandLine().getOut().println(image[line]);
            line++;
        }

    }

    private int printLayer(int line, Map<String, String> properties, String... image){
        return printLayer(line, properties, sprayPaint, image);
    }

    private int printLayer(int line, Map<String, String> properties, AnsiRenderer.Code[] attributes, String... image) {
        for (String property : properties.keySet()) {
            String imageLine;
            if (line >= image.length) {
                imageLine = String.format("%" + getMaxLength(image) + "s", " ");
            } else {
                imageLine = String.format("%-" + getVisibleLength(getMaxLength(image), image[line]) + "s", image[line]);
            }
            spec.commandLine()
                    .getOut()
                    .println(ansi().render(String.format(stencil, Arrays.stream(attributes)
                            .map(code -> code. )
                            .collect(Collectors.joining(","))), String.format(imageLine +  propertiesFormatter + ": %-1s",
                            property,
                            properties.get(property)))));
            line++;
        }
        return line;
    }

    public void printSnapshot(CommandLine.Model.CommandSpec spec, AsciiArtEnum asciiEnum, Map<String, String> properties) {
        printSnapshot(spec, asciiEnum.artPiece.split("\n"), properties);
    }

    public static String getLastColorCode(String AnsiString) {
        Matcher ansiMatcher = LAST_ANSI_PATTERN.matcher(AnsiString);
        return ansiMatcher.find() ? ansiMatcher.group() : COLOR_RESET;
    }

    public static int getVisibleLength(int maxLengthSansAnsiSequence, String string) {
        Matcher ansiMatcher = ANSI_PATTERN.matcher(string);
        while (ansiMatcher.find()) {
            maxLengthSansAnsiSequence += ansiMatcher.group().length();
        }
        return maxLengthSansAnsiSequence;
    }

    public static int getMaxLength(String[] strings) {
        return Arrays.stream(strings)
                .mapToInt(string -> ANSI_PATTERN
                        .matcher(string)
                        .replaceAll("")
                        .length())
                .max()
                .orElse("hostname".length());
    }
}
