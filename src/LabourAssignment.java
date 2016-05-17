import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class LabourAssignment {

Scanner keyboard = new Scanner(System.in);
private int i; //check no of worker
private String [] name;
private double [] salary;
private String [] position;
private int [] workercode;

public LabourAssignment() {
}

public void readfile(){
//read how many item(s)
    i=0;
try {
Scanner a = new Scanner(new FileInputStream("labour.txt"));
while(a.hasNextLine()){
String line = a.nextLine();
i++;
}
}catch (FileNotFoundException e) {
System.out.println("Problem with file input"); 
}

}
public void setName(){ //normalize
//assign number of item to number of element
name= new String[i];
salary=new double[i];
position=new String[i];
workercode=new int [i]; 
//assign file content to array;
try {
Scanner a = new Scanner(new FileInputStream("labour.txt"));

        for( i=0;a.hasNextLine();i++){
            String line = a.nextLine();
        String[] split = line.split(",");
        name[i]=split[0];
        salary[i]=Double.parseDouble(split[1]);
        position[i]= split[2];
        workercode [i]= Integer.parseInt(split[3]);
        }
//name[1]=fahmi
}catch (FileNotFoundException e) {
System.out.println(e); 
}
}

public void addnew() {
    Scanner b = new Scanner(System.in);
    System.out.println("Enter the new employee name:");
    String new_name = keyboard.nextLine();
    System.out.println("Enter the new employee salary:");
    double new_salary= keyboard.nextDouble();
    System.out.println("Enter the new employee position:");
    String new_position = b.nextLine(); //kalau dua kali scan nextLine() guna object sama dr class scanner, jd problem
    System.out.println("Enter the new employee worker code");
    int new_workercode= keyboard.nextInt();
        try {
        PrintWriter a = new PrintWriter(new FileOutputStream("labour.txt",true));
        a.println(new_name+","+new_salary+","+new_position+","+new_workercode);

        a.close();
        } catch (IOException e) {
        System.out.println("Problem with file output"); 
        }

    }

public void modifyname(){
readfile();
setName();

    System.out.println("Enter the name of existing employee");
    String employee_name=keyboard.nextLine();
    System.out.println("Enter the new name for the employee:");
    Scanner b = new Scanner(System.in);
    String new_employee_name = b.nextLine();
for(int i=0;i<name.length;i++){
if(employee_name.equalsIgnoreCase(name[i])){
name[i]=new_employee_name;
}
}
try {
PrintWriter a = new PrintWriter(new FileOutputStream("labour.txt"));
for(int i=0;i<name.length;i++){
a.println(name[i]+","+salary[i]+","+position[i]+","+workercode[i]);

}


a.close();
} catch (IOException e) {
System.out.println("Problem with file output"); 
}
}

public void modifysalary(){
readfile();
setName();

    System.out.println("Enter the name of employee:");
    String employee_name=keyboard.nextLine();
    System.out.println("Enter the new salary for the employee:");
    Scanner b = new Scanner(System.in);
    double new_salary = b.nextDouble();
        for(int i=0;i<name.length;i++){
        if(employee_name.equalsIgnoreCase(name[i])){
        salary[i]=new_salary;
        }
        }
    try {
    PrintWriter a = new PrintWriter(new FileOutputStream("labour.txt"));
    for(int i=0;i<name.length;i++){
    a.println(name[i]+","+salary[i]+","+position[i]+","+workercode[i]);
    }
    a.close();
    } catch (IOException e) {
    System.out.println("Problem with file output"); 
    }
    

}

public void modifyposition(){
readfile();
setName();
        
    System.out.println("Enter the name of employee:");
    String employee_name=keyboard.nextLine();
    System.out.println("Enter the new position for the employee:");
    Scanner b = new Scanner(System.in);
    String new_position = b.nextLine();
for(int i=0;i<position.length;i++){
if(employee_name.equalsIgnoreCase(name[i])){
position[i]=new_position;
}
}

try {
PrintWriter a = new PrintWriter(new FileOutputStream("labour.txt"));
for(int i=0;i<name.length;i++){
a.println(name[i]+","+salary[i]+","+position[i]+","+workercode[i]);


}


a.close();
} catch (IOException e) {
System.out.println("Problem with file output"); 
}
}

public void modifycode(){
readfile();
setName();

System.out.println("Enter the name of employee:");
    String employee_name=keyboard.nextLine();
    System.out.println("Enter the new workercode for the employee:");
    Scanner b = new Scanner(System.in);
    int new_workercode = b.nextInt();

for(int i=0;i<position.length;i++){
if(employee_name.equalsIgnoreCase(name[i])){
workercode[i]=new_workercode;
//break;
}
}

try {
PrintWriter a = new PrintWriter(new FileOutputStream("labour.txt"));
for(int i=0;i<name.length;i++){
a.println(name[i]+","+salary[i]+","+position[i]+","+workercode[i]);

}
a.close();
} catch (IOException e) {
System.out.println("Problem with file output"); 
}
}

    public String[] getName() {
        return name;
    }

    public int[] getWorkercode() {
        return workercode;
    }


public void delete(){
readfile();
setName();
    System.out.println("Enter the name of employee you want to remove");
String delete_item = keyboard.nextLine();
try {
PrintWriter a = new PrintWriter(new FileOutputStream("labour.txt"));
    for(int i=0;i<name.length-1;i++){
        if(delete_item.equalsIgnoreCase(name[i]))
            continue;
        a.println(name[i]+","+salary[i]+","+position[i]+","+workercode[i]);
        //name[j++]=name[i];

        }

a.close();
} catch (IOException e) {
System.out.println("Problem with file output"); 
}
}

public void display(){
        readfile();
        setName();
            System.out.println("");
            //System.out.println(name[1]);
        for(int i=0;i<name.length;i++){
        System.out.println("Name: "+name[i]);
        System.out.println("Salary : RM"+salary[i]);
        System.out.println("Position : "+position[i]);
        System.out.println("Worker Code : "+workercode[i]);
            System.out.println("");
        }       
    }

    public void start(){
    
        System.out.println("Welcome to Employee Management System");
        System.out.println("Please select the next operation:");
        System.out.println("[ADD] [MODIFY] [REMOVE] [VIEW]");
        Scanner a = new Scanner(System.in);
        Scanner b = new Scanner(System.in);
        
        String operation = a.nextLine();
        if(operation.equalsIgnoreCase("add")){
            addnew();
        }else if(operation.equalsIgnoreCase("remove")){
            delete();
        }else if(operation.equalsIgnoreCase("view")){
            display();
        }
        else if(operation.equalsIgnoreCase("modify")){
            System.out.println("[NAME] [SALARY] [POSITION] [WORKERCODE]");
            operation = b.nextLine();
            if(operation.equalsIgnoreCase("add "))
                modifyname();
            else if(operation.equalsIgnoreCase("salary"))
                modifysalary();
            else if(operation.equalsIgnoreCase("position"))
                modifyposition();
            else if(operation.equalsIgnoreCase("workercode"))
                modifycode();
            else
                System.out.println("Your argument is invalid");
            
        }
        
    }

    public double[] getSalary() {
        return salary;
    }
}

    

