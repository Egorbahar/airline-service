package com.godeltech.web.controller;

import com.godeltech.facade.StewardessFacade;
import com.godeltech.web.dto.request.StewardessRequestDto;
import com.godeltech.web.dto.response.StewardessResponseDto;
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
@RequestMapping("/stewardesses")
public class StewardessController {
    private final StewardessFacade stewardessFacade;

    @GetMapping("/{id}")
    public ResponseEntity<StewardessResponseDto> findById(@PathVariable @Validated @NotNull @Positive Long id) {
        return new ResponseEntity<>(stewardessFacade.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StewardessResponseDto>> findAll() {
        return new ResponseEntity<>(stewardessFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StewardessResponseDto> save(@Valid @RequestBody StewardessRequestDto stewardessRequestDto) {
        return new ResponseEntity<>(stewardessFacade.save(stewardessRequestDto), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable @Validated @NotNull @Positive Long id) {
        stewardessFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<StewardessResponseDto> update(@PathVariable @Validated @NotNull @Positive Long id,
                                                         @RequestBody StewardessRequestDto stewardessRequestDto) {
        return new ResponseEntity<>(stewardessFacade.update(id, stewardessRequestDto), HttpStatus.OK);
    }
}
