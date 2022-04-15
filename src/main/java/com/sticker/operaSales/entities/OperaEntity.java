package com.sticker.operaSales.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class OperaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int opera_id;
    private int theatre_id;
    private String name;
    private String definition;
    private int ageCategory;
    private int placesCount;
    private String places;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private TheatreEntity theatre;

}
