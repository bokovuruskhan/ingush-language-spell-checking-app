package open.bokovuruskhan.ingushlanguagespellcheckingapp.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordsCompareEntry {

    private String sourceWord;

    private String targetWord;

}
