package auto.controller;





import auto.dao.AutoDAO;
import auto.dto.AutoDto;
import auto.model.Auto;
import auto.service.AutoService;

import lombok.RequiredArgsConstructor;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


@Slf4j
@Validated
@RestController
@RequestMapping("/api/auto")
@RequiredArgsConstructor               // или это
public class AutoControllerRest {


    private final AutoService autoService;



    @GetMapping()
    public List<Auto> autoAll() {
        return autoService.allCars();
    }

   // @SneakyThrows
   @PostMapping
    public ResponseEntity<Auto> create(@RequestPart("autos") @Valid Auto auto) {
        autoService.add(auto);
        return new ResponseEntity<>(auto, HttpStatus.CREATED);
    }


   /* @SneakyThrows
    @PostMapping
    public ResponseEntity<AutoDto> create(@RequestPart("avatar") MultipartFile carFile,
                                         @RequestPart("autos") AutoDto autoDto) {
        autoDto.setAvatar(carFile.getBytes());
        log.info("file name {} {}", carFile.getName(), carFile.getBytes().length);
        AutoDto car = autoService.add(autoDto);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }*/
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
