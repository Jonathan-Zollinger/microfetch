package com.github.jonathan.zollinger

import com.github.jonathan.zollinger.model.AsciiEnum
import spock.lang.Specification

class AsciiArtSpec extends Specification {

    void "print all enums sans error"() {
        when:
        for(AsciiEnum distro: AsciiEnum.getEnumConstants()){
            System.println(distro)
        }
        then:
        noExceptionThrown()
    }
}
