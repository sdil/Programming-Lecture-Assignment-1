
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MohamadFadhil
 */
public class Bill extends Order {
    
    
    LabourAssignment labour = new LabourAssignment();
    String[] workers;
    double pay;
    int current_table;
    
    public Bill(){
    }
    
    public void displayBill(){
        //print getOrdered
        normalize();
        normalizeOrder();
        //System.out.println("Please enter your table number:");
        double total=0;
        int num=1;
        int param = current_table; //calculating the bill for table 1
        
        System.out.println("");
        System.out.println("");
        System.out.println(" ----FaFaFa Garden----");
        System.out.println("www.fafafagarden.com");
        System.out.println("The best food on Earth");
        System.out.println("");
        System.out.println("Staff: " + assignEmployee());
        System.out.println("-------------------------------");
        
        for (int i=0;i<orderFoodName[param].length;i++){
            
            if(orderFoodName[param][i]!=null){
                for(int j=0;j<line_no;j++){
                    if(name[j].equalsIgnoreCase(orderFoodName[param][i])){
                        total+=price[j]*orderQuantity[param][i];
                        System.out.printf("%d %-20s %d pcs\t RM%-20.2f RM%-20.2f\n",num,orderFoodName[param][i],orderQuantity[param][i],price[j],price[j]*orderQuantity[param][i]);
                        num++;
                    }
                }
            }else{
            }
        }
        System.out.println("");
        System.out.println("-------------------------------");
        System.out.println("GST +6%");
        System.out.println("Service tax +5%");
        System.out.println("Total price after tax is: "+ calcBill(param));
        System.out.println("You paid: RM"+pay);
        System.out.printf("The balance is: RM%.2f\n", pay(pay,param));
        System.out.println("--------------------------------");
        System.out.println("Thank you. Please come again.");
        System.out.println("");
        System.out.println("     FAFAFA GARDEN (M)");
        System.out.println("          SDN BHD.   ");
        
    }
    
    public double calcBill(int a){
        //compute total price
        normalize();
        normalizeOrder();
        double total=0;
        int param =a; //calculating the bill for table 1
        
        for (int i=0;i<orderFoodName[param].length;i++){
            if(orderFoodName[param][i]!=null){
                //System.out.println(orderFoodName[param][i]);
                //System.out.println(orderQuantity[param][i]);
                
                for(int j=0;j<line_no;j++){
                    if(name[j].equalsIgnoreCase(orderFoodName[param][i])){
                        //System.out.println(price[j]);
                        total+=price[j]*orderQuantity[param][i];
                    }
                }
                
            }else{
            }
        }    
        total += total*0.06+total*0.05;
        return total;
    }
    
    public double calcBillWithoutTax(int a){
        //compute total price
        normalize();
        normalizeOrder();
        double total=0;
        int param =a; //calculating the bill for table 1
        
        for (int i=0;i<orderFoodName[param].length;i++){
            if(orderFoodName[param][i]!=null){
                //System.out.println(orderFoodName[param][i]);
                //System.out.println(orderQuantity[param][i]);
                
                for(int j=0;j<line_no;j++){
                    if(name[j].equalsIgnoreCase(orderFoodName[param][i])){
                        //System.out.println(price[j]);
                        total+=price[j]*orderQuantity[param][i];
                    }
                }
                
            }else{
            }
        }
        //System.out.println(total);
        //System.out.println("");
        //System.out.println("After taxes:");
        
        //System.out.println(total);
        
        return total;
    }
    
    public double pay(double a,int b){
        double balance=0;
        int table = b;
        
        balance=pay-calcBill(b);
        return balance;
    }
    
    public void payment(){
        System.out.println("Your table number?");
        current_table = keyboard.nextInt();
        
        getBill();
        
        System.out.print("Payment: ");
        double paid=keyboard.nextDouble();
        this.pay = paid;
        System.out.println("here's your receipt:");
        displayBill();
        writeBill();
    }
    
