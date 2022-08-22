package com.ERetail.controller;

import com.ERetail.dto.RegionDto.*;
import com.ERetail.service.RegionService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/")
@Slf4j
public class RegionController {

    @Autowired
    private RegionService regionService;

    @SneakyThrows(Exception.class)
    @PostMapping(path = "/region", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createRegion(@RequestBody CreateRegionDto dto) {
        log.info("api api/v1/region from POST is executed");
        return regionService.createRegion(dto);
    }

    @SneakyThrows(Exception.class)
    @PutMapping(path = "/region", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateRegion(@RequestBody UpdateRegionDto dto) {
        log.info("api api/v1/region from PUT is executed");
        return regionService.updateRegion(dto);
    }

    @SneakyThrows(Exception.class)
    @GetMapping(path = "/region", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getRegion(@PathVariable(name = "id") Long id) {
        log.info("GET http://localhost:8081/api/v1/region{} is called...", id);
        return regionService.getRegion(id);
    }

    @SneakyThrows(Exception.class)
    @GetMapping(path = "/regions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getRegions() {

        log.info("GET http://localhost:8081/api/v1/regions is called...");

        return regionService.getRegions();
    }

    @SneakyThrows(Exception.class)
    @DeleteMapping(path = "/region/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteRegion(@PathVariable(name = "id") Long id) {

        log.info("DELETE http://localhost:8081/api/v1/region/{} is called...", id);

        return regionService.deleteRegion(id);
    }
}
