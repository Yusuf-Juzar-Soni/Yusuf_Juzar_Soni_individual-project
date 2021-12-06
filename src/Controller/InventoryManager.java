package Controller;

import DataModels.Item;
import Database.MockDB;
import FileFactory.ResultHandler;

import java.util.ArrayList;

public class InventoryManager {
    private MockDB database=MockDB.getInstance();
    private ResultHandler file;
    public InventoryManager(String filePath){
        file=new ResultHandler(filePath);
    }
    public void populateDatabase(){
        try{
            file.readFile(true);
        }catch(Exception e){
            System.out.println("Database File Not Found, Kindly verify file path");
            System.exit(0);
        }
        fetchItems(file.getFileContent());
    }
    private void fetchItems(ArrayList<String> fileContent){
        for(String contentLine:fileContent) {
            String[] item = contentLine.split(",");
            database.getItems().put(item[1], new Item( item[0], item[1], Double.parseDouble( item[3] ), Integer.parseInt( item[2] ) ) );
        }

    }
}
