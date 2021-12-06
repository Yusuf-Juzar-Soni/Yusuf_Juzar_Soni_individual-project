package FileFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public  abstract class ResultGenerator {
    abstract void writeToFile(ArrayList<String> content);
    abstract void saveFile (Path path) throws IOException;


}
