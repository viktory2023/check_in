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
@RequestMapping("building")
public class buildingController {
    private final Ibuilding ibuilding;
    public buildingController (Ibuilding ibuilding) {
        this.ibuilding = ibuilding;
    }
    @GetMapping
    public  String all(Model model){
        Iterable<building> buildingIterable = ibuilding.findAll();
        model.addAttribute("buildingIterable", buildingIterable);
        return "buildings/building";
    }
    @PostMapping("add")
    public String add(@RequestParam String name_street,
                      @RequestParam int house_number,
                      @RequestParam int case_number) {
        building building = new building(
                name_street,
                house_number,
                case_number);
        ibuilding.save(building);
        return "redirect:/building";
    }
    @PostMapping("delete/{id_building}")
    public String delete(@PathVariable(value = "id_building") Long id_building) {
        building building = ibuilding.findById(id_building).orElseThrow();
        ibuilding.delete(building);
        return "redirect:/building";
    }
    @GetMapping("{id_building}")
    public String one(@PathVariable(value = "id_building") Long id_building, Model model){
        building building = ibuilding.findById(id_building).orElseThrow();
        model.addAttribute("building", building);
        return "buildings/building-creation";
    }
    @PostMapping("{id_building}")
    public String update(@PathVariable(value = "id_building") Long id_building,
                         @RequestParam String name_street,
                         @RequestParam int house_number,
                         @RequestParam int case_number) {
        building building = ibuilding.findById(id_building).orElseThrow();
        building.setName_street(name_street);
        building.setHouse_number(house_number);
        building.setCase_number(case_number);
        ibuilding.save(building);
        return "redirect:/building";
    }
}
