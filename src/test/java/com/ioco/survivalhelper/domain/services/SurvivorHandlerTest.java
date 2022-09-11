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
    void When_testGetSurvivorReport_Then_returnReport() {

        List<Survivor> infectedSurvivors = List.of(new Survivor(null, "name1", 0, 0d, 0d, true,
                List.of(new SurvivorResources("item", "comment"))));
        List<Survivor> nonInfectedSurvivors = List.of(new Survivor(null, "name2", 0, 0d, 0d, true,
                List.of(new SurvivorResources("item", "comment"))));

        when(survivorPersistencePort.getSurvivors(true)).thenReturn(infectedSurvivors);
        when(survivorPersistencePort.getSurvivors(false)).thenReturn(nonInfectedSurvivors);

        SurvivorReport result = survivorHandler.getSurvivorReport();

        Assertions.assertEquals(new SurvivorReport(50.0d, 50.0d,
                List.of(new Survivor(null, "name1", 0, 0d, 0d, true,
                        List.of(new SurvivorResources("item", "comment")))),
                List.of(new Survivor(null, "name2", 0, 0d, 0d, true,
                        List.of(new SurvivorResources("item", "comment"))))), result);
    }
}