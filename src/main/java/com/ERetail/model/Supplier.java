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
    @Column(name = "id_supplier", nullable = false, insertable = false, unique = true)
    private Long id_supplier;

    @NotBlank
    @Column(name = "nama_supplier", nullable = false, length = 255)
    private String nama_supplier;

    @Column (name = "email", nullable = false, length = 255)
    private String email;

    @Column (name = "no_telp", nullable = false, length = 255)
    private String no_telp;

    @Column(name = "alamat_supplier", nullable = false, length = 255)
    private String alamat_supplier;

    @Column(name = "id_region", nullable = false)
    private Long id_region;
}
