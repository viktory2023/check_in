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
@RequestMapping("category")
public class categoryController {
    private final Icategory icategory;

    @GetMapping
    public  String all(Model model){
        Iterable<category> categoryIterable = icategory.findAll();
        model.addAttribute("categoryIterable", categoryIterable);
        return "categories/category";
    }
    @PostMapping("add")
    public String add(@RequestParam String name_category) {
        category category = new category(name_category);
        icategory.save(category);
        return "redirect:/category";
    }
    @PostMapping("delete/{id_category}")
    public String delete(@PathVariable(value = "id_category") Long id_category) {
        category category = icategory.findById(id_category).orElseThrow();
        icategory.delete(category);
        return "redirect:/category";
    }
    @GetMapping("{id_category}")
    public String one(@PathVariable(value = "id_category") Long id_category, Model model){
        category category = icategory.findById(id_category).orElseThrow();
        model.addAttribute("category", category);
        return "categories/category-creation";
    }
    @PostMapping("{id_category}")
    public String update(@PathVariable(value = "id_category") Long id_category,
                         @RequestParam String name_category) {
        category category  = icategory.findById(id_category).orElseThrow();
        category.setName_category(name_category);
        icategory.save(category);
        return "redirect:/category";
    }
}
