package com.ERetail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity(name = "Brand")
@Table(name = "brand")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Brand implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBrand", nullable = false, insertable = false, unique = true)
    private Long idBrand;

    @NotBlank
    @Column(name = "namaBrand", nullable = false, length = 255)
    private String namaBrand;
}
