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

    public WordsCompareEntry check(String word) {
        WordsCompareEntry wordsCompareEntry = new WordsCompareEntry();
        wordsCompareEntry.setSourceWord(word);

        for (var wordFromDatabase : wordService.getAll()) {
            int distance = LevenshteinDistance.getDefaultInstance().apply(word, wordFromDatabase.getWord());
            if (distance < SpellCheckingConfig.LEVENSHTEIN_MAX_DISTANCE) {
                wordsCompareEntry.getPossibleWords().add(wordFromDatabase.getWord());
            }
        }

        return wordsCompareEntry;
    }

}
