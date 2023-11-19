package com.github.jonathan.zollinger

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import org.fusesource.jansi.Ansi
import spock.lang.Specification

import static org.fusesource.jansi.Ansi.ansi

class ApplicationSpec extends Specification {


    void "test microfetch with command line option"() {
        given:
        ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)
        ByteArrayOutputStream baos = new ByteArrayOutputStream()
        System.setOut(new PrintStream(baos))

        String[] args = ['-v'] as String[]
        PicocliRunner.run(Application, ctx, args)

        expect:
        baos.toString()
    }

    void "test printing colors"() {
        when:
        System.out.println(ansi()
                .fg(Ansi.Color.BLUE).a("I'm a test")
                .fg(Ansi.Color.GREEN).a(" for varying colors"));

        then:
        noExceptionThrown()
    }
}

