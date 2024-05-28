package com.global.commtech.test.anagramfinder.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
class OutputHandlerTest {
    OutputHandler outputHandler;

    @BeforeEach
    void setUp() {
        outputHandler = new OutputHandler();
    }
    @Test
    void shouldPrintList(final CapturedOutput capturedOutput) {
        Map<String, List<String>> input = new HashMap<>();
        input.put("str1", List.of("str1", "str2"));
        input.put("str3", List.of("str3", "str4"));
        input.put("str5", List.of("str5"));
        input.put("str6", List.of("str6"));
        outputHandler.print(input);

        assertThat(capturedOutput.getOut()).contains("str1,str2");
        assertThat(capturedOutput.getOut()).contains("str3,str4");
        assertThat(capturedOutput.getOut()).contains("str5");
        assertThat(capturedOutput.getOut()).contains("str6");
    }
}