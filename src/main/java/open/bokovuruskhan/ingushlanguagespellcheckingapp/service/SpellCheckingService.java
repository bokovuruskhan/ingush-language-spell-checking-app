package open.bokovuruskhan.ingushlanguagespellcheckingapp.service;

import open.bokovuruskhan.ingushlanguagespellcheckingapp.config.SpellCheckingConfig;
import open.bokovuruskhan.ingushlanguagespellcheckingapp.rest.dto.WordsCompareEntry;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpellCheckingService {

    @Autowired
    private WordService wordService;

    private static double weightCalculate(String sourceWord, String targetWord) {
        double weight = 0.0;

        char[] sourceWordCharArray = sourceWord.toCharArray();
        char[] targetWordCharArray = targetWord.toCharArray();


        if (sourceWordCharArray[0] == targetWordCharArray[0]) {
            weight += 0.1;
        }
        if (sourceWordCharArray[sourceWordCharArray.length - 1] == targetWordCharArray[targetWordCharArray.length - 1]) {
            weight += 0.1;
        }

        int counter = 0;
        int i = 0, j = 0;

        for (; i < sourceWordCharArray.length && j < targetWord.length(); i++, j++) {
            if (sourceWordCharArray[i] == targetWordCharArray[j]) {
                counter++;
            } else {
                break;
            }
        }

        weight += counter * 0.3;

        counter = 0;
        i = sourceWord.length() - 1;
        j = targetWord.length() - 1;

        for (; i >= 0 && j >= 0; i--, j--) {
            if (sourceWordCharArray[i] == targetWordCharArray[j]) {
                counter++;
            } else {
                break;
            }
        }

        weight += counter * 0.3;

        return weight;
    }

    public WordsCompareEntry check(String word) {
        WordsCompareEntry wordsCompareEntry = new WordsCompareEntry(word);

        for (var wordFromDatabase : wordService.getAll()) {
            int distance = LevenshteinDistance.getDefaultInstance().apply(word, wordFromDatabase.getWord());
            if (distance < SpellCheckingConfig.LEVENSHTEIN_MAX_DISTANCE) {
                wordsCompareEntry.getPossibleWords().put(weightCalculate(word, wordFromDatabase.getWord()), wordFromDatabase.getWord());
            }
        }

        return wordsCompareEntry;
    }

}
