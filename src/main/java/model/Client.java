package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Client {


    private String firstName, lastName, email, address, username, password;
    private String phoneNumber;


    public Client(String firstName, String lastName, String phoneNumber, String email,
                  String address, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.username = username;
        this.password = password;
        createTable();
    }


    //Test DataBase
    public void createTable() {
        String url = "jdbc:sqlite:Database.db";
        String sql = "CREATE TABLE IF NOT EXISTS clients (\n"
                + "    FirstName TEXT NOT NULL,\n"
                + "    LastName TEXT NOT NULL,\n"
                + "    Email TEXT NOT NULL,\n"
                + "    PhoneNumber TEXT NOT NULL,\n"
                + "    Address TEXT NOT NULL,\n"
                + "    UserName TEXT PRIMARY KEY,\n"
                + "    Password TEXT NOT NULL\n"
                + ");";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
            System.out.println("Added successfully!");
        } catch (SQLException e) {
            System.out.println("Exception message: " + e.getMessage());
            e.printStackTrace();
        }

        sql = "INSERT INTO clients (FirstName, LastName, Email, PhoneNumber, Address, UserName, Password) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.getFirstName());
            pstmt.setString(2, this.getLastName());
            pstmt.setString(3, this.getEmail());
            pstmt.setString(4, this.getPhoneNumber());
            pstmt.setString(5, this.getAddress());
            pstmt.setString(6, this.getUsername());
            pstmt.setString(7, this.getPassword());
            pstmt.executeUpdate();
            System.out.println("Client added successfully!");
        } catch (SQLException e) {
            System.out.println("Exception message: " + e.getMessage());
            e.printStackTrace();
        }
    }




    //Getters and Setters

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


//  soon

    public void printInfo(){

    }
//  soon


}
