package com.global.commtech.test.anagramfinder;

import java.io.File;
import java.io.FileNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.global.commtech.test.anagramfinder.constant.Constants.FILE_NOT_PROVIDED_ERROR;

@Component
@RequiredArgsConstructor
public class AnagramCommandLineRunner implements CommandLineRunner {
    final AnagramHandler anagramHandler;

    @Override
    public void run(final String... args) throws Exception {
        validateArgument(args);

        final File inputFile = new File(args[0]);
        validateFile(inputFile, args[0]);

        anagramHandler.processAnagrams(inputFile);
    }

    private static void validateArgument(String[] args) {
        if(args.length != 1)
            throw new RuntimeException(FILE_NOT_PROVIDED_ERROR);
    }

    private void validateFile(File inputFile, String fileName) throws FileNotFoundException {
        if(!inputFile.exists())
            throw new FileNotFoundException(fileName + " Does not exist");
    }
}
