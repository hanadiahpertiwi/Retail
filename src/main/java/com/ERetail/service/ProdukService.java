package com.ERetail.service;

import com.ERetail.dto.ProdukDto.*;
import com.ERetail.errorresponse.ErrorResponse;
import com.ERetail.model.Produk;
import com.ERetail.repository.BrandRepository;
import com.ERetail.repository.KategoriRepository;
import com.ERetail.repository.ProdukRepository;
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
public class ProdukService {
    @Autowired
    private ProdukRepository produkRepository;
    
    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> createProduk(CreateProdukDto dto){

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String,Object> res = new HashMap<>();

        Produk produk = new Produk();
        produk.setIdSupplier(dto.getIdSupplier());
        produk.setIdBrand(dto.getIdBrand());
        produk.setIdKategori(dto.getIdKategori());
        produk.setNamaProduk(dto.getNamaProduk().trim());
        produk.setDeskripsiProduk(dto.getDeskripsiProduk());
        produk.setHarga(dto.getHarga());
        produk.setStok(dto.getStok());

        produkRepository.save(produk);

        res.put("code", HttpStatus.CREATED.value());
        res.put("message", "success");
        res.put("data", produk);

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> getProduk(Long id) {

        Map<String, Object> res = new HashMap<>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        val produk = produkRepository.findById(id);

        if (Optional.ofNullable(produk).isPresent()) {
            res.put("message", "success");
            res.put("data", produk);
        } else {
            res.put("message", "failed");
            res.put("data", null);
        }
        res.put("code", HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> getProduks() {

        Map<String, Object> res = new HashMap<String, Object>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        val produk = produkRepository.findAll();

        res.put("code", HttpStatus.OK.value());
        res.put("message", "success");
        res.put("data", produk);

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> updateProduk(UpdateProdukDto dto){

        Map<String,Object> res = new HashMap<String, Object>();

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        val produk = produkRepository.findById(dto.getIdProduk()).orElse(null);
        if(Optional.ofNullable(produk).isPresent()){

            produk.setIdSupplier(dto.getIdSupplier());
            produk.setIdBrand(dto.getIdBrand());
            produk.setIdKategori(dto.getIdKategori());
            produk.setNamaProduk(dto.getNamaProduk().trim());
            produk.setDeskripsiProduk(dto.getDeskripsiProduk());
            produk.setHarga(dto.getHarga());
            produk.setStok(dto.getStok());

            produkRepository.save(produk);

            res.put("message", "success");
            res.put("data", produk);
        }else {
            ErrorResponse err = new ErrorResponse("999","Data Not Found");
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(err);
        }

        res.put("code", HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> deleteProduk(Long id) {

        Map<String, Object> res = new HashMap<String, Object>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        val produk = produkRepository.findById(id).orElse(null);

        if (Optional.ofNullable(produk).isPresent()) {

            produkRepository.deleteById(id);

            res.put("message", "success");
            res.put("data", produk);

        } else {
            res.put("message", "failed");
            res.put("data", null);
        }

        res.put("code", HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
    }

}
