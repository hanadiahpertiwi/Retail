package com.ERetail.service;

import com.ERetail.dto.RegionDto.*;
import com.ERetail.errorresponse.ErrorResponse;
import com.ERetail.model.Region;
import com.ERetail.repository.RegionRepository;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional(rollbackOn = Exception.class)
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> createRegion(CreateRegionDto dto){

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String,Object> res = new HashMap<>();

        Region region = new Region();
        region.setNamaRegion(dto.getNamaRegion().trim());

        regionRepository.save(region);

        res.put("code", HttpStatus.CREATED.value());
        res.put("message", "success");
        res.put("data", region);

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> getRegion(String namaRegion) {

        Map<String, Object> res = new HashMap<>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Region region = regionRepository.findByNamaRegion(namaRegion);

        if (Optional.ofNullable(region).isPresent()) {
            res.put("message", "success");
            res.put("data", region);
        } else {
            res.put("message", "failed");
            res.put("data", null);
        }
        res.put("code", HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> getRegions() {

        Map<String, Object> res = new HashMap<String, Object>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        val region = regionRepository.findAll();

        res.put("code", HttpStatus.OK.value());
        res.put("message", "success");
        res.put("data", region);

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> updateRegion(UpdateRegionDto dto){

        Map<String,Object> res = new HashMap<String, Object>();

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        Region region = regionRepository.findById(dto.getIdRegion()).orElse(null);
        if(Optional.ofNullable(region).isPresent()){

            region.setNamaRegion(dto.getNamaRegion().trim());

            regionRepository.save(region);

            res.put("message", "success");
            res.put("data", region);
        }else {
            ErrorResponse err = new ErrorResponse("999","Data Not Found");
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(err);
        }

        res.put("code", HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> deleteRegion(Long id) {

        Map<String, Object> res = new HashMap<String, Object>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Region region = regionRepository.findById(id).orElse(null);

        if (Optional.ofNullable(region).isPresent()) {

            regionRepository.deleteById(id);

            res.put("message", "success");
            res.put("data", region);

        } else {
            res.put("message", "failed");
            res.put("data", null);
        }

        res.put("code", HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
    }

}
