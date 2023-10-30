package ru.netology.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.*;

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
