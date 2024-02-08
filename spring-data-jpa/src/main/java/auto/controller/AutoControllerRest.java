package auto.controller;

import auto.dto.AutoDto;
import auto.service.AutoService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
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

    @GetMapping(path = "/{id}/autoFile", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getAvatarById(
            @PathVariable @Parameter(description = "Auto id", required = true) Long id) {
        return ResponseEntity.ok(autoService.getById(id).getAvatar());
    }

    @PostMapping
    public ResponseEntity<AutoDto> save(
            @RequestPart @Parameter(description = "Auto  file", required = true) MultipartFile avatar,
            @Valid @Parameter(description = "Auto data", required = true) AutoDto autoDto) throws IOException {
        autoDto.setAvatar(avatar.getBytes());
        return ResponseEntity.ok(autoService.save(autoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable @Parameter(description = "auto id", required = true) Long id) {
        autoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
