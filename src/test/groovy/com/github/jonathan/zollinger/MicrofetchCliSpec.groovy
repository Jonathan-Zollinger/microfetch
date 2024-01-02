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
import spock.lang.Unroll

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

    @Unroll
    def "argument '#distro.toLowerCase()' parses properly as a distro argument"() {
        when:
        distro = distro.toLowerCase()

        String[] args = new String[]{"--distro", distro}
        PicocliRunner.run(Microfetch, ctx, args)

        then:
        !outputStream.toString().isBlank()
        errStream.toString().isBlank()

        where:
        distro                              | _
        AsciiEnum.AIX.name()                | _
        AsciiEnum.ALMA_LINUX.name()         | _
        AsciiEnum.ALPINE.name()             | _
        AsciiEnum.ALPINE_SMALL.name()       | _
        AsciiEnum.ALTER.name()              | _
        AsciiEnum.AMAZON.name()             | _
        AsciiEnum.ANARCHY.name()            | _
        AsciiEnum.ANDROID.name()            | _
        AsciiEnum.ANTERGOS.name()           | _
        AsciiEnum.ANTIX.name()              | _
        AsciiEnum.AOSC_OS.name()            | _
        AsciiEnum.AOSC_OS_RETRO.name()      | _
        AsciiEnum.APERIO_GNU_LINUX.name()   | _
        AsciiEnum.APRICITY.name()           | _
        AsciiEnum.ARCH.name()               | _
        AsciiEnum.ARCH_OLD.name()           | _
        AsciiEnum.ARCH_SMALL.name()         | _
        AsciiEnum.ARCH_BOX.name()           | _
        AsciiEnum.ARCH_CRAFT.name()         | _
        AsciiEnum.ARCH_LABS.name()          | _
        AsciiEnum.ARCH_MERGE.name()         | _
        AsciiEnum.ARCH_STRIKE.name()        | _
        AsciiEnum.CENTOS.name()             | _
        AsciiEnum.CENTOS_SMALL.name()       | _
        AsciiEnum.CUCUMBER.name()           | _
        AsciiEnum.DEBIAN.name()             | _
        AsciiEnum.DEBIAN_SMALL.name()       | _
        AsciiEnum.FEDORA.name()             | _
        AsciiEnum.FEDORA_OLD.name()         | _
        AsciiEnum.FEDORA_SMALL.name()       | _
        AsciiEnum.KALI.name()               | _
        AsciiEnum.KDE.name()                | _
        AsciiEnum.KUBUNTU.name()            | _
        AsciiEnum.LINUX.name()              | _
        AsciiEnum.LINUX_MINT.name()         | _
        AsciiEnum.LINUX_MINT_OLD.name()     | _
        AsciiEnum.LINUXMINT_SMALL.name()    | _
        AsciiEnum.MAC.name()                | _
        AsciiEnum.MAC_SMALL.name()          | _
        AsciiEnum.SUSE.name()               | _
        AsciiEnum.SUSE_LEAP.name()          | _
        AsciiEnum.SUSE_SMALL.name()         | _
        AsciiEnum.SUSE_TUMBLEWEED.name()    | _
        AsciiEnum.ORACLE.name()             | _
        AsciiEnum.POP_OS.name()             | _
        AsciiEnum.RASPBIAN.name()           | _
        AsciiEnum.RASPBIAN_SMALL.name()     | _
        AsciiEnum.REDHAT.name()             | _
        AsciiEnum.REDHAT_OLD.name()         | _
        AsciiEnum.STEAMOS.name()            | _
        AsciiEnum.UBUNTU.name()             | _
        AsciiEnum.UBUNTU_OLD.name()         | _
        AsciiEnum.UBUNTU_SMALL.name()       | _
        AsciiEnum.UBUNTU_STUDIO.name()      | _
        AsciiEnum.UBUNTU_GNOME.name()       | _
        AsciiEnum.WINDOWS.name()            | _
        AsciiEnum.WINDOWS_10.name()         | _
        AsciiEnum.WINDOWS_11.name()         | _

    }
}

