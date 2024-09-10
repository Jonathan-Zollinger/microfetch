package com.github.jonathan.zollinger

import com.github.jonathan.zollinger.cli.Microfetch
import com.github.jonathan.zollinger.model.AsciiEnum
import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.annotation.Value
import io.micronaut.context.env.Environment
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import oshi.SystemInfo
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class MicrofetchCliSpec extends Specification {

    @Shared
    @Value('${micronaut.application.version}')
    String version = "0.0.1"

    def "query version without error"() {
        when:
        String[] args = new String[]{versionArg}
        def (outputStream, errStream) = executeCommand(args)

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
        def (outputStream, errStream) = executeCommand(args)

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
        def (outputStream, errStream) = executeCommand(args)

        then: "no error output and output contains linux distro"
        !outputStream.toString().isBlank()
        !outputStream.toString().contains("Exception")
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
        def (outputStream, errStream) = executeCommand("")

        then: "no error output"
        errStream.toString().isBlank()
        def expectedDistroArt = AsciiEnum.getEnumConstants().find {os}.toString()

        and: "#os distro art is returned"
        outputStream.toString().contains(expectedDistroArt)

    }

    /**
     * Execute a command with the given arguments and return a pair of streams as stdout and stderr.
     *
     * This method captures the stdout and stderr, runs the command using the PicocliRunner,
     * and then returns the output streams.
     *
     * @param args the arguments to pass to the command
     * @return an array containing the output stream and error stream
     */
    String[] executeCommand(String... args) {
        OutputStream out = new ByteArrayOutputStream()
        OutputStream err = new ByteArrayOutputStream()
        System.setOut(new PrintStream(out))
        System.setErr(new PrintStream(out))
        try (ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)) {
            PicocliRunner.run(Microfetch.class, ctx, args)
        }
        return new String[]{out, err}
    }
}

