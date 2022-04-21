package com.godeltech.web.controller;

import com.godeltech.facade.EngineerFacade;
import com.godeltech.web.dto.request.EngineerRequestDto;
import com.godeltech.web.dto.response.EngineerResponseDto;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/engineers")
@Slf4j
public class EngineerController {
    private final EngineerFacade engineerFacade;

    @GetMapping("/{id}")
    public ResponseEntity<EngineerResponseDto> findById(@PathVariable @Validated @NotNull @Positive Long id) {
        log.info("Find engineer with id:{}", id);
        return new ResponseEntity<>(engineerFacade.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EngineerResponseDto>> findAll() {
        log.info("Find all engineers");
        return new ResponseEntity<>(engineerFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EngineerResponseDto> save(@Valid @RequestBody EngineerRequestDto engineerRequestDto) {
        log.info("Save new engineer");
        return new ResponseEntity<>(engineerFacade.save(engineerRequestDto), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable @Validated @NotNull @Positive Long id) {
        log.info("Delete engineer with id:{}", id);
        engineerFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<EngineerResponseDto> update(@PathVariable @Validated @NotNull @Positive Long id,
                                                     @RequestBody EngineerRequestDto engineerRequestDto) {
        log.info("Update engineer with id:{}", id);
        return new ResponseEntity<>(engineerFacade.update(id, engineerRequestDto), HttpStatus.OK);
    }
}
