
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
        Scanner keyboard = new Scanner(System.in);
        Bill bill = new Bill();
        Item item = new Item();
        Order order = new Order();
        Report report = new Report();
        LabourAssignment labour = new LabourAssignment();
        
        System.out.println("        .::FAFAFA GARDEN::.");
        System.out.println("The best food available on planet Earth");
        System.out.println("");
        System.out.println("Welcome to our hanging garden.");
        System.out.println("How can I help you?");
        System.out.println("[ORDER] [BILL] [ADMIN ACCESS] [QUIT]");
        //order.normalizeOrder();
        //report.getAll();
        
//        System.out.println(order.name[1]);
        
        String operation =null;
        do{
        Scanner keyboard2 = new Scanner(System.in);
        operation = keyboard2.nextLine();
        if(operation.equalsIgnoreCase("Order")){
            order.startOrder();
        }else if(operation.equalsIgnoreCase("Bill")){
                bill.payment();
        }
        else if(operation.equalsIgnoreCase("Admin access")){
            Scanner keyboard3 = new Scanner(System.in);
            System.out.println("Please enter the password: (Hint: your lecturer's name)");
            String password = keyboard3.nextLine();
            if(password.equalsIgnoreCase("dr aznul")){
                System.out.println("Welcome to Admin Access");
                System.out.println("Please choose next action:");
                System.out.println("[ITEM] [LABOUR] [REPORTING]");
                    operation = keyboard.nextLine();
                    if(operation.equalsIgnoreCase("item")){
                        item.start();
                    }
                    else if(operation.equalsIgnoreCase("labour")){
                        labour.start();
                    }
                    else if(operation.equalsIgnoreCase("reporting")){
                        report.getAll();
                    }
                    else{
                        System.out.println("Invalid ");
                    }
        }
        else if(operation.equalsIgnoreCase("quit")){
            System.out.println("Thank you for coming. Please come again");
        }
        else{
        System.out.println("The keyword entered is invalid");
        }
        }
              System.out.println("[ORDER] [BILL] [ADMIN ACCESS] [QUIT]");
        }while(!operation.equalsIgnoreCase("quit"));
            
        
    
    
}
}
