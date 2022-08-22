package com.ERetail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class RegionDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateRegionDto {

        private String nama_region;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateRegionDto {

        private Long id;
        private String nama_region;
    }
}
