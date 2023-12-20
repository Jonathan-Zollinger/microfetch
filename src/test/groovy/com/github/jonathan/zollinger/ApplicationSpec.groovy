package com.github.jonathan.zollinger


import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class ApplicationSpec extends Specification {

    @Shared @AutoCleanup
    ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)

    void "test microfetch with command line option"() {
        given:
        ByteArrayOutputStream baos = new ByteArrayOutputStream()
        System.setOut(new PrintStream(baos))

        String[] args = "--distro alpine".split(" ")
        PicocliRunner.run(Application, ctx, args)

        expect:
        baos.toString()
    }
}

