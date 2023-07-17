package com.sg.SuperHero.dao;

import com.sg.SuperHero.dto.SuperHuman;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class) // Use SpringRunner as the test runner
@SpringBootTest // Load the Spring application context for testing
@Transactional // Use transactions for each test method
public class SuperHumanDaoImplTest {

    @Autowired
    private SuperHumanDao superHumanDao; // The DAO to be tested

    @Test
    public void testGetById() {
        // Arrange: Create a SuperHuman entity and insert it into the database
        SuperHuman superhuman = new SuperHuman("Superman", "The Last Son of Krypton", true, 1);
        superHumanDao.create(superhuman);

        // Act: Get the inserted SuperHuman by ID
        SuperHuman retrievedSuperhuman = superHumanDao.getById(superhuman.getSuperhumanId());

        // Assert: Check if the retrieved SuperHuman matches the inserted one
        assertEquals(superhuman, retrievedSuperhuman);
    }

    @Test
    public void testGetAll() {
        // Arrange: Create multiple SuperHuman entities and insert them into the database
        SuperHuman superhuman1 = new SuperHuman("Superman", "The Last Son of Krypton", true, 1);
        SuperHuman superhuman2 = new SuperHuman("Doctor Strange", "Master of the Mystic Arts", true, 2);
        superHumanDao.create(superhuman1);
        superHumanDao.create(superhuman2);

        // Act: Get all SuperHumans from the database
        List<SuperHuman> superHumans = superHumanDao.getAll();

        // Assert: Check if the list contains the inserted SuperHumans
        assertTrue(superHumans.contains(superhuman1));
        assertTrue(superHumans.contains(superhuman2));
    }

    @Test
    public void testCreate() {
        // Arrange: Create a SuperHuman entity
        SuperHuman superhuman = new SuperHuman("Thanos", "The Mad Titan", false, 3);

        // Act: Insert the SuperHuman into the database
        superHumanDao.create(superhuman);

        // Assert: Check if the SuperHuman was successfully inserted by fetching it by ID
        SuperHuman retrievedSuperhuman = superHumanDao.getById(superhuman.getSuperhumanId());
        assertEquals(superhuman, retrievedSuperhuman);
    }

    @Test
    public void testUpdate() {
        // Arrange: Create a SuperHuman entity and insert it into the database
        SuperHuman superhuman = new SuperHuman("Loki", "God of Mischief", false, 4);
        superHumanDao.create(superhuman);

        // Act: Update the SuperHuman's description
        superhuman.setSuperhumanDesc("Trickster God");
        superHumanDao.update(superhuman);

        // Assert: Check if the SuperHuman's description was updated correctly
        SuperHuman updatedSuperhuman = superHumanDao.getById(superhuman.getSuperhumanId());
        assertEquals("Trickster God", updatedSuperhuman.getSuperhumanDesc());
    }

    @Test
    public void testDelete() {
        // Arrange: Create a SuperHuman entity and insert it into the database
        SuperHuman superhuman = new SuperHuman("Scarlet Witch", "Reality Warping Witch", false, 5);
        superHumanDao.create(superhuman);

        // Act: Delete the SuperHuman from the database
        superHumanDao.delete(superhuman.getSuperhumanId());

        // Assert: Check if the SuperHuman was deleted by trying to fetch it by ID (should be null)
        SuperHuman deletedSuperhuman = superHumanDao.getById(superhuman.getSuperhumanId());
        assertNull(deletedSuperhuman);
    }
}
