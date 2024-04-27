package com.mycompany.propertymanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="title", nullable = false)
    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private String price;
    private String address;
    @ManyToOne(fetch = FetchType.EAGER)//It will not fetch the user while fetching the property.
    //By default the fetch type is lazy
    @JoinColumn(name="USER_ID", nullable = false)
    private UserEntity userEntity;
}
