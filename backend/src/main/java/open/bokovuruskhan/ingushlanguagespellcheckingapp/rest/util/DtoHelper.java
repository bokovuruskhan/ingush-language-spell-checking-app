package open.bokovuruskhan.ingushlanguagespellcheckingapp.rest.util;

import open.bokovuruskhan.ingushlanguagespellcheckingapp.database.model.Word;
import open.bokovuruskhan.ingushlanguagespellcheckingapp.rest.dto.WordDto;

import java.util.List;
import java.util.stream.Collectors;

public class DtoHelper {

    public static WordDto convertWord(Word word) {
        return new WordDto(word.getWord());
    }

    public static Word convertWordDto(WordDto wordDto) {
        Word word = new Word();
        word.setWord(wordDto.getWord());
        return word;
    }

    public static List<Word> convertWordDtoList(List<WordDto> wordDtoList) {
        return wordDtoList.stream()
                .map(DtoHelper::convertWordDto)
                .collect(Collectors.toList());
    }

    public static List<WordDto> convertWordList(List<Word> wordList) {
        return wordList.stream()
                .map(DtoHelper::convertWord)
                .collect(Collectors.toList());
    }

}
