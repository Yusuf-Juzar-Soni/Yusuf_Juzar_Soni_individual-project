package FileFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class ErrorGenerator extends ResultGenerator {
    private ArrayList<String> content;
    @Override
    public void writeToFile(ArrayList<String>errorMessage){
        content=errorMessage;
    }
    @Override
    public void saveFile(Path filePath)throws IOException{
        FileWriter errorFile=new FileWriter(filePath.getParent().toString()+"error_log.txt");
        for(String contentLine:content)
            errorFile.write(contentLine+"\n");
        errorFile.close();
    }


}
