package open.bokovuruskhan.ingushlanguagespellcheckingapp.rest;


import open.bokovuruskhan.ingushlanguagespellcheckingapp.rest.util.RestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ProcessingController.PREFIX)
public class ProcessingController {

    public static final String PREFIX = RestUtils.PREFIX + "/processing";

}
