package com.github.jonathan.zollinger

import com.github.jonathan.zollinger.cli.Microfetch
import com.github.jonathan.zollinger.model.AsciiEnum
import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.annotation.Value
import io.micronaut.context.env.Environment
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import oshi.SystemInfo
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

    @Shared
    @AutoCleanup
    ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)

    @Shared
    @Value('${micronaut.application.version}')
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

    def "querying for a linux distro parses from the cli without an error"() {
        given:
        String flag = new Random().nextBoolean() ? "--distro" : "--os"

        when: "using '#flag' flag"
        String[] args = new String[]{flag, (distro as AsciiEnum).name().toLowerCase()}
        PicocliRunner.run(Microfetch, ctx, args)

        then: "no error output and output contains appropriate distro"
        !outputStream.toString().isBlank()
        outputStream.toString().contains(distro.toString())
        errStream.toString().isBlank()

        where:
        distro << AsciiEnum.getEnumConstants()
    }

    def "querying for an invalid or blank distro prints a default linux image"() {
        given:
        String flag = new Random().nextBoolean() ? "--distro" : "--os"

        when: "using '#flag' flag"
        String[] args = new String[]{flag, distro.toLowerCase()}
        PicocliRunner.run(Microfetch, ctx, args)

        then: "no error output and output contains linux distro"
        !outputStream.toString().isBlank()
        outputStream.toString().contains(AsciiEnum.LINUX.toString())
        errStream.toString().isBlank()

        where:
        distro         | _
        ""             | _
        "Randy Newman" | _
    }

    def "default distro is appropriate for this os (whatever this os is)"() {
        given:
        String os = new SystemInfo().operatingSystem.getFamily()

        when: "perform query with no args"
        PicocliRunner.run(Microfetch, ctx, new String[]{})

        then: "no error output"
        errStream.toString().isBlank()

        and: "#os distro art is returned"
        outputStream.toString().contains(
                AsciiEnum.getEnumConstants().find {it.name().equalsIgnoreCase(os)}.toString()
        )

    }
}

