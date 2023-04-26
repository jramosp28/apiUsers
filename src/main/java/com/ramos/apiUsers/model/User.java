package com.ramos.apiUsers.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *
 * @author javierrampob
 */
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id @GeneratedValue 
    private Integer id;
    private String name;
    private String lastName;
    private String lastName2;
    private String email;
    private String phone;
    private String address;
    private String city;
    private Date date;
    private boolean bike;
    private String bikeModel;
}
