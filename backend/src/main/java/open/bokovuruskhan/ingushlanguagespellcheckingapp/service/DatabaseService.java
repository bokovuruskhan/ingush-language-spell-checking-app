package open.bokovuruskhan.ingushlanguagespellcheckingapp.service;

import jakarta.annotation.PostConstruct;
import open.bokovuruskhan.ingushlanguagespellcheckingapp.database.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DatabaseService {

    private final static String dictionaryFileName = "ingush.dictionary";

    @Autowired
    private FileService fileService;
    @Autowired
    private WordService wordService;

    @PostConstruct
    public void initDatabaseFromDictionary() throws IOException {
        for (var line : fileService.readLinesFromFile(dictionaryFileName)) {
            Word word = new Word();
            word.setWord(line);
            wordService.add(word);
        }
    }

}
