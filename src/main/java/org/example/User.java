package org.example;

/**
 * By the software team of UOMSystemX
 *
 */

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @Column(name = "ID", nullable = false, length = 11)
    private int id;

    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;


    //  getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//  toString method to fetch data from database


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
