package com.ERetail;

import com.ERetail.model.Brand;
import com.ERetail.repository.BrandRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class BrandApplicationTests {
    @Autowired
    private BrandRepository brandRepository;

    @Test
    public  void testCreateBrand(){
        Brand brand = new Brand();

        brand.setNamaBrand("Suprime");

        Brand res = brandRepository.save(brand);

        assertNotNull(res);

    }
    @Test
    public void testGetBrand() {

        Brand res = brandRepository.findById(6);

        assertEquals("Test32", res.getNamaBrand().trim());
    }
    @Test
    public void testGetBrands() {

        List<Brand> res = brandRepository.findAll();

        assertThat(res).size().isGreaterThan(0);
    }

    @Test
    public void testUpdateBrand() {

        Brand brand = brandRepository.findById(6);

        brand.setNamaBrand("Tas");

        Brand res = brandRepository.save(brand);

        assertEquals("Tas", res.getNamaBrand().trim());
    }

    @Test
    public void testDeleteBrand() {

        Brand brand = brandRepository.findById(6);

        brandRepository.delete(brand);

        assertNull(brandRepository.findById(6));
    }

}
