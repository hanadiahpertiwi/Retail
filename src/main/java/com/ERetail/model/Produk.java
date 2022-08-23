package com.ERetail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity(name = "Produk")
@Table(name = "produk")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Produk implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduk", nullable = false, insertable = false, unique = true)
    private Long idProduk;

    @Column (name = "idSupplier", nullable = false)
    private Long idSupplier;

    @Column (name = "idBrand", nullable = false)
    private Long idBrand;

    @Column(name = "idKategori", nullable = false)
    private Long idKategori;

    @NotBlank
    @Column(name = "namaProduk", nullable = false, length = 255)
    private String namaProduk;

    @Column(name = "deskripsiProduk", nullable = false, length = 255)
    private String deskripsiProduk;

    @Column(name = "harga", nullable = false)
    private Integer harga;

    @Column(name = "stok", nullable = false)
    private Integer stok;
}
