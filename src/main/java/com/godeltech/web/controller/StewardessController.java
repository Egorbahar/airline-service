package com.godeltech.web.controller;

import com.godeltech.facade.StewardessFacade;
import com.godeltech.web.dto.request.StewardessRequestDto;
import com.godeltech.web.dto.response.StewardessResponseDto;
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
@RequestMapping("/stewardesses")
@Slf4j
public class StewardessController {
    private final StewardessFacade stewardessFacade;

    @GetMapping("/{id}")
    public ResponseEntity<StewardessResponseDto> findById(@PathVariable @Validated @NotNull @Positive Long id) {
        log.info("Find stewardess with id:{}", id);
        return new ResponseEntity<>(stewardessFacade.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StewardessResponseDto>> findAll() {
        log.info("Find all stewardesses");
        return new ResponseEntity<>(stewardessFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StewardessResponseDto> save(@Valid @RequestBody StewardessRequestDto stewardessRequestDto) {
        log.info("Save new stewardess");
        return new ResponseEntity<>(stewardessFacade.save(stewardessRequestDto), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable @Validated @NotNull @Positive Long id) {
        log.info("Delete stewardess with id:{}", id);
        stewardessFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<StewardessResponseDto> update(@PathVariable @Validated @NotNull @Positive Long id,
                                                         @RequestBody StewardessRequestDto stewardessRequestDto) {
        log.info("Update stewardess with id:{}", id);
        return new ResponseEntity<>(stewardessFacade.update(id, stewardessRequestDto), HttpStatus.OK);
    }
}
