package auto.controller;

import auto.model.Auto;
import auto.service.AutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Slf4j
@Validated
@RestController
@RequestMapping("/api/auto")
@RequiredArgsConstructor
@Tag(name = "autos", description = "car information system")
public class AutoControllerRest {

    private final AutoService autoService;

    @GetMapping()
    @Operation(operationId = "all", description = "Fetch all autos")
    public List<Auto> autoAll() {
        return autoService.allCars();
    }


    @GetMapping("/http")
    public List<Auto> findAll() {
        return autoService.allCarsHttp();
    }

    @PostMapping
    @ApiResponse(responseCode = "200", description = "get info about auto if everything is ok")
    @ApiResponse(responseCode = "400", description = "validation failed")
    public ResponseEntity<Auto> create(@RequestPart("autos") @Valid Auto auto) {
        if (autoService.checkVin(auto.getVin())) {
            autoService.add(auto);
            return new ResponseEntity<>(auto, HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        Auto auto = autoService.getById(id);
        autoService.delete(auto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Auto> update(@PathVariable int id, @RequestBody @Valid Auto auto) {
        if (!Objects.equals(id, auto.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Auto> result = autoService.allCars().stream()
                .filter(it -> Objects.equals(id, it.getId()))
                .findFirst();
        if (result.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Auto response = result.get();
        if (!StringUtils.isEmpty(auto.getVin())) {
            response.setVin(auto.getVin());
        }
        if (!StringUtils.isEmpty(auto.getBrand())) {
            response.setBrand(auto.getBrand());
        }
        if (!StringUtils.isEmpty(auto.getYear())) {
            response.setYear(auto.getYear());
        }
        autoService.edit(auto);
        return ResponseEntity.ok(response);
    }


}
