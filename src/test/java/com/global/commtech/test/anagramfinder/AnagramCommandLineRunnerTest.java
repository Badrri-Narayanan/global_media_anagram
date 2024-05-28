package com.global.commtech.test.anagramfinder;

import static com.global.commtech.test.anagramfinder.constant.Constants.FILE_NOT_PROVIDED_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.system.OutputCaptureExtension;

@ExtendWith(MockitoExtension.class)
@ExtendWith(OutputCaptureExtension.class)
class AnagramCommandLineRunnerTest {

    @InjectMocks
    AnagramCommandLineRunner anagramCommandLineRunner;

    @Test
    void shouldThrowExceptionWhenNoArgumentsPresent() {
        final var exception = assertThrows(Exception.class, () -> anagramCommandLineRunner.run());
        assertThat(exception.getMessage()).isEqualTo(FILE_NOT_PROVIDED_ERROR);
    }

    @Test
    void shouldThrowExceptionWhenMoreThanOneArgumentIsPassed() {
        final var exception = assertThrows(Exception.class, () -> anagramCommandLineRunner.run("one", "two"));
        assertThat(exception.getMessage()).isEqualTo(FILE_NOT_PROVIDED_ERROR);
    }

    @Test
    void shouldThrowExceptionWhenInputFileDoesNotExist() {
        final var exception = assertThrows(Exception.class, () -> anagramCommandLineRunner.run("notExists"));
        assertThat(exception.getMessage()).isEqualTo("notExists Does not exist");
    }
}