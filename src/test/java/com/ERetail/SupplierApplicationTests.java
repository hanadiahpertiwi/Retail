package com.ERetail;

import com.ERetail.model.Supplier;
import com.ERetail.repository.SupplierRepository;
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
class SupplierApplicationTests {
    @Autowired
    private SupplierRepository supplierRepository;

    @Test
    public  void testCreateSupplier(){
        Supplier supplier = new Supplier();

        supplier.setNamaSupplier("Supplier 1");
        supplier.setEmail("supplier@gmail.com");
        supplier.setNoTelp("081245122");
        supplier.setAlamatSupplier("Jl. Mawar");
        supplier.setIdRegion(1L);

        Supplier res = supplierRepository.save(supplier);

        assertNotNull(res);

    }
    @Test
    public void testGetSupplier() {

        Supplier res = supplierRepository.findById(6);

        assertEquals("Test32", res.getNamaSupplier().trim());
    }
    @Test
    public void testGetSuppliers() {

        List<Supplier> res = supplierRepository.findAll();

        assertThat(res).size().isGreaterThan(0);
    }

    @Test
    public void testUpdateSupplier() {

        Supplier supplier = supplierRepository.findById(6);

        supplier.setNamaSupplier("Supplier 2");
        supplier.setEmail("supplier@gmail.com");
        supplier.setNoTelp("081245122");
        supplier.setAlamatSupplier("Jl. Mawar");
        supplier.setIdRegion(1L);

        Supplier res = supplierRepository.save(supplier);

        assertEquals("Supplier 2", res.getNamaSupplier().trim());
    }

    @Test
    public void testDeleteSupplier() {

        Supplier supplier = supplierRepository.findById(1);

        supplierRepository.delete(supplier);

        assertNull(supplierRepository.findById(1));
    }

}
