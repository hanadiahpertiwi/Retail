package com.ERetail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity(name = "Kategori")
@Table(name = "kategori")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Kategori implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idKategori", nullable = false, insertable = false, unique = true)
    private Long idKategori;

    @NotEmpty
    @Column(name = "namaKategori", nullable = false, length = 255)
    private String namaKategori;
}
