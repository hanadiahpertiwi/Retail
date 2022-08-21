package com.ERetail.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePelangganDto {
    private String nama_pelanggan;
    private Integer umur;
    private LocalDate ttl;
    private Integer no_hp;
}