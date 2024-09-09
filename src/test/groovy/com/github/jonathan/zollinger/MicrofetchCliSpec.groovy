package com.github.jonathan.zollinger

import com.github.jonathan.zollinger.cli.Microfetch
import com.github.jonathan.zollinger.model.AsciiEnum
import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.annotation.Value
import io.micronaut.context.env.Environment
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class MicrofetchCliSpec extends Specification {
    @Shared
    final PrintStream originalOut = System.out
    @Shared
    final PrintStream originalErr = System.err

    @Shared
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
    ByteArrayOutputStream errStream = new ByteArrayOutputStream()

    @Shared @AutoCleanup
    ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)

    @Shared @Value('${micronaut.application.version}')
    String version = "0.0.1"

    def setup() {
        outputStream.reset()
        errStream.reset()
        System.setOut(new PrintStream(outputStream))
        System.setErr(new PrintStream(errStream))
    }

    def cleanup() {
        System.setOut(originalOut)
        System.setErr(originalErr)
    }

    def "query version without error"() {
        when:
        String[] args = new String[]{versionArg}
        PicocliRunner.run(Microfetch, ctx, args)

        then:
        outputStream.toString() == "[Microfetch Version $version]${System.lineSeparator()}"
        errStream.toString().isEmpty()

        where:
        versionArg  | _
        "--version" | _
        "version"   | _
        "-v"        | _
    }

    def "querying for #distro parses from the cli without an error"() {
        given:
        String flag = new Random().nextBoolean() ? "--distro" : "--os"

        when: "using '#flag #distro' flag"
        String[] args = new String[]{flag, distro}
        PicocliRunner.run(Microfetch, ctx, args)

        then: "no error output and output is not blank"
        !outputStream.toString().isBlank()
        errStream.toString().isBlank()

        where:
        distro << AsciiEnum.getEnumConstants()*.name()*.toLowerCase()
    }
}

