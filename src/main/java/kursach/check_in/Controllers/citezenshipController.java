package kursach.check_in.Controllers;

import kursach.check_in.Models.*;
import kursach.check_in.Repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("citezenship")
public class citezenshipController {
    private final Icitizenship icitizenship;
    public categoryController (Icitizenship icitizenship){
        this.icitizenship = icitizenship;
    }

    @GetMapping
    public  String all(Model model){
        Iterable<citizenship> citizenshipIterable = icitizenship.findAll();
        model.addAttribute("citizenshipIterable", citizenshipIterable);
        return "citizenships/citizenship";
    }
    @PostMapping("add")
    public String add(@RequestParam String country,
                      @RequestParam String type_of_citizenship,
                      @RequestParam String registration_address) {
        citizenship citizenship = new citizenship(
                country,
                type_of_citizenship,
                registration_address);
        icitizenship.save(citizenship);
        return "redirect:/citizenship";
    }
    @PostMapping("delete/{id_citizenship}")
    public String delete(@PathVariable(value = "id_citizenship") Long id_citizenship) {
        citizenship citizenship = icitizenship.findById(id_citizenship).orElseThrow();
        icitizenship.delete(citizenship);
        return "redirect:/citizenship";
    }
    @GetMapping("{id_citizenship}")
    public String one(@PathVariable(value = "id_citizenship") Long id_citizenship, Model model){
        citizenship citizenship = icitizenship.findById(id_citizenship).orElseThrow();
        model.addAttribute("citizenship", citizenship);
        return "citizenships/citizenship-creation";
    }
    @PostMapping("{id_citizenship}")
    public String update(@PathVariable(value = "id_citizenship") Long id_citizenship,
                         @RequestParam String country,
                         @RequestParam String type_of_citizenship,
                         @RequestParam String registration_address) {
        citizenship citizenship = icitizenship.findById(id_citizenship).orElseThrow();
        rooms.setCountry(country);
        rooms.setType_of_citizenship(type_of_citizenship);
        rooms.setRegistration_address(registration_address);
        icitizenship.save(citizenship);
        return "redirect:/citizenship";
    }
}
