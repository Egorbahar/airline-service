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

@Validated
@RestController
@RequestMapping("/airplanes")
@RequiredArgsConstructor
@Slf4j
public class AirplaneController {
    private final AirplaneFacade airplaneFacade;

    @GetMapping("/{id}")
    public ResponseEntity<AirplaneResponseDto> findById(@PathVariable @Validated @NotNull @Positive Long id) {
        log.info("Find airplane with id:{}", id);
        return new ResponseEntity<>(airplaneFacade.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AirplaneResponseDto>> findAll() {
        log.info("Find all airplanes");
        return new ResponseEntity<>(airplaneFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AirplaneResponseDto> save(@Validated @RequestBody AirplaneRequestDto airplaneRequestDto) {
        log.info("Save new airplane");
        return new ResponseEntity<>(airplaneFacade.save(airplaneRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable @Validated @NotNull @Positive Long id) {
        log.info("Delete airplane with id:{}", id);
        airplaneFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<AirplaneResponseDto> update(@PathVariable @Validated @NotNull @Positive Long id,
                                                      @RequestBody AirplaneRequestDto airplaneRequestDto) {
        log.info("Update airplane with id:{}", id);
        return new ResponseEntity<>(airplaneFacade.update(id, airplaneRequestDto), HttpStatus.OK);
    }
}
