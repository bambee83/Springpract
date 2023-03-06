package com.example.jpabasiclivelecture230305.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Course  {

    @Id
    private Long id;
    private String title;
    private String instructors;
    private Double cost;

}
