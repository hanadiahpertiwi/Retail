package com.ERetail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity(name = "Region")
@Table(name = "region")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Region implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRegion", nullable = false, insertable = false, unique = true)
    private Long idRegion;

    @NotBlank
    @Column(name = "namaRegion", nullable = false, length = 255)
    private String namaRegion;
}
