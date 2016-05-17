
import java.util.Random;
import java.util.Calendar;

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
    
    double pay=100;
    
    public Bill(){
    }
    
    public void displayBill(){
        //print getOrdered
        normalize();
        normalizeOrder();
        System.out.println("Please enter your table number:");
        double total=0;
        int num=1;
        int param =keyboard.nextInt(); //calculating the bill for table 1
        
        System.out.println(" ----FaFaFa Garden----");
        System.out.println("Staff: " + assignEmployee());
        System.out.println("-------------------------------");
        
        for (int i=0;i<orderFoodName[param].length;i++){
            
            if(orderFoodName[param][i]!=null){
                for(int j=0;j<line_no;j++){
                    if(name[j].equalsIgnoreCase(orderFoodName[param][i])){
                        total+=price[j]*orderQuantity[param][i];
                        System.out.printf("%d %-20s %-20d %-20.2f %-20.2f\n",num,orderFoodName[param][i],orderQuantity[param][i],price[j],price[j]*orderQuantity[param][i]);
                        num++;
                    }
                }
            }else{
            }
        }
        System.out.println("----------------");
        System.out.println("GST +6%");
        System.out.println("Service tax +5%");
        System.out.println("Total price after tax is: "+ calcBill(param));
        System.out.println("You paid: "+pay);
        System.out.println("The balance is: "+ pay(pay,param));
        System.out.println("----------------");
        System.out.println("Thank you. Please come gain.");
        
        
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
        //System.out.println(total);
        //System.out.println("");
        //System.out.println("After taxes:");
        
        //System.out.println(total);
        total+=(total*6/100+total*5/100);
        return total;
    }
    
    public double pay(double a,int b){
        double balance=0;
        double paid=a;
        int table = b;
        
        balance=paid-calcBill(b);
        return balance;
    }
    
    public String assignEmployee(){
        //randomize a code 0 to 10. which will then be the waiters' code
        int temp;
        Random g = new Random();
        //temp = g.nextInt(10);
        temp = 2;
        int workercode = 2;
        
            for(int i=0;i<1;i++){
            if(workercode==temp){
                //Report.workercode[i]===temp sout(Report.name[i]);
            }
            }
            
            return "fahmi";
        }
        
    
    
    
}