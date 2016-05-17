
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Item {
    
    Scanner keyboard = new Scanner(System.in);
    protected String[] name; //patutnya buat method utk getName();
    protected double[] cost;
    protected double[] price;
    protected int line_no;
    protected int[] quantity;
    
    public Item(){
        //normalize();
    }
    
    public String readFile(){ //reading the whole txt file\
        line_no=0;
        String txt="";
        try{
        Scanner file = new Scanner(new FileInputStream ("item.txt"));
        while(file.hasNextLine()){
            txt += file.nextLine()+"\n";
            line_no++; //line = 2
        }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
        return txt;
        
    }
    
    public void normalize(){
        //gonna call this function everytime we doing any operation
        //this is resetting all variable in the program
        readFile();// dapatkan line no
        name=null; //starts from zero again. resetting the variables from scratch
        cost=null;
        price=null;
        quantity=null;
        try{
            Scanner in = new Scanner(new FileInputStream("item.txt"));
            String line;
            String[] splitted;
            name = new String[line_no]; //check line first!
            cost = new double[line_no];
            price = new double[line_no];
            quantity= new int[line_no];
            int i = 0;
            while(in.hasNextLine()){
                line = in.nextLine();
                splitted = line.split(",");
                name[i] = splitted[0];
                cost[i] = Double.parseDouble(splitted[1]);
                price[i] = Double.parseDouble(splitted[2]);
                quantity[i] = Integer.parseInt(splitted[3]);
                i++;
            }
            //System.out.println(name[0]);
            //System.out.println(cost[1]);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    public void addItem(){
        //add line to the text file
        String a= keyboard.nextLine();
        double b = keyboard.nextDouble();
        double c = keyboard.nextDouble();
        int d = keyboard.nextInt();
        
        try{
        PrintWriter write = new PrintWriter(new FileOutputStream ("item.txt", true));
        write.println(a+","+b+","+c+","+d);
        write.close(); //kalu tk close writer, tk tubik output dkt txt file
        }catch(IOException e)
        {
            System.out.println(e);
        }
        
    }
    
    public boolean checkItem(String a){
        boolean exist=false;
        
        normalize();
        
        for(int i=0;i<line_no;i++){
            if(name[i].equalsIgnoreCase(a))
                exist=true;
        }
        return exist;
    }
    
    public void deleteItem(String a){
        //search for the line, delete the line
        //write the whole item.txt again
        
        String param =a;
        if(checkItem(param)==true){
        normalize();
        PrintWriter write = null;
        try{
                write = new PrintWriter(new FileOutputStream ("item.txt"));
            }catch(FileNotFoundException e)
            {
                System.out.println(e);
            }
        for(int i=0;i<line_no-1;i++){
            
                if(name[i].equalsIgnoreCase(param)){
                continue;
                }
                //write.println("");
                write.println(name[i]+","+cost[i]+","+price[i]+","+quantity[i]);
        }
        write.close();
        }
        else{
            System.out.println("It doesnt exist in the system");
        }
    }
    
    public void modifyItem(String a){
        normalize();
        String param = a;
        if(checkItem(param)==true){
        
        String operation;
        double argument1 = 0;
        double argument2 =0;
        int argument3=0;
        PrintWriter write = null;
        try{
                write = new PrintWriter(new FileOutputStream ("item.txt"));
                }catch(FileNotFoundException e)
                {
                    System.out.println(e);
                }
        for (int i=0;i<line_no;i++){ //look for every line mana yang sama dengan param. kalau tk sama, ignore
            argument1 = cost[i];
            argument2 = price[i];
            argument3 = quantity[i];
            
            if(name[i].equalsIgnoreCase(param)){
                System.out.println("Edit the cost? Yes or No");
                operation = keyboard.nextLine();
                if (operation.equalsIgnoreCase("Yes"))
                    {
                        System.out.println("What is the new cost?");
                        argument1 = keyboard.nextDouble();
                    }
                    else{
                        argument1 = cost[i];
                    }
                
                System.out.println("Edit the price? Yes or No");
                operation = keyboard.nextLine();
                    if(operation.equalsIgnoreCase("yes"))
                    {
                        System.out.println("What is the new price?");
                        argument2 = keyboard.nextDouble();
                    }
                    else{
                        argument2 = price[i];
                    }
                    
                System.out.println("Edit the quantity available? Yes or No");
                operation = keyboard.nextLine();
                    if(operation.equalsIgnoreCase("yes"))
                    {
                        System.out.println("What is the new quantity available?");
                        argument3 = keyboard.nextInt();
                    }
                    else{
                        argument3 = quantity[i];
                    }
        }
        write.println(name[i]+","+argument1+","+argument2+","+argument3);
        
        }
        write.close();
        }else{
            System.out.println("The item is not in the database");
        }
    }
    
    public void getItems(){
        //print the whole file
        normalize();
        System.out.print("Name"
                + "\t\t\tPrice per serving"
                + "\t Cost per serving"
                + "\t Quantity Available"
                + "\n");
        for(int i=0;i<line_no;i++)
        {
            System.out.printf("%-23s RM %-21.2f RM %.2f \t\t %d\n",name[i], price[i], cost[i], quantity[i]); //for formatting the items
        }
        
    }
    
    public String[] getNames(){
        return name;
    }
    
    public int[] getQuantity(){
        return quantity;
    }
    
    public double[] getPrices(){
        return price;
    }
}