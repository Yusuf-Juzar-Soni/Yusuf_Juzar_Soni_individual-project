package FileFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class BillGenerator extends ResultGenerator {
    private ArrayList<String> content=new ArrayList<>();
    @Override
    public void writeToFile(ArrayList<String> orderDetails){
        content=orderDetails;
    }
    @Override
    public void saveFile(Path filePath)throws IOException {
        FileWriter billFile=new FileWriter(filePath.getParent().toString()+"order_log.txt");
        for(String contentLine:content)
            billFile.write(contentLine+"\n");
        billFile.close();
    }

}
