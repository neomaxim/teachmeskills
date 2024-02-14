package auto.controller;

import auto.dto.AutoDto;
import auto.jpa.OffsetLimitPageable;
import auto.service.AutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/auto")
@RequiredArgsConstructor
@Tag(name = "autos", description = "car information system")
public class AutoControllerRest {
    private final AutoService autoService;

    @GetMapping()
    public ResponseEntity<List<AutoDto>> getAll() {
        return ResponseEntity.ok(autoService.allCars());
    }

    @GetMapping("/http")
    public List<AutoDto> findAll(@RequestParam(defaultValue = "10") Integer limit, @RequestParam(defaultValue = "0") Long offset) {
        if (limit > 10) {
            limit = 10;
        }
        if (offset < 0) {
            offset = 0L;
        }
        return autoService.getAll(OffsetLimitPageable.of(offset, limit));

    }

    @GetMapping(value = "/search", produces = "application/xml")
    @Operation(operationId = "all", description = "search autos")
    public List<AutoDto> getAll(

            @RequestParam(required = false) String vin
    ) {

        return StringUtils.isEmpty(vin) ? autoService.allCars() : autoService.findByVin(vin); // производим поиск vin по базе
    }

    @GetMapping(path = "/{id}/avatar", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getAvatarById(
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(autoService.getById(id).getAvatar());

    }

    @PostMapping
    public ResponseEntity<AutoDto> create(@RequestPart("autos") @Valid AutoDto autoDto) {

        autoService.save(autoDto);
        return new ResponseEntity<>(autoDto, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable @Parameter(description = "auto id", required = true) Long id) {
        autoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
