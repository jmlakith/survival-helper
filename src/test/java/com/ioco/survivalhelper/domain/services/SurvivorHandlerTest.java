package com.ioco.survivalhelper.domain.services;

import com.ioco.survivalhelper.domain.dto.Survivor;
import com.ioco.survivalhelper.domain.dto.SurvivorReport;
import com.ioco.survivalhelper.domain.dto.SurvivorResources;
import com.ioco.survivalhelper.domain.ports.out.SurvivorPersistencePort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author Lakith Dharmarathna
 * Date : 12/09/2022
 */
class SurvivorHandlerTest {
    @Mock
    SurvivorPersistencePort survivorPersistencePort;
    @InjectMocks
    SurvivorHandler survivorHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddSurvivors() {
        survivorHandler.addSurvivors(Arrays.<Survivor>asList(new Survivor(null, "name", 0, 0d, 0d, true, Arrays.<SurvivorResources>asList(new SurvivorResources("item", "comment")))));
    }

    @Test
    void testGetSurvivors() {
        when(survivorPersistencePort.getSurvivors(anyBoolean())).thenReturn(Arrays.<Survivor>asList(new Survivor(null, "name", 0, 0d, 0d, true, Arrays.<SurvivorResources>asList(new SurvivorResources("item", "comment")))));

        List<Survivor> result = survivorHandler.getSurvivors(Boolean.TRUE);
        Assertions.assertEquals(Arrays.<Survivor>asList(new Survivor(null, "name", 0, 0d, 0d, true, Arrays.<SurvivorResources>asList(new SurvivorResources("item", "comment")))), result);
    }

    @Test
    void testUpdateLocation() {
        survivorHandler.updateLocation(null, 0d, 0d);
    }

    @Test
    void testUpdateIsInfected() {
        survivorHandler.updateIsInfected(null, true);
    }

    @Test
    void testGetSurvivorReport() {
        when(survivorPersistencePort.getSurvivors(anyBoolean())).thenReturn(Arrays.<Survivor>asList(new Survivor(null, "name", 0, 0d, 0d, true, Arrays.<SurvivorResources>asList(new SurvivorResources("item", "comment")))));

        SurvivorReport result = survivorHandler.getSurvivorReport();
        Assertions.assertEquals(new SurvivorReport(0d, 0d, Arrays.<Survivor>asList(new Survivor(null, "name", 0, 0d, 0d, true, Arrays.<SurvivorResources>asList(new SurvivorResources("item", "comment")))), Arrays.<Survivor>asList(new Survivor(null, "name", 0, 0d, 0d, true, Arrays.<SurvivorResources>asList(new SurvivorResources("item", "comment"))))), result);
    }
}