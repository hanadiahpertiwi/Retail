package com.ERetail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;


@Entity(name = "Pelanggan")
@Table(name = "pelanggan")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Pelanggan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, unique = true)
    private Long id;

    @Column(name = "username", nullable = false, length = 255)
    private String username;

    @Column(name = "nama_pelanggan", nullable = false, length = 255)
    private String nama_pelanggan;

    @Column (name = "umur", nullable = false)
    private Integer umur;

    @Column (name = "ttl", nullable = false, columnDefinition = "DATE")
    private LocalDate ttl;

    @Column (name = "jenis_kelamin", nullable = false, length = 255)
    private String jenis_kelamin;

    @Column(name = "alamat", nullable = false, length = 255)
    private String alamat;

    @Column(name = "no_hp", nullable = false)
    private Integer no_hp;

    @Column(name = "no_rekening", nullable = false)
    private Long no_rekening;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "saldo", nullable = false)
    private Long saldo;
}
