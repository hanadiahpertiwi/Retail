package com.ERetail.repository;

import com.ERetail.model.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategoriRepository extends JpaRepository<Kategori, Long> {
    Kategori findById(long id);
    public Kategori findByNamaKategori(String namaKategori);
}
