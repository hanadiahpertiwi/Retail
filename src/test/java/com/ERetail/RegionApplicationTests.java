package com.ERetail;

import com.ERetail.model.Region;
import com.ERetail.repository.RegionRepository;
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
class RegionApplicationTests {
    @Autowired
    private RegionRepository regionRepository;

    @Test
    public  void testCreateRegion(){
        Region region = new Region();

        region.setNamaRegion("Bandung");

        Region res = regionRepository.save(region);

        assertNotNull(res);

    }
    @Test
    public void testGetRegion() {

        Region res = regionRepository.findByNamaRegion("Jakarta");

        assertEquals("Jakarta", res.getNamaRegion().trim());
    }
    @Test
    public void testGetRegions() {

        List<Region> res = regionRepository.findAll();

        assertThat(res).size().isGreaterThan(0);
    }

    @Test
    public void testUpdateRegion() {

        Region region = regionRepository.findByNamaRegion("Jakarta");

        region.setNamaRegion("Palembang");

        Region res = regionRepository.save(region);

        assertEquals("Palembang", res.getNamaRegion().trim());
    }

    @Test
    public void testDeleteRegion() {

        Region region = regionRepository.findByNamaRegion("Jakarta");

        regionRepository.delete(region);

        assertNull(regionRepository.findByNamaRegion("Jakarta"));
    }

}
