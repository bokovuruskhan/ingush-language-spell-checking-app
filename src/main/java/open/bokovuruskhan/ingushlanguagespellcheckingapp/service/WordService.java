package open.bokovuruskhan.ingushlanguagespellcheckingapp.service;

import open.bokovuruskhan.ingushlanguagespellcheckingapp.database.repository.WordRepository;
import open.bokovuruskhan.ingushlanguagespellcheckingapp.rest.dto.WordDto;
import open.bokovuruskhan.ingushlanguagespellcheckingapp.rest.util.DtoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    public List<WordDto> getAll() {
        return DtoHelper.convertWordList(wordRepository.findAll());
    }

    public WordDto add(WordDto wordDto) {
        return DtoHelper.convertWord(wordRepository.save(DtoHelper.convertWordDto(wordDto)));
    }

}
