package com.godeltech.web.controller;

import com.godeltech.facade.FlightFacade;
import com.godeltech.web.dto.request.FlightRequestDto;
import com.godeltech.web.dto.response.FlightResponseDto;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightFacade flightFacade;

    @GetMapping("/{id}")
    public ResponseEntity<FlightResponseDto> findById(@PathVariable @NotNull @Positive Long id) {
        return new ResponseEntity<>(flightFacade.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FlightResponseDto>> findAll() {
        return new ResponseEntity<>(flightFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FlightResponseDto> save(@Valid @RequestBody FlightRequestDto flightRequestDto) {
        return new ResponseEntity<>(flightFacade.save(flightRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable @NotNull @Positive Long id) {
        flightFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<FlightResponseDto> update(@PathVariable @NotNull @Positive Long id,
                                                    @RequestBody FlightRequestDto flightRequestDto) {
        return new ResponseEntity<>(flightFacade.update(id, flightRequestDto), HttpStatus.OK);
    }
    @PatchMapping("/{id}/starts/{start_status_id}")
    public ResponseEntity<FlightResponseDto> updateFlightStartStatus(@PathVariable @NotNull @Positive Long id,
                                                                     @PathVariable("start_status_id") @NotNull @Positive Long startStatusId) {

        return new ResponseEntity<>(flightFacade.updateFlightStartStatus(id, startStatusId), HttpStatus.OK);
    }
    @PatchMapping("/{id}/progresses/{progress_status_id}")
    public ResponseEntity<FlightResponseDto> updateFlightProgressStatus(@PathVariable @NotNull @Positive Long id,
                                                                        @PathVariable("progress_status_id") @NotNull @Positive Long progressStatusId) {
        return new ResponseEntity<>(flightFacade.updateFlightProgressStatus(id, progressStatusId), HttpStatus.OK);
    }
}
