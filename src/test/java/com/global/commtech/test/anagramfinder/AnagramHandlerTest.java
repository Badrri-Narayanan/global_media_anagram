package com.global.commtech.test.anagramfinder;

import com.global.commtech.test.anagramfinder.utils.OutputHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
class AnagramHandlerTest {
    AnagramHandler anagramHandler;

    @BeforeEach
    void setUp() {
        anagramHandler = new AnagramHandler(new OutputHandler());
    }

    @Test
    void shouldGroupAnagram1(final CapturedOutput capturedOutput) {
        File file = new File("src/test/resources/example1.txt");

        anagramHandler.processAnagrams(file);
        assertThat(capturedOutput.getOut()).contains("abc,bac,cba");
        assertThat(capturedOutput.getOut()).contains("fun,unf");
        assertThat(capturedOutput.getOut()).contains("hello");
    }

    @Test
    void shouldGroupAnagram2(final CapturedOutput capturedOutput) {
        File file = new File("src/test/resources/example3.txt");

        anagramHandler.processAnagrams(file);
        assertThat(capturedOutput.getOut()).contains("abc,bac,cba");
        assertThat(capturedOutput.getOut()).contains("fun,unf");
        assertThat(capturedOutput.getOut()).contains("hello");
        assertThat(capturedOutput.getOut()).contains("world");
        assertThat(capturedOutput.getOut()).contains("silent,listen");
    }

    @Test
    void shouldGroupAnagram3(final CapturedOutput capturedOutput) {
        File file = new File("src/test/resources/example4.txt");

        anagramHandler.processAnagrams(file);
        assertThat(capturedOutput.getOut()).contains("listen,silent");
        assertThat(capturedOutput.getOut()).contains("mountain");
        assertThat(capturedOutput.getOut()).contains("terrain");
        assertThat(capturedOutput.getOut()).contains("acres,scare");
        assertThat(capturedOutput.getOut()).contains("estate");
        assertThat(capturedOutput.getOut()).contains("taste");
    }
}