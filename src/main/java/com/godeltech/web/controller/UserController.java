package com.godeltech.web.controller;

import com.godeltech.facade.UserFacade;
import com.godeltech.web.dto.request.UserRequestDto;
import com.godeltech.web.dto.response.UserResponseDto;
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
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserFacade userFacade;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable @Validated @NotNull @Positive Long id) {
        return new ResponseEntity<>(userFacade.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll() {
        return new ResponseEntity<>(userFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> save(@Valid @RequestBody UserRequestDto userRequestDto) {
        return new ResponseEntity<>(userFacade.save(userRequestDto), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable @Validated @NotNull @Positive Long id) {
        userFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable @Validated @NotNull @Positive Long id,
                                                        @RequestBody UserRequestDto userRequestDto) {
        return new ResponseEntity<>(userFacade.update(id, userRequestDto), HttpStatus.OK);
    }
}
