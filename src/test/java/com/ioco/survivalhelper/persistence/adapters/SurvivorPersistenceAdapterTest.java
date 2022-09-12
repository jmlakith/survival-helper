package com.ioco.survivalhelper.persistence.adapters;

import com.ioco.survivalhelper.persistence.entities.SurvivorEntity;
import com.ioco.survivalhelper.persistence.exception.SurvivorNotAvailableException;
import com.ioco.survivalhelper.persistence.exception.SurvivorPersistenceFailedException;
import com.ioco.survivalhelper.persistence.repositories.SurvivorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.PersistenceException;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

/**
 * @author Lakith Dharmarathna
 * Date : 12/09/2022
 */
class SurvivorPersistenceAdapterTest {
    @Mock
    SurvivorRepository survivorRepository;
    @InjectMocks
    SurvivorPersistenceAdapter survivorPersistenceAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    //Please note that I have written few sample unit tests since this is a timed test,
    // it might not cover every method, Thank you

    @Test
    void Test_UpdateLocation_when_SurvivorRecordIsNotAvailable_Then_SurvivorNotAvailableExceptionThrown() {

        when(survivorRepository.findById(anyString())).thenReturn(Optional.empty());

        SurvivorNotAvailableException exception = Assertions.assertThrows(SurvivorNotAvailableException.class,
                () -> survivorPersistenceAdapter.updateLocation(UUID.randomUUID(), 0d, 0d));

        Assertions.assertEquals("Survivor not available", exception.getMessage());
    }

    @Test
    void Test_UpdateIsInfected_when_SurvivorRecordIsNotAvailable_Then_SurvivorNotAvailableExceptionThrown() {

        when(survivorRepository.findById(anyString())).thenReturn(Optional.empty());

        SurvivorNotAvailableException exception = Assertions.assertThrows(SurvivorNotAvailableException.class,
                () -> survivorPersistenceAdapter.updateIsInfected(UUID.randomUUID(), true));

        Assertions.assertEquals("Survivor not available", exception.getMessage());
    }

    @Test
    void Test_UpdateLocation_when_JpaFailedToUpdateTheRecord_Then_SurvivorPersistenceFailedExceptionThrown() {

        when(survivorRepository.findById(anyString())).thenReturn(Optional.of(new SurvivorEntity()));
        when(survivorRepository.save(any(SurvivorEntity.class))).thenThrow(new PersistenceException());

        SurvivorPersistenceFailedException exception = Assertions.assertThrows(SurvivorPersistenceFailedException.class,
                () -> survivorPersistenceAdapter.updateLocation(UUID.randomUUID(), 0d, 0d));

        Assertions.assertEquals("Failed to update the survivor location", exception.getMessage());
    }

    @Test
    void Test_UpdateIsInfected_when_JpaFailedToUpdateTheRecord_Then_SurvivorPersistenceFailedExceptionThrown() {

        when(survivorRepository.findById(anyString())).thenReturn(Optional.of(new SurvivorEntity()));
        when(survivorRepository.save(any(SurvivorEntity.class))).thenThrow(new PersistenceException());

        SurvivorPersistenceFailedException exception = Assertions.assertThrows(SurvivorPersistenceFailedException.class,
                () -> survivorPersistenceAdapter.updateIsInfected(UUID.randomUUID(), true));

        Assertions.assertEquals("Failed to update the infected status", exception.getMessage());
    }

    @Test
    void Test_UpdateIsInfected_when_ValidDataFoundWithoutDbInterruptions_Then_saveMethodCalled() {

        when(survivorRepository.findById(anyString())).thenReturn(Optional.of(new SurvivorEntity()));

        survivorPersistenceAdapter.updateIsInfected(UUID.randomUUID(), true);

        verify(survivorRepository).save(any(SurvivorEntity.class));
    }

    @Test
    void Test_UpdateLocation_when_ValidDataFoundWithoutDbInterruptions_Then_saveMethodCalled() {

        when(survivorRepository.findById(anyString())).thenReturn(Optional.of(new SurvivorEntity()));

        survivorPersistenceAdapter.updateLocation(UUID.randomUUID(), 0d, 0d);

        verify(survivorRepository).save(any(SurvivorEntity.class));
    }

}
