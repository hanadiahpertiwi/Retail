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
    @Column(name = "id_region", nullable = false, insertable = false, unique = true)
    private long id_region;

    @NotBlank
    @Column(name = "nama_region", nullable = false, length = 255)
    private String nama_region;
}
