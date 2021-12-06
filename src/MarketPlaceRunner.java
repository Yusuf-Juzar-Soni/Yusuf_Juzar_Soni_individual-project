import Controller.InventoryManager;
import Controller.OrderManager;


import java.io.IOException;
import java.util.Scanner;

public class MarketPlaceRunner {
    public static void main(String args[])throws IOException{
        MarketPlaceRunner runner=new MarketPlaceRunner();
        runner.beginProcessing(args);
    }
    private void beginProcessing(String[] args){
        if(args.length==0){
            System.out.println("Please load database file to begin demonstration");
            System.exit(0);
        }
        StringBuilder stringBuilder=new StringBuilder();
        for( String arg : args ) {

            if( !(stringBuilder.length()==0) ) stringBuilder.append(" ");

            stringBuilder.append(arg);

        }
        InventoryManager inventoryManager=new InventoryManager(stringBuilder.toString() );
        inventoryManager.populateDatabase();
        while(true){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the order file to begin transaction, otherwise press Ctrl+C to exit");
            String inputFilePath="";
            try{
                inputFilePath=sc.next();
            }catch(Exception e){
                e.printStackTrace();
            }
            if(inputFilePath.equals(""))
                break;
            beginNewTransaction(inputFilePath);
        }
        System.out.println("Demonstration end. Thank You");
    }
    private void beginNewTransaction(String filePath){
        OrderManager orderManager=new OrderManager(filePath);
        if(orderManager.initiateOrder()){
            System.out.println("Order Initiated Successfully!");
            if(orderManager.validateOrder()) {
                System.out.println("Items checked for quantity in stock and item cap");
                orderManager.calculateFinalAmount();
                System.out.println("Final amount calculated !");
                orderManager.checkoutOrder();
                System.out.println("Congratulations!! Order Processed Successfully!!");

            }else{
                    System.out.println("Oops!! An error has occured. Kindly check error logs");
                    orderManager.generateResultFile();
                }
            }
            else{
                System.out.println("Order file not found, Kindly enter correct file path");
            }
        }

    }




