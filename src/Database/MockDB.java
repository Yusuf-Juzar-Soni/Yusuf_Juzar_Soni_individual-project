package Database;

import DataModels.Invoice;
import DataModels.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MockDB {
    //Singleton Pattern Implementation.
    private static MockDB instance;
    private HashMap<String, Item> inventory=new HashMap<>();
    private HashSet<String> creditCardList=new HashSet<>();
    private ArrayList<Invoice> orders=new ArrayList<>();
    private MockDB(){}; //Constructor made private
    //Instantiate through static method
    public static MockDB getInstance(){
        if(instance == null)
            instance=new MockDB();
        return instance;
    }
    public HashMap<String, Item> getItems() {
        return inventory;
    }

    public ArrayList<Invoice> getOrders() {
        return orders;
    }

    public HashSet<String> getCreditCards() {
        return creditCardList;
    }
}
