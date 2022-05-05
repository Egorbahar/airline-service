package com.godeltech.service.impl;

import com.godeltech.persistence.model.Airplane;
import com.godeltech.persistence.model.Category;
import com.godeltech.persistence.repository.AirplaneRepository;
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
class AirplaneServiceImplTest {
    private final static Long ID = 1L;
    private Airplane expectedAirplane;
    private List<Airplane> expectedAirplaneList;
    @Mock
    private AirplaneRepository airplaneRepository;
    @InjectMocks
    private AirplaneServiceImpl airplaneService;

    @BeforeEach
    void init() {
        Category category = Category.builder().id(ID).name("Transport").build();
        expectedAirplane = Airplane.builder().id(ID).name("Ан-24").category(category).build();
        expectedAirplaneList = new ArrayList<>(List.of(Airplane.builder().id(3L).category(category).build(),
                                                       Airplane.builder().id(4L).category(category).build()));
    }

    @Test
    void testFindById() {
        when(airplaneRepository.findById(ID)).thenReturn(Optional.of(expectedAirplane));

        Airplane actualAirPlane = airplaneService.findById(ID);

        verify(airplaneRepository, times(1)).findById(ID);

        Assertions.assertEquals(expectedAirplane, actualAirPlane);
    }

    @Test
    void testFindAll() {
        when(airplaneRepository.findAll()).thenReturn(expectedAirplaneList);

        List<Airplane> actualAirPlaneList = airplaneService.findAll();

        verify(airplaneRepository, times(1)).findAll();

        Assertions.assertEquals(expectedAirplaneList, actualAirPlaneList);
    }

    @Test
    void testSave() {
        when(airplaneRepository.save(expectedAirplane)).thenReturn(expectedAirplane);

        Airplane actualAirplane = airplaneService.save(expectedAirplane);

        verify(airplaneRepository, times(1)).save(expectedAirplane);

        Assertions.assertEquals(expectedAirplane, actualAirplane);
    }

    @Test
    void testDeleteById() {
        doReturn(Optional.of(expectedAirplane)).when(airplaneRepository).findById(ID);

        airplaneService.deleteById(ID);

        verify(airplaneRepository, times(1)).deleteById(ID);

    }

    @Test
    void testUpdate() {
        doReturn(Optional.of(expectedAirplane)).when(airplaneRepository).findById(ID);

        when(airplaneRepository.saveAndFlush(expectedAirplane)).thenReturn(expectedAirplane);

        Airplane actualAirplane = airplaneService.update(expectedAirplane);

        verify(airplaneRepository, times(1)).saveAndFlush(expectedAirplane);

        Assertions.assertEquals(expectedAirplane, actualAirplane);
    }
}