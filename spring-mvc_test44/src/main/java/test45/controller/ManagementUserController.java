package test45.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test45.dto.UserDto;
import test45.service.UserService;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;


    @Controller
    @RequiredArgsConstructor
    @RequestMapping("/management")
    public class ManagementUserController {

        private final UserService userService;
        private final ObjectMapper objectMapper;

        @PostMapping
        public String create(UserDto userDto) {
            userService.create(userDto);
            return "redirect:/";
        }

        @PutMapping(consumes = "application/json")
//    public String update(@RequestBody UserDto user) {
        public String update(HttpServletRequest request) throws IOException {
            String body = request.getReader().lines().collect(Collectors.joining());
            UserDto user = objectMapper.readValue(body, UserDto.class);
            userService.update(user);
            return "redirect:/";
        }

        @DeleteMapping
        public String delete(@RequestParam Long id) {
            userService.remove(id);
            return "redirect:/";
        }

        @GetMapping
        public String findById(@RequestParam Long id, Model model) {
            Optional<UserDto> user = userService.findById(id);
            user.ifPresent(it -> model.addAttribute("user", it));
            return "user";
        }

}
