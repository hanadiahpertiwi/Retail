package com.ERetail.repository;

import com.ERetail.model.Pelanggan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PelangganRepository extends JpaRepository<Pelanggan, Long> {
      Pelanggan findById(long id);
}
