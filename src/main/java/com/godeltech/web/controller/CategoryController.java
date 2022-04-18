package com.godeltech.web.controller;

import com.godeltech.facade.CategoryFacade;
import com.godeltech.web.dto.request.CategoryRequestDto;
import com.godeltech.web.dto.response.CategoryResponseDto;
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
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryFacade categoryFacade;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> findById(@PathVariable @Validated @NotNull @Positive Long id) {
        return new ResponseEntity<>(categoryFacade.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> findAll() {
        return new ResponseEntity<>(categoryFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> save(@Valid @RequestBody CategoryRequestDto categoryRequestDto) {
        return new ResponseEntity<>(categoryFacade.save(categoryRequestDto), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable @Validated @NotNull @Positive Long id) {
        categoryFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<CategoryResponseDto> update(@PathVariable @Validated @NotNull @Positive Long id,
                                                      @RequestBody CategoryRequestDto categoryRequestDto) {
        return new ResponseEntity<>(categoryFacade.update(id, categoryRequestDto), HttpStatus.OK);
    }

}
