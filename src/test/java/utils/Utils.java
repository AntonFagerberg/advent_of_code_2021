package utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Utils {

    public static Utils INSTANCE = new Utils();

    public List<String> readFile(String name) {
        try {
            return Files.readAllLines(Paths.get(getClass().getClassLoader().getResource(name).toURI()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }
}
