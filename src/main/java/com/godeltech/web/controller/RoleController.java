package com.godeltech.web.controller;

import com.godeltech.facade.RoleFacade;
import com.godeltech.web.dto.request.RoleRequestDto;
import com.godeltech.web.dto.response.RoleResponseDto;
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
@RequestMapping("/roles")
@RequiredArgsConstructor
@Slf4j
public class RoleController {
    private final RoleFacade roleFacade;

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDto> findById(@PathVariable @Validated @NotNull @Positive Long id) {
        log.info("Find role with id:{}", id);
        return new ResponseEntity<>(roleFacade.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RoleResponseDto>> findAll() {
        log.info("Find all roles");
        return new ResponseEntity<>(roleFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleResponseDto> save(@Valid @RequestBody RoleRequestDto roleRequestDto) {
        log.info("Save new role");
        return new ResponseEntity<>(roleFacade.save(roleRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable @Validated @NotNull @Positive Long id) {
        log.info("Delete role with id:{}", id);
        roleFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<RoleResponseDto> update(@PathVariable @Validated @NotNull @Positive Long id,
                                                  @RequestBody RoleRequestDto roleRequestDto) {
        log.info("Update role with id:{}", id);
        return new ResponseEntity<>(roleFacade.update(id, roleRequestDto), HttpStatus.OK);
    }
}