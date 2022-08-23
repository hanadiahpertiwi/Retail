package com.ERetail.service;

import com.ERetail.dto.BrandDto.*;
import com.ERetail.errorresponse.ErrorResponse;
import com.ERetail.model.Brand;
import com.ERetail.repository.BrandRepository;
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
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> createBrand(CreateBrandDto dto){

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String,Object> res = new HashMap<>();

        Brand brand = new Brand();
        brand.setNamaBrand(dto.getNamaBrand().trim());

        brandRepository.save(brand);

        res.put("code", HttpStatus.CREATED.value());
        res.put("message", "success");
        res.put("data", brand);

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> getBrand(String namaBrand) {

        Map<String, Object> res = new HashMap<>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        val brand = brandRepository.findByNamaBrand(namaBrand);

        if (Optional.ofNullable(brand).isPresent()) {
            res.put("message", "success");
            res.put("data", brand);
        } else {
            res.put("message", "failed");
            res.put("data", null);
        }
        res.put("code", HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> getBrands() {

        Map<String, Object> res = new HashMap<String, Object>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        val brand = brandRepository.findAll();

        res.put("code", HttpStatus.OK.value());
        res.put("message", "success");
        res.put("data", brand);

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> updateBrand(UpdateBrandDto dto){

        Map<String,Object> res = new HashMap<String, Object>();

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        Brand brand = brandRepository.findById(dto.getIdBrand()).orElse(null);
        if(Optional.ofNullable(brand).isPresent()){

            brand.setNamaBrand(dto.getNamaBrand().trim());

            brandRepository.save(brand);

            res.put("message", "success");
            res.put("data", brand);
        }else {
            ErrorResponse err = new ErrorResponse("999","Data Not Found");
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(err);
        }

        res.put("code", HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> deleteBrand(Long id) {

        Map<String, Object> res = new HashMap<String, Object>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        val brand = brandRepository.findById(id).orElse(null);

        if (Optional.ofNullable(brand).isPresent()) {

            brandRepository.deleteById(id);

            res.put("message", "success");
            res.put("data", brand);

        } else {
            res.put("message", "failed");
            res.put("data", null);
        }

        res.put("code", HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
    }

}
