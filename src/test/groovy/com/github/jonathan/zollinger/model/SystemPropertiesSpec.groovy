package com.github.jonathan.zollinger.model

import io.micronaut.core.annotation.Introspected
import io.micronaut.core.io.ResourceLoader
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import jakarta.inject.Singleton
import org.spockframework.runtime.SpockAssertionError
import spock.lang.Shared
import spock.lang.Specification

import java.util.function.BiFunction
import java.util.stream.Collectors

@MicronautTest
class SystemPropertiesSpec extends Specification {

    @Inject
    @Shared
    ResourceLoader resourceLoader

    @Shared
    Map<Long, String> testData;


    @Inject
    @Shared
    TestSystemProperties systemProperties

    void setupSpec() {

        BiFunction<Object[], Integer, String> mapper = (objects, it) -> {
            (object) -> object[it as String] as String
        }
        testData = Arrays.stream(new String(getResourceFromFile("classpath:bytes-to-readable-test-data")))
                .map(line -> line.split ",")
                .filter { pile -> pile.length == 2 }
                .collect(Collectors
                        .toMap(dump -> Long.valueOf(mapper.apply(dump as Object[], 0)),
                                dump -> mapper.apply(dump as Object[], 1)))
    }


    byte[] getResourceFromFile(String filepath) {
        try {
            return resourceLoader.getResourceAsStream(filepath).get().readAllBytes()
        } catch (IOException e) {
            throw new SpockAssertionError(String.format("failed to load '%s'.", filepath), e)
        }
    }

    def 'test converting #input is converted to \"#value\"'() {
        when:
        String actualValue = systemProperties.readableBytes.apply(input as Long)

        then:
        actualValue.equalsIgnoreCase(value as String)

        where:
        [input, value] << [testData.keySet(), testData.values()]
    }


    @Introspected
    @Singleton
    private class TestSystemProperties extends SystemProperties {
        @Override
        protected String name() { return null }

        @Override
        protected String Value() { return null }
    }
}
