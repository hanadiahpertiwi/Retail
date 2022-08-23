package com.ERetail.controller;

import com.ERetail.dto.SupplierDto.*;
import com.ERetail.service.SupplierService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/")
@Slf4j
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @SneakyThrows(Exception.class)
    @PostMapping(path = "/supplier", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createSupplier(@RequestBody CreateSupplierDto dto) {
        log.info("api api/v1/supplier from POST is executed");
        return supplierService.createSupplier(dto);
    }

    @SneakyThrows(Exception.class)
    @PutMapping(path = "/supplier", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateSupplier(@RequestBody UpdateSupplierDto dto) {
        log.info("api api/v1/supplier from PUT is executed");
        return supplierService.updateSuplier(dto);
    }

    @SneakyThrows(Exception.class)
    @GetMapping(path = "/supplier/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getSupplier(@PathVariable(name = "id") Long id) {
        log.info("GET http://localhost:8081/api/v1/supplier{} is called...", id);
        return supplierService.getSupplier(id);
    }

    @SneakyThrows(Exception.class)
    @GetMapping(path = "/suppliers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getSuppliers() {

        log.info("GET http://localhost:8081/api/v1/suppliers is called...");

        return supplierService.getSuppliers();
    }

    @SneakyThrows(Exception.class)
    @DeleteMapping(path = "/supplier/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteSupplier(@PathVariable(name = "id") Long id) {

        log.info("DELETE http://localhost:8081/api/v1/supplier/{} is called...", id);

        return supplierService.deleteSupplier(id);
    }
}
