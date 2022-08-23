package com.ERetail;

import com.ERetail.model.Kategori;
import com.ERetail.repository.KategoriRepository;
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
class KategoriApplicationTests {
    @Autowired
    private KategoriRepository kategoriRepository;

    @Test
    public  void testCreateKategori(){
        Kategori kategori = new Kategori();

        kategori.setNamaKategori("Kategori 1");

        Kategori res = kategoriRepository.save(kategori);

        assertNotNull(res);

    }
    @Test
    public void testGetKategori() {

        Kategori res = kategoriRepository.findByNamaKategori("Tas");

        assertEquals("Tas", res.getNamaKategori().trim());
    }
    @Test
    public void testGetKategoris() {

        List<Kategori> res = kategoriRepository.findAll();

        assertThat(res).size().isGreaterThan(0);
    }

    @Test
    public void testUpdateKategori() {

        Kategori kategori = kategoriRepository.findByNamaKategori("Tas");

        kategori.setNamaKategori("Tas Tali");

        Kategori res = kategoriRepository.save(kategori);

        assertEquals("Tas Tali", res.getNamaKategori().trim());
    }

    @Test
    public void testDeleteKategori() {

        Kategori kategori = kategoriRepository.findByNamaKategori("Tas");

        kategoriRepository.delete(kategori);

        assertNull(kategoriRepository.findByNamaKategori("Tas"));
    }

}