    public void getBill(){
        normalize();
        normalizeOrder();
        //int param=a;
        int param = current_table;
        double total2=0;
        double total=0;
        int num=1;
        
        System.out.println("Your bill is:");
        for (int i=0;i<orderFoodName[param].length;i++){
            
            if(orderFoodName[param][i]!=null){
                for(int j=0;j<line_no;j++){
                    if(name[j].equalsIgnoreCase(orderFoodName[param][i])){
                        total+=price[j]*orderQuantity[param][i];
                        System.out.printf("%d %-20s %d pcs\t RM%-20.2f RM%-20.2f\n",num,orderFoodName[param][i],orderQuantity[param][i],price[j],price[j]*orderQuantity[param][i]);
                        num++;
                        total2+=total;
                    }
                    
                }
                
            }else{
            }
            
        
            
        }
        
        //////////////
            
//            for (int i=0;i<orderFoodName[param].length;i++){
//            
//            if(orderFoodName[param][i]!=null){
//                for(int j=0;j<line_no;j++){
//                    if(name[j].equalsIgnoreCase(orderFoodName[param][i])){
//                        total+=price[j]*orderQuantity[param][i];
//                        System.out.printf("%d %-20s %d pcs\t RM%-20.2f RM%-20.2f\n",num,orderFoodName[param][i],orderQuantity[param][i],price[j],price[j]*orderQuantity[param][i]);
//                        num++;
//                    }
//                }
//            }else{
//            }
//        }
        
        System.out.println("Total is: RM"+calcBillWithoutTax(current_table));
        
    }
    
//    public void assignEmployeeToEachTable(){
//        
//        Random g = new Random();
//        String[] name = labour.getName();
//        int[] code = labour.getWorkercode();
//        
//        int[] workercode = new int[orderline_no];
//        workers = null;
//        workers = new String[orderline_no];
//        
//        for(int i=0;i<workers.length;i++){ //scan for the table length.ada berapa table?
//            
//            for(int j=0;j<code.length;j++)
//            {
//                workercode[i] = g.nextInt(5); //generate satu random num
//                if(workercode[i]==code[j]){ //kalau number yg digenerate sama dengan worker code,
//                    workers[i]=name[j]; //assign worker yg number tu ke meja yg ke berapa
//                    System.out.println(workers[i]);
//                    System.out.println(name[j]);
//                }
//        }
//        }
//    }
//
    
        public String assignEmployee(){
        //randomize a code 0 to 10. which will then be the waiters' code
        int temp;
        Random g = new Random();
        temp = g.nextInt(5); //3
        
        String workerName="";
        labour.readfile();
        labour.setName();
        String[] name = labour.getName();
        int[] workercode = labour.getWorkercode();
        
            for(int i=0;i<name.length;i++){
                if(temp==workercode[i]){ //3=3
                workerName=name[i];
                break;
            }else{
                }
            }
            
            return workerName;
        }
    
        public void writeBill(){
        //print getOrdered
        normalize();
        normalizeOrder();
        //write.println("Please enter your table number:");
        double total=0;
        int num=1;
        int param = current_table; //calculating the bill for table 1
            System.out.println("Your bill is parmanently stored at: "+current_table+".txt");
        PrintWriter write=null;
                try{
                    write = new PrintWriter(new FileOutputStream(current_table+".txt"));
                }catch(IOException e){
                    System.out.println(e);
                }
        
        write.println("");
        write.println("");
        write.println(" ----FaFaFa Garden----");
        write.println("www.fafafagarden.com");
        write.println("The best food on Earth");
        write.println("");
        write.println("Staff: " + assignEmployee());
        write.println("-------------------------------");
        
        for (int i=0;i<orderFoodName[param].length;i++){
            
            if(orderFoodName[param][i]!=null){
                for(int j=0;j<line_no;j++){
                    if(name[j].equalsIgnoreCase(orderFoodName[param][i])){
                        total+=price[j]*orderQuantity[param][i];
                        write.printf("%d %-20s %d pcs\t RM%-20.2f RM%-20.2f",num,orderFoodName[param][i],orderQuantity[param][i],price[j],price[j]*orderQuantity[param][i]);
                        write.println("");
                        num++;
                    }
                }
            }else{
            }
        }
        write.println("");
        write.println("-------------------------------");
        write.println("GST +6%");
        write.println("Service tax +5%");
        write.println("Total price after tax is: "+ calcBill(param));
        write.println("You paid: RM"+pay);
        write.printf("The balance is: RM%.2f", pay(pay,param));
        write.println("");
        write.println("--------------------------------");
        write.println("Thank you. Please come again.");
        write.println("");
        write.println("     FAFAFA GARDEN (M)");
        write.println("          SDN BHD.   ");
        write.close();
    }
}