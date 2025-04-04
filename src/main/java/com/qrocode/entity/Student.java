package com.qrocode.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Author: Sandeep Singh
 * Date: 04/04/25
 */

@Entity
@Document(collection = "student")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Student {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;

}
