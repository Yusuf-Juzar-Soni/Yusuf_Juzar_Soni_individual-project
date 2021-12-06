package Controller;

import DataModels.Invoice;
import DataModels.InvoiceItems;
import DataModels.Item;
import Database.MockDB;
import FileFactory.ResultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class OrderManager {
    private MockDB database=MockDB.getInstance();
    private ResultHandler file;
    private ArrayList<String> outputMessage=new ArrayList<>();
    private HashSet<String> creditCards=new HashSet<>();
    private ArrayList<InvoiceItems> itemList=new ArrayList<>();
    private Invoice currentInvoice=new Invoice();
    private double totalAmount=0;
    public OrderManager(String filePath){
        file=new ResultHandler(filePath);
    }
    public boolean initiateOrder(){
        try{
            file.readFile(true);
        }catch(Exception e){
            return false;
        }
        getItems(file.getFileContent());
        return true;
    }
    public boolean validateOrder(){
        checkItemQuantity();
        checkItemCap();
        return outputMessage.isEmpty();
    }
    public void calculateFinalAmount(){
        itemList.forEach((item)->{
            totalAmount+= item.getItemQuantity()* item.getPrice();
        });
        currentInvoice.setTotalPrice(totalAmount);
    }



    public void checkoutOrder(){
        database.getOrders().add(currentInvoice);
        for(InvoiceItems currentItem:itemList){
            Item item=database.getItems().get(currentItem.getInvoiceItemName());
            item.setQuantityInInventory(item.getQuantityInInventory()-currentItem.getItemQuantity());

        }
        for(String creditCard:creditCards){
            if(!database.getCreditCards().contains(creditCard)){
                database.getCreditCards().add(creditCard);
            }
        }
        for(String card:creditCards){
            System.out.println("Credit cards in DB are as follows");
            System.out.println(card);
        }
        generateResultFile();
    }

    private void getItems(ArrayList<String> fileContent){
        for(String contentLine:fileContent) {
            String[] item = contentLine.split(",");
            if (database.getItems().containsKey(item[0])) {
                itemList.add(new InvoiceItems(item[0], Integer.parseInt(item[1]), item[2].replaceAll("\\s+", "")));
            } else {
                outputMessage.add("Item" + item[0] + "not present in inventory");
            }

        }
        if(!outputMessage.isEmpty()){
            itemList.clear();
        }
    }
    private boolean checkItemQuantity(){
        StringBuilder message=new StringBuilder();
        for(InvoiceItems currentItem:itemList){
            Item item=database.getItems().get(currentItem.getInvoiceItemName());
            if(item.getQuantityInInventory()<currentItem.getItemQuantity()){
                if(message.length()>0)
                    message.append(",");
                message.append("OrderItem "+currentItem.getInvoiceItemName()+"is not present in sufficient quantity in inventory");
            }
            else{
                currentItem.setPrice(item.getItemPrice());
                if(!creditCards.contains(currentItem.getCreditCardInfo()))
                    creditCards.add(currentItem.getCreditCardInfo());
            }
        }
        if(message.length()>0){
            outputMessage.add("Please Add appropriate quantities.");
            outputMessage.add(message.toString());
        }

        return (message.length()==0);



    }
    private boolean checkItemCap(){
        final int luxCap = 3;
        final int essCap = 5;
        final int miscCap = 6;
        HashMap<String,Integer> map = new HashMap<>();
        MockDB database = MockDB.getInstance();
        for(InvoiceItems orderItem:itemList){
            map.put(database.getItems().get(orderItem.getInvoiceItemName()).getCategory(),map.getOrDefault(database.getItems().get(orderItem.getInvoiceItemName()).getCategory(),0)+orderItem.getItemQuantity());
        }

        if(map.getOrDefault("Luxury",0)>luxCap){
            outputMessage.add(" Luxury ItemCap is being violated");
            return false;
        }

        else if(map.getOrDefault("Essential",0)>essCap){
            outputMessage.add(" Essential ItemCap is being violated");
            return false;
        }

        else if(map.getOrDefault("Misc",0)>miscCap){
            outputMessage.add(" Misc ItemCap is being violated");
            return false;
        }

        return true;
    }

    public void generateResultFile(){
        if(outputMessage.isEmpty()){
            outputMessage.add("Payment Successful !!");
            outputMessage.add("Amount Paid:="+ Double.toString(currentInvoice.getTotalPrice()));
            try{
                file.writeResults(outputMessage,false);
            }catch(Exception e){
               e.printStackTrace();
            }


        }else{
            try{
                file.writeResults(outputMessage,true);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }



}
