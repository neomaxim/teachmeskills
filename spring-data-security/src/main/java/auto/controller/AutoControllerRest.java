package auto.controller;

import auto.dto.AutoDto;
import auto.dto.AutoVinDto;
import auto.jpa.OffsetLimitPageable;
import auto.model.Auto;
import auto.service.AutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/auto")
@RequiredArgsConstructor
@Tag(name = "autos", description = "car information system")
public class AutoControllerRest {
    private  final AutoService autoService;

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
        return autoService.getAll(OffsetLimitPageable.of(offset, limit));// сортируем по количеству элементов на странице
       // return autoService.getAll(OffsetLimitPageable.of(offset, limit, Sort.by(Sort.Direction.DESC, "id"))); //сортирует по количеству выдаваемых елементов и внутри себя возращает в обратном порядке
    }
    @GetMapping(value = "/search",produces = "application/xml")
    @Operation(operationId = "all", description = "search autos")
    public List<AutoDto> getAll(

            @RequestParam(required = false) String vin
    ) {

        return StringUtils.isEmpty(vin) ? autoService.allCars() : autoService.findByVin(vin); // производим поиск vin по базе
    }
     @GetMapping(path = "/{id}/avatar", produces = MediaType.IMAGE_JPEG_VALUE)
   public ResponseEntity<byte[]> getAvatarById(
           @PathVariable ( "id") Long id) {
       return ResponseEntity.ok(autoService.getById(id).getAvatar());

   }
/*   @GetMapping(path = "/{auto id}/avatar", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getAvatarById(
            @PathVariable @Parameter(description = "auto id", required = true) Long id) {
        return ResponseEntity.ok(autoService.getById(id).getAvatar());
    }*/
/*@GetMapping(value = "/{autoId}/avatar", produces = MediaType.IMAGE_JPEG_VALUE)
public ResponseEntity<byte[]> getAvatarById(@PathVariable("autoId") Long id) {
    Optional<AutoDto> result = autoService.getById(id);
    return result
            .map(AutoDto::getAvatar)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
}*/
  /*  @PostMapping
    public ResponseEntity<AutoDto> save(
           // @RequestPart @Parameter(description = "avatar", required = true) MultipartFile avatar,
            @Valid @Parameter(description = "autos", required = true) AutoDto autoDto) throws IOException {
        autoDto.setAvatar(avatar.getBytes());
        return ResponseEntity.ok(autoService.save(autoDto));
        autoService.save(autoDto);
        return new ResponseEntity<>(autoDto, HttpStatus.CREATED);
    }*/
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
