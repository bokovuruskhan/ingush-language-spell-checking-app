package open.bokovuruskhan.ingushlanguagespellcheckingapp.rest;


import open.bokovuruskhan.ingushlanguagespellcheckingapp.rest.dto.WordsCompareEntry;
import open.bokovuruskhan.ingushlanguagespellcheckingapp.rest.util.RestUtils;
import open.bokovuruskhan.ingushlanguagespellcheckingapp.service.SpellCheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = SpellCheckingController.PREFIX)
public class SpellCheckingController {

    public static final String PREFIX = RestUtils.PREFIX + "/spell_checking";

    @Autowired
    private SpellCheckingService spellCheckingService;

    @GetMapping("/")
    public ResponseEntity<WordsCompareEntry> wordSpellChecking(@RequestParam String word) {
        return ResponseEntity.ok(spellCheckingService.check(word));
    }

}
