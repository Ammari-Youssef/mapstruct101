package com.moushtario.mapstruct101.domain.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author dell
 * @version 1.0
 * @created 22/04/2025
 */
@Entity
@Table(name = "people")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
