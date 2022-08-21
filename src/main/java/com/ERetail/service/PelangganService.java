package com.ERetail.service;

import com.ERetail.dto.CreatePelangganDto;
import com.ERetail.dto.UpdatePelangganDto;
import com.ERetail.errorresponse.ErrorResponse;
import com.ERetail.model.Pelanggan;
import com.ERetail.repository.PelangganRepository;
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

public class PelangganService {
    @Autowired
    private PelangganRepository pelangganRepository;


    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> create (CreatePelangganDto dto){

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String,Object> res = new HashMap<>();

        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setNama_pelanggan(dto.getNama_pelanggan().trim());
        pelanggan.setTtl(dto.getTtl());
        pelanggan.setNo_hp(dto.getNo_hp());
        pelanggan.setUmur(dto.getUmur());

        pelangganRepository.save(pelanggan);

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> update (UpdatePelangganDto dto){

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String,Object> res = new HashMap<String, Object>();

        Pelanggan pelanggan = pelangganRepository.findById(dto.getId());
        if(Optional.ofNullable(pelanggan).isPresent()){

            pelanggan.setNama_pelanggan(dto.getNama_pelanggan().trim());
            pelanggan.setUmur(dto.getUmur());
            pelanggan.setNo_hp(dto.getNo_hp());
            pelangganRepository.save(pelanggan);
        }else
        {
            ErrorResponse err = new ErrorResponse("999","Data Not Found");
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(err);
        }

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> getPelanggan (long id) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> res = new HashMap<>();
        val std = pelangganRepository.findById(id);
        if (Optional.ofNullable(std).isPresent()) {
            res.put("message", "success");
            res.put("data", std);
        } else {
            res.put("message", "failed");
            res.put("data", null);
        }
        res.put("code", HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> delete(long id) {

        Map<String, Object> res = new HashMap<String, Object>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        val std = pelangganRepository.findById(id);

        if (Optional.ofNullable(std).isPresent()) {

            pelangganRepository.deleteById(id);

            res.put("message", "success");
            res.put("data", std);

        } else {
            res.put("message", "failed");
            res.put("data", null);
        }

        res.put("code", HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
    }
}
