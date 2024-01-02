package com.github.jonathan.zollinger.cli.util;

import com.github.jonathan.zollinger.model.AsciiEnum;
import com.google.common.base.Enums;
import com.google.common.base.Optional;
import picocli.CommandLine;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AsciiEnumTypeConverter implements CommandLine.ITypeConverter<AsciiEnum> {

    @Override
    public AsciiEnum convert(String s) {
        Optional<AsciiEnum> distro = Enums.getIfPresent(AsciiEnum.class, s.toUpperCase())
                .or(Enums.getIfPresent(AsciiEnum.class, s));
        if (!distro.isPresent()) {
            throw new CommandLine.TypeConversionException(
                    String.format("Invalid option: '%s'", s) +
                            String.format("Valid options are: %s", Arrays.stream(AsciiEnum.class
                                            .getEnumConstants())
                                    .map(Enum::name).collect(Collectors.joining(", "))
                            ));
        }
        return distro.get();
    }
}
