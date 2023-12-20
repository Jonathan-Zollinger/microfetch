package com.github.jonathan.zollinger

import com.github.jonathan.zollinger.model.AsciiEnum
import org.fusesource.jansi.AnsiConsole
import spock.lang.Specification

class AsciiArtSpec extends Specification {

    void setup(){
        AnsiConsole.systemInstall()
    }

    void cleanup(){
        AnsiConsole.systemUninstall()
    }

    void "print all enums sans error"() {
        when:
        for(AsciiEnum distro: AsciiEnum.getEnumConstants()){
            System.println(distro)
        }
        then:
        noExceptionThrown()
    }
}
