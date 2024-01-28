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
@RequestMapping("check_in")
public class check_inController {
    private final Icheck_in icheck_in;
    private final Iorder iorder;
    public check_inController(Icheck_in icheck_in, Iorder iorder){
        this.icheck_in = icheck_in;
        this.iorder = iorder;

    }

    @GetMapping
    public  String all(Model model){
        Iterable<check_in> checkInIterable = icheck_in.findAll();
        model.addAttribute("checkInIterable", checkInIterable);
        return "check_in/check_in";
    }
    @PostMapping("add")
    public String add(@RequestParam LocalDate check_in_date,
                      @RequestParam LocalDate check_out_date,
                      @RequestParam Long id_order) {
        check_in checkIn = new rooms(
                check_in_date,
                check_out_date,
                iorder.findById(id_order).orElseThrow());
        icheck_in.save(checkIn);
        return "redirect:/check_in";
    }
    @PostMapping("delete/{id_check_in}")
    public String delete(@PathVariable(value = "id_check_in") Long id_check_in) {
        check_in checkIn = icheck_in.findById(id_check_in).orElseThrow();
        icheck_in.delete(checkIn);
        return "redirect:/check_in";
    }
    @GetMapping("{id_room}")
    public String one(@PathVariable(value = "id_check_in") Long id_check_in, Model model){
        check_in checkIn = icheck_in.findById(id_check_in).orElseThrow();
        model.addAttribute("checkIn", checkIn);
        return "check_in/check_in-creation";
    }
    @PostMapping("{id_check_in}")
    public String update(@PathVariable(value = "id_check_in") Long id_check_in,
                         @RequestParam LocalDate check_in_date,
                         @RequestParam LocalDate check_out_date,
                         @RequestParam Long id_order) {
        check_in checkIn = icheck_in.findById(id_check_in).orElseThrow();
        rooms.setCheck_in_date(check_in_date);
        rooms.setCheck_out_date(check_out_date);
        rooms.setOrder(iorder.findById(id_order).orElseThrow());
        icheck_in.save(checkIn);
        return "redirect:/check_in";
    }
