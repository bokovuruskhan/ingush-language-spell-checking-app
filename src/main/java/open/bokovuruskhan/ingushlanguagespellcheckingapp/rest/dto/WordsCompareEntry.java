package open.bokovuruskhan.ingushlanguagespellcheckingapp.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.TreeMap;

@Data
@AllArgsConstructor
public class WordsCompareEntry {

    private String sourceWord;

    private TreeMap<Double, String> possibleWords;

    public WordsCompareEntry(String sourceWord) {
        this.sourceWord = sourceWord;
        this.possibleWords = new TreeMap<>();
    }
}
