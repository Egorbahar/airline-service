package com.godeltech.web.controller;

import com.godeltech.facade.AirplaneFacade;
import com.godeltech.web.dto.request.AirplaneRequestDto;
import com.godeltech.web.dto.response.AirplaneResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/airplanes")
@RequiredArgsConstructor
public class AirplaneController {
    private final AirplaneFacade airplaneFacade;
    @GetMapping("/{id}")
    public ResponseEntity<AirplaneResponseDto> findById(@PathVariable @Validated @NotNull @Positive Long id) {
        return new ResponseEntity<>(airplaneFacade.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AirplaneResponseDto>> findAll() {
        return new ResponseEntity<>(airplaneFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AirplaneResponseDto> save(@Valid @RequestBody AirplaneRequestDto airplaneRequestDto) {
        return new ResponseEntity<>(airplaneFacade.save(airplaneRequestDto), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable @Validated @NotNull @Positive Long id) {
        airplaneFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<AirplaneResponseDto> update(@PathVariable @Validated @NotNull @Positive Long id,
                                                     @RequestBody AirplaneRequestDto airplaneRequestDto) {
        return new ResponseEntity<>(airplaneFacade.update(id, airplaneRequestDto), HttpStatus.OK);
    }
}
