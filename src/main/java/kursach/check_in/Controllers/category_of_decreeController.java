package kursach.check_in.Controllers;

import kursach.check_in.Models.category_of_decree;
import kursach.check_in.Models.rooms;
import kursach.check_in.Repo.Icategory_of_decree;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class category_of_decreeController {
    private final Icategory_of_decree icategoryOfDecree;

    public category_of_decreeController(Icategory_of_decree icategoryOfDecree) {
        this.icategoryOfDecree = icategoryOfDecree;
    }
    @GetMapping
    public String all (Model model){
        Iterable<category_of_decree> categoryOfDecreeIterable = icategoryOfDecree.findAll();
        model.addAttribute("categoryOfDecreeIterable", categoryOfDecreeIterable);
        return "category_of_decree/category_of_decree";
    }
    @PostMapping("add")
    public String add(@RequestParam String name_category){
        category_of_decree categoryOfDecree = new category_of_decree(name_category);
        icategoryOfDecree.save(categoryOfDecree);
        return "redirect:/category_of_decree";
    }
    @PostMapping("delete/{id_category}")
    public String delete(@PathVariable(value = "id_category") Long id_category) {
        category_of_decree categoryOfDecree = icategoryOfDecree.findById(id_category).orElseThrow();
        icategoryOfDecree.delete(categoryOfDecree);
        return "redirect:/category_of_decree";
    }
    @GetMapping("{id_category}")
    public String one(@PathVariable(value = "id_category") Long id_category, Model model){
        category_of_decree categoryOfDecree = icategoryOfDecree.findById(id_category).orElseThrow();
        model.addAttribute("categoryOfDecree", categoryOfDecree);
        return "category_of_decree/category_of_decree-creation";
    }
    @PostMapping("{id_category}")
    public String update(@PathVariable(value = "id_category") Long id_category,
                         @RequestParam String name_category) {
        category_of_decree categoryOfDecree = icategoryOfDecree.findById(id_category).orElseThrow();
        categoryOfDecree.setName_category (name_category);
        icategoryOfDecree.save(categoryOfDecree);
        return "redirect:/category_of_decree";
    }
}
