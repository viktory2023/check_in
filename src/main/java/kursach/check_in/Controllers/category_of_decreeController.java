package kursach.check_in.Controllers;

import kursach.check_in.Models.category_of_decree;
import kursach.check_in.Repo.Icategory_of_decree;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("pass")
public class category_of_decreeController {
    private final Icategory_of_decree icategoryOfDecree;

    public category_of_decreeController(Icategory_of_decree icategoryOfDecree) {
        this.icategoryOfDecree = icategoryOfDecree;
    }
    @GetMapping
    public String all (Model model){
        Iterable<category_of_decree> categoryOfDecreeIterable = icategoryOfDecree.findAll();
        model.addAttribute("categoryOfDecreeIterable", categoryOfDecreeIterable);
        return "category_of_decree";
    }
    @PostMapping("add")
    public String add(@RequestParam String name_category){
        category_of_decree categoryOfDecree = new category_of_decree(name_category);
        icategoryOfDecree.save(categoryOfDecree);
        return "redirect:/category_of_decree";
    }
}
