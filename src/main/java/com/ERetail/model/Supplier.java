package com.ERetail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;


@Entity(name = "Supplier")
@Table(name = "supplier")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Supplier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSupplier", nullable = false, insertable = false, unique = true)
    private Long idSupplier;

    @NotBlank
    @Column(name = "namaSupplier", nullable = false, length = 255)
    private String namaSupplier;

    @Column (name = "email", nullable = false, length = 255)
    private String email;

    @Column (name = "noTelp", nullable = false, length = 255)
    private String noTelp;

    @Column(name = "alamatSupplier", nullable = false, length = 255)
    private String alamatSupplier;

    @Column(name = "idRegion", nullable = false)
    private Long idRegion;
}
