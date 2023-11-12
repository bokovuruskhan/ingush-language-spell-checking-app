package open.bokovuruskhan.ingushlanguagespellcheckingapp.service;

import open.bokovuruskhan.ingushlanguagespellcheckingapp.database.model.Word;
import open.bokovuruskhan.ingushlanguagespellcheckingapp.rest.dto.WordsCompareEntry;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpellCheckingService {

    @Autowired
    private WordService wordService;

    public WordsCompareEntry check(String word) {
        int minDistance = Integer.MAX_VALUE;
        Word bestMatch = null;
        for (var wordFromDatabase : wordService.getAll()) {
            int distance = LevenshteinDistance.getDefaultInstance().apply(word, wordFromDatabase.getWord());
            if (distance < minDistance) {
                minDistance = distance;
                bestMatch = wordFromDatabase;
            }
        }
        if (bestMatch != null) {
            WordsCompareEntry wordsCompareEntry = new WordsCompareEntry();
            wordsCompareEntry.setSourceWord(word);
            wordsCompareEntry.setTargetWord(bestMatch.getWord());
            return wordsCompareEntry;
        }
        return null;
    }

}
