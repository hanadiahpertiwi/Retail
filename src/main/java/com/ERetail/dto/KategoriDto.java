package com.ERetail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class KategoriDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateKategoriDto {

        private String namaKategori;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateKategoriDto {

        private Long idKategori;
        private String namaKategori;
    }
}
