package com.ERetail.repository;

import com.ERetail.model.Brand;
import com.ERetail.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    Brand findById(long id);

    Region findByNamaBrand(String namaBrand);
}
