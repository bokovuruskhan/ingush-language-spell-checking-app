package open.bokovuruskhan.ingushlanguagespellcheckingapp.service;

import open.bokovuruskhan.ingushlanguagespellcheckingapp.database.model.Word;
import open.bokovuruskhan.ingushlanguagespellcheckingapp.database.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    public List<Word> getAll() {
        return wordRepository.findAll();
    }

    public Word add(Word word) {
        return wordRepository.save(word);
    }

}
