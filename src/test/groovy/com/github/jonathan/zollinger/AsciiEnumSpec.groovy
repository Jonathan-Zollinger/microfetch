package com.github.jonathan.zollinger

import com.github.jonathan.zollinger.model.AsciiEnum
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import static com.diogonunes.jcolor.Ansi.colorize
import static com.diogonunes.jcolor.Attribute.TEXT_COLOR

@MicronautTest
class AsciiEnumSpec extends Specification {

    void "print all enums sans error"() {
        when:
        for(AsciiEnum distro: AsciiEnum.getEnumConstants()){
            System.println(colorize("vvvvvvvvv ${distro.name()} logo below    vvvvvvvvv", TEXT_COLOR(0)))
            System.println(distro)
            System.println(colorize("^^^^^^^^^ ${distro.name()} logo above ^^^^^^^^^", TEXT_COLOR(0)) + "\n\n")
        }
        then:
        noExceptionThrown()
    }

    void "visual test linux distro prints colors"() {
        when:
        System.println("vvvvvvvvv ${distro.name()} logo below    vvvvvvvvv")
        System.println(distro)
        System.println("^^^^^^^^^ ${distro.name()} logo above ^^^^^^^^^")

        then:
        noExceptionThrown()

        where:
        distro                  | _
        AsciiEnum.KALI          | _
        AsciiEnum.WINDOWS_10    | _
        //add distros to test visuals manually here

    }
}
