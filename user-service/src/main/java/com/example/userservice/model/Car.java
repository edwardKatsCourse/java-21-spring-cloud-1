package com.example.userservice.model;

import lombok.*;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
@ToString
public class Car {

    @Id
    @GeneratedValue
    private Integer id;

    private String model;

    @ManyToOne
    @RestResource(path = "user")
    private User user;
}
