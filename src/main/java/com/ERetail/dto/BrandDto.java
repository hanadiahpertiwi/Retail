package com.ERetail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BrandDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateBrandDto {

        private String namaBrand;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateBrandDto {

        private Long idBrand;
        private String namaBrand;
    }
}
