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
@RequestMapping("people")
public class peopleController {
    private final Ipeople ipeople;
    private final Icategory icategory;
    private final Icitizenship icitizenship;

    public peopleController (Ipeople ipeople, Icategory icategory, Icitizenship icitizenship){
        this.ipeople = ipeople;
        this.icategory = icategory;
        this.icitizenship = icitizenship;
    }

    @GetMapping
    public  String all(Model model){
        Iterable<people> peopleIterable = ipeople.findAll();
        model.addAttribute("peopleIterable", peopleIterable);
        return "peoples/people";
    }
    @PostMapping("add")
    public String add(@RequestParam String passport_data,
                      @RequestParam String surname,
                      @RequestParam String name,
                      @RequestParam String patronymic,
                      @RequestParam String gender,
                      @RequestParam int age,
                      @RequestParam Long id_category,
                      @RequestParam Long id_citizenship) {
        people people = new people(
                passport_data,
                surname,
                name,
                patronymic,
                gender,
                age,
                icategory.findById(id_category).orElseThrow()
                icitizenship.findById(id_citizenship).orElseThrow());
        ipeople.save(people);
        return "redirect:/people";
    }
    @PostMapping("delete/{id_people}")
    public String delete(@PathVariable(value = "id_people") Long id_people) {
        people people = ipeople.findById(id_people).orElseThrow();
        ipeople.delete(people);
        return "redirect:/people";
    }
    @GetMapping("{id_people}")
    public String one(@PathVariable(value = "id_people") Long id_people, Model model){
        people people = ipeople.findById(id_people).orElseThrow();
        model.addAttribute("people", people);
        return "peoples/people-creation";
    }
    @PostMapping("{id_people}")
    public String update(@PathVariable(value = "id_people") Long id_people,
                         @RequestParam String passport_data,
                         @RequestParam String surname,
                         @RequestParam String name,
                         @RequestParam String patronymic,
                         @RequestParam String gender,
                         @RequestParam int age,
                         @RequestParam Long id_category,
                         @RequestParam Long id_citizenship) {
        people people = ipeople.findById(id_people).orElseThrow();
        people.setPassport_data(passport_data);
        people.setSurname(surname);
        people.setName(name);
        people.setPatronymic(patronymic);
        people.setGender(gender);
        people.setAge(age);
        people.setCategory(icategory.findById(id_category).orElseThrow());
        people.setCitizenship(icitizenship.findById(id_citizenship).orElseThrow());
        ipeople.save(people);
        return "redirect:/people";
    }
}
