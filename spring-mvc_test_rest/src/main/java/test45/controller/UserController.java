package test45.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import test45.dto.UserDto;
import test45.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    //    @ResponseBody
    @GetMapping(produces = "application/xml")

    public List<UserDto> getAll(@CookieValue(value = "test", required = false) String cookieValue) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                log.info("cookie name {} with value {}", cookie.getName(), cookie.getValue());
            }
        }
        log.info("Test cookie {}", cookieValue);
        Cookie cookie = new Cookie("test", "123");
        response.addCookie(cookie);
        return userService.getAll();
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_XML_VALUE)

    public ResponseEntity<UserDto> getById(@PathVariable("userId") Long id) {
        Optional<UserDto> result = userService.getById(id);
        return result.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @GetMapping(value = "/{userId}/avatar", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getAvatarById(@PathVariable("userId") Long id) {
        Optional<UserDto> result = userService.getById(id);
        return result
                .map(UserDto::getAvatar)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @SneakyThrows
    @PostMapping
    public ResponseEntity<UserDto> create(
            @RequestPart("avatar") MultipartFile avatarFile
            , @RequestPart("user") @Valid UserDto userDto) {
        if (userDto.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
            userDto.setAvatar(avatarFile.getBytes());
        log.info("file name {} {}", avatarFile.getName(), avatarFile.getBytes().length);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-UniqueHeader", UUID.randomUUID().toString());
        return new ResponseEntity<>(
                userService.create(userDto),
                httpHeaders,
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody @Valid UserDto userDto) {
        if (!Objects.equals(id, userDto.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Optional<UserDto> result = userService.getAll().stream()
                .filter(it -> Objects.equals(id, it.getId()))
                .findFirst();
        if (result.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        UserDto response = result.get();
        if (!StringUtils.isEmpty(userDto.getName())) {
            response.setName(userDto.getName());
        }
        if (!StringUtils.isEmpty(userDto.getLastName())) {
            response.setLastName(userDto.getLastName());
        }
        if (!StringUtils.isEmpty(userDto.getLogin())) {
            response.setLogin(userDto.getLogin());
        }
        userService.update(id, response);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }
}