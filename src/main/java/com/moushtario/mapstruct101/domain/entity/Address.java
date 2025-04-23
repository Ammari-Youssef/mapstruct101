package com.moushtario.mapstruct101.domain.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author dell
 * @version 1.0
 * @created 23/04/2025
 */
@Entity
@Table(name = "addresses")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street;
    private String city;
    private String zipCode;
}
