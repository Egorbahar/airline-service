package com.godeltech.web.controller;

import com.godeltech.facade.SecondPilotFacade;
import com.godeltech.web.dto.request.SecondPilotRequestDto;
import com.godeltech.web.dto.response.SecondPilotResponseDto;
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
@RequestMapping("/secondpilots")
@Slf4j
public class SecondPilotController {
    private final SecondPilotFacade secondPilotFacade;

    @GetMapping("/{id}")
    public ResponseEntity<SecondPilotResponseDto> findById(@PathVariable @Validated @NotNull @Positive Long id) {
        log.info("Find second pilot with id:{}", id);
        return new ResponseEntity<>(secondPilotFacade.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SecondPilotResponseDto>> findAll() {
        log.info("Find all second pilots");
        return new ResponseEntity<>(secondPilotFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SecondPilotResponseDto> save(@Valid @RequestBody SecondPilotRequestDto secondPilotRequestDto) {
        log.info("Save new second pilot");
        return new ResponseEntity<>(secondPilotFacade.save(secondPilotRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable @Validated @NotNull @Positive Long id) {
        log.info("Delete second pilot with id:{}", id);
        secondPilotFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<SecondPilotResponseDto> update(@PathVariable @Validated @NotNull @Positive Long id,
                                                         @RequestBody SecondPilotRequestDto secondPilotRequestDto) {
        log.info("Update second pilot with id:{}", id);
        return new ResponseEntity<>(secondPilotFacade.update(id, secondPilotRequestDto), HttpStatus.OK);
    }
}
