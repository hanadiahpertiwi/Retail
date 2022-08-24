package com.ERetail;

import com.ERetail.model.Produk;
import com.ERetail.repository.ProdukRepository;
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
class ProdukApplicationTests {
    @Autowired
    private ProdukRepository produkRepository;

    @Test
    public  void testCreateProduk(){
        Produk produk = new Produk();

        produk.setIdSupplier(1L);
        produk.setIdBrand(1L);
        produk.setIdKategori(1L);
        produk.setNamaProduk("Jeans");
        produk.setDeskripsiProduk("Baru");
        produk.setStok(5);
        produk.setHarga(50000);

        Produk res = produkRepository.save(produk);

        assertNotNull(res);

    }
    @Test
    public void testGetProduk() {

        Produk res = produkRepository.findByNamaProduk("Test Produk");

        assertEquals("Test Produk", res.getNamaProduk().trim());
    }
    @Test
    public void testGetProduks() {

        List<Produk> res = produkRepository.findAll();

        assertThat(res).size().isGreaterThan(0);
    }

    @Test
    public void testUpdateProduk() {

        Produk produk = produkRepository.findByNamaProduk("Test Produk");

        produk.setIdSupplier(1L);
        produk.setIdBrand(1L);
        produk.setIdKategori(1L);
        produk.setNamaProduk("Sepatu");
        produk.setDeskripsiProduk("Baru");
        produk.setStok(5);
        produk.setHarga(50000);

        Produk res = produkRepository.save(produk);

        assertEquals("Sepatu", res.getNamaProduk().trim());
    }

    @Test
    public void testDeleteProduk() {

        Produk produk = produkRepository.findById(1);

        produkRepository.delete(produk);

        assertNull(produkRepository.findById(6));
    }

}
