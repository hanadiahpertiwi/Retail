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
    private long id;

    @NotBlank
    @Column(name = "nama_pelanggan", nullable = false, length = 255)
    private String nama_pelanggan;

    @JoinColumn (name = "umur", nullable = false)
    private Integer umur;

    @JoinColumn (name = "ttl", nullable = false, columnDefinition = "DATE")
    private LocalDate ttl;

    @JoinColumn(name = "no_hp", nullable = false)
    private Integer no_hp;
}
