package com.ERetail.controller;

import com.ERetail.dto.ProdukDto.*;
import com.ERetail.service.ProdukService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/")
@Slf4j
public class ProdukController {

    @Autowired
    private ProdukService produkService;

    @SneakyThrows(Exception.class)
    @PostMapping(path = "/produk", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createProduk(@RequestBody CreateProdukDto dto) {
        log.info("api api/v1/produk from POST is executed");
        return produkService.createProduk(dto);
    }

    @SneakyThrows(Exception.class)
    @PutMapping(path = "/produk", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateProduk(@RequestBody UpdateProdukDto dto) {
        log.info("api api/v1/produk from PUT is executed");
        return produkService.updateProduk(dto);
    }

    @SneakyThrows(Exception.class)
    @GetMapping(path = "/produk/{nama_produk}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getProduk(@PathVariable(name = "nama_produk") Long id) {
        log.info("GET http://localhost:8081/api/v1/produk{} is called...", id);
        return produkService.getProduk(id);
    }

    @SneakyThrows(Exception.class)
    @GetMapping(path = "/produks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getProduks() {

        log.info("GET http://localhost:8081/api/v1/produks is called...");

        return produkService.getProduks();
    }

    @SneakyThrows(Exception.class)
    @DeleteMapping(path = "/produk/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteProduk(@PathVariable(name = "id") Long id) {

        log.info("DELETE http://localhost:8081/api/v1/produk/{} is called...", id);

        return produkService.deleteProduk(id);
    }
}
