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
    @Column(name = "id_produk", nullable = false, insertable = false, unique = true)
    private Long id_produk;

    @Column (name = "id_supplier", nullable = false)
    private Long id_supplier;

    @Column (name = "id_brand", nullable = false)
    private Long id_brand;

    @Column(name = "id_kategori", nullable = false)
    private Long id_kategori;

    @NotBlank
    @Column(name = "nama_produk", nullable = false, length = 255)
    private String nama_produk;

    @Column(name = "deskripsi_produk", nullable = false, length = 255)
    private String deskripsi_produk;

    @Column(name = "harga", nullable = false)
    private Integer harga;

    @Column(name = "stok", nullable = false)
    private Integer stok;
}
