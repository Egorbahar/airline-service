package com.godeltech.web.controller;

import com.godeltech.facade.FlightFacade;
import com.godeltech.web.dto.request.FlightRequestDto;
import com.godeltech.web.dto.response.FlightResponseDto;
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
@RequestMapping("/flights")
@RequiredArgsConstructor
@Slf4j
public class FlightController {
    private final FlightFacade flightFacade;

    @GetMapping("/{id}")
    public ResponseEntity<FlightResponseDto> findById(@PathVariable @NotNull @Positive Long id) {
        log.info("Find flight with id:{}", id);
        return new ResponseEntity<>(flightFacade.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FlightResponseDto>> findAll() {
        log.info("Find all flights");
        return new ResponseEntity<>(flightFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FlightResponseDto> save(@Validated @RequestBody FlightRequestDto flightRequestDto) {
        log.info("Save new flight");
        return new ResponseEntity<>(flightFacade.save(flightRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable @NotNull @Positive Long id) {
        log.info("Delete flight with id:{}", id);
        flightFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<FlightResponseDto> update(@PathVariable @NotNull @Positive Long id,
                                                    @RequestBody FlightRequestDto flightRequestDto) {
        log.info("Update flight with id:{}", id);
        return new ResponseEntity<>(flightFacade.update(id, flightRequestDto), HttpStatus.OK);
    }

    @PatchMapping("/{id}/starts/{start_status_id}")
    public ResponseEntity<FlightResponseDto> updateFlightStartStatus(@PathVariable @NotNull @Positive Long id,
                                                                     @PathVariable("start_status_id") @NotNull @Positive Long startStatusId) {
        log.info("Update start status of the flight with id:{}", id);
        return new ResponseEntity<>(flightFacade.updateFlightStartStatus(id, startStatusId), HttpStatus.OK);
    }

    @PatchMapping("/{id}/progresses/{progress_status_id}")
    public ResponseEntity<FlightResponseDto> updateFlightProgressStatus(@PathVariable @NotNull @Positive Long id,
                                                                        @PathVariable("progress_status_id") @NotNull @Positive Long progressStatusId) {
        log.info("Update progress status of the flight with id:{}", id);
        return new ResponseEntity<>(flightFacade.updateFlightProgressStatus(id, progressStatusId), HttpStatus.OK);
    }
}
