package com.global.commtech.test.anagramfinder.utils;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class OutputHandler {
    public void print(Map<String, List<String>> anagramMap) {
        for(String key: anagramMap.keySet())
            System.out.println(concateStrings(anagramMap.get(key)));
    }

    private String concateStrings(List<String> line) {
        if(line.size() == 1)
            return line.get(0);

        StringBuilder output = new StringBuilder();

        for(String word: line)
            output.append(word).append(",");

        return output.toString();
    }
}
