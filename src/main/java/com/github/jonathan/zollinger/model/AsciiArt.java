package com.github.jonathan.zollinger.model;

import lombok.Getter;
import org.fusesource.jansi.Ansi.Color;
import picocli.CommandLine;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class AsciiArt {
    private final String art;

    public AsciiArt(AsciiEnum art, Color... colors) {
        if (findColorCount(art) > colors.length) {
            throw new CommandLine.PicocliException(String.format("color scheme provided (%s colors) " +
                            "doesn't match the color count required (%s colors) " +
                            "by the ascii image below:\n%s",
                    colors.length, findColorCount(art), art));
        }
        this.art = String.format(art.distroArt, Arrays.stream(colors).map(String::valueOf).toArray());
    }


    private int findColorCount(AsciiEnum asciiArt) {
        Matcher matcher = Pattern.compile("%(\\d+)\\$s").matcher(asciiArt.toString());
        if (matcher.find()) {
            return Math.max(Integer.parseInt(matcher.group(0)), 1);
        }
        return 1;
    }

    public enum AsciiEnum {
        ALMA_LINUX("""
                @|%1$s         'c:.|@
                @|%1$s        lkkkx, ..       |@%2$s..   ,cc,|@
                @|%1$s        okkkk:ckkx'  |@%2$s.lxkkx.okkkkd|@
                @|%1$s        .:llcokkx'  |@%2$s:kkkxkko:xkkd,|@
                @|%1$s      .xkkkkdood:  |@%2$s;kx,  .lkxlll;|@
                @|%1$s       xkkx.       |@%2$sxk'     xkkkkk:|@
                @|%1$s       'xkx.       |@%2$sxd      .....,.|@
                @|%3$s      .. |@%1$s:xkl'     |@%2$s:c      ..''..|@
                @|%3$s    .dkx'  |@%1$s.:ldl:'. |@%2$s'  |@%4$s':lollldkkxo;|@
                @|%3$s  .''lkkko'                     |@%4$sckkkx.|@
                @|%3$s'xkkkd:kkd.       ..  |@%5$s;'        |@%4$s:kkxo.|@
                @|%3$s,xkkkd;kk'      ,d;    |@%5$sld.   |@%4$s':dkd::cc,|@
                @|%3$s .,,.;xkko'.';lxo.      |@%5$sdx,  |@%4$s:kkk'xkkkkc|@
                @|%3$s     'dkkkkkxo:.        |@%5$s;kx  |@%4$s.kkk:;xkkd.|@
                @|%3$s       .....   |@%5$s.;dk:.   |@%5$slkk.  |@%4$s:;,|@
                @|%5$s             :kkkkkkkdoxkkx|@
                @|%1$s              ,c,,;;;:xkkd.|@
                @|%1$s                ;kkkkl...|@
                @|%1$s                ;kkkkl|@
                @|%1$s                 ,od;|@
                """);
        final String distroArt;
        AsciiEnum(String distroArt){
            this.distroArt = distroArt;
        }
    }
}
