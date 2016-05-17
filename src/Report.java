/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Trina
 */
public class Report{
    
    Order orderClass = new Order();
    Item itemClass = new Item();
    private double revenue=0, totalprofit, totalcost=0, target;
    private int tableserved, totalitem;

    public void Revenue(){
        orderClass.normalizeOrder();
        itemClass.normalize();
        String[][] orderFoodName = orderClass.getOrderFoodName();
        String[] name = itemClass.getNames();
        int[][] quantity = orderClass.getOrderQuantity();
        double[] prices = itemClass.getPrices();
        
        
        for(int i=0;i<orderFoodName.length;i++){
            for(int j=0;j<orderFoodName[i].length;j++){
                for(int k=0;k<name.length;k++){
                if(name[k].equalsIgnoreCase(orderFoodName[i][j])){
                        
                        revenue += prices[k]*quantity[i][j];
                        
                }
                    }
                
            }
        }        
        
        
            
        }
    //String[] names = itemClass.getNames();
    public void sortDishes(){
        //use bubble sort to sort the served[]\
        itemClass.normalize();
        orderClass.normalize();
        orderClass.normalizeOrder();
        
        int[] served = itemClass.getServed();
        String[] names = itemClass.getNames();
        
        for(int i=0;i<served.length;i++){ //utk kiraan pass
            for(int j=0;j<served.length-1;j++){ //utk kiraan pass
            if(served[j]<served[j+1]){
                int temp=served[j];
                String temp1=names[j];
                served[j]=served[j+1];
                names[j]=names[j+1];
                served[j+1]=temp;
                names[j+1]=temp1;
            }
        }
        }
//        for(int i=0;i<served.length;i++){
//        System.out.println(served[i]);
//        System.out.println(names[i]);
//        }
        System.out.println("The most popular dish is: "+names[0]);
        System.out.println("The least popular dish is: "+names[names.length-1]);
    }
    
    
    public void Costs(){
        orderClass.normalizeOrder();
        itemClass.normalize();
        String[][] orderfoodname = orderClass.getOrderFoodName();
        String[] Name = itemClass.getNames();
        double[] cost = itemClass.getCost();
        int[][] amount = orderClass.getOrderQuantity();
        
        for(int i=0; i<orderfoodname.length; i++){
            for(int j=0; j<orderfoodname.length; j++){
                for(int k=0; k<Name.length; k++){
                    if(Name[k].equalsIgnoreCase(orderfoodname[i][j]))
                    {
                        
                        totalcost+=amount[i][j]*cost[k];
                        
                    } 
                }
            }
    }
    }
    
    public void Profit(){
        totalprofit=revenue-totalcost;
    
        
    }
    public void tableserved(){
        orderClass.normalize();
        orderClass.normalizeOrder();
        tableserved= orderClass.getOrderline_no();
        
    }
    
    public void TotalMenu(){
        itemClass.normalize();
        totalitem= itemClass.getLine_no();
       
       
    }
    
    
    
    public void Target(){
        Profit();
        Scanner b = new Scanner(System.in);
        System.out.print("Please enter your target for today: RM");
        target = b.nextDouble();
        if(totalprofit>target)
        {
            
            System.out.printf("You have achieved your target for today with extra profit of RM%.2f\n", totalprofit-target);
        }
        else
            System.out.printf("You need RM%.2f to achieve your target.\n", target-totalprofit);
    }
    
    public void getAll(){
        TotalMenu();
        tableserved();
        Costs();
        Revenue();
        Profit();
        Target();
        
        System.out.printf("Total Sale: RM%.2f\n",revenue);
        System.out.printf("Total Cost: RM%.2f\n",totalcost);
        System.out.printf("Total Profit: RM%.2f\n",totalprofit);
        System.out.println("Tables Served: "+tableserved);
        System.out.println("Total Item: "+totalitem);
        sortDishes();
        System.out.println("-----------------------------------");
        System.out.println("Shareholders");
        System.out.printf("Fadhil: RM%.2f\n",totalprofit*0.5);
        System.out.printf("Faez: RM%.2f\n", totalprofit*0.3);
        System.out.printf("Fahmi: RM%.2f\n", totalprofit*0.2);
    }
    
    
    //Labour labourClass = new Class();
    //Scanner a= new Scanner("order.txt, labour.txt, item.txt");
    //protected String[] order;
    //protected double price; //= new double[100];
    
    //private int turnover;
    //private String leastpopular, line, Popular;
    
//    protected int tehquan= super.teh;
//    protected int mihunquan= super.mihun;
//    protected int meesupquan= super.meesup;
//    protected int airtebuquan= super.airtebu;
//    protected int airlimauquan= super.airlimau;
//    protected int populardish=0;
    //protected String name;
    //int[] order1 = new int [100];
    
