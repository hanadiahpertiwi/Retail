package com.ERetail.service;

import com.ERetail.dto.KategoriDto.*;
import com.ERetail.errorresponse.ErrorResponse;
import com.ERetail.model.Kategori;
import com.ERetail.model.Region;
import com.ERetail.repository.KategoriRepository;
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
public class KategoriService {
    @Autowired
    private KategoriRepository kategoriRepository;

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> createKategori(CreateKategoriDto dto){

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String,Object> res = new HashMap<>();

        Kategori kategori = new Kategori();
        kategori.setNama_kategori(dto.getNama_kategori().trim());

        kategoriRepository.save(kategori);

        res.put("code", HttpStatus.CREATED.value());
        res.put("message", "success");
        res.put("data", kategori);

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> getKategori(long id) {

        Map<String, Object> res = new HashMap<>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Kategori kategori = kategoriRepository.findById(id);

        if (Optional.ofNullable(kategori).isPresent()) {
            res.put("message", "success");
            res.put("data", kategori);
        } else {
            res.put("message", "failed");
            res.put("data", null);
        }
        res.put("code", HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> getKategoris() {

        Map<String, Object> res = new HashMap<String, Object>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        val kategoris = kategoriRepository.findAll();

        res.put("code", HttpStatus.OK.value());
        res.put("message", "success");
        res.put("data", kategoris);

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> updateKategori(UpdateKategoriDto dto){

        Map<String,Object> res = new HashMap<String, Object>();

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        Kategori kategori = kategoriRepository.findById(dto.getId()).orElse(null);
        if(Optional.ofNullable(kategori).isPresent()){

            kategori.setNama_kategori(dto.getNama_kategori().trim());

            kategoriRepository.save(kategori);

            res.put("message", "success");
            res.put("data", kategori);
        }else {
            ErrorResponse err = new ErrorResponse("999","Data Not Found");
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(err);
        }

        res.put("code", HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> deleteKategori(Long id) {

        Map<String, Object> res = new HashMap<String, Object>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Kategori kategori = kategoriRepository.findById(id).orElse(null);

        if (Optional.ofNullable(kategori).isPresent()) {

            kategoriRepository.deleteById(id);

            res.put("message", "success");
            res.put("data", kategori);

        } else {
            res.put("message", "failed");
            res.put("data", null);
        }

        res.put("code", HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
    }

}
