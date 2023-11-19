package open.bokovuruskhan.ingushlanguagespellcheckingapp.rest;


import open.bokovuruskhan.ingushlanguagespellcheckingapp.rest.dto.WordDto;
import open.bokovuruskhan.ingushlanguagespellcheckingapp.rest.util.RestUtils;
import open.bokovuruskhan.ingushlanguagespellcheckingapp.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = WordController.PREFIX)
public class WordController {

    public static final String PREFIX = RestUtils.PREFIX + "/word";

    @Autowired
    private WordService wordService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<WordDto>> getAll() {
        return ResponseEntity.ok(wordService.getAll());
    }

    @PostMapping
    public ResponseEntity<WordDto> addWord(@RequestBody WordDto word) {
        return ResponseEntity.ok(wordService.add(word));
    }


}
