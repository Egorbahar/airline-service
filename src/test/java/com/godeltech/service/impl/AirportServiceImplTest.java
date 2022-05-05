package com.godeltech.service.impl;

import com.godeltech.persistence.model.Airport;
import com.godeltech.persistence.repository.AirportRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class AirportServiceImplTest {
    private final static Long ID = 1L;
    private Airport expectedAirport;
    private List<Airport> expectedAirportList;
    @Mock
    private AirportRepository airportRepository;
    @InjectMocks
    private AirportServiceImpl airportService;
    @BeforeEach
    void init() {

        expectedAirport = Airport.builder().id(ID).build();
        expectedAirportList = new ArrayList<>(List.of(Airport.builder().id(ID).build(),
                                                      Airport.builder().id(2L).build()));
    }
    @Test
    void testFindById() {
        when(airportRepository.findById(ID)).thenReturn(Optional.of(expectedAirport));

        Airport actualAirPort = airportService.findById(ID);

        verify(airportRepository, times(1)).findById(ID);

        Assertions.assertEquals(expectedAirport, actualAirPort);
    }

    @Test
    void testFindAll() {
        when(airportRepository.findAll()).thenReturn(expectedAirportList);

        List<Airport> actualAirPortList = airportService.findAll();

        verify(airportRepository, times(1)).findAll();

        Assertions.assertEquals(expectedAirportList, actualAirPortList);
    }

    @Test
    void testSave() {
        when(airportRepository.save(expectedAirport)).thenReturn(expectedAirport);

        Airport actualAirport = airportService.save(expectedAirport);

        verify(airportRepository, times(1)).save(expectedAirport);

        Assertions.assertEquals(expectedAirport, actualAirport);
    }

    @Test
    void testUpdate() {
        doReturn(Optional.of(expectedAirport)).when(airportRepository).findById(ID);

        when(airportRepository.saveAndFlush(expectedAirport)).thenReturn(expectedAirport);

        Airport actualAirport = airportService.update(expectedAirport);

        verify(airportRepository, times(1)).saveAndFlush(expectedAirport);

        Assertions.assertEquals(expectedAirport, actualAirport);
    }

    @Test
    void testDeleteById() {
        doReturn(Optional.of(expectedAirport)).when(airportRepository).findById(ID);

        airportService.deleteById(ID);

        verify(airportRepository, times(1)).deleteById(ID);
    }
}