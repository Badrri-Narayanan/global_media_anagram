package com.global.commtech.test.anagramfinder;

import com.global.commtech.test.anagramfinder.utils.OutputHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static com.global.commtech.test.anagramfinder.constant.Constants.UNABLE_TO_READ_FILE_ERROR;

@Component
@RequiredArgsConstructor
public class AnagramHandler {
    private final OutputHandler outputHandler;

    public void processAnagrams(File file) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            groupAndPrintAnagrams(bufferedReader);
        } catch (Exception e) {
            System.err.println(UNABLE_TO_READ_FILE_ERROR + e.getMessage());
        }
    }

    void groupAndPrintAnagrams(BufferedReader bufferedReader) throws IOException {
        Map<String, List<String>> anagramMap = new HashMap<>();

        int previousWordLength = 0;
        String currentWord;

        while ((currentWord = bufferedReader.readLine()) != null) {
            int currentWordLength = currentWord.length();
            String sortedCurrentWord = sortByCharacter(currentWord);

            if(currentWordLength != previousWordLength) {
                outputHandler.print(anagramMap);
                anagramMap = new HashMap<>();
                previousWordLength = currentWordLength;
            }

            addCurrentWordToAnagramMap(currentWord, anagramMap, sortedCurrentWord);
        }
        outputHandler.print(anagramMap);
    }

    private String sortByCharacter(String currentWord) {
        char[] characters = currentWord.toCharArray();
        Arrays.sort(characters);
        return new String(characters);
    }

    private void addCurrentWordToAnagramMap(String currentWord, Map<String, List<String>> anagramMap, String sortedCurrentWord) {
        List<String> values = anagramMap.containsKey(sortedCurrentWord)
                                ? anagramMap.get(sortedCurrentWord)
                                : new ArrayList<>();
        values.add(currentWord);
        anagramMap.put(sortedCurrentWord, values);
    }
}

