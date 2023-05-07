package model;

public class Client {


    private String firstName, lastName, email, address, username, password;
    private int phoneNumber;


    public Client(String firstName, String lastName, int phoneNumber, String email,
                  String address, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public void printInfo(){

    }

    public String getFirstName() {
        return firstName;
    }

//  soon


}
