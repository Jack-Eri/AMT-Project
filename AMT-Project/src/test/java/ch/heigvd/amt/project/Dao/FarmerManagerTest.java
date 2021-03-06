package ch.heigvd.amt.project.Dao;

import ch.heigvd.amt.project.datastore.exceptions.DuplicateKeyException;
import ch.heigvd.amt.project.datastore.exceptions.KeyNotFoundException;
import ch.heigvd.amt.project.model.Farmer;
import ch.heigvd.amt.project.services.FarmersManagerLocal;
import org.arquillian.container.chameleon.deployment.api.DeploymentParameters;
import org.arquillian.container.chameleon.deployment.maven.MavenBuild;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import java.sql.SQLException;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
@MavenBuild
@DeploymentParameters(testable = true)
public class FarmerManagerTest {

    @EJB
    FarmersManagerLocal farmersManager;

    @Test
    @Transactional(TransactionMode.ROLLBACK)
    public void itShouldBePossibleToCreateFarmer() throws SQLException {

        Farmer farmer = Farmer.builder().username("AndyMister")
                .firstName("Andy")
                .lastName("Moreno")
                .address("Javaland")
                .email("toto@mimi.com")
                .build();

        Farmer created = farmersManager.create(farmer);
        assertTrue(created != null);
    }

    @Test
    @Transactional(TransactionMode.ROLLBACK)
    public void itShouldBePossibleToCreateAndRetrieveAFarmerViaTheFarmerDAO() throws KeyNotFoundException, SQLException {
        Farmer farmer = Farmer.builder().username("AndyMister")
                .firstName("Andy")
                .lastName("Moreno")
                .address("Javaland")
                .email("toto@mimi.com")
                .build();

        Farmer farmerCreated = farmersManager.create(farmer);
        Farmer farmerLoadedWithId = farmersManager.findById(farmerCreated.getIdFarmer());


        assertNotNull(farmerLoadedWithId);
        assertEquals(farmerCreated.getIdFarmer(), farmerLoadedWithId.getIdFarmer());
    }

    @Test
    @Transactional(TransactionMode.ROLLBACK)
    public void itShouldBePossibleToDeleteAFarmer() throws KeyNotFoundException, SQLException {
        Farmer farmer = Farmer.builder().username("AndyMister")
                .firstName("Andy")
                .lastName("Moreno")
                .address("Javaland")
                .email("toto@mimi.com")
                .build();

        Farmer farmerCreated = farmersManager.create(farmer);
        Farmer farmerLoadedWithId = farmersManager.findById(farmerCreated.getIdFarmer());

        assertNotNull(farmerLoadedWithId);
        assertEquals(farmerCreated.getIdFarmer(), farmerLoadedWithId.getIdFarmer());

        farmersManager.deleteById(farmerLoadedWithId.getIdFarmer());
        boolean hasThrown = false;
        try {
            farmersManager.findById(farmerCreated.getIdFarmer());
        } catch (KeyNotFoundException e) {
            hasThrown = true;
        }
        assertTrue(hasThrown);
    }

    @Test
    @Transactional(TransactionMode.ROLLBACK)
    public void itShouldBePossibleToUpdateAFarmer() throws KeyNotFoundException, SQLException {
        Farmer farmer = Farmer.builder().username("AndyMister")
                .firstName("Andy")
                .lastName("Moreno")
                .address("Javaland")
                .email("toto@mimi.com")
                .build();

        farmersManager.create(farmer);
        Farmer farmerCreated = farmersManager.findByUser(farmer.getUsername());
        Farmer farmerModified = farmerCreated.toBuilder().firstName("Jack").lastName("Londra").build();

        farmersManager.update(farmerModified);

        Farmer farmerModifiedInDB = farmersManager.findByUser(farmer.getUsername());

        assertEquals(farmerModified, farmerModifiedInDB);
        assertNotEquals(farmerCreated, farmerModifiedInDB);
    }
}