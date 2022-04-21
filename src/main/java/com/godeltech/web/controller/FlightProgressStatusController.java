package com.godeltech.web.controller;

import com.godeltech.facade.FlightProgressStatusFacade;
import com.godeltech.web.dto.request.FlightProgressStatusRequestDto;
import com.godeltech.web.dto.response.FlightProgressStatusResponseDto;
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
@RequestMapping("/progress/statuses")
@Slf4j
public class FlightProgressStatusController {
    private final FlightProgressStatusFacade flightProgressStatusFacade;

    @GetMapping("/{id}")
    public ResponseEntity<FlightProgressStatusResponseDto> findById(@PathVariable @Validated @NotNull @Positive Long id) {
        log.info("Find progress status with id:{}", id);
        return new ResponseEntity<>(flightProgressStatusFacade.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FlightProgressStatusResponseDto>> findAll() {
        log.info("Find all progress statuses");
        return new ResponseEntity<>(flightProgressStatusFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FlightProgressStatusResponseDto> save(@Valid @RequestBody FlightProgressStatusRequestDto flightProgressStatusRequestDto) {
        log.info("Save new progress status");
        return new ResponseEntity<>(flightProgressStatusFacade.save(flightProgressStatusRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable @Validated @NotNull @Positive Long id) {
        log.info("Delete progress status with id:{}", id);
        flightProgressStatusFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<FlightProgressStatusResponseDto> update(@PathVariable @Validated @NotNull @Positive Long id,
                                                                  @RequestBody FlightProgressStatusRequestDto flightProgressStatusRequestDto) {
        log.info("Update progress status with id:{}", id);
        return new ResponseEntity<>(flightProgressStatusFacade.update(id, flightProgressStatusRequestDto), HttpStatus.OK);
    }
}
