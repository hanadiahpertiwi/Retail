package com.ERetail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BrandDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateBrandDto {

        private String nama_brand;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateBrandDto {

        private Long id_brand;
        private String nama_brand;
    }
}
