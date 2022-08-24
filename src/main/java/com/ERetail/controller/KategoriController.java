package com.ERetail.controller;

import com.ERetail.dto.KategoriDto.*;
import com.ERetail.service.KategoriService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/")
@Slf4j
public class KategoriController {

    @Autowired
    private KategoriService kategoriService;

    @SneakyThrows(Exception.class)
    @PostMapping(path = "/kategori", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createKategori(@RequestBody CreateKategoriDto dto) {
        log.info("api api/v1/kategori from POST is executed");
        return kategoriService.createKategori(dto);
    }

    @SneakyThrows(Exception.class)
    @PutMapping(path = "/kategori", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateKategori(@RequestBody UpdateKategoriDto dto) {
        log.info("api api/v1/kategori from PUT is executed");
        return kategoriService.updateKategori(dto);
    }

    @SneakyThrows(Exception.class)
    @GetMapping(path = "/kategori", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getKategori(@PathVariable(name = "id") Long id) {
        log.info("GET http://localhost:8081/api/v1/kategori{} is called...", id);
        return kategoriService.getKategori(id);
    }

    @SneakyThrows(Exception.class)
    @GetMapping(path = "/kategoris", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getKategoris() {

        log.info("GET http://localhost:8081/api/v1/regions is called...");

        return kategoriService.getKategoris();
    }

    @SneakyThrows(Exception.class)
    @DeleteMapping(path = "/kategori/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteKategori(@PathVariable(name = "id") Long id) {

        log.info("DELETE http://localhost:8081/api/v1/kategori/{} is called...", id);

        return kategoriService.deleteKategori(id);
    }
}
