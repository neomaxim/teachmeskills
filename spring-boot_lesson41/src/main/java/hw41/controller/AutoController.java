package hw41.controller;
import hw41.model.Auto;
import hw41.service.AutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;



@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class AutoController {
    private AutoService autoService;

    @Autowired
    public void setAutoService(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping("/")
    public ModelAndView allAuto() {
        List<Auto> auto = autoService.allAuto();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auto");
        modelAndView.addObject("autoList", auto);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAuto(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Auto auto = autoService.getById(id);
        autoService.delete(auto);
        return modelAndView;
    }

    @GetMapping("/add")

    public String registration() {

        return "registration";
    }

    @PostMapping("/add")
    public String register(Model model, @Valid @ModelAttribute Auto auto, BindingResult result) {

        if (result.hasErrors()) {
            FieldError fieldError = result.getFieldError();
            String key = fieldError.getField();
            String defaultMessage = fieldError.getDefaultMessage();
            switch (key) {
                case "vin" -> model.addAttribute("vinErrorLabel", defaultMessage);
                case "brand" -> model.addAttribute("brandErrorLabel", defaultMessage);
                case "year" -> model.addAttribute("yearErrorLabel", defaultMessage);
            }
            return "redirect:/";
        }
        autoService.registration(auto.getVin(), auto.getBrand(), auto.getYear());
        autoService.add(auto);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editAuto(@PathVariable("id") int id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        Auto auto = autoService.getById(id);
        autoService.edit(auto);
        return modelAndView;
    }

}
