package ru.netology.hibernate.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

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
