package open.bokovuruskhan.ingushlanguagespellcheckingapp.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordsCompareEntry {

    private String sourceWord;

    private ArrayList<String> possibleWords;

}
