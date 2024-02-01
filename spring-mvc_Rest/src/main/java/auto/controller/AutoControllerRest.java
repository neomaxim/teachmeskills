package auto.controller;


import auto.dto.AutoDto;


import auto.service.AutoService;

import lombok.RequiredArgsConstructor;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import java.util.UUID;


@Slf4j
@Validated
@RestController
@RequestMapping("/api/auto")
@RequiredArgsConstructor
public class AutoControllerRest {


    private AutoService autoService;

    @Autowired
    public void setAutoService(AutoService autoService) {
        this.autoService = autoService;
    }


    @SneakyThrows
    @PostMapping
    public ResponseEntity<AutoDto> create(
            @RequestPart("avatar") MultipartFile avatarFile
            , @RequestPart("user") @Valid AutoDto userDto) {
        if (userDto.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        userDto.setAvatar(avatarFile.getBytes());
        log.info("file name {} {}", avatarFile.getName(), avatarFile.getBytes().length);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-UniqueHeader", UUID.randomUUID().toString());
        return new ResponseEntity<>(
                autoService.create(userDto),
                httpHeaders,
                HttpStatus.CREATED);
    }


}
