package org.example;

import java.sql.*;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String url="jdbc:postgresql://localhost/crmData";
    private static final String user = "postgres";
    private static final String password ="Pass@12345";

    public static void main( String[] args )
    {
        Scanner scanner= new Scanner(System.in);
        while (true){

            System.out.println("1. List Customers");
            System.out.println("2. Add Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Quit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();
            try{
              if(option==1){
                  listCustomers();
              }else if(option==2){
                  System.out.println("Add Customer");
                  System.out.println("Enter name: ");
                  String name = scanner.nextLine();
                  System.out.println("Enter age: ");
                  int age = scanner.nextInt();
                  scanner.nextLine();
                  addCustomer(name,age);
              } else if (option==3) {
                  System.out.println("Update Customer");
                  System.out.println("Enter Customer ID to Update: ");
                  int id = scanner.nextInt();
                  scanner.nextLine();
                  System.out.println("Enter name: ");
                  String name = scanner.nextLine();
                  System.out.print("Enter new age: ");
                  int age = scanner.nextInt();
                  scanner.nextLine();

                  updateCustomer(id,name, age);


              }
              else if(option==4){
                  System.out.print("Enter customer id to delete: ");
                  int id = scanner.nextInt();
                  scanner.nextLine();
                  deleteCustomer(id);

              }
              else if(option==5){
                  System.out.println("Goodbye!");
                  break;
              }
              else {
                  System.out.println("Invalid option!");
              }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private static Connection connect() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }

    private static void listCustomers()  throws SQLException{
        String SQL = "SELECT * FROM customers";
        try(Connection con= connect()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getInt("age"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void deleteCustomer(int id) throws SQLException{
        String SQL = "DELETE FROM customers WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Customer deleted successfully.");
            } else {
                System.out.println("Customer with such id doesn't exist.");
            }
        }
    }

    private static void updateCustomer(int id, String name, int age) throws SQLException {
        String SQL = "UPDATE customers SET name = ?, age = ? WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Customer updated successfully.");
            } else {
                System.out.println("Customer with such id doesn't exist.");
            }
        }
    }

    private static void addCustomer(String name, int age) throws SQLException{
        try(Connection con= connect()){
            PreparedStatement stmt = con.prepareStatement("INSERT INTO customers(name, age) VALUES (?, ?)");
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.executeUpdate();
            System.out.println("Customer added");
        }
    }


}
/**
 docker run --name some-postgres -e POSTGRES_PASSWORD=Pass@12345 -p 5432:5432  -d postgres

 CREATE TABLE customers (
 id SERIAL PRIMARY KEY,
 name VARCHAR(50),
 age INT );


 */