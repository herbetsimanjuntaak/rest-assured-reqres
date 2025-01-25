package helper;

import java.io.File;

public class Utils {

    public static File getJSONFile(String JSONFile) {
        return new File("src/test/resources/JSON/Schema/" + JSONFile);
    }
}
