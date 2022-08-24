package com.ERetail.repository;

import com.ERetail.model.Kategori;
import com.ERetail.model.Produk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdukRepository extends JpaRepository<Produk, Long> {
    Produk findById(long id);
    public Produk findByNamaProduk(String namaProduk);
}
