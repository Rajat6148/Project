
import java.util.Scanner;
import java.sql.*;
 
class bankInternal {
    int acno;
    long bal=0;
    String name;
    long mobile;
    String address;
    
    
    Scanner get = new Scanner(System.in);
  
    void openaccount()
    { 
        try{
        
            Connection conn = null;
            Scanner sc = new Scanner(System.in);
            
            Class.forName("com.mysql.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/banking system";
            
            conn = DriverManager.getConnection(url, "root", "");
            
            if(conn != null)
            {
                System.out.println("Database Connected");
            }
        
        System.out.println("Enter Account Number:");
        acno = get.nextInt();
        
        get.nextLine();
        
        System.out.println("Enter the Name of Account Holder");
        
        name=get.nextLine();
        System.out.println("Enter mobile number");
        mobile=get.nextLong();
        get.nextLine();
        System.out.println("Enter Address");
        
        address=get.nextLine();
        System.out.println("Enter Initial Balance:");
        bal = get.nextLong();
        
        String query = "insert into bankers values(?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, acno);
            pstmt.setString(2, name);
            pstmt.setLong(3, mobile);
            pstmt.setString(4, address);
            pstmt.setLong(5, bal);
            
            int a = pstmt.executeUpdate();
            
            Statement stmt = conn.createStatement();
            
            String query2 = "select * from bankers";
            ResultSet rs = stmt.executeQuery(query2);
            
            while(rs.next())
            {
                System.out.println("Account Succesfully Created! ");
                System.out.println("Acno: " +rs.getInt(1) + " " + "Name: " +rs.getString(2) + " " + "Mobile: " +rs.getLong(3)+ " " + "Address: " +rs.getString(4)+ " " + "Balance: " +rs.getLong(5));
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        mainmenu();
    }
    

    void changedetails()
    {
        int ch;
        
        System.out.println("\n1.Change the Name of Account Holder");
        System.out.println("2.Change mobile number");
        System.out.println("3.Change Address");
        System.out.println("Enter your choice");
        ch=get.nextInt();
        switch(ch)
        {
            case 1:
                 try{
        
            Connection conn = null;
            Scanner sc = new Scanner(System.in);
            
           
            Class.forName("com.mysql.jdbc.Driver");
            
          
            String url = "jdbc:mysql://localhost:3306/banking system";
            System.out.println("Enter account number");
                     int c=sc.nextInt();
                     sc.nextLine();
                System.out.println("Enter the Name of Account Holder");
                 name=sc.nextLine();
                  conn = DriverManager.getConnection(url, "root", "");
                 String query = "UPDATE `bankers` SET `Name`=? WHERE `Accountno.`= ?";
                 PreparedStatement pstmt = conn.prepareStatement(query);
                 pstmt.setString(1, name);
                 pstmt.setInt(2, c);
                 int a = pstmt.executeUpdate();
                 
                 Statement stmt = conn.createStatement();
            String query2 = "select * from bankers";
            ResultSet rs = stmt.executeQuery(query2);
            
           
            while(rs.next())
            {
                System.out.println("Succsefully alter");
                System.out.println("Acno: " +rs.getInt(1) + " " + "Name: " +rs.getString(2) + " " + "Mobile: " +rs.getLong(3)+ " " + "Address: " +rs.getString(4)+ " " + "Balance: " +rs.getLong(5));
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
                 menu();
                 break;
                 
            case 2:
                 try{
        
            Connection conn = null;
            Scanner sc = new Scanner(System.in);
            
           
            Class.forName("com.mysql.jdbc.Driver");
            
          
            String url = "jdbc:mysql://localhost:3306/banking system";
            
                     System.out.println("Enter account number");
                     int c=sc.nextInt();
                     sc.nextLine();
                System.out.println("Enter mobile number");
                mobile=get.nextLong();
                
                 conn = DriverManager.getConnection(url, "root", "");
                 String query = "UPDATE `bankers` SET `Mobileno.`=? WHERE `Accountno.`= ?";
                 PreparedStatement pstmt = conn.prepareStatement(query);
                 pstmt.setLong(1, mobile);
                 pstmt.setInt(2, c);
                 int a = pstmt.executeUpdate();
                 System.out.println("Succsefully alter");
               
            Statement stmt = conn.createStatement();
            
            String query2 = "select * from bankers";
            ResultSet rs = stmt.executeQuery(query2);
            
            while(rs.next())
            {
                System.out.println("Succsefully alter");
                System.out.println("Acno: " +rs.getInt(1) + " " + "Name: " +rs.getString(2) + " " + "Mobile: " +rs.getLong(3)+ " " + "Address: " +rs.getString(4)+ " " + "Balance: " +rs.getLong(5));
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
                 menu();
                break;
            
            case 3:
                try{
        
            Connection conn = null;
            Scanner sc = new Scanner(System.in);
            
           
            Class.forName("com.mysql.jdbc.Driver");
            
          
            String url = "jdbc:mysql://localhost:3306/banking system";
            
                     System.out.println("Enter account number");
                     int c=sc.nextInt();
                     sc.nextLine();
                System.out.println("Enter Address");
                address=get.next();
               
                conn = DriverManager.getConnection(url, "root", "");
                 String query = "UPDATE `bankers` SET `Address`=? WHERE `Accountno.`= ?";
                 PreparedStatement pstmt = conn.prepareStatement(query);
                 pstmt.setString(1, address);
                 pstmt.setInt(2, c);
                 int a = pstmt.executeUpdate();
                 System.out.println("Succsefully alter");
                  
            Statement stmt = conn.createStatement();
            
            
            String query2 = "select * from bankers";
            ResultSet rs = stmt.executeQuery(query2);
            
            while(rs.next())
            {
                 System.out.println("Succsefully alter");
                System.out.println("Acno: " +rs.getInt(1) + " " + "Name: " +rs.getString(2) + " " + "Mobile: " +rs.getLong(3)+ " " + "Address: " +rs.getString(4)+ " " + "Balance: " +rs.getLong(5));
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
                 menu();
                break;
            default:
                System.out.println("We recieve incorrect input");
                break;
                
        }
        
    }
    
    void showdetails()
            
    { 
        try{
        
            Connection conn = null;
            Scanner sc = new Scanner(System.in);
            
           
            Class.forName("com.mysql.jdbc.Driver");
            
          
            String url = "jdbc:mysql://localhost:3306/banking system";
            
            
            conn = DriverManager.getConnection(url, "root", "");
            

            String query2 = "select * from bankers";
          
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(query2);
            
            while(rs.next())
            {
                System.out.println("Acno: " +rs.getInt(1) + " " + "Name: " +rs.getString(2) + " " + "Mobile: " +rs.getLong(3)+ " " + "Address: " +rs.getString(4)+ " " + "Balance: " +rs.getLong(5));
            }menu();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    
    void deposit()
    { try{
        
            Connection conn = null;
            Scanner sc = new Scanner(System.in);
            
           
            Class.forName("com.mysql.jdbc.Driver");
            
          
            String url = "jdbc:mysql://localhost:3306/banking system";
            
                     System.out.println("Enter account number");
                     int c=sc.nextInt();
                     sc.nextLine();
        long amount;
        System.out.println("Enter Amount to be Deposit: ");
        amount = get.nextLong();
        if(amount>=500)
        {
            bal = bal+amount;
            
        
        conn = DriverManager.getConnection(url, "root", "");
                 String query = "UPDATE `bankers` SET `Balance`=Balance+? WHERE `Accountno.`= ?";
                 PreparedStatement pstmt = conn.prepareStatement(query);
                 pstmt.setLong(1, bal);
                 pstmt.setInt(2, c);
                 int a = pstmt.executeUpdate();
                 System.out.println("Succsefully alter");
                  
            Statement stmt = conn.createStatement();
            
            String query2 = "select * from bankers";
            ResultSet rs = stmt.executeQuery(query2);
            
           
            while(rs.next())
            {
                System.out.println("Amount Succesfully Deposited! Total balance"+rs.getLong(3));
                System.out.println("Acno: " +rs.getInt(1) + " " + "Name: " +rs.getString(2) + " " + "Mobile: " +rs.getLong(3)+ " " + "Address: " +rs.getString(4)+ " " + "Balance: " +rs.getLong(5));
            }
        }
            else
        {
            System.out.println("Transection failed! We Accept minimum Amount of 500 rupees for deposit");
        }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
                 menu();
        
        
    }
    
    void withdraw()
    {
        try{
        
            Connection conn = null;
            Scanner sc = new Scanner(System.in);
            
            Class.forName("com.mysql.jdbc.Driver");
            
          
            String url = "jdbc:mysql://localhost:3306/banking system";
            
                     System.out.println("Enter account number");
                     int c=sc.nextInt();
                     sc.nextLine();
        long amount;
        System.out.println("Enter Amount to be Withdrawn:");
        amount = get.nextLong();
        if(amount<bal)
        {
            bal = bal-amount;
            
        
        
         conn = DriverManager.getConnection(url, "root", "");
                 String query = "UPDATE `bankers` SET `Balance`=Balance-? WHERE `Accountno.`= ?";
                 PreparedStatement pstmt = conn.prepareStatement(query);
                 pstmt.setLong(1, bal);
                 pstmt.setInt(2, c);
                 int a = pstmt.executeUpdate();
                 System.out.println("Succsefully alter");
                  
            Statement stmt = conn.createStatement();
            
            String query2 = "select * from bankers";
            ResultSet rs = stmt.executeQuery(query2);
            
           
            while(rs.next())
            {
                System.out.println("Amount: "+ amount +" Succesfully Withdrawn!! available balance"+rs.getLong(5));
                System.out.println("Acno: " +rs.getInt(1) + " " + "Name: " +rs.getString(2) + " " + "Mobile: " +rs.getLong(3)+ " " + "Address: " +rs.getString(4)+ " " + "Balance: " +rs.getLong(5));
            }
        }
        else
        {
            System.out.println("Insufficient funds!!");
        }
        
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
                 menu();
    }
    
   
    void menu()
    {
        int ch;
        System.out.println("\nDashboared");
        System.out.println("----------");
        System.out.println("1.Show Details");
        System.out.println("2.Change Details");
        System.out.println("3.Add Funds");
        System.out.println("4.Withdraw Amount");
        System.out.println("5.Exit");
        System.out.println("Enter your choice");
        ch=get.nextInt();
        
        switch(ch)
        {
            case 1:
                showdetails();
                menu();
                break;
            
            case 2:
                
                changedetails();
                menu();
                break;
                
            case 3:
                deposit();
                menu();
                break;
            
            case 4:
                withdraw();
                menu();
                         
                break;
               
       
            case 5:
               end();
                break;
                
            default:
                System.out.println("incorrect input");
                    menu();
                
        }
        
        
        
    }
     void mainmenu()
    {
          Scanner get = new Scanner(System.in);
        
        int ch;
        System.out.println("--------------------");
        System.out.println("1.Create new record");
        System.out.println("2.open dashboard for available accounts");
        System.out.println("3.Exit");
        System.out.println("Enter your choice");
        ch=get.nextInt();
        switch(ch)
        {
            
            case 1:
                openaccount();
                break;
            
            case 2:
                    
                menu();
                        
                break;
                
            case 3: 
                
                end();
                break;
            
            default:
                System.out.println("We recieve incorrect choice");
                
        }
      
    }
   
     int end()
    {
        System.out.println("Bye Bye!");
        return 0;
    }
}

public class Bank {
     public static void main(String[] args)
    {
        bankInternal myobj = new bankInternal();
     
        System.out.println("Welcome to E-banking");
        myobj.mainmenu();

    }
    
}

