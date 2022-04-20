package com.godeltech.web.controller;

import com.godeltech.facade.FlightStartStatusFacade;
import com.godeltech.web.dto.request.FlightStartStatusRequestDto;
import com.godeltech.web.dto.response.FlightStartStatusResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/start/statuses")
public class FlightStartStatusController {
    private final FlightStartStatusFacade flightStartStatusFacade;

    @GetMapping("/{id}")
    public ResponseEntity<FlightStartStatusResponseDto> findById(@PathVariable @Validated @NotNull @Positive Long id) {
        return new ResponseEntity<>(flightStartStatusFacade.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FlightStartStatusResponseDto>> findAll() {
        return new ResponseEntity<>(flightStartStatusFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FlightStartStatusResponseDto> save(@Valid @RequestBody FlightStartStatusRequestDto flightStartStatusRequestDto) {
        return new ResponseEntity<>(flightStartStatusFacade.save(flightStartStatusRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable @Validated @NotNull @Positive Long id) {
        flightStartStatusFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<FlightStartStatusResponseDto> update(@PathVariable @Validated @NotNull @Positive Long id,
                                                    @RequestBody FlightStartStatusRequestDto flightStartStatusRequestDto) {
        return new ResponseEntity<>(flightStartStatusFacade.update(id, flightStartStatusRequestDto), HttpStatus.OK);
    }
}
