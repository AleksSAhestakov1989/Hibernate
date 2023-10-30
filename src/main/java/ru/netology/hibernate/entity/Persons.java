package ru.netology.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "netology")
public class Persons {
    @EmbeddedId
    private PrimaryId primaryId;
    @Column(name = "phone_number", columnDefinition = "varchar(15) default 'XXX-XXX'")
    private String phoneNumber;
    @Column(name = "city_of_living")
    private String cityOfLiving;

}
