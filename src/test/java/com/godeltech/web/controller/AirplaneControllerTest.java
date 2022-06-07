package com.godeltech.web.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.godeltech.facade.AirplaneFacade;
import com.godeltech.web.dto.request.AirplaneRequestDto;
import com.godeltech.web.dto.response.AirplaneResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AirplaneController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class,
        useDefaultFilters = false)
@Import(AirplaneController.class)
public class AirplaneControllerTest {
    public static final String URL = "/airplanes";
    public static final Long ID = 2L;
    @MockBean
    private AirplaneFacade airplaneFacade;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private List<AirplaneResponseDto> airplaneResponseDtoList;

    @BeforeEach()
    void setUp() throws Exception {
        this.airplaneResponseDtoList = new ArrayList<>();
        this.airplaneResponseDtoList.add(new AirplaneResponseDto(1L, "An-25", 23D, 1L, "Transport"));
        this.airplaneResponseDtoList.add(new AirplaneResponseDto(2L, "An-26", 12D, 2L, "Passenger"));
        this.airplaneResponseDtoList.add(new AirplaneResponseDto(3L, "An-27", 11D, 3L, "Mail"));
    }

    @Test
    public void testFindAll() throws Exception {

        when(airplaneFacade.findAll())
                .thenReturn(airplaneResponseDtoList);
        mockMvc.perform(get(URL).contentType(MediaType.ALL))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

    }

    @Test
    void testFindById() throws Exception {

        AirplaneResponseDto expectedAirplaneResponseDto = airplaneResponseDtoList.get(1);
        when(airplaneFacade.findById(ID))
                .thenReturn(expectedAirplaneResponseDto);

        MvcResult mvcResult = mockMvc.perform(get(URL + "/" + ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedJsonResponse = objectMapper.writeValueAsString(expectedAirplaneResponseDto);
        assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);

        verify(airplaneFacade, times(1)).findById(ID);
    }

    @Test
    void testSave() throws Exception {

        AirplaneRequestDto newAirplane = new AirplaneRequestDto("An-30", 12D, 1L);
        AirplaneResponseDto savedAirplane = new AirplaneResponseDto(1L, "An-30", 12D, 1L, "Transport");

        when(airplaneFacade.save(newAirplane))
                .thenReturn(savedAirplane);

        mockMvc.perform(MockMvcRequestBuilders
                        .post(URL)
                        .content(objectMapper.writeValueAsString(newAirplane))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andDo(print());
    }

    @Test
    public void testUpdate() throws Exception {
        AirplaneRequestDto newAirplane = new AirplaneRequestDto("An-30", 12D, 1L);
        AirplaneResponseDto savedAirplane = new AirplaneResponseDto(ID, "An-30", 12D, 1L, "Transport");

        when(airplaneFacade.update(ID, newAirplane))
                .thenReturn(savedAirplane);

        mockMvc.perform(MockMvcRequestBuilders
                        .put(URL + "/" + ID)
                        .content(objectMapper.writeValueAsString(newAirplane))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("An-30"))
                .andExpect(jsonPath("$.windSpeed").value(12D))
                .andExpect(jsonPath("$.categoryId").value(1L))
                .andDo(print());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(URL + "/" + ID))
                .andExpect(status().isOk());
    }
}
