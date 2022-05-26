package com.godeltech.web.controller;

import com.godeltech.facade.FlightStartStatusFacade;
import com.godeltech.web.dto.request.FlightStartStatusRequestDto;
import com.godeltech.web.dto.response.FlightStartStatusResponseDto;
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
@RequestMapping("/start-statuses")
@Slf4j
public class FlightStartStatusController {
    private final FlightStartStatusFacade flightStartStatusFacade;

    @GetMapping("/{id}")
    public ResponseEntity<FlightStartStatusResponseDto> findById(@PathVariable @Validated @NotNull @Positive Long id) {
        log.info("Find start status with id:{}", id);
        return new ResponseEntity<>(flightStartStatusFacade.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FlightStartStatusResponseDto>> findAll() {
        log.info("Find all start statuses");
        return new ResponseEntity<>(flightStartStatusFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FlightStartStatusResponseDto> save(@Valid @RequestBody FlightStartStatusRequestDto flightStartStatusRequestDto) {
        log.info("Save new start status");
        return new ResponseEntity<>(flightStartStatusFacade.save(flightStartStatusRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable @Validated @NotNull @Positive Long id) {
        log.info("Delete start status with id:{}", id);
        flightStartStatusFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<FlightStartStatusResponseDto> update(@PathVariable @Validated @NotNull @Positive Long id,
                                                               @RequestBody FlightStartStatusRequestDto flightStartStatusRequestDto) {
        log.info("Update start status with id:{}", id);
        return new ResponseEntity<>(flightStartStatusFacade.update(id, flightStartStatusRequestDto), HttpStatus.OK);
    }
}
