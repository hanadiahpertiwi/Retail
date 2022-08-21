package com.ERetail.controller;


import com.ERetail.dto.CreatePelangganDto;
import com.ERetail.dto.UpdatePelangganDto;
import com.ERetail.service.PelangganService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/")
@Slf4j
public class PelangganController {

    @Autowired
    private PelangganService pelangganService;

    @SneakyThrows(Exception.class)
    @PostMapping(path = "/pelanggan", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody CreatePelangganDto dto) {
        log.info("api api/v1/pelanggan fro POST is executed");
        return pelangganService.create(dto);
    }

    @SneakyThrows(Exception.class)
    @PutMapping(path = "/pelanggan", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updatePelanggan(@RequestBody UpdatePelangganDto dto) {
        log.info("api api/v1/user fro PUT is executed");
        return pelangganService.update(dto);
    }

    @SneakyThrows(Exception.class)
    @GetMapping(path = "/pelanggan", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getPelanggan(@PathVariable(name = "id") Long id) {
        log.info("GET http://localhost:8081/api/v1/pelanggan{} is called...", id);
        return pelangganService.getPelanggan(id);
    }
}
