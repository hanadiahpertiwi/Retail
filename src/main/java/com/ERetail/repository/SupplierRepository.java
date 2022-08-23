package com.ERetail.repository;

import com.ERetail.model.Region;
import com.ERetail.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Supplier findById(long id);

    Region findByNamaSupplier(String namaSupplier);
}
