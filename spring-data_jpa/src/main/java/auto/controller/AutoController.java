package auto.controller;
import auto.model.Auto;
import auto.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class AutoController {
    private int page;

    private AutoService autoService;

    @Autowired
    public void setAutoService(AutoService autoService) {
        this.autoService = autoService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allAuto(@RequestParam(defaultValue = "1") int page) {
        List<Auto> autos = autoService.allAutos(page);
        int autosCount = autoService.autosCount();
        int pagesCount = (autosCount + 9)/10;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("autos");
        modelAndView.addObject("page", page);
        modelAndView.addObject("autosList", autos);
        modelAndView.addObject("autosCount", autosCount);
        modelAndView.addObject("pagesCount", pagesCount);
        this.page = page;
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage(@ModelAttribute("message") String message) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addAuto(@ModelAttribute("auto") Auto auto) {
        ModelAndView modelAndView = new ModelAndView();
        if (autoService.checkVin(auto.getVin())) {
            modelAndView.setViewName("redirect:/");
            modelAndView.addObject("page", page);
            autoService.add(auto);
        } else {
            modelAndView.addObject("message","part with vin \"" + auto.getVin() + "\" already exists");
            modelAndView.setViewName("redirect:/add");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id,
                                 @ModelAttribute("message") String message) {
        Auto auto = autoService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("auto", auto);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editAuto(@ModelAttribute("auto") Auto auto) {
        ModelAndView modelAndView = new ModelAndView();
        if (autoService.checkVin(auto.getVin()) || autoService.getById(auto.getId()).getVin().equals(auto.getVin())) {
            modelAndView.setViewName("redirect:/");
            modelAndView.addObject("page", page);
            autoService.edit(auto);
        } else {
            modelAndView.addObject("message","part with vin \"" + auto.getVin() + "\" already exists");
            modelAndView.setViewName("redirect:/edit/" +  + auto.getId());
        }
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAuto(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        int autosCount = autoService.autosCount();
        int page = ((autosCount - 1) % 10 == 0 && autosCount > 10 && this.page == (autosCount + 9)/10) ?
                this.page - 1 : this.page;
        modelAndView.setViewName("redirect:/");
        modelAndView.addObject("page", page);
        Auto auto = autoService.getById(id);
        autoService.delete(auto);
        return modelAndView;
    }
}