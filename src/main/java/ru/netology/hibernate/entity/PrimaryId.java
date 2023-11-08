package ru.netology.hibernate.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "netology")
@Embeddable
public class PrimaryId implements Serializable {
    @Column(nullable = false, length = 15)
    private String name;
    @Column(nullable = false, length = 15)
    private String surname;
    @Column(nullable = false)
    private int age;
}