    //order1[1]= super.ng;
//    public Report(){
//        //cost=0.0;
//        turnover=0;
//        //order1[0]=0;
//        //populardish="";
//        leastpopular="";
//    }
    
//    public void test(){
//        
//        System.out.println(super.teh);
//    }
    
//    public void PopularDish(){
////        normalizeOrder();
////        //System.out.println("teh "+tehquan);
////        order1[0]=0;
////        order1[1]=super.ng;
////        //order1[1]=ngquan;
////        order1[2]=super.teh;
////        order1[3]=super.mihun;
////        order1[4]=super.meesup;
////        order1[5]=super.airtebu;
////        order1[6]=super.airlimau;
//        System.out.println("0 "+order1[0]);
//        System.out.println("1 "+order1[1]);
//        for(int pass=0; pass<7; pass++)
//        {
//            for(int i=0;i<7; i++){
//            if(order1[i]>order1[i+1]){
//                int hold=order1[i];
//                //System.out.println("hold "+hold);
//                order1[i]=order1[i+1];
//                //System.out.println("order "+order1[i+1]);
//                order1[i+1]=hold;
//                //System.out.println("order1 "+order1[i]);
//                //System.out.println(order1[i+1]);
//                //int highest=order1[6];
//            }//System.out.println("Highest "+order1[i+1]);
//            }
//           // System.out.println("order "+ highest);
//        }
////        if(ngquan>tehquan){
////            populardish=ngquan;
////            name="Nasi Goreng";
////            System.out.println("Popular Dish:"+name);
////        }
////        if(ngquan>tehquan){
////            populardish=ngquan;
////            System.out.println("Popular Dish:");
////        }
////        else if(ngquan>mihunquan)
////        {
////            populardish=ngquan;
////            System.out.println("Popular Dish: ");
////        }
////        else if(ngquan>meesupquan)
////        {
////            populardish=ngquan;
////            System.out.println("Popular Dish:");
////        }
////        else if(ngquan>airtebuquan)
////        {
////            populardish=ngquan;
////            System.out.println("Popular Dish:");
////        }
////        else 
////        {
////            populardish=airlimauquan;
////            System.out.println("Popular Dish:");
////        }
//    }
    
    
    
//    public void TotalQuantity(){
//        orderClass.normalizeOrder();
//        String[][] OrderName = orderClass.getOrderFoodName();
//        String[][] OrderName2 = orderClass.getOrderFoodName();
//        int[][] Quantity = orderClass.getOrderQuantity();
//        int totalQuantity=0;
//        for(int i=0; i<OrderName.length;i++){
//            for(int j=0;j<OrderName.length;j++){
//                for(int k=0; k<OrderName2.length; k++){
//                    for(int l=1; l<OrderName2.length; l++){
//                        if(OrderName2[k][l].equalsIgnoreCase(OrderName[i][j])){
//                            System.out.println(OrderName[i][j]+" "+OrderName2[k][l]+" "+Quantity[i][j]);
//                            totalQuantity=0;
//                            totalQuantity+=Quantity[i][j];
//                            System.out.println(totalQuantity);
//                            
//                        }
//                        else 
//                           System.out.println(OrderName[i][j]+" "+Quantity[i][j]);
//                    }
//                }
//            }
//        }
//    }
    
//    public void PopularDish(){
//        orderClass.normalizeOrder();
//        itemClass.normalize();
//        String[][] OrderName = orderClass.getOrderFoodName();
//        int[][] Quantity = orderClass.getOrderQuantity();
//        String[] ItemName = itemClass.getNames();
//        int max=0;
//        for(int i=0; i<OrderName.length; i++){
//            for(int j=0; j<OrderName.length; j++){
//                
//                if(Quantity[i][j]>max){
//                    
//                    max=Quantity[i][j];
//                    Popular= OrderName[i][j];
//                    
//                    
//                }
//            }
//        }System.out.println(Popular);
//        System.out.println(max);
//    }
    
    
    
    
//        System.out.println(name[1][1]);
//        try{ 
////            int i=0;
////            //int count=0;
////            Scanner in = new Scanner(new FileInputStream("item.txt"));
////            while(in.hasNextLine()){
////                //count++; 
////                //int j=0;
////                //j++;
////                line = in.nextLine();
////                System.out.println(line);
////                order = line.split(",");
////                
////                System.out.println(order[2]);
////                normalizeOrder();
////                //System.out.println("teh "+tehquan);
////                order1[0]=0;
////                order1[1]=super.ng;
////                //order1[1]=ngquan;
////                order1[2]=super.teh;
////                order1[3]=super.mihun;
////                order1[4]=super.meesup;
////                order1[5]=super.airtebu;
////                order1[6]=super.airlimau;
////                
//////                contoh[i]= order[2];
////                
////                price= Double.parseDouble(order[2]);  
////                System.out.printf("%.2f\n", price);
////                
////                //j++;
////                //System.out.println(j);
////                
////            }
//            
////            for(int i=0; i<=count; i++)
////                {
////                    for(int j=0;j<3; j++)
////                    {
////                    
////                    }
////                }
////            Scanner in2 = new Scanner("order.txt");
//            Scanner in = new Scanner(new FileInputStream("order.txt"));
//            
//            
//            
//            in.close();
//        }catch(FileNotFoundException e){
//            System.out.println("File not found");
//        }
    //}
    
//    public Report(double a, double b, int c, String d, String e){
//        cost=a;
//        price=b;
//        turnover=c;
//        populardish=d;
//        leastpopular=e;
//    }
    
//    public void display(){
        //revenue= price-turnover;
        //System.out.printf("The revenue are RM %.2f\n", revenue);
        
  //  }
}
