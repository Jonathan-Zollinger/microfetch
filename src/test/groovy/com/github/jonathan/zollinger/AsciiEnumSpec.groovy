package com.github.jonathan.zollinger

import com.github.jonathan.zollinger.model.AsciiEnum
import spock.lang.Specification

import static com.diogonunes.jcolor.Ansi.colorize
import static com.diogonunes.jcolor.Attribute.TEXT_COLOR

class AsciiEnumSpec extends Specification {

    void "print all enums sans error"() {
        when:
        for(AsciiEnum distro: AsciiEnum.getEnumConstants()){
            System.println(colorize("vvvvvvvvv new ascii image below    vvvvvvvvv", TEXT_COLOR(0)))
            System.println(distro)
            System.println(colorize("^^^^^^^^^ finish above ascii image ^^^^^^^^^", TEXT_COLOR(0)))
        }
        then:
        noExceptionThrown()
    }

    void "visual test linux distro prints colors"() {
        when:
        System.println("vvvvvvvvv new ascii image below    vvvvvvvvv")
        System.println(distro)
        System.println("^^^^^^^^^ finish above ascii image ^^^^^^^^^")

        then:
        noExceptionThrown()

        where:
        distro                  | _
        AsciiEnum.KALI          | _
        AsciiEnum.WINDOWS_10    | _

    }
}
