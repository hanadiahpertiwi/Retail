package com.ERetail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class KategoriDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateKategoriDto {

        private String nama_kategori;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateKategoriDto {

        private Long id;
        private String nama_kategori;
    }
}
