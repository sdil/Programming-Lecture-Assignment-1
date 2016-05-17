
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MohamadFadhil
 */
public class Start {
    
    public static void main(String[] args){
//        System.out.println("Starts now....");
//        Item item = new Item();
//        item.normalize();
//        //Bill bill = new Bill();
//        //Order order = new Order();
//        //Report report = new Report();
//        //item.readFile();
//        //System.out.println(item.readFile());
        Scanner in = new Scanner(System.in);
//      
//        System.out.println("Can i help you, sir?:");
//        System.out.println("You may:");
//        System.out.println("Order new food: Order");
//        System.out.println("See your bill: Bill");
//        System.out.println("Access to admin area: Admin");
//        System.out.println("To exit, type 'Quit'");
//        
//        System.out.print("What's now? ");
        String operation;
//        
//        int order_no=0;
//        
//        //ada 2 operation: order & bill
//        //satu option untuk ke admin
//        while(!operation.equalsIgnoreCase("Quit"))
//        {if (operation.equalsIgnoreCase("Order"))
//        {
//            System.out.println("Please take your order");
//            item.getItems();
//            //printout menu first
//            //order.takeOrder();
//            //print receipt
//            order_no++;
//            
//        }
//        
//        else if (operation.equalsIgnoreCase("Bill"))
//        {
//            System.out.println("Calculating your bill:");
//            // bill.toString
//            
//        }
//        else if (operation.equalsIgnoreCase("Admin"))
//        {
//            System.out.println("Accessing admin area");
//            System.out.println("Please authenticate yourself first");
//            String password = in.nextLine();
//            if(password.equals("dr aznul"))
//            {
//                System.out.println("You're authenticated");
//                System.out.print("What's now? ");
//                operation = in.nextLine();
//                
//                if (operation.equalsIgnoreCase("Item"))
//                {System.out.println("You can:");
//                System.out.println("Add Item");
//                System.out.println("Delete Existing Item");
//                System.out.println("Modify Existing Item");
//                operation = in.nextLine();
//                if(operation.equalsIgnoreCase("add item"));
//                {
//                    String additem1 = in.nextLine();
//                    String additem2 = in.nextLine();
//                    String additem3 = in.nextLine();
//                    item.addItem(additem1,additem2,additem3);
//                }
//                if(operation.equalsIgnoreCase("delete item")){
//                    item.getItems();
//                    //delete the item of the 
//                    }
//                }
//                
//            }
//            else{
//                System.out.println("You're not the admin");
//                
//            }
//        }
//        
//        else{
//                    System.out.println("Operation is invalid");
//        }
//        
//            System.out.println("What's next?");
//        operation = in.nextLine();
//        
//        }
        
        Item item = new Item();
        //System.out.println(item.readFile());
        //System.out.println(item.line_no);
        //item.addItem("ikan bilis", "5.90", "10.00");
        //System.out.println(item.readFile());
//        System.out.println(item.readFile());
//        System.out.println(item.line_no);
        
        item.getItems();
//        item.deleteItem("kek");
//        item.getItems();
        //System.out.println("");
        //item.getItems();
        //item.deleteItem("teh");
//        System.out.println("");
//        item.getItems();
        
//        item.modifyItem("Timun Bakar");
           //item.getItems();
        
          Order order = new Order();
          //order.addFirstOrder();
          //order.finishOrder();
          //order.getMenu();
          //order.normalizeOrder();
          //order.getOrdered();
          
          //item.addItem();
          //item.getItems();
          //order.addFirstOrder();
          //System.out.println("Do you wish to add more orders?");
          //operation= in.nextLine();
//          do
//          {
//              System.out.println("Do you wish to add more orders?");
//              operation= in.nextLine();
//              if(operation.equalsIgnoreCase("yes")){
//              order.addOrder();}
//              else{
//                break;
//              }
//          }while(operation.equalsIgnoreCase("Yes"));
//          order.finishOrder();
//          order.getOrdered();
          item.getItems();
          //System.out.println("You've ordered these:");
          //order.getOrdered();
//        String operation;
//        operation = in.nextLine();
//        while(!operation.equalsIgnoreCase("done")){
//        order.addOrder();
//        operation = in.nextLine();
//        }
        //order.finishOrder();
        //order.getOrdered();
          
          Bill bill = new Bill();
          //bill.calcBill();
          bill.displayBill();
          //System.out.printf("%.2f\n",bill.pay(400));
    }
    
}
