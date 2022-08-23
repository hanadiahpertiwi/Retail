package com.ERetail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class RegionDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateRegionDto {

        private String namaRegion;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateRegionDto {

        private Long idRegion;
        private String namaRegion;
    }
}
