package open.bokovuruskhan.ingushlanguagespellcheckingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private ResourceLoader resourceLoader;

    public List<String> readLinesFromFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();

        Resource resource = resourceLoader.getResource("classpath:" + filePath);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }
}
