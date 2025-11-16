package com.github.jonathan.zollinger

import com.github.jonathan.zollinger.cli.Microfetch
import com.github.jonathan.zollinger.model.AsciiEnum
import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import oshi.SystemInfo
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class MicrofetchCliSpec extends Specification {

    @Shared
    def gradleProperties = new Properties()

    @Shared
    String microfetchVersion

    def setupSpec() {
        new File('gradle.properties').withInputStream { stream ->
            gradleProperties.load(stream)
        }
        microfetchVersion = gradleProperties.getProperty('microfetchVersion')
    }

    def "query version without error"() {
        when:
        String[] args = new String[]{"microfetch", versionArg}
        def (outputStream, errStream) = executeCommand(args)

        then:
        verifyAll {
            outputStream.toString() == "Microfetch Version $microfetchVersion${System.lineSeparator()}"
            errStream.toString().isEmpty()
        }

        where:
        versionArg  | _
        "--version" | _
        "-V"        | _
    }

    def "querying for a linux distro parses from the cli without an error"() {
        when:
        String[] args = new String[]{(distro as AsciiEnum).name().toLowerCase()}
        def (outputStream, errStream) = executeCommand(args)

        then: "no error output and output contains appropriate distro"
        verifyAll {
            !outputStream.toString().isBlank()
            outputStream.toString().contains(distro.toString())
            errStream.toString().isBlank()
        }

        where:
        distro << AsciiEnum.getEnumConstants()
    }

    def "querying for an invalid or blank distro prints a default linux image"() {
        given:
        String[] args = new String[]{ distro.toLowerCase() }
        String osFamily = new SystemInfo().operatingSystem.getFamily()
        def osMap = [
                windows: AsciiEnum.WINDOWS,
                macos  : AsciiEnum.MAC
        ].withDefault { AsciiEnum.LINUX }

        when:
        def (outputStream, errStream) = executeCommand(args)

        then: "no error output and standard output is appropriate distro for this os (whatever this os is)"
        verifyAll {
            !outputStream.toString().isBlank()
            !outputStream.toString().contains("Exception")
            outputStream.toString().contains(osMap[osFamily.toLowerCase()].toString())
            errStream.toString().isBlank()
        }
        where:
        distro         | _
        ""             | _
        "Randy Newman" | _
    }

    /**
     * Execute a command with the given arguments and return a pair of streams as stdout and stderr.
     *
     * This requires that the command be included in the args, ie "microfetch", as well as "windows"
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
        System.setErr(new PrintStream(err))
        try (ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)) {
            PicocliRunner.run(Microfetch.class, ctx, args)
        }
        return new String[]{out, err}
    }
}
