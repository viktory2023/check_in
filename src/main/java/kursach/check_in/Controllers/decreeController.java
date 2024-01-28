package kursach.check_in.Controllers;
import kursach.check_in.Models.*;
import kursach.check_in.Repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("decree")
public class decreeController {
    private final Idecree idecree;
    private final Icategory_of_decree icategory_of_decree;

    @GetMapping
    public  String all(Model model){
        Iterable<decree> decreeIterable = idecree.findAll();
        model.addAttribute("decreeIterable", decreeIterable);
        return "decrees/decree";
    }
    @PostMapping("add")
    public String add(@RequestParam String name_decree,
                      @RequestParam LocalDate date_of_formation,
                      @RequestParam Long id_category) {
        decree decree = new decree(
                name_decree,
                date_of_formation,
                icategory_of_decree.findById(id_category).orElseThrow());
        idecree.save(decree);
        return "redirect:/decree";
    }
    @PostMapping("delete/{id_decree}")
    public String delete(@PathVariable(value = "id_decree") Long id_decree) {
        decree decree = idecree.findById(id_decree).orElseThrow();
        idecree.delete(decree);
        return "redirect:/decree";
    }
    @GetMapping("{id_decree}")
    public String one(@PathVariable(value = "id_decree") Long id_decree, Model model){
        decree decree = idecree.findById(id_decree).orElseThrow();
        model.addAttribute("decree", decree);
        return "decrees/decree-creation";
    }
    @PostMapping("{id_decree}")
    public String update(@PathVariable(value = "id_decree") Long id_decree,
                         @RequestParam String name_decree,
                         @RequestParam LocalDate date_of_formation,
                         @RequestParam Long id_category) {
        decree decree = idecree.findById(id_decree).orElseThrow();
        decree.setName_decree(name_decree);
        decree.setDate_of_formation(date_of_formation);
        decree.setCategory(icategory_of_decree.findById(id_category).orElseThrow());
        idecree.save(decree);
        return "redirect:/decree";
    }

}
