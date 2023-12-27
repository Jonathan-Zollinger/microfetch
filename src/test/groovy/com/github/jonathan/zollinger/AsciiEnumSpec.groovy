package com.github.jonathan.zollinger

import com.github.jonathan.zollinger.model.AsciiEnum
import spock.lang.Specification

class AsciiEnumSpec extends Specification {

    void "print all enums sans error"() {
        when:
        for(AsciiEnum distro: AsciiEnum.getEnumConstants()){
            System.println(distro)
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
        AsciiEnum.ALMA_LINUX    | _
        AsciiEnum.ANTERGOS      | _


    }
}
