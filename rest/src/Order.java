
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Order extends Item{ //inherit the Item class because we're using the same data to serve customer
    
    private int orderline_no;
    private String ordertxt;
    protected String[] table_order; //get the value when reading the line
//    private String[] name = super.getNames();
//    private double[] price = super.getPrices();
    protected String[][] orderFoodName;
    protected int[][] orderQuantity;
    protected String[][] ordersPhrase;
    private int[] ordercount;
    
    public Order(){
        super();
    }
    
    public int totalOrders(){
        return ordercount.length;
    }
    
    public void normalizeOrder(){
        //gonna call this function everytime we doing any operation
        //this is resetting all variable in the program
        readOrderFile();
        ordersPhrase=null;
        orderQuantity=null;
        orderFoodName=null;
        table_order=null;
        try{
            Scanner in = new Scanner(new FileInputStream("order.txt"));
            String line;
            String[] splitted;
            ordersPhrase = new String[orderline_no][]; //check line first!
            table_order = new String[orderline_no];
            int i = 0;
            while(in.hasNextLine()){
                 //assigning the table number for the order
                line = in.nextLine();
                table_order[i] = line;
                splitted = line.split(",");
                ordersPhrase[i] = splitted; //each row wont have the same number of columns. be cool
                //System.out.println(ordersPhrase[i][1]);
                // OrderPhrase[1] = "Mihun - 2"
                i++;
            }
        }catch(IOException e){
            System.out.println(e);
        }
        
        orderFoodName = new String[ordersPhrase.length][100]; //maximum of 100 items per bill
        orderQuantity = new int[ordersPhrase.length][100];
        
        String splitted2[];
        for(int i =0;i<ordersPhrase.length;i++){
            for(int j=0;j<ordersPhrase[i].length;j++){
                splitted2 = ordersPhrase[i][j].split("-"); //mihun-2
                orderFoodName[i][j] = splitted2[0] ; //mihun // what is the food ordered at the table
                orderQuantity[i][j] = Integer.parseInt(splitted2[1]); //2 // no of quantity ordered
            }
        }
        
    }
    
    public String readOrderFile(){
        orderline_no=0;
        String txt="";
        try{
        Scanner file = new Scanner(new FileInputStream ("order.txt"));
        while(file.hasNextLine()){
        txt += "\n"+file.nextLine();
            orderline_no++;
        }
        }catch(IOException e){
            System.out.println(e);
        }
        return ordertxt;
    }
    
    public void getMenu(){
        normalizeOrder();
        System.out.print("Name"
                + "\t\t\tPrice per serving"
                + "\n");
        for(int i=0;i<line_no;i++)
        {
            System.out.printf("%-23s RM %.2f\n",name[i], price[i]);
        }
    }
    
    public void reduceItemQuantity(String a,int b){
        normalize();
        //normalizeOrder();
        String param = a;
        int q =b;
        //System.out.println(line_no);
        
        int argument=0;
        PrintWriter write = null;
        try{
                write = new PrintWriter(new FileOutputStream ("item.txt"));
           }catch(FileNotFoundException e)
            {
                System.out.println(e);
            }
        for (int i=0;i<line_no;i++){ //look for every line in item.txt utk check mana yang sama dengan param
            if(name[i].equalsIgnoreCase(param)){ // if name[1] = timun bakar
                argument = quantity[i]-q; // argument = quantity[1]-2
            }
            else{
                argument=quantity[i]; //argument = quantity[1]
            }
        write.println(name[i]+","+cost[i]+","+price[i]+","+argument);
      }
        write.close();
    }
    
    public void addFirstOrder(){
        System.out.print("May I take your order please, sir? ");
        String param = keyboard.nextLine();
        if(checkItem(param)==true){ //check wheter is the product exist in the database or not
            System.out.print("How many sets? ");
        int q = keyboard.nextInt();
        PrintWriter write = null;
        try{
            write = new PrintWriter(new FileOutputStream("order.txt",true));
        }catch(IOException e){
            System.out.println(e);
        }
        //if(checkItem(param)==true)
        write.print(param + "-" + q);
        write.close();
        
        //reduce the number of orderQuantity in item.txt
        //akan ada printwriter satu lg ke item.txt utk delete orderQuantity no
        
        reduceItemQuantity(param,q);
        }
        else{
            System.out.println("Sorry. The food is not in our menu");
        }
    }
    
    public void addOrder(){
        System.out.print("May I take next order? ");
        String param = keyboard.nextLine();
        if(checkItem(param) == true){
        System.out.print("How many sets? ");
        int q = keyboard.nextInt();
        PrintWriter write = null;
        try{
            write = new PrintWriter(new FileOutputStream("order.txt",true));
        }catch(IOException e){
            System.out.println(e);
        }
        //if(checkItem(param)==true)
        write.print("," + param + "-" + q);
        write.close();
        
        reduceItemQuantity(param,q);
        }
        else{
            System.out.println("Sorry. The food is not in our menu.");
        }
    }
    
    public void finishOrder(){ //to do the formatting on the order.txt file
        normalizeOrder();
        //kalau tkde order tk pyh add new line
        System.out.println("Thank you very much. Your dishes will be served soon.");
        System.out.println("Your table number is "+(orderline_no-1));
        PrintWriter write = null;
        try{
            write = new PrintWriter(new FileOutputStream("order.txt",true));
        }catch(IOException e){
            System.out.println(e);
        }
        write.println("");
        write.close();
    }
    
    public void getOrderCount(){
        normalizeOrder();
        ordercount=new int[ordersPhrase.length];
        for(int i=0;i<ordersPhrase.length;i++)
            ordercount[i] = ordersPhrase[i].length;
    }
    
    public void getOrdered(){
        normalize();
        normalizeOrder();
        getOrderCount();
        System.out.println(ordersPhrase.length);
        
            for(int j =0;j<ordercount[ordersPhrase.length-1];j++){
                System.out.println(orderFoodName[ordersPhrase.length-1][j]+" "+orderQuantity[ordersPhrase.length-1][j]+" sets");
            }
        }
        
}
