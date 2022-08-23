package com.ERetail.controller;

import com.ERetail.dto.BrandDto.*;
import com.ERetail.service.BrandService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/")
@Slf4j
public class BrandController {

    @Autowired
    private BrandService brandService;

    @SneakyThrows(Exception.class)
    @PostMapping(path = "/brand", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createBrand(@RequestBody CreateBrandDto dto) {
        log.info("api api/v1/brand from POST is executed");
        return brandService.createBrand(dto);
    }

    @SneakyThrows(Exception.class)
    @PutMapping(path = "/brand", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateBrand(@RequestBody UpdateBrandDto dto) {
        log.info("api api/v1/brand from PUT is executed");
        return brandService.updateBrand(dto);
    }

    @SneakyThrows(Exception.class)
    @GetMapping(path = "/brand/{namaBrand}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getBrand(@PathVariable(name = "namaBrand") String namaBrand) {
        log.info("GET http://localhost:8081/api/v1/brand{} is called...", namaBrand);
        return brandService.getBrand(namaBrand);
    }

    @SneakyThrows(Exception.class)
    @GetMapping(path = "/brands", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getBrands() {

        log.info("GET http://localhost:8081/api/v1/brands is called...");

        return brandService.getBrands();
    }

    @SneakyThrows(Exception.class)
    @DeleteMapping(path = "/brand/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteBrand(@PathVariable(name = "id") Long id) {

        log.info("DELETE http://localhost:8081/api/v1/brand/{} is called...", id);

        return brandService.deleteBrand(id);
    }
}
