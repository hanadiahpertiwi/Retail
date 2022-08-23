package com.ERetail.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePelangganDto {
    private String username;
    private String nama_pelanggan;
    private Integer umur;
    private LocalDate ttl;
    private String jenis_kelamin;
    private String alamat;
    private Integer no_hp;
    private Long no_rekening;
    private String email;
    private Long saldo;
}
