package com.ERetail;

import com.ERetail.model.TransaksiDetil;
import com.ERetail.repository.TransaksiDetilRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TransaksiDetilAplicationTest {
    @Autowired
    private TransaksiDetilRepository transaksiDetilRepository;

    @Test
    public  void testCreateTransaksiDetil(){
        TransaksiDetil transaksiDetil = new TransaksiDetil();

        transaksiDetil.setSub_total(1000);
        transaksiDetil.setQuantity(2);
        transaksiDetil.setHarga(1000);


        TransaksiDetil res = transaksiDetilRepository.save(transaksiDetil);

        assertNotNull(res);

    }

    @Test
    public void testGetTransaksiDetil() {

        TransaksiDetil res = transaksiDetilRepository.findById(1);

        assertEquals(1000, res.getHarga());
    }

    @Test
    public void testGetTransaksiDetils() {

        List<TransaksiDetil> res = transaksiDetilRepository.findAll();

        assertThat(res).size().isGreaterThan(0);
    }

    @Test
    public void testUpdateTransaksiDetil() {

        TransaksiDetil transaksiDetil = transaksiDetilRepository.findById(1);

        transaksiDetil.setHarga(100);

        TransaksiDetil res = transaksiDetilRepository.save(transaksiDetil);

        assertEquals(100, res.getHarga());
    }

    @Test
    public void testDeleteTransaksiDetil() {

        TransaksiDetil transaksiDetil = transaksiDetilRepository.findById(1);

        transaksiDetilRepository.delete(transaksiDetil);

        assertNull(transaksiDetilRepository.findById(1));
    }
}
