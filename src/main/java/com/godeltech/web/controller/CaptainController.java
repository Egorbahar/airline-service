package com.godeltech.web.controller;

import com.godeltech.facade.CaptainFacade;
import com.godeltech.web.dto.request.CaptainRequestDto;
import com.godeltech.web.dto.response.CaptainResponseDto;
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
@RequestMapping("/captains")
public class CaptainController {
    private final CaptainFacade captainFacade;

    @GetMapping("/{id}")
    public ResponseEntity<CaptainResponseDto> findById(@PathVariable @Validated @NotNull @Positive Long id) {
        return new ResponseEntity<>(captainFacade.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CaptainResponseDto>> findAll() {
        return new ResponseEntity<>(captainFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CaptainResponseDto> save(@Valid @RequestBody CaptainRequestDto captainRequestDto) {
        return new ResponseEntity<>(captainFacade.save(captainRequestDto), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable @Validated @NotNull @Positive Long id) {
        captainFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<CaptainResponseDto> update(@PathVariable @Validated @NotNull @Positive Long id,
                                                      @RequestBody CaptainRequestDto captainRequestDto) {
        return new ResponseEntity<>(captainFacade.update(id, captainRequestDto), HttpStatus.OK);
    }

}
