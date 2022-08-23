package com.ERetail.service;

import com.ERetail.dto.SupplierDto.*;
import com.ERetail.errorresponse.ErrorResponse;
import com.ERetail.model.Supplier;
import com.ERetail.repository.SupplierRepository;
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
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> createSupplier(CreateSupplierDto dto){

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String,Object> res = new HashMap<>();

        Supplier supplier = new Supplier();
        supplier.setNama_supplier(dto.getNama_supplier().trim());
        supplier.setEmail(dto.getEmail().trim());
        supplier.setNo_telp(dto.getNo_telp().trim());
        supplier.setAlamat_supplier(dto.getAlamat_supplier().trim());
        supplier.setId_region(dto.getId_region());

        supplierRepository.save(supplier);

        res.put("code", HttpStatus.CREATED.value());
        res.put("message", "success");
        res.put("data", supplier);

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> getSupplier(Long id) {

        Map<String, Object> res = new HashMap<>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        val supplier = supplierRepository.findById(id);

        if (Optional.ofNullable(supplier).isPresent()) {
            res.put("message", "success");
            res.put("data", supplier);
        } else {
            res.put("message", "failed");
            res.put("data", null);
        }
        res.put("code", HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> getSuppliers() {

        Map<String, Object> res = new HashMap<String, Object>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        val supplier = supplierRepository.findAll();

        res.put("code", HttpStatus.OK.value());
        res.put("message", "success");
        res.put("data", supplier);

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> updateSuplier(UpdateSupplierDto dto){

        Map<String,Object> res = new HashMap<String, Object>();

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        Supplier supplier = supplierRepository.findById(dto.getId_supplier()).orElse(null);
        if(Optional.ofNullable(supplier).isPresent()){

            supplier.setNama_supplier(dto.getNama_supplier().trim());
            supplier.setEmail(dto.getEmail().trim());
            supplier.setNo_telp(dto.getNo_telp().trim());
            supplier.setAlamat_supplier(dto.getAlamat_supplier().trim());
            supplier.setId_region(dto.getId_region());

            supplierRepository.save(supplier);

            res.put("message", "success");
            res.put("data", supplier);
        }else {
            ErrorResponse err = new ErrorResponse("999","Data Not Found");
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(err);
        }

        res.put("code", HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> deleteSupplier(Long id) {

        Map<String, Object> res = new HashMap<String, Object>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        val supplier = supplierRepository.findById(id).orElse(null);

        if (Optional.ofNullable(supplier).isPresent()) {

            supplierRepository.deleteById(id);

            res.put("message", "success");
            res.put("data", supplier);

        } else {
            res.put("message", "failed");
            res.put("data", null);
        }

        res.put("code", HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
    }

}
