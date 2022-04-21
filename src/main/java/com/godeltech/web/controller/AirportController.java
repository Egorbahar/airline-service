package com.godeltech.web.controller;

import com.godeltech.facade.AirportFacade;
import com.godeltech.web.dto.request.AirportRequestDto;
import com.godeltech.web.dto.response.AirportResponseDto;
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
@RequiredArgsConstructor
@RequestMapping("/airports")
@Slf4j
public class AirportController {
    private final AirportFacade airportFacade;

    @GetMapping("/{id}")
    public ResponseEntity<AirportResponseDto> findById(@PathVariable @Validated @NotNull @Positive Long id) {
        log.info("Find airport with id:{}", id);
        return new ResponseEntity<>(airportFacade.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AirportResponseDto>> findAll() {
        log.info("Find all airports");
        return new ResponseEntity<>(airportFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AirportResponseDto> save(@Valid @RequestBody AirportRequestDto airportRequestDto) {
        log.info("Save new airport");
        return new ResponseEntity<>(airportFacade.save(airportRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable @Validated @NotNull @Positive Long id) {
        log.info("Delete airport with id:{}", id);
        airportFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<AirportResponseDto> update(@PathVariable @Validated @NotNull @Positive Long id,
                                                     @RequestBody AirportRequestDto airportRequestDto) {
        log.info("Update airport with id:{}", id);
        return new ResponseEntity<>(airportFacade.update(id, airportRequestDto), HttpStatus.OK);
    }
}
